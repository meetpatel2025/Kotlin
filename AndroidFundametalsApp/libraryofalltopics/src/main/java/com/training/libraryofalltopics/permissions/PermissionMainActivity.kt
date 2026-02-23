package com.training.libraryofalltopics.permissions

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.training.libraryofalltopics.R

class PermissionMainActivity : AppCompatActivity() {

    private lateinit var tvStatus: TextView
    private lateinit var btnRequestPerms: Button
    private lateinit var btnShowNotiA: Button
    private lateinit var btnShowNotiB: Button

    /** Request multiple dangerous permissions in one go (SDK-aware list) */
    private val requestMultiplePermissions = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { grantResults ->
        // grantResults: Map<String, Boolean>
        val granted = grantResults.filterValues { it }.keys
        val denied  = grantResults.filterValues { !it }.keys

        val summary = buildString {
            appendLine("Granted: ${if (granted.isEmpty()) "(none)" else granted.joinToString()}")
            appendLine("Denied : ${if (denied.isEmpty()) "(none)" else denied.joinToString()}")
        }
        tvStatus.text = summary

        if (denied.isNotEmpty()) {
            handleDeniedPermissions(denied.toList())
        } else {
            tvStatus.append("\nAll required permissions granted ✅")
            updateFeatureButtonsEnabled(true)
        }
    }

    /** Single-permission launcher for notifications (optional separate) */
    private val requestNotificationPermission = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (!granted) {
            showGoToSettingsDialog(
                title = "Notifications blocked",
                message = "To receive alerts, allow Notifications in Settings."
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.permission_activity_main)

        tvStatus = findViewById(R.id.tvStatus)
        btnRequestPerms = findViewById(R.id.btnRequestPerms)
        btnShowNotiA = findViewById(R.id.btnShowNotiA)
        btnShowNotiB = findViewById(R.id.btnShowNotiB)

        // Initial UI state based on current permissions
        updateFeatureButtonsEnabled(PermissionUtils.hasAllPermissions(this))

        btnRequestPerms.setOnClickListener {
            val missing = PermissionUtils.missingPermissions(this)
            if (missing.isEmpty()) {
                tvStatus.text = "All permissions already granted ✅"
                updateFeatureButtonsEnabled(true)
            } else {
                // If Android 13+, you might want to ask noti perm separately before posting any noti
                // (We also include it in the multiple request; either is fine.)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                    missing.contains(Manifest.permission.POST_NOTIFICATIONS)
                ) {
                    requestNotificationPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
                requestMultiplePermissions.launch(missing.toTypedArray())
            }
        }

        // SHOW NOTIFICATIONS (works when app is open/background/closed)
//        btnShowNotiA.setOnClickListener {
//            ensureNotificationPermissionThen {
//                NotificationHelper.showFeatureNotification(
//                    context = this,
//                    featureId = "feature_A_123",
//                    title = "Order #123",
//                    body = "Tap to view order details",
//                    notificationId = 1001
//                )
//            }
//        }

//        btnShowNotiB.setOnClickListener {
//            ensureNotificationPermissionThen {
//                NotificationHelper.showFeatureNotification(
//                    context = this,
//                    featureId = "offer_B_202",
//                    title = "New Offer",
//                    body = "Tap to view special offer",
//                    notificationId = 1002
//                )
//            }
//        }
    }

    /** If noti permission required on Android 13+, request it before posting. */
    private fun ensureNotificationPermissionThen(action: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val missing = PermissionUtils.missingPermissions(this)
            if (missing.contains(Manifest.permission.POST_NOTIFICATIONS)) {
                requestNotificationPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
                tvStatus.text = "Asked for Notification permission…"
                return
            }
        }
        action()
    }

    /** Disable features if permissions missing; enable when all granted */
    private fun updateFeatureButtonsEnabled(enabled: Boolean) {
        btnShowNotiA.isEnabled = enabled
        btnShowNotiB.isEnabled = enabled
    }

    /** Handle denied & permanently denied cases with rationale/Settings dialog */
    private fun handleDeniedPermissions(deniedList: List<String>) {
        val permanentlyDenied = deniedList.filter { PermissionUtils.isPermanentlyDenied(this, it) }
        val temporarilyDenied = deniedList - permanentlyDenied.toSet()

        if (temporarilyDenied.isNotEmpty()) {
            AlertDialog.Builder(this)
                .setTitle("Permissions needed")
                .setMessage(
                    "Some features need access to:\n${temporarilyDenied.joinToString("\n")}\n\n" +
                            "Without these, certain features will remain disabled."
                )
                .setPositiveButton("Try Again") { _, _ ->
                    requestMultiplePermissions.launch(temporarilyDenied.toTypedArray())
                }
                .setNegativeButton("Not now") { _, _ ->
                    tvStatus.append("\nFeatures locked until permissions are granted.")
                    updateFeatureButtonsEnabled(false)
                }
                .show()
        }

        if (permanentlyDenied.isNotEmpty()) {
            showGoToSettingsDialog(
                title = "Permissions blocked",
                message = "You selected “Don’t ask again” for:\n" +
                        permanentlyDenied.joinToString("\n") +
                        "\n\nOpen Settings to allow them."
            )
            updateFeatureButtonsEnabled(false)
        }
    }

    private fun showGoToSettingsDialog(title: String, message: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Open Settings") { _, _ -> PermissionUtils.openAppSettings(this) }
            .setNegativeButton("Cancel", null)
            .show()
    }

}