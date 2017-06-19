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
package dev.cobb.android_workshop.todo.data.pojo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

import org.greenrobot.greendao.annotation.Generated;

/**
 * ToDoItem is our data base Entity or main object class  we only crete entity and its property in this case we crete
 * a class like bellow , Our db creation and table operations are made by greendao library , Data base fully  encapsulated by
 * greendao if you can change any of the Entity given billow or create a new Entity class you must delete auto crete build from
 * project build path
 *
 * @see "your project path + \ToDo_AndroidWorkShop\build"
 * <p>
 * more refrenace and help of using  greendao vist   http://greenrobot.org/greendao/
 *
 * -------------------------------------------------------------------------------------------------------------------
 * <p>
 * Entity(indexes = {
 * Index(value = "todoTask, todoDate DESC", unique = true)})
 * public class ToDoItem {
 * Id (autoincrement = true)
 * private Long id;
 * NotNull private String todoTask;
 * NotNull private Date todoDate;
 * NotNull private boolean isReminder;
 * NotNull private boolean isDone;}"
 * --------------------------------------------------------------------------------------------------------------------
 * @author dev.cobb
 * @version 1.0
 * @since 22 may 2017
 *
 */

@Entity(indexes = {
        @Index(value = "todoTask, todoDate DESC", unique = true)
})
public class ToDoItem {
        @Id (autoincrement = true)
        private Long id;
        @NotNull
        private String todoTask;
        @NotNull
        private Date todoDate;
        @NotNull
    private boolean isReminder;
    @NotNull
    private boolean isDone;
    @Generated(hash = 266074178)
    public ToDoItem(Long id, @NotNull String todoTask, @NotNull Date todoDate, boolean isReminder, boolean isDone) {
        this.id = id;
        this.todoTask = todoTask;
        this.todoDate = todoDate;
        this.isReminder = isReminder;
        this.isDone = isDone;
    }
    @Generated(hash = 5358619)
    public ToDoItem() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTodoTask() {
        return this.todoTask;
    }
    public void setTodoTask(String todoTask) {
        this.todoTask = todoTask;
    }
    public Date getTodoDate() {
        return this.todoDate;
    }
    public void setTodoDate(Date todoDate) {
        this.todoDate = todoDate;
    }
    public boolean getIsReminder() {
        return this.isReminder;
    }
    public void setIsReminder(boolean isReminder) {
        this.isReminder = isReminder;
    }
    public boolean getIsDone() {
        return this.isDone;
    }
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
    }

