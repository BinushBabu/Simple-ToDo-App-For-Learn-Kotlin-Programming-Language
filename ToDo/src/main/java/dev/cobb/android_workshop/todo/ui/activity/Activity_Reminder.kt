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
package dev.cobb.android_workshop.todo.ui.activity


import TODO_ID
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import dev.cobb.android_workshop.todo.R
import dev.cobb.android_workshop.todo.app.App
import dev.cobb.android_workshop.todo.data.pojo.ToDoItem
import dev.cobb.android_workshop.todo.service.navigator.goToHomeActivity
import dev.cobb.android_workshop.todo.service.setReminder
import kotlinx.android.synthetic.main.activity_reminder.*
import java.util.*

/**
 * The type Activity reminder is using pop up when click on notification
 * you can see the notification and change the notification status
 * can delete and snooze the reminder

 * @author dev.cobb
 * *
 * @version 1.0
 * *
 * @since 22 may 2017
 */
class Activity_Reminder : AppCompatActivity() {

    /**
     * The To do item.
     */
    private var toDoItem: ToDoItem? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reminder)
        setOnClick()
        val intent = intent
        val todID = intent.getLongExtra(TODO_ID, 0L)

        try {
            toDoItem = App.getTodoItemDao.load(todID)
            tv_reminder_text.text = toDoItem!!.todoTask
        } catch (e: Exception) {
            e.printStackTrace()
          goToHomeActivity(this)
        }

        setUpSpinner()

    }

    /** spinner to use snooze reminder you can add more time options add values in R.array.snooze_options */
    private fun setUpSpinner() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.snooze_options, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        todoReminderSnoozeSpinner.adapter = adapter

        todoReminderSnoozeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                var snoozeTime: Long = 0
                when (i) {
                    0 -> snoozeTime = (10 * 60 * 1000).toLong()
                    1 -> snoozeTime = (30 * 60 * 1000).toLong()
                    2 -> snoozeTime = (60 * 60 * 1000).toLong()
                    else -> {
                    }
                }


                val currentDate = Date()
                val updateDate = Date(currentDate.time + snoozeTime)
                toDoItem!!.todoDate = updateDate
               setReminder(reminder = toDoItem!!, context = this@Activity_Reminder)
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {

            }
        }
    }


    /**
     * On view clicked manging click events of different views
     */

     fun setOnClick() {

              toDoReminderDelete .setOnClickListener {
                    App.getTodoItemDao.delete(toDoItem)
                    goToHomeActivity(this@Activity_Reminder)
                }
               toDoReminderDoneButton.setOnClickListener {
                    toDoItem!!.isDone = true
                    App.getTodoItemDao.update(toDoItem)
                    goToHomeActivity(this@Activity_Reminder)
                }
            }




}
