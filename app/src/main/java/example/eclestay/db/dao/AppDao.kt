package example.eclestay.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import example.eclestay.Utils.Resource
import example.eclestay.data.network.responses.categories.CategoriesResponseItem
import example.eclestay.data.network.responses.hosts.HostsResponseItem
import example.eclestay.data.network.responses.services.Service
import example.eclestay.data.network.responses.services.ServicesResponse

@Dao
interface AppDaos {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertService(service: List<Service>)
 @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertServiceResponse(servicesResponse: ServicesResponse)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: List<CategoriesResponseItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHost(hosts: List<HostsResponseItem>)

    @Query("SELECT * FROM 'Service'")
    fun getAllServices() : LiveData<Service>

    @Query("SELECT * FROM 'ServiceResponse'")
    fun getServiceResponse() : LiveData<ServicesResponse>

    @Query("SELECT * FROM 'categories'")
    fun getAllCategories() : List<CategoriesResponseItem>

    @Query("SELECT * FROM 'Host'")
    fun getAllHosts(): List<HostsResponseItem>

}