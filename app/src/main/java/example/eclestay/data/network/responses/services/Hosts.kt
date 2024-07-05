package example.eclestay.data.network.responses.services

data class Hosts(
    val about: String,
    val approved: Boolean,
    val business_doc: String,
    val business_name: String,
    val county_id: Int,
    val email: String,
    val hostReviews: List<Any>,
    val host_id: Int,
    val host_name: String,
    val language: String,
    val number: Int,
    val picture: String
)