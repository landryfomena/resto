package com.example.resto.ui.explore.item

import com.bumptech.glide.Glide
import com.example.resto.R
import com.example.resto.models.NicePlace
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.top_categories_item.view.*

class ItemTopCategories(var nicePlace: NicePlace) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        nicePlace.apply {
            imageUrl?.let {
                Glide.with(viewHolder.itemView).load(it).into(viewHolder.itemView.image_resto)
            }
            title?.let { title ->
                viewHolder.itemView.image_name.text = title
            }
        }
    }

    override fun getLayout() = R.layout.top_categories_item
}