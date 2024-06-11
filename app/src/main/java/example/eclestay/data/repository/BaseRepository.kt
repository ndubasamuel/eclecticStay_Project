package example.eclestay.data.repository

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import example.eclestay.Utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject



abstract class BaseRepository() {

    suspend fun <T> safeApiCall(
        apiCall : suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            }catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        Resource.Failure(false, throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        Resource.Failure(true, null, null)
                    }
                }
            }

        }
    }

}