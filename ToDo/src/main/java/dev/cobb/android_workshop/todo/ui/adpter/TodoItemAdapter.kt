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
package dev.cobb.android_workshop.todo.ui.adpter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import dev.cobb.android_workshop.todo.R
import dev.cobb.android_workshop.todo.data.pojo.ToDoItem
import dev.cobb.android_workshop.todo.ui.adpter.holder.TodoItemHolder


/**
 * The type TodoItem adapter To create todoItem list.
 * [RecyclerView]

 * @author dev.cobb
 * *
 * @version 1.0
 * *
 * @since 8 oct 2016
 */
class TodoItemAdapter
/**
 * Instantiates a new TodoItem adapter.

 * @param itemList the item list
 * *
 * @param context  the context
 */
(private val itemList: List<ToDoItem>,
 /**
  * The Context.
  */
 private val context: Context) : RecyclerView.Adapter<TodoItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.holder_todo_item, parent, false)
        return TodoItemHolder(itemView)
    }

    override fun onBindViewHolder(holder: TodoItemHolder, position: Int) {

        val toDoItem = itemList[position]
        holder.bind(toDoItem);
    }

    override fun getItemCount(): Int {
        return itemList.size
    }



}
