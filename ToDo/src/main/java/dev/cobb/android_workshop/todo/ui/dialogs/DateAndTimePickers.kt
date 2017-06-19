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
package dev.cobb.android_workshop.todo.ui.dialogs

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.view.View
import android.widget.TextView
import dev.cobb.android_workshop.todo.data.dao.Data_Change_Listener
import java.util.*

/**
 * The type Date and time pickers its use chose crete date and time picker in all your projects.
 * Both time picker and date picker need context don't use App instants they need  current activity context
 * its date format declare in Constants

 * @author dev.cobb
 * *
 * @version 1.0
 * *
 * @since 22 may 2017
 */



    /**
     * Show date picker.

     * @param context              the context
     * *
     * @param view                 the view
     * *
     * @param data_change_listener the data change listener
     */
    fun showDatePicker(context: Context, view: View, data_change_listener: Data_Change_Listener) {
        val calendar = Calendar.getInstance()
        val mYear = calendar.get(Calendar.YEAR)
        val mMonth = calendar.get(Calendar.MONTH)
        val mDay = calendar.get(Calendar.DAY_OF_MONTH)


        val datePickerDialog = DatePickerDialog(context,
                DatePickerDialog.OnDateSetListener { datePicker, year, monthOfYear, dayOfMonth ->
                    val tv_result = view as TextView
                    tv_result.text = dayOfMonth.toString() + "-" + (monthOfYear + 1)+"-" + year
                    data_change_listener.dataChange()
                }, mYear, mMonth, mDay)
        datePickerDialog.show()

    }


    /**
     * Show time picker.

     * @param context               the context
     * *
     * @param view                  the view
     * *
     * @param data_change_listenerS the data change listener s
     */
    fun showTimePicker(context: Context, view: View, data_change_listenerS: Data_Change_Listener) {

        val calendar = Calendar.getInstance()
        val mHour = calendar.get(Calendar.HOUR_OF_DAY)
        val mMinute = calendar.get(Calendar.MINUTE)


        val timePickerDialog = TimePickerDialog(context, TimePickerDialog.OnTimeSetListener { timePicker, hours, minutes ->
            val tv_result_time = view as TextView
            tv_result_time.text = updateTime(hours, minutes)
            data_change_listenerS.dataChange()
        }, mHour, mMinute, false)

        timePickerDialog.show()
    }


    /**
     * updateTime time to use a time data convert to AM and PM

     * @param hours the hour in selected time
     * *
     * @param mints the mint in selected time
     */
    private fun updateTime(hours: Int, mints: Int): String {
        var hours = hours


        val timeSet: String
        if (hours > 12) {
            hours -= 12
            timeSet = "PM"
        } else if (hours == 0) {
            hours += 12
            timeSet = "AM"
        } else if (hours == 12)
            timeSet = "PM"
        else
            timeSet = "AM"

        val minutes: String
        if (mints < 10) {
            minutes = "0" + mints
        } else {
            minutes = mints.toString() + ""
        }

        // Append in a StringBuilder

        return hours.toString() + ":" + minutes + " " + timeSet

    }





