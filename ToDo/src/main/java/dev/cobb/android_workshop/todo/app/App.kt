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
package dev.cobb.android_workshop.todo.app

import android.app.Application
import dev.cobb.android_workshop.todo.data.pojo.DaoMaster
import dev.cobb.android_workshop.todo.data.pojo.DaoSession
import dev.cobb.android_workshop.todo.data.pojo.ToDoItemDao


/**
 * The Application is Base class for maintaining global application state.
 * Application class, is instantiated before any other class when the process
 * for your application/package is created.

 * @author Binush
 * *
 * @version 1.0
 * *
 * @since 11 06 2017
 */

class App : Application() {

    /**
     * This method is inherited from application class working
     * before any method of this class as well ass all program
     */
    override fun onCreate() {
        super.onCreate()
        instance = this
        getTodoItemDao = initializeDatabase().toDoItemDao

    }

    /**
     * initializeDatabase is using initialize data base this is crete a singleton instance of data base,
     * and access tables using Sessions of particular tables

     * @see ToDoItemDao
     */
    private fun initializeDatabase(): DaoSession {
        val openHelper = DaoMaster.DevOpenHelper(instance, "todo_app_db", null)
        val db = openHelper.writableDatabase
        val daoMaster = DaoMaster(db)
        return daoMaster.newSession()
    }

    companion object {

        /**
         * instance of application class
         */
        private var instance: App? = null

        /**
         * instance of ToDoItemDao table you can assess todo_item table using this
         * eg : - you can add a item into table
         * App.getTodoItemDao.insert(object)
         */
        lateinit  var getTodoItemDao: ToDoItemDao

        /**
         * Gets the application context.

         * @return the application context
         */
        val context: App?
            @Synchronized get() {
                if (instance == null) {
                    synchronized(App::class.java) {
                        if (instance == null) {
                            instance = App()
                        }
                    }
                }
                return instance
            }


    }
}