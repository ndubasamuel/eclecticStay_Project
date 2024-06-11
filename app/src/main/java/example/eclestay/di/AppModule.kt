package example.eclestay.di

import android.app.Application
import android.content.Context
import android.provider.ContactsContract.Data
import androidx.viewbinding.ViewBinding
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import example.eclestay.data.UserPreferences
import example.eclestay.data.network.DataApi
import example.eclestay.data.network.HostSelectionInterceptor
import example.eclestay.data.network.RemoteDataSource
import example.eclestay.data.repository.BaseRepository
import example.eclestay.data.repository.BaseRepositoryImpl
import example.eclestay.view.LoginFragment
import example.eclestay.view.SignUpFragment
import example.eclestay.view.base.BaseFragment
import retrofit2.http.POST
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Singleton
    @Provides
    fun provideAuthApi(remoteDataSource: RemoteDataSource) : DataApi{
        return remoteDataSource.buildApi(DataApi::class.java)
    }

    @Singleton
    @Provides
    fun provideUserPreferences() : UserPreferences{
        return UserPreferences(context)
    }

    @Singleton
    @Provides
    fun provideBaseRepository() : BaseRepository{
        return BaseRepositoryImpl()
    }

    @Singleton
    @Provides
    fun provideHostSelectionInterceptor(): HostSelectionInterceptor{
        return HostSelectionInterceptor()
    }


}