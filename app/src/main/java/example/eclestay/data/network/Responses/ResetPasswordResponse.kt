package example.eclestay.data.network.Responses

data class ResetPasswordResponse(
    val Status: String,
    val resentLink: String,
    val token: String
)