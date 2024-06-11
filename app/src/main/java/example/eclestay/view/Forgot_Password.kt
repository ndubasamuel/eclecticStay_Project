package example.eclestay.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import example.eclestay.R
import example.eclestay.data.network.DataApi
import example.eclestay.data.repository.Repository
import example.eclestay.databinding.FragmentForgotPasswordBinding
import example.eclestay.databinding.FragmentLoginBinding
import example.eclestay.view.base.BaseFragment
import example.eclestay.viewModel.ViewModelClass


class Forgot_Password : BaseFragment<ViewModelClass, FragmentForgotPasswordBinding, Repository>() {


    override fun getViewModel(): Class<ViewModelClass> {
        return ViewModelClass::class.java
    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentForgotPasswordBinding {

        return FragmentForgotPasswordBinding.inflate(inflater, container, false)
    }

    override fun getFragmentRepository(): Repository {
        return Repository(remoteDataStore.buildApi(DataApi::class.java), userPreferences)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            toolBar.setOnClickListener {
                findNavController().navigate(R.id.action_forgot_Password_to_loginFragment)
            }

            usePhoneNumber.setOnClickListener{
                findNavController().navigate(R.id.action_forgot_Password_to_forgotPassword_UsePhoneFragment)
            }

            sendCode.setOnClickListener{
                initializeEmailCode()
            }
        }


    }

    fun initializeEmailCode() {
        val useEmail = binding.userEmailToRecoverPassword.text.toString().trim()
        
    }


}