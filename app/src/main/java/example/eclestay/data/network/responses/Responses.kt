package example.eclestay.data.network.Responses

import example.eclestay.Model.Types
import example.eclestay.Model.User

//Registration Login
data class AuthResponse(
    val user: User,
    val Message: String,
    val `data`: Data,
    val status: Int

)

data class Data(
    val token: String
)

data class ResetPasswordResponse(
    val Status: String,
    val resentLink: String,
    val token: String
)


data class Food(
    val amenities: List<Amenity>,
    val approved: Boolean,
    val bath: Int,
    val bedroom: Int,
    val beds: Int,
    val cancellation_policy: String,
    val county: County,
    val county_id: Int,
    val description: String,
    val end_date: String,
    val guests: Int,
    val host_id: Int,
    val hosts: Hosts,
    val images: List<Image>,
    val price: Int,
    val pricing_criteria: String,
    val roles: List<Role>,
    val service_id: Int,
    val service_name: String,
    val start_date: String,
    val type_id: Int,
    val types: Types
)

//  DataX
data class DataX(
    val Services: List<Service>
)

data class Service(
    val amenities: List<Amenity>,
    val approved: Boolean,
    val bath: Int,
    val bedroom: Int,
    val beds: Int,
    val cancellation_policy: String,
    val county: County,
    val county_id: Int,
    val description: String,
    val end_date: String,
    val guests: Int,
    val host_id: Int,
    val hosts: Hosts,
    val images: List<Image>,
    val price: Int,
    val pricing_criteria: String,
    val roles: List<Role>,
    val service_id: Int,
    val service_name: String,
    val start_date: String,
    val type_id: Int
)
data class Hosts(
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

data class Image(
    val image_id: Int,
    val service_id: Int,
    val service_image: String
)

data class Role(
    val role_id: Int,
    val role_name: String,
    val service_id: Int
)
//  Amenities
data class Amenity(
    val amenity_id: Int,
    val amenity_name: String,
    val service_id: Int
)

// Country
data class County(
    val county_code: Int,
    val county_id: Int,
    val county_name: String,
    val county_url: String
)





//          awaiting actual api's
data class Item (val imageResource: Int,
                 val title: String)

data class Popular(val Image: Int,
    val title: String,
    val location: String,
    val locationName: String,
    val rating: Int,
    )

data class Places(
    val image: Int,
    val title: String,
)

data class Category(
    val image: Int,
    val title: String
)

data class Menu(
    val title: String
)
