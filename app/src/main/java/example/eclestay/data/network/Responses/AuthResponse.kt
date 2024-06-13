package example.eclestay.data.network.Responses

data class LoginResponse(
    val Message: String,
    val `data`: Data,
    val status: Int
)