package example.eclestay.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import example.eclestay.Model.RemoteResponse
import example.eclestay.Utils.Resource
import example.eclestay.data.repository.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelClass @Inject constructor(private val repository: Repository): ViewModel() {

    private val _registerData: MutableLiveData<Resource<RemoteResponse>> = MutableLiveData()
    val registerData: LiveData<Resource<RemoteResponse>>
        get() = _registerData

    private val _loginData: MutableLiveData<Resource<RemoteResponse>> = MutableLiveData()
    val loginData: LiveData<Resource<RemoteResponse>>
        get() = _loginData



    fun registerUser(firstName: String, secondName: String, email: String, phone: Int?, password: String){
        try {
            Log.d("ViewModel", "User Registration")
            viewModelScope.launch {
                _registerData.value =
                    phone?.let {
                        repository.registerUser(firstName, secondName, email, it, password
                        )
                    }
            }
        } catch (_:Exception){
            Log.d("ViewModel", "User Registration")
        }
    }


    fun loginUser(email: String, password: String) {
      try {
        viewModelScope.launch {
          Log.d("ViewModel", "Repo Data ${email}, $password")
          _loginData.value = repository.login(email, password)
       }
        }catch (_:Exception) {
          Log.d("ViewModel", "Failed")
        }


    }

    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
        repository.saveAccessTokens(accessToken, refreshToken)
    }
}