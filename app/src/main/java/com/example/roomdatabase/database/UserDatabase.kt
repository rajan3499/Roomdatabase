package com.example.roomdatabase.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatabase.dao.UserDao
import com.example.roomdatabase.model.User

@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao():UserDao
}