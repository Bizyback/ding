package com.bizyback.ding.utils

import com.intellij.notification.Notification
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.project.Project

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     11:00 am
 *
 */
/**
 * Wrapper function for showing notification.
 */

private const val NOTIFICATION_GROUP_ID = "Ding"

/**
 * Shows notification.
 *
 * @param project  current project
 * @param title    notification title
 * @param content  notification text
 * @param type     notification type
 */
fun Project?.notify(
    title: String,
    content: String? = null,
    type: NotificationType,
    block: (Notification.() -> Unit)? = null
) {
    val notification = NotificationGroupManager.getInstance()
        .getNotificationGroup(NOTIFICATION_GROUP_ID).run {
            when (content) {
                null -> createNotification(title, type)
                else -> createNotification(title, content, type)
            }
        }
    block?.invoke(notification)
    Notifications.Bus.notify(notification, this)
}
