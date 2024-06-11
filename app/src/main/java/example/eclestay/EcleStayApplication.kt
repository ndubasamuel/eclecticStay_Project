package example.eclestay

import android.app.Application
import androidx.viewbinding.ViewBinding
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import example.eclestay.data.network.HostSelectionInterceptor
import example.eclestay.di.AppComponent
import example.eclestay.di.DaggerAppComponent
import example.eclestay.data.network.RemoteDataSource
import example.eclestay.data.repository.BaseRepository
import example.eclestay.data.repository.Repository
import example.eclestay.di.AppModule
import example.eclestay.viewModel.ViewModelClass
import javax.inject.Inject
import javax.inject.Qualifier

class EcleStayApplication: Application(), HasAndroidInjector {

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .application(Application())
            .build()
            .inject(this)
    }

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class ApplicationContext

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }

}