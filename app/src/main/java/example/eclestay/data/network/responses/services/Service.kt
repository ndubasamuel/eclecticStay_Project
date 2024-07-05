package example.eclestay.data.network.responses.services

data class Service(
    val amenities: List<Amenity>,
    val approved: Boolean,
    val bath: Any,
    val bedroom: Any,
    val beds: Any,
    val cancellation_policy: Any,
    val county: County,
    val county_id: Int,
    val description: String,
    val end_date: String,
    val guests: Any,
    val host_id: Int,
    val hosts: Hosts,
    val images: List<Image>,
    val price: Int,
    val pricing_criteria: String,
    val roles: List<Role>,
    val serviceReviews: List<Any>,
    val service_id: Int,
    val service_name: String,
    val start_date: String,
    val type_id: Int
)