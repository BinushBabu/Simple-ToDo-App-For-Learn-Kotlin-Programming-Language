/*Copyright 2017 dev.cobb
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
package dev.cobb.android_workshop.todo.ui.view

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import java.util.*


/**
 * The type Round text class use a  round shaped color Drawable using test drawable class.
 *
 * @author dev.cobb
 * @version 1.0
 * @since 22 may 2017
 *
 */


    /**
     * Get round text drawable text drawable.

     * @param data the data
     * *
     * @return the text drawable its an custom drawable image
     */
    fun getRoundTextDrawable(): GradientDrawable {
        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(200))
        val gd = GradientDrawable()
        gd.shape = GradientDrawable.OVAL
        gd.setColor(color)

        return gd
    }


