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

import MSG_EXIT
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import dev.cobb.android_workshop.todo.R
import dev.cobb.android_workshop.todo.app.App
import dev.cobb.android_workshop.todo.data.pojo.ToDoItem
import dev.cobb.android_workshop.todo.service.navigator.goToAboutActivity
import dev.cobb.android_workshop.todo.service.navigator.goToAddTodoActivity
import dev.cobb.android_workshop.todo.ui.adpter.TodoItemAdapter
import dev.cobb.android_workshop.todo.ui.dialogs.showToast
import dev.cobb.android_workshop.todo.ui.view.VerticalLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*


/**
 * The type Activity home is main screen of application you can see previous add todoItems
 * and its status and a option to add new todoItem also add about the app in menu   .

 * @author Binush
 * *
 * @version 1.0
 * *
 * @since 11 06 2017
 */
class Activity_Home : AppCompatActivity() {


    /**
     * The To do item list.
     */
    internal var toDoItemList: List<ToDoItem> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }

    override fun onStart() {
        super.onStart()
        toDoItemList = App.getTodoItemDao.loadAll()
        if (!toDoItemList.isEmpty()) {
            ll_home_empty_recycler.visibility = View.GONE
            rv_home_todoList.visibility = View.VISIBLE
            rv_home_todoList.layoutManager = VerticalLayoutManager(this@Activity_Home)
            val todoItemAdapter = TodoItemAdapter(toDoItemList, this@Activity_Home)
            rv_home_todoList.adapter = todoItemAdapter

        } else {
            ll_home_empty_recycler.visibility = View.VISIBLE
            rv_home_todoList.visibility = View.GONE
        }

        fab_home_addTodo.setOnClickListener { goToAddTodoActivity(this@Activity_Home) }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_home, menu)//Menu Resource, Menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home_about -> {
                goToAboutActivity(this@Activity_Home)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
        } else {
            doubleTapExit()
        }

    }

    /**
     * The Double back to exit pressed once.
     */
    internal var doubleBackToExitPressedOnce = false

    /**
     * Double tap exit.
     */
    private fun doubleTapExit() {

        this.doubleBackToExitPressedOnce = true
       showToast(MSG_EXIT)

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

}
