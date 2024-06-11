package example.eclestay.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import example.eclestay.EcleStayApplication
import example.eclestay.Model.RemoteResponse
import example.eclestay.R
import example.eclestay.Utils.Resource
import example.eclestay.data.UserPreferences
import example.eclestay.data.network.DataApi
import example.eclestay.data.repository.BaseRepository
import example.eclestay.data.repository.Repository
import example.eclestay.databinding.FragmentLandingBinding
import example.eclestay.databinding.FragmentLoginBinding
import example.eclestay.view.base.BaseFragment
import example.eclestay.viewModel.ViewModelClass
import example.eclestay.viewModel.ViewModelFactory
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject


class LoginFragment : BaseFragment<ViewModelClass, FragmentLoginBinding, Repository>() {


    @Inject
    lateinit var factory: ViewModelFactory
    //val sharedPreferences = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().application as EcleStayApplication).mInjector.inject(this)
        viewModel = ViewModelProvider(this, factory).get(ViewModelClass::class.java)

        binding.apply {
            buttonLogin.setOnClickListener {
                validate()
            }
            createAccount.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
            }
            forgotPassword.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_forgot_Password)
            }
        }
//        Observe User data
        viewModel.loginData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    val sharedPreferences = UserPreferences(requireContext())
                    lifecycleScope.launch {
                        sharedPreferences.saveAccessTokens("", "")
                    }
                    it.value.user.access_token.let{
                            findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
                        Toast.makeText(requireContext(), "Registration Successful ):", Toast.LENGTH_SHORT).show()
                        }
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Login Failed", Toast.LENGTH_SHORT).show()

                }
            }
        })
    }


    override fun getViewModel(): Class<ViewModelClass> {
        return ViewModelClass::class.java
    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun getFragmentRepository(): Repository {
        return Repository(remoteDataStore.buildApi(DataApi::class.java), userPreferences)
    }


    //   Email & Password Validation
    private fun validate(){
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        if (email.isEmpty()) {
            Toast.makeText(requireContext(), "Email Required", Toast.LENGTH_SHORT).show()
            return
        }
        if (password.isEmpty()) {
            Toast.makeText(requireContext(), "Password Required", Toast.LENGTH_SHORT).show()
            return
        }


        viewModel.loginUser(email, password)

    }

}