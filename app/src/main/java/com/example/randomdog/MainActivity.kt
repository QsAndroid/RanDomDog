package com.example.randomdog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.api.load
import com.example.randomdog.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        var binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)


        binding.buttonGet.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {

                try {

                    val response = ApiAdapter.apiClient.getRandomDogImage()

                    if (response.isSuccessful && response.body() != null) {

                        val data = response.body()!!

                        data.message?.let { url ->

                            withContext(Dispatchers.Main) {

                                binding.imageViewRandomdog.load(url)

                            }




                        }
                    }
                } catch (exception : Exception) {

                }


            }


        }





    }
}