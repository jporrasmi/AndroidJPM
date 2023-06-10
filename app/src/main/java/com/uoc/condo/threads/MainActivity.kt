package com.uoc.condo.threads

//import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.uoc.condo.threads.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val boton = findViewById<Button>(R.id.btnPrueba)
       // val texto = findViewById<TextView>(R.id.texto)



        binding.btnPrueba.setOnClickListener {
            val miHilo = MiHilo();
            println("1. it will invoke the thread hilo.")
            miHilo.start()
        }

        binding.btnCallSecondActivity.setOnClickListener {

            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            if (!binding.txtNameFA.text.isEmpty()) {
                intent.putExtra("Name", binding.txtNameFA.text.toString())
            }
            if (!binding.txtLastNameFA.text.isEmpty()) {
                intent.putExtra("LastName", binding.txtLastNameFA.text.toString())
            }
            if (!binding.txtCityFA.text.isEmpty()) {
                intent.putExtra("City", binding.txtCityFA.text.toString())
            }
            if (!binding.txtAgeFA.text.isEmpty()) {
                intent.putExtra("Age", binding.txtAgeFA.text.toString().toInt())
            }


            startActivity(intent)
        }

    }



}
class MiHilo(): Thread() {

     override  fun run(){

        for (i in 1..5){
           println((i+1).toString() + ",  Hilo" + i.toString())
        }
         println("7. Va a salir del hijo invocado")
    }
}


class SimpleRunnable: Runnable {
    override fun run() {
        println("${Thread.currentThread()} has run")
    }

}


internal class MiThread(private val n: Int) : Thread() {
    private val res = 0
}