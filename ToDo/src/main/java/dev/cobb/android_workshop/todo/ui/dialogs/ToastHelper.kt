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

import android.widget.Toast

import dev.cobb.android_workshop.todo.app.App


/**
 * The class Toast helper using show Toast  in all your project you can simple call them.
 * ToastHelper.show("data to show")

 * @author Binush Babu
 * *
 * @version 1.0
 * *
 * @since 04/15/2016
 */


    /**
     * Displays android toast message.

     * @param message the message
     */
    fun showToast(message: String) {
        Toast.makeText(App.context, message,
                Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays android toast message.

     * @param message  the message
     * *
     * @param duration the duration
     */
    fun showToast(message: String, duration: Int) {
        Toast.makeText(App.context, message,
                duration).show()

}
