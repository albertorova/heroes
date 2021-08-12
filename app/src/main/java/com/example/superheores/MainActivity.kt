package com.example.superheores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheores.modelo.HeroesResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val heroes = readJsonFromFile()

        rvHeroes.layoutManager = LinearLayoutManager(this)
        rvHeroes.adapter = HeroesAdapter(heroes.results) {
            val intent = Intent(this, DetailHeroeActivity::class.java)
            intent.putExtra("heroe", it)

            //Forma 2
            DataHolder.heroeSeleccionado = it

            startActivity(intent)
        }
    }

    fun readJsonFromFile(): HeroesResponse {
        var json = ""
        try {
            val url = "heroes.json"
            val bufferedReader = BufferedReader(
                    InputStreamReader(assets.open(url))
            )
            val paramsBuilder = StringBuilder()
            var line: String? = bufferedReader.readLine()
            while (line != null) {
                paramsBuilder.append(line)
                line = bufferedReader.readLine()
            }

            json = paramsBuilder.toString()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val heroes = Gson().fromJson(json, HeroesResponse::class.java)

        return heroes
    }
}
