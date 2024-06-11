package example.eclestay.di

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import example.eclestay.EcleStayApplication
import example.eclestay.MainActivity
import example.eclestay.data.network.DataApi
import example.eclestay.data.network.HostSelectionInterceptor
import example.eclestay.data.network.RemoteDataSource
import example.eclestay.data.repository.BaseRepository
import example.eclestay.data.repository.Repository
import example.eclestay.view.Home.HomeActivity
import example.eclestay.view.LoginFragment
import example.eclestay.view.SignUpFragment
import example.eclestay.view.WlcmFragment
import example.eclestay.view.base.BaseFragment
import example.eclestay.viewModel.ViewModelFactory
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, FragmentModule::class, HostSelectionInterceptor::class])
interface AppComponent: AndroidInjector<EcleStayApplication> {



    fun inject(remote: RemoteDataSource)
    fun inject(activity: MainActivity)
    fun inject(homeActivity: HomeActivity)
    fun inject(wlcmFragment: WlcmFragment)
    fun inject(loginFragment: LoginFragment)
    fun inject(signUpFragment: SignUpFragment)
    fun inject(viewModelFactory: ViewModelFactory)
    fun inject(baseRepository: BaseRepository)





    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application) : Builder

       fun appModule(appModule: AppModule) : Builder


        fun build() : AppComponent
    }
}