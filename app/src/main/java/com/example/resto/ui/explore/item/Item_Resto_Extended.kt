package com.example.resto.ui.explore.item

import com.bumptech.glide.Glide
import com.example.resto.R
import com.example.resto.models.NicePlace
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.new_places_item.view.*


class Item_Resto_Extended(var nicePlace: NicePlace) :Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        nicePlace.apply {
            imageUrl?.let {
                try{
                    Glide.with(viewHolder.itemView.image_resto_new_place).load(it).into(viewHolder.itemView.image_resto_new_place)
                }catch (e:KotlinNullPointerException){
                    e.printStackTrace()
                }

            }
            title?.let { title ->
                viewHolder.itemView.image_name_new_place.text = title
            }
        }
    }
    override fun getLayout()= R.layout.new_places_item
}