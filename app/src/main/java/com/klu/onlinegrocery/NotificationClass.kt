package com.klu.onlinegrocery

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

class NotificationClass {

    fun showNotification(context: Context, eventType: String, message: String) {
        val drawable = ContextCompat.getDrawable(context, R.drawable.vegetables_vector)
        val bitmap = drawableToBitmap(drawable)

        val builder = NotificationCompat.Builder(context, "APP_EVENTS_CHANNEL")
            .setSmallIcon(R.drawable.vegetables_vector) // Use a simple icon for smallIcon (required)
            .setLargeIcon(bitmap) // Set your large vector-converted bitmap
            .setContentTitle(" $eventType")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context)) {
            notify((System.currentTimeMillis() % 10000).toInt(), builder.build())
        }
    }

    private fun drawableToBitmap(drawable: Drawable?): Bitmap? {
        if (drawable == null) return null

        val width = drawable.intrinsicWidth.takeIf { it > 0 } ?: 96
        val height = drawable.intrinsicHeight.takeIf { it > 0 } ?: 96

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)

        return bitmap
    }
}
