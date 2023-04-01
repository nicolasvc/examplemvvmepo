package com.example.examplemvvmepo.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examplemvvmepo.framework.database.daos.UserDao
import com.example.examplemvvmepo.framework.database.entities.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class UserDataBase: RoomDatabase() {

    abstract fun getUserDao() : UserDao


    companion object {
        @Synchronized
        fun getDatabase(context: Context): UserDataBase =
            Room.databaseBuilder(
                context.applicationContext,
                UserDataBase::class.java,
                "user_db"
            ).build()
    }
}