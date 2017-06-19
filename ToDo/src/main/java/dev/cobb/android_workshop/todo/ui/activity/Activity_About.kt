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

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dev.cobb.android_workshop.todo.R
import dev.cobb.android_workshop.todo.service.navigator.goToHomeActivity

/**
 * The type Activity about its show a simple screen about our project name version and developer info
 * @author Binush
 * @version 1.0
 * @since 11 06 2017
 */
class Activity_About : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    override fun onBackPressed() {

        /* Move to home Activity */
        goToHomeActivity(this@Activity_About)

    }


}
