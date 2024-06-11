package example.eclestay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import example.eclestay.data.UserPreferences
import example.eclestay.view.Home.HomeActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

//        val userPreferences = UserPreferences(this)
//        userPreferences.authToken.asLiveData().observe(this, Observer {
//            Toast.makeText(this, it ?:"Token is null", Toast.LENGTH_SHORT).show()

//            startActivity( Intent(this, HomeActivity::class.java))

//        })
//
//        finish()
//            startActivity( Intent(this, HomeActivity::class.java))
    }
}
