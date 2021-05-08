package com.example.resto.ui.collectionbyfozzy.item

import com.bumptech.glide.Glide
import com.example.resto.R
import com.example.resto.models.NicePlace
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.collections_by_fozzi_item.view.*

class Collection_Item(var nicePlace: NicePlace) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener{

        }
        nicePlace.apply {
            imageUrl?.let {
                try{
                    Glide.with(viewHolder.itemView).load(it).into(viewHolder.itemView.image_collection)
                }catch (e:KotlinNullPointerException){
                    e.printStackTrace()
                }

            }
            title?.let { title ->
                viewHolder.itemView.title_collection.text = title
            }
        }
    }
    override fun getLayout()= R.layout.collections_by_fozzi_item
}