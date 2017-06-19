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
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import dev.cobb.android_workshop.todo.R
import dev.cobb.android_workshop.todo.service.navigator.goToHomeActivity


/**
 * The type Activity splash its just a intro screen show app icon and name after time delay move to home screen automatic .
 * @author dev.cobb
 *
 * @version 1.0
 *
 * @since 22 may 2017
 */
class Activity_Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler()
        val timeDelay = (1000 * 2).toLong()
        handler.postDelayed({ goToHomeActivity(this@Activity_Splash) }, timeDelay)


    }

}
