package com.example.roomdatabase.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.dao.UserDao
import com.example.roomdatabase.database.UserDatabase
import com.example.roomdatabase.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context) : UserDatabase =
            Room.databaseBuilder(context,UserDatabase::class.java,"userDatabase")
                .build()

    @Provides
    fun providesUserDao(userDatabase: UserDatabase):UserDao =
        userDatabase.userDao()

    @Provides
    fun providesUserRepository(userDao: UserDao):UserRepository =
        UserRepository(userDao)

}