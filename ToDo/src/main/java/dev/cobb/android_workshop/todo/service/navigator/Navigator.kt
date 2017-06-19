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
package dev.cobb.android_workshop.todo.service.navigator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import dev.cobb.android_workshop.todo.ui.activity.Activity_About
import dev.cobb.android_workshop.todo.ui.activity.Activity_AddTodo
import dev.cobb.android_workshop.todo.ui.activity.Activity_Home


/**
 * The type Navigator.
 * Navigator is common class to use navigate betokens  two activity's its initialised done in application class

 * @author dev.cobb
 * *
 * @version 1.0
 * *
 * @since 22 may 2017
 */



    /**
     * Go to home activity.

     * @param sourceClass the instants of source class
     */
    fun goToHomeActivity(sourceClass: AppCompatActivity) {
        sourceClass.startActivity(Intent(sourceClass, Activity_Home::class.java))
        sourceClass.finish()
    }


    /**
     * Go to add todo activity.

     * @param sourceClass the instants of  source class
     */
    fun goToAddTodoActivity(sourceClass: AppCompatActivity) {
        sourceClass.startActivity(Intent(sourceClass, Activity_AddTodo::class.java))
        sourceClass.finish()
    }


    /**
     * Go to about activity.

     * @param sourceClass the instants of  source class
     */
    fun goToAboutActivity(sourceClass: AppCompatActivity) {
        sourceClass.startActivity(Intent(sourceClass, Activity_About::class.java))
        sourceClass.finish()
    }



