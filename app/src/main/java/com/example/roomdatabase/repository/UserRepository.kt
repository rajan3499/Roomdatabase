package com.example.roomdatabase.repository

import kotlinx.coroutines.flow.Flow
import com.example.roomdatabase.dao.UserDao
import com.example.roomdatabase.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class UserRepository @Inject constructor(private val userDao: UserDao) {

    val getUserData:Flow<List<User>> = userDao.getUserData()

    suspend fun insert(user: User) = withContext(Dispatchers.IO)
    {
        userDao.insert(user)
    }
}