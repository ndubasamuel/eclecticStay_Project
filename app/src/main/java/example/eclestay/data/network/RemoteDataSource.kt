package example.eclestay.data.network

import android.app.Application
import androidx.viewbinding.BuildConfig
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import example.eclestay.data.repository.BaseRepository
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton


@Module
class RemoteDataSource @Inject constructor(){
    companion object val BASE_URL = "https://d12c-41-90-101-26.ngrok-free.app"


        @Provides
        @Singleton
        fun provideGson(): Gson {
            return Gson()
        }
        @Provides
        @Singleton
        fun provideCache(application: Application): Cache {
            val cacheSize = 10 * 1024 * 1024 // 10 MB
            val cacheDir = File(application.cacheDir, "http_cache")
            return Cache(cacheDir, cacheSize.toLong())
        }

        @Provides
        @Singleton
        fun provideOkHttpClient(cache: Cache): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(HostSelectionInterceptor())
                .cache(cache)
                .build()
        }
//        @Provides
//        @Singleton
//        fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
//            return Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .client(okHttpClient)
//                .build()
//        }

    @Provides
    @Singleton
    fun getChangeURLInterceptor(): HostSelectionInterceptor? {
        return HostSelectionInterceptor()
    }


    fun<Api> buildApi(
        api: Class<Api> ) : Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HostSelectionInterceptor())
                    .build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}


