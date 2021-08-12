package com.example.superheores

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.superheores.modelo.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_heroes.view.*

class HeroesAdapter(private val heroes: List<Result>, var onHeroeSelect: (Result) -> Unit) :
        RecyclerView.Adapter<HeroesAdapter.MyViewHolder>() {


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun mostrar(heroe: Result) {
            itemView.tvHeroe.text = heroe.name.toUpperCase()

            if (heroe.connections.superAffiliation != null) {
                itemView.iv_badge.isVisible = true

                when (heroe.connections.superAffiliation) {
                    "jl" -> {
                        itemView.iv_badge.setImageResource(R.drawable.ic_jl)
                    }
                    "avengers" -> {
                        itemView.iv_badge.setImageResource(R.drawable.ic_avengers)
                    }

                    "watchmen" -> {
                        itemView.iv_badge.setImageResource(R.drawable.ic_watchmen)
                    }
                }

            } else {
                itemView.iv_badge.isVisible = false
            }
            if (heroe.image.url.isNotEmpty()) {
                Picasso.get().load(heroe.image.url).into(itemView.ivHeroe)
            }
        }
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): MyViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_heroes, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mostrar(heroes[position])

        holder.itemView.setOnClickListener {
            onHeroeSelect(heroes[position])
        }
    }

    override fun getItemCount() = heroes.size
}

fun ImageView.tint(@ColorRes id: Int, mode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN) {
    this.setColorFilter(ContextCompat.getColor(context, id), mode)
}