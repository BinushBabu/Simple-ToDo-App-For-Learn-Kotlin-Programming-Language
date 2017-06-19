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
package dev.cobb.android_workshop.todo.util

import FORMAT_DATE
import FORMAT_DATE_AND_TIME
import FORMAT_TIME
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * The type Date and time util using manipulations of date and time such as date to string and string and date .

 * @author dev.cobb
 * *
 * @version 1.0
 * *
 * @since 22 may 2017
 */
    /**
     * Gets default alarm date.

     * @return the default alarm date
     */
     val defaultAlarmDate: String
        get() {
            val simpleDateFormat = SimpleDateFormat(FORMAT_DATE)
            val date = Date(Date().time)
            val dateString = simpleDateFormat.format(date)
            return dateString
        }

    /**
     * Gets default alarm time.

     * @return the default alarm time
     */
     val defaultAlarmTime: String
        get() {
            val simpleDateFormat = SimpleDateFormat(FORMAT_TIME)
            val date = Date(Date().time)
            val timeString = simpleDateFormat.format(date)
            return timeString
        }

    /**
     * Generate date and time string to date.

     * @param dateText the date text
     * *
     * @param timeText the time text
     * *
     * @return the date
     */
     fun generateDateTimeFromString(dateText: String, timeText: String): Date {
        val currentDateString = dateText + " " + timeText
        val format = SimpleDateFormat(FORMAT_DATE_AND_TIME, Locale.ENGLISH)
        var date: Date? = null
        try {
            date = format.parse(currentDateString)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return date!!
    }

    /**
     * Convert date and time to string .

     * @param date the date
     * *
     * @return the string
     */
     fun convertDateTimeToString(date: Date): String {

        val simpleDateFormat = SimpleDateFormat(FORMAT_DATE_AND_TIME)
        val time: String = simpleDateFormat.format(date).toString()
        return time
    }

    /**
     * Convert date and  time to string array .

     * @param date the date
     * *
     * @return the string [ ] of date and time
     */
     fun convertDateTimeToStringArray(date: Date): Array<String> {
        val simpleDateFormat = SimpleDateFormat(FORMAT_DATE_AND_TIME)
        val time = simpleDateFormat.format(date)
        val newDateAndTime = time.trim { it <= ' ' }.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        newDateAndTime[1] = newDateAndTime[1] + " " + newDateAndTime[2]
        return newDateAndTime
    }



