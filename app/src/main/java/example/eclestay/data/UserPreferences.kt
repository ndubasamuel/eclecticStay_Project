package example.eclestay.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


const val PREFERENCES_NAME = "auth_key"

class UserPreferences(context: Context) {

    private val applicationContext = context.applicationContext
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

    val authToken: Flow<String?> = context.dataStore.data
        .map { prefereces ->
            prefereces[KEY_AUTH]

        }
    val refreshToken: Flow<String?> = context.dataStore.data.map { preferences ->
            preferences[REFRESH_TOKEN]
        }

    suspend fun saveAccessTokens(authToken: String, refreshToken: String){
        applicationContext.dataStore.edit { preferences ->
            preferences[KEY_AUTH] = authToken
            preferences[REFRESH_TOKEN] = refreshToken
        }
    }



    companion object{
        private val KEY_AUTH = stringPreferencesKey("auth_key")
        private val REFRESH_TOKEN = stringPreferencesKey("refresh_token")

    }




}


