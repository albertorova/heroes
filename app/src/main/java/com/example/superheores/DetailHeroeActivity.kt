package com.example.superheores

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.superheores.modelo.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_heroe.*
import kotlinx.android.synthetic.main.item_heroes.view.*

class DetailHeroeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_heroe)
        setSupportActionBar(toolbar)

        var heroe = intent.getSerializableExtra("heroe") as? Result


        heroe = DataHolder.heroeSeleccionado

        if (heroe != null) {
            mostrar(heroe)
        }

       supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    fun mostrar(heroe: Result) {
        toolbar.title = heroe.name.toUpperCase()

        if (heroe.connections.superAffiliation != null) {
            iv_badge.visibility = View.VISIBLE

            when (heroe.connections.superAffiliation) {
                "jl" -> {
                    iv_badge.setImageResource(R.drawable.ic_jl)
                }
                "avengers" -> {
                    iv_badge.setImageResource(R.drawable.ic_avengers)
                }

                "watchmen" -> {
                    iv_badge.setImageResource(R.drawable.ic_watchmen)
                }
            }

        } else {
            iv_badge.visibility = View.GONE
        }
        if (heroe.image.url.isNotEmpty()) {
            Picasso.get().load(heroe.image.url).into(ivHeroe)
        }

        text.text = heroe.biography.toString()
    }
}