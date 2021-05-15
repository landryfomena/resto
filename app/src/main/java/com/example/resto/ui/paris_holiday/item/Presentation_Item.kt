package com.example.resto.ui.paris_holiday.item

import com.bumptech.glide.Glide
import com.example.resto.R
import com.example.resto.models.NicePlace
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.presentation_item_resto.view.*

class Presentation_Item(var nicePlace: NicePlace)  : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        nicePlace.apply {
            imageUrl?.let {
                try{
                    Glide.with(viewHolder.itemView).load(it).into(viewHolder.itemView.image_presentation)
                }catch (e:KotlinNullPointerException){
                    e.printStackTrace()
                }

            }
        }
    }
    override fun getLayout()= R.layout.presentation_item_resto
}