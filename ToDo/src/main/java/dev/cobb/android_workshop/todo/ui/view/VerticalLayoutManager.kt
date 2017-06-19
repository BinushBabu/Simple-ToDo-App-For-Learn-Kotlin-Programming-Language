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
package dev.cobb.android_workshop.todo.ui.view

import android.content.Context
import android.support.v7.widget.LinearLayoutManager

/**
 * The type Vertical layout manager using arrange a recycler view {[android.support.v7.widget.RecyclerView.Recycler]}.
 * items is in a vertical mainer

 * @author dev.cobb
 * *
 * @version 1.0
 * *
 * @since 22 may 2017
 */
class VerticalLayoutManager
/**
 * Instantiates a new Vertical layout manager.

 * @param context the context
 */
(context: Context) : LinearLayoutManager(context) {

    init {
        orientation = LinearLayoutManager.VERTICAL
    }
}
