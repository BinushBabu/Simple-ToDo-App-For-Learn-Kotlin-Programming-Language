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

import ERROR_EMPTY_TODO
import MSG_ADD_TODO
import VALUES_SELECTED_TODO_ITEM
import VALUES_TODO_EDIT_MOD
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import dev.cobb.android_workshop.todo.R
import dev.cobb.android_workshop.todo.app.App
import dev.cobb.android_workshop.todo.data.dao.Data_Change_Listener
import dev.cobb.android_workshop.todo.data.pojo.ToDoItem
import dev.cobb.android_workshop.todo.service.navigator.goToHomeActivity
import dev.cobb.android_workshop.todo.service.setReminder
import dev.cobb.android_workshop.todo.ui.dialogs.showDatePicker
import dev.cobb.android_workshop.todo.ui.dialogs.showTimePicker
import dev.cobb.android_workshop.todo.ui.dialogs.showToast
import dev.cobb.android_workshop.todo.util.convertDateTimeToStringArray
import dev.cobb.android_workshop.todo.util.defaultAlarmDate
import dev.cobb.android_workshop.todo.util.defaultAlarmTime
import dev.cobb.android_workshop.todo.util.generateDateTimeFromString
import kotlinx.android.synthetic.main.activity_add_to_do.*
import java.util.*

/**
 * The type Activity add todoItem class to add a new todoItem with reminder or with out reminder

 * @author Binush
 * *
 * @version 1.0
 * *
 * @since 11 06 2017
 */
class Activity_AddTodo : AppCompatActivity(), Data_Change_Listener {

    var isDone = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)
        setClicks()

        btn_add_todo_choose_time.text = defaultAlarmTime

        if (VALUES_TODO_EDIT_MOD) {
            ll_add_todo_bottom_layout.visibility = View.VISIBLE
            setEditMod(VALUES_SELECTED_TODO_ITEM!!)
            if (VALUES_SELECTED_TODO_ITEM!!.isDone) {
                btn_add_todo_done.visibility = View.GONE
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        VALUES_TODO_EDIT_MOD = false

    }


    fun setClicks() {

        iv_add_todo_close.setOnClickListener { goToHomeActivity(this@Activity_AddTodo) }
        sc_add_todo_is_reminder.setOnClickListener { reminderOnOff() }
        btn_add_todo_choose_date.setOnClickListener { showDatePicker(this@Activity_AddTodo, btn_add_todo_choose_date, this) }
        btn_add_todo_choose_time.setOnClickListener { showTimePicker(this@Activity_AddTodo, btn_add_todo_choose_time, this) }
        fab_add_todo_save.setOnClickListener {
            saveToDB()}
            btn_add_todo_delete.setOnClickListener {
                App.getTodoItemDao.delete(VALUES_SELECTED_TODO_ITEM)
                goToHomeActivity(this@Activity_AddTodo)
            }

            btn_add_todo_done.setOnClickListener {
                isDone = true
                saveToDB()
            }
        }



    /** to control SwitchCompat on off , if its on make visible option to add reminder date and time , if off make it invisible   */
    private fun reminderOnOff() {
        if (sc_add_todo_is_reminder.isChecked) {
            ll_add_todo_reminder_date_time_layout.visibility = View.VISIBLE
            tv_add_todo_date_and_time.text = btn_add_todo_choose_date.text.toString() + " @ " + btn_add_todo_choose_time.text.toString()
        } else {
            ll_add_todo_reminder_date_time_layout.visibility = View.GONE

        }
    }

    //** To save a todoItem to data base  */
    private fun saveToDB() {

        if (!et_add_todo_data.text.toString().trim { it <= ' ' }.isEmpty()) {
            val toDoItem = ToDoItem()
            if (VALUES_TODO_EDIT_MOD) {
                toDoItem.id = VALUES_SELECTED_TODO_ITEM!!.id
            }
            toDoItem.todoTask = et_add_todo_data.text.toString().trim { it <= ' ' }
            if (sc_add_todo_is_reminder.isChecked) {
                toDoItem.isReminder = true
                val currentSelectedDate = btn_add_todo_choose_date.text.toString().trim { it <= ' ' }
                val currentSelectedTime = btn_add_todo_choose_time.text.toString().trim { it <= ' ' }
                if (currentSelectedDate.equals(getString(R.string.today), ignoreCase = true)) {
                    toDoItem.todoDate = generateDateTimeFromString(defaultAlarmDate, currentSelectedTime)
                } else {
                    toDoItem.todoDate = generateDateTimeFromString(currentSelectedDate, currentSelectedTime)
                }

            } else {
                toDoItem.isReminder = false
                toDoItem.todoDate = Date()
            }


            val currentItemID: Long
            if (VALUES_TODO_EDIT_MOD) {
                if (isDone) {
                    isDone = false
                    toDoItem.isDone = true
                }
                App.getTodoItemDao.update(toDoItem)

            } else {
                toDoItem.isDone = false
                currentItemID = App.getTodoItemDao.insert(toDoItem)
                toDoItem.id = currentItemID
            }

            setReminder(toDoItem, this@Activity_AddTodo)
            showToast(MSG_ADD_TODO)
            goToHomeActivity(this@Activity_AddTodo)


        }else{
            et_add_todo_data.text.clear()
            showToast(ERROR_EMPTY_TODO)
        }

    }

    override fun dataChange() = reminderOnOff()


    /**
     * Sets edit mod the method is working if activity open from a previously add todoItem and enable the option to mark its done  .

     * @param toDoItem the to do item
     */
    fun setEditMod(toDoItem: ToDoItem) {
        et_add_todo_data.setText(toDoItem.todoTask)
        if (toDoItem.isReminder) {
            sc_add_todo_is_reminder.isChecked = true
            val currentDate = convertDateTimeToStringArray(toDoItem.todoDate)
            btn_add_todo_choose_date.text = currentDate[0]
            btn_add_todo_choose_time.text = currentDate[1]
            reminderOnOff()
        }
    }

    override fun onBackPressed() {
        goToHomeActivity(this@Activity_AddTodo)
    }


}
