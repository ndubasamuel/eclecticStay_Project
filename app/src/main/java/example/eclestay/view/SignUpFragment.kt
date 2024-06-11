package example.eclestay.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.android.support.AndroidSupportInjection
import example.eclestay.EcleStayApplication
import example.eclestay.R
import example.eclestay.Utils.Resource
import example.eclestay.data.UserPreferences
import example.eclestay.data.network.DataApi
import example.eclestay.data.repository.Repository
import example.eclestay.databinding.FragmentSignUpBinding
import example.eclestay.view.base.BaseFragment
import example.eclestay.viewModel.ViewModelClass
import example.eclestay.viewModel.ViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject


class SignUpFragment : BaseFragment<ViewModelClass, FragmentSignUpBinding, Repository>() {


    @Inject
    lateinit var factory: ViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun getViewModel(): Class<ViewModelClass> {
        return ViewModelClass::class.java
    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentSignUpBinding {
        return FragmentSignUpBinding.inflate(inflater, container, false)
    }

    override fun getFragmentRepository(): Repository {
        return Repository(remoteDataStore.buildApi(DataApi::class.java), userPreferences)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().application as EcleStayApplication).mInjector.inject(this)

        viewModel = ViewModelProvider(this, factory).get(ViewModelClass::class.java)

        binding.apply {
            signUpButton.setOnClickListener{
                validateUser()
            }
        }

        viewModel.registerData.observe(viewLifecycleOwner, Observer{
            when (it){
                is Resource.Success -> {
                    val sharedPreferences = UserPreferences(requireContext())
                    lifecycleScope.launch {
                        sharedPreferences.saveAccessTokens("", "")
                    }
                    it.value.user.access_token.let {
                        findNavController().navigate(R.id.action_signUpFragment_to_homeActivity)
                        Toast.makeText(requireContext(), "Successful ):", Toast.LENGTH_SHORT).show()
                    }


                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), ":( Registration Failed", Toast.LENGTH_SHORT).show()

                }
            }
        })


    }

    fun validateUser(){
        val firstName = binding.firstName.text.toString().trim()
        val secondName = binding.secondName.text.toString().trim()
        val email = binding.email.text.toString().trim()
        val phone = binding.phoneNumber.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        val confirmPassword = binding.etConfirmPassword.text.toString().trim()




        if (firstName.isEmpty()){
            Toast.makeText(requireContext(), " :( First Name Required", Toast.LENGTH_SHORT).show()
            return
        }
        if (secondName.isEmpty()){
            Toast.makeText(requireContext(), " :( Second Name Required", Toast.LENGTH_SHORT).show()
            return
        }
        if (email.isEmpty() || !email.matches(Regex("^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$"))) {
            Toast.makeText(requireContext(), " :( User Email Required", Toast.LENGTH_SHORT).show()
            return
        }
        if (phone.isNullOrEmpty() || !phone.matches(Regex("^(254|0)([7][0-9]|[1][0-1]){1}[0-9]{1}[0-9]{6}\$"))){
            Toast.makeText(requireContext(), " :( Phone Number Required", Toast.LENGTH_SHORT).show()
            return

        }
        if (password.isEmpty() || !password.matches(Regex("^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[A-Z])(?=.*[-\\#\\\$\\.\\%\\&\\*])(?=.*[a-zA-Z]).{8,16}\$"))){
            Toast.makeText(requireContext(), " :( Password Required", Toast.LENGTH_SHORT).show()
            return
        }
        if (confirmPassword.isEmpty() || !password.matches(Regex("^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[A-Z])(?=.*[-\\#\\\$\\.\\%\\&\\*])(?=.*[a-zA-Z]).{8,16}\$"))) {
            Toast.makeText(requireContext(), " :( Confirm Password", Toast.LENGTH_SHORT).show()
            return

        }
        if (password.length != confirmPassword.length){
            Toast.makeText(requireContext(), " :( Password Has to match", Toast.LENGTH_SHORT).show()
        }

        viewModel.registerUser(firstName, secondName, email, phone.toIntOrNull(), password)
        return

    }



}