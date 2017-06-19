/*
  Copyright 2017 dev.cobb
  <p>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  <p>
  http://www.apache.org/licenses/LICENSE-2.0
  <p>
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package dev.cobb.android_workshop.todo.service.broadcast

import TODO_ID
import TODO_TEXT
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

import dev.cobb.android_workshop.todo.R
import dev.cobb.android_workshop.todo.ui.activity.Activity_Reminder


/**
 * The type Reminder receiver is a receiver to get the intent  from alarm manger with pending intent with  including
 * ReminderReceiver. In this class get id and data of a predefined todoitem
 * ReminderReceiver mus be register in manifesto file under the tag receiver and add meta data of sms receiver

 * @author dev.cobb
 * *
 * @version 1.0
 * *
 * @since 22 may 2017
 */
class ReminderReceiver : BroadcastReceiver() {


    /**
     * onReceive
     * @param  context is application instants
     * *
     * @param intent  intent with extra  data  of item id and text
     * *
     */
    override fun onReceive(context: Context, intent: Intent) {


        /** crete and send notification using onReceive params   */
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intentToReminderActivity = Intent(context, Activity_Reminder::class.java)
        intentToReminderActivity.putExtra(TODO_TEXT, intent.getStringExtra(TODO_TEXT))
        val id = intent.getLongExtra(TODO_ID, 0)
        intentToReminderActivity.putExtra(TODO_ID, id)
        val notification = Notification.Builder(context)
                .setContentTitle(intent.getStringExtra(TODO_TEXT))
                .setSmallIcon(R.drawable.ic_done_w)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setContentIntent(PendingIntent.getActivity(context, id.toInt(), intentToReminderActivity, PendingIntent.FLAG_UPDATE_CURRENT))
                .build()
        manager.notify(100, notification)
    }


}
