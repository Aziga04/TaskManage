package com.example.taskmanage.Data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskmanage.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase (){
    abstract fun dao(): TaskDao
}