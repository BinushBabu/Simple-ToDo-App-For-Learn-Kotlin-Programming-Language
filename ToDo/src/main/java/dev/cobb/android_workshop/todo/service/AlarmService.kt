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
package dev.cobb.android_workshop.todo.service

import TODO_ID
import TODO_TEXT
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import dev.cobb.android_workshop.todo.data.pojo.ToDoItem
import dev.cobb.android_workshop.todo.service.broadcast.ReminderReceiver


import java.util.*

/**
 * The type Alarm service class to use generate a reminder in a particular date and time its initialised done in application class.
 * @author dev.cobb
 * *
 * @version 1.0
 * *
 * @since 22 may 2017
 */


    /**
     * Sets reminder.
     * @param reminder the object of reminder
     * @param context  the context
     */
    fun setReminder(reminder: ToDoItem, context: Context) {
        val currentItemID = reminder.id!!
        val targetCal = GregorianCalendar()
        targetCal.time = reminder.todoDate
        val intent = Intent(context, ReminderReceiver::class.java)
        intent.putExtra(TODO_TEXT, reminder.todoTask)
        intent.putExtra(TODO_ID, currentItemID)
        val pID = currentItemID.toInt()
        val pendingIntent = PendingIntent.getBroadcast(context, pID, intent, 0)
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.timeInMillis, pendingIntent)

}
