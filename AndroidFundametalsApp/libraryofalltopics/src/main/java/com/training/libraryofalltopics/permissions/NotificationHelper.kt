package com.training.libraryofalltopics.permissions

import android.Manifest
import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationHelper {

    private val CHANNEL_ID = "feature_updates"
    private val CHANNEL_NAME = "Feature Updates"
    private val CHANNEL_DESC = "Notifications for feature events"

    fun createChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH // heads-up
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance).apply {
                description = CHANNEL_DESC
                enableLights(true)
                lightColor = Color.CYAN
                enableVibration(true)
            }
            val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nm.createNotificationChannel(channel)
        }
    }

    /**
     * Build a PendingIntent that opens FeatureActivity with the provided featureId.
     * Uses TaskStackBuilder so back button behaves naturally even if app was closed.
     */
    private fun pendingIntentToFeature(context: Context, featureId: String): PendingIntent {
        val detailIntent = Intent(context, FeatureActivity::class.java).apply {
            putExtra(FeatureActivity.EXTRA_FEATURE_ID, featureId)
        }

        // Build synthetic back stack: MainActivity -> FeatureActivity
        val stackBuilder = TaskStackBuilder.create(context).apply {
            addParentStack(FeatureActivity::class.java)
            addNextIntent(detailIntent)
        }

        return stackBuilder.getPendingIntent(
            featureId.hashCode(), // unique requestCode per feature
            (PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        )!!
    }

    /** Show a high-priority notification. Tapping it opens FeatureActivity. */
    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    fun showFeatureNotification(context: Context, featureId: String, title: String, body: String, notificationId: Int) {
        createChannel(context)

        val contentPi = pendingIntentToFeature(context, featureId)

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.drawable.ic_dialog_info)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH) // heads-up on pre-O
            .setContentIntent(contentPi)

        NotificationManagerCompat.from(context).notify(notificationId, builder.build())
    }

}