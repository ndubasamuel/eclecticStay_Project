package example.eclestay.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import dagger.Provides
import example.eclestay.Model.RemoteResponse
import example.eclestay.data.UserPreferences
import example.eclestay.data.network.RemoteDataSource
import example.eclestay.data.repository.BaseRepository
import example.eclestay.viewModel.ViewModelFactory
import javax.inject.Singleton



abstract class BaseFragment<VM: ViewModel, Binding: ViewBinding, Repo: BaseRepository>: Fragment(){


    protected lateinit var userPreferences: UserPreferences
    protected lateinit var binding: Binding
    protected lateinit var viewModel: VM
    protected val remoteDataStore = RemoteDataSource()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        userPreferences = UserPreferences(requireContext())
        binding = getFragmentBinding(inflater, container)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())
        return binding.root
    }

    abstract fun getViewModel(): Class<VM>
    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) : Binding

    abstract fun getFragmentRepository(): Repo
}