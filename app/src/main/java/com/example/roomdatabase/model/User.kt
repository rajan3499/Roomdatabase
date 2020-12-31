package com.example.roomdatabase.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user" )
data class User(val name: String,val age: Int) {

    @PrimaryKey(autoGenerate = true)
    var id:Int ?= null

}