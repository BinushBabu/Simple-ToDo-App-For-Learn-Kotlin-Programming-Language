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

import dev.cobb.android_workshop.todo.data.pojo.ToDoItem

/**
 * The class Constants is using declare all Constants values using this project every constants declare under specified  tags

 * @author dev.cobb
 * *
 * @version 1.0
 * *
 * @since 22 may 2017
 */


/**
 * Preference and intent  keys  using declare key value of preference and key value of intent extra
 * data formats  using declare different  type of data format eg - date format , time for mat email etc
 * Error messages using for declare error messages
 * messages using for declare common messages
 * app values for declare scarified  values using this projects
 */

//Preference and intent  keys
const val TODO_TEXT = "todoText"
const val TODO_ID = "todoID"


// data formats
const val FORMAT_DATE = "dd-MM-yyyy"
const val FORMAT_TIME = "h:mm a"
const val FORMAT_DATE_AND_TIME: String = "dd-MM-yyyy h:mm a"


// Error messages
const val ERROR_EMPTY_TODO = "Oops !! Pleas Add a Todo"


//messages
const val MSG_EXIT = "Please click BACK again to exit"
const val MSG_ADD_TODO = "Add Todo Successfully .. "


//app values
 var VALUES_TODO_EDIT_MOD = false
 var VALUES_SELECTED_TODO_ITEM: ToDoItem? = null


