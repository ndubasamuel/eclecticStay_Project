package example.eclestay.view

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import example.eclestay.R
import example.eclestay.data.network.DataApi
import example.eclestay.data.repository.Repository
import example.eclestay.databinding.FragmentSignUpBinding
import example.eclestay.databinding.FragmentWlcmBinding
import example.eclestay.view.base.BaseFragment
import example.eclestay.viewModel.ViewModelClass


class WlcmFragment : BaseFragment<ViewModelClass, FragmentWlcmBinding, Repository>()  {



    override fun getViewModel(): Class<ViewModelClass> {
        return ViewModelClass::class.java
    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentWlcmBinding {
        return FragmentWlcmBinding.inflate(inflater, container, false)
    }

    override fun getFragmentRepository(): Repository {
        return Repository(remoteDataStore.buildApi(DataApi::class.java), userPreferences)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.registerNow.background.setColorFilter(Color.YELLOW, PorterDuff.Mode.MULTIPLY)

        binding.apply {
            registerNow.setOnClickListener {
                findNavController().navigate(R.id.action_wlcmFragment_to_signUpFragment)
            }
            proceedLogin.setOnClickListener {
                findNavController().navigate(R.id.action_wlcmFragment_to_loginFragment)
            }
        }
    }
}