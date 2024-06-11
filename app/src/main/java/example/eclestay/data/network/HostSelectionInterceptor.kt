package example.eclestay.data.network

import android.util.Patterns
import androidx.datastore.core.DataStore
import dagger.Module
import example.eclestay.data.UserPreferences
import okhttp3.*
import java.io.IOException
import javax.inject.Inject

@Module
class HostSelectionInterceptor @Inject constructor(): Interceptor {

    lateinit var dataStore: DataStore<String>

    @Volatile
    private var host: String? = null

    private fun setHost(host: String?) {
        this.host = host
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain) : Response {
        var original: Request = chain.request()

//        val requestUrl = original.url.toString()
//        val protocol = "(?i:http|https|rtsp)://"
//        requestUrl.replaceFirst(protocol.toRegex(), "")
//            .replaceFirst(Patterns.DOMAIN_NAME.toString().toRegex(), "")
        val host = host
        if (host != null) {
            val newUrl: HttpUrl = original.url.newBuilder()
                .host(host)
                .build()
            original = original.newBuilder()

                .url(newUrl)
                .build()
        }
        return chain.proceed(original)
    }

    @Throws(Exception::class)
    fun main() {
        val interceptor = HostSelectionInterceptor()
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val request: Request = Request.Builder()
            .url("https://91d5-41-90-101-26.ngrok-free.app")
            .build()
        val call1 = okHttpClient.newCall(request)
        val response1 = call1.execute()

        interceptor.setHost("www.pepsi.com")
        val call2 = okHttpClient.newCall(request)
        val response2 = call2.execute()

    }

    private fun validateBackSlash(str: String): Boolean {
        return str.substring(str.length - 1) != "/"
    }
}


