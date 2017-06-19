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
package dev.cobb.android_workshop.todo.ui.adpter.holder

import VALUES_SELECTED_TODO_ITEM
import VALUES_TODO_EDIT_MOD
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import dev.cobb.android_workshop.todo.data.pojo.ToDoItem
import dev.cobb.android_workshop.todo.service.navigator.goToAddTodoActivity
import dev.cobb.android_workshop.todo.ui.view.getRoundTextDrawable
import dev.cobb.android_workshop.todo.util.convertDateTimeToString
import kotlinx.android.synthetic.main.holder_todo_item.view.*


/**
 * The type TodoItem holder is using declare view elements in a single .

 * @author dev.cobb
 * *
 * @version 1.0
 * *
 * @since 8 oct 2016
 */

/**
 * Instantiates a new TodoItem holder.

 * @param itemView the item view
 * *
 */


class TodoItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(todoItem: ToDoItem) = with(itemView) {
        iv_holder_todo_item_firstLetter.text=todoItem.todoTask.substring(0, 1).toUpperCase()
        iv_holder_todo_item_image.setImageDrawable(getRoundTextDrawable())
        cb_holder_todo_item_done.isChecked = todoItem.isDone
        tv_holder_todo_item_text.text = todoItem.todoTask
        if (todoItem.isReminder) {
            tv_holder_todo_item_date.text = convertDateTimeToString(todoItem.todoDate)
        } else {
            tv_holder_todo_item_date.visibility = View.GONE
        }
        itemView.setOnClickListener {
            VALUES_TODO_EDIT_MOD = true
            VALUES_SELECTED_TODO_ITEM = todoItem
            goToAddTodoActivity(sourceClass = context as AppCompatActivity)
        }
    }
}



