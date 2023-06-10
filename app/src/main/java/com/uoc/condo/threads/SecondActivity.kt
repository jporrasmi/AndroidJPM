package com.uoc.condo.threads

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uoc.condo.threads.databinding.ActivityMainBinding
import com.uoc.condo.threads.databinding.ActivitySecondBinding
import com.squareup.picasso.Picasso


class SecondActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = getIntent()
        if (intent.extras?.isEmpty() != true) {
            val name = intent.getStringExtra("Name")
            val lastName = intent.getStringExtra("LastName")
            val city = intent.getStringExtra("City")
            val age = intent.getIntExtra("Age", 0)

            binding.txtName.setText(name)
            binding.txtLastName.setText(lastName)
            binding.txtCity.setText(city)
            binding.txtAge.setText(age.toString())
        }

        Picasso.get().load("https://i.imgur.com/DvpvklR.png")
            .resize(600, 600).centerCrop()
            .into(binding.image);


       /*
        setContent {
            ThreadsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        */
    }


}





    //Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(binding.imageView)


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

