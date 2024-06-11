package example.eclestay.view.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import example.eclestay.R
import example.eclestay.data.network.DataApi
import example.eclestay.data.repository.BaseRepository
import example.eclestay.data.repository.Repository
import example.eclestay.databinding.FragmentForgotPasswordBinding
import example.eclestay.databinding.FragmentForgotPasswordUsePhoneBinding
import example.eclestay.view.base.BaseFragment
import example.eclestay.viewModel.ViewModelClass


class ForgotPassword_UsePhoneFragment :  BaseFragment<ViewModelClass, FragmentForgotPasswordUsePhoneBinding, Repository>() {

    override fun getViewModel(): Class<ViewModelClass> {
        return ViewModelClass::class.java
    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentForgotPasswordUsePhoneBinding {
        return FragmentForgotPasswordUsePhoneBinding.inflate(inflater, container, false)
    }

    override fun getFragmentRepository(): Repository {
        return Repository(remoteDataStore.buildApi(DataApi::class.java), userPreferences)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            toolBar.setOnClickListener{
                findNavController().navigate(R.id.action_forgotPassword_UsePhoneFragment_to_forgot_Password)
            }
            usePhoneNumberInstead.setOnClickListener{
                findNavController().navigate(R.id.action_forgotPassword_UsePhoneFragment_to_forgot_Password)
            }
            sendCode.setOnClickListener{
                initiateCodeRetrival()
            }

        }
    }

    fun initiateCodeRetrival() {
        val enteredPhone = binding.etPhoneNumberRecovery.text.toString().trim()

    }

}