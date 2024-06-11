package example.eclestay.data.network

import example.eclestay.Model.RemoteResponse
import example.eclestay.Utils.Resource
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface DataApi {

    @FormUrlEncoded
    @POST("/user/signUp")
    suspend fun signUp(
        @Field("first_name") firstName: String,
        @Field("second_name") lastName: String,
        @Field("email") email: String,
        @Field("phone") phoneNumber: Int?,
        @Field("password") password: String

    ): RemoteResponse

    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): RemoteResponse


}