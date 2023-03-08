package cn.jiguang.imuisample.data.source

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import cn.jiguang.imuisample.data.MyMessage

@Database(entities = arrayOf(MyMessage::class), version = 3, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun messageDao(): MessageDao

    companion object {
        private val sLock = Any()
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            if (null == INSTANCE) {
                synchronized(sLock) {
                    if (null == INSTANCE) {
                        INSTANCE = Room
                                .databaseBuilder<MyDatabase>(context.applicationContext, MyDatabase::class.java, "sample.db")
                                .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}