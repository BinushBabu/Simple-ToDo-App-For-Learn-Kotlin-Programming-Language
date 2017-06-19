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

package dev.cobb.android_workshop.todo.data.dao

/**
 * Data change listener is interface using inform a data change in between  two class or two different posses
 * in this project Using data change listener to identifying date or time change in add reminder class

 * @see dev.cobb.android_workshop.todo.ui.activity.Activity_AddTodo


 * @author dev.cobb
 * *
 * @version 1.0
 * *
 * @since 22 may 2017
 */
interface Data_Change_Listener {
    fun dataChange()
}
