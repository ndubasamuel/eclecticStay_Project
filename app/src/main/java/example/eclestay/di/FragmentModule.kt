package example.eclestay.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import example.eclestay.view.LoginFragment
import example.eclestay.view.SignUpFragment


@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginInjector() : LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeSignUpFragment(): SignUpFragment
}