package example.eclestay.data.repository

import android.util.Log
import example.eclestay.Model.RemoteResponse
import example.eclestay.Utils.Resource
import example.eclestay.data.UserPreferences
import example.eclestay.data.network.DataApi
import javax.inject.Inject

class Repository @Inject constructor(private val api: DataApi, private val preferences: UserPreferences) : BaseRepository(){


    suspend fun registerUser(firstName: String,
                             secondName: String, email:
                             String, phone: Int,
                             password: String) = safeApiCall {

         api.signUp(firstName, secondName, email, phone, password)

    }


    suspend fun login(email: String, password: String) = safeApiCall {
       Log.d("Repo", "$email, $password")
         api.login(email, password)
    }



    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
        preferences.saveAccessTokens(accessToken, refreshToken)
    }
}