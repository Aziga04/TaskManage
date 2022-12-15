package com.example.taskmanage.Data.local

import androidx.room.*
import com.example.taskmanage.model.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAll(): List<Task>
    
    @Insert
     fun insert(task: Task)

     @Delete
     fun delete(task: Task)
    @Update
    fun update(task: Task)

}