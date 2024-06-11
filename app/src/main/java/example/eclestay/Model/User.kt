package example.eclestay.Model

import retrofit2.http.FormUrlEncoded

data class User(
    val first_name: String,
    val second_name: String,
    val email: String,
    val password: String,
    val phone: String,
    val access_token: String

)