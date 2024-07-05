package example.eclestay.data.network.responses.hosts

data class HostsResponseItem(
    val about: String,
    val approved: Boolean,
    val business_doc: String,
    val business_name: String,
    val county_id: Int,
    val email: String,
    val host_id: Int,
    val host_name: String,
    val language: String,
    val number: Int,
    val picture: String
)