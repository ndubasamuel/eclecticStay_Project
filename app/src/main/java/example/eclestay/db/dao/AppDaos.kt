package example.eclestay.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import example.eclestay.data.network.responses.services.Service

@Dao
interface ServiceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(service: List<Service>)


    @Query("SELECT * FROM 'Services'")
    fun getAllServices() : List<Service>

}