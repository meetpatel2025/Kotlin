package com.training.userpermissionandnotificationapp

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.core.content.ContextCompat

object PermissionUtils {

    fun requiredRuntimePermissions(): Array<String> {
        val base = mutableListOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_CONTACTS
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            base += Manifest.permission.READ_MEDIA_IMAGES
            base += Manifest.permission.READ_MEDIA_VIDEO
            base += Manifest.permission.READ_MEDIA_AUDIO
            base += Manifest.permission.POST_NOTIFICATIONS
        } else {
            base += Manifest.permission.READ_EXTERNAL_STORAGE
        }
        return base.toTypedArray()
    }

    fun hasAllPermissions(context: Context): Boolean {
        return requiredRuntimePermissions().all { perm ->
            ContextCompat.checkSelfPermission(context, perm) == PackageManager.PERMISSION_GRANTED
        }
    }

    fun missingPermissions(context: Context): List<String> {
        return requiredRuntimePermissions().filter { perm ->
            ContextCompat.checkSelfPermission(context, perm) != PackageManager.PERMISSION_GRANTED
        }
    }

    fun isPermanentlyDenied(activity: Activity, permission: String): Boolean {
        val granted = ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED
        if (granted) return false
        return !activity.shouldShowRequestPermissionRationale(permission)
    }

    fun openAppSettings(context: Context) {
        val uri = Uri.fromParts("package", context.packageName, null)
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = uri
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }

}