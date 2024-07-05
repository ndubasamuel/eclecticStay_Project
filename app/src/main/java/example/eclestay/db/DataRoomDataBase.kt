package example.eclestay.db

import androidx.room.Database
import androidx.room.TypeConverters


@TypeConverters(DataConverter::class)
@Database(entities = [Service::class], version = 2, exportSchema = false)
abstract class RoomDataBase: RoomDataBase {
        abstract fun getNewsDao(): NewsDao

        companion object {
            @Volatile
            private var instance: NewsDatabase? = null
            private val LOCK = Any()
            operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
                instance ?: createDatabase(context).also { instance = it}
            }
            private fun createDatabase(context: Context) =
                Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "news_db.db"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
        }
    }
}