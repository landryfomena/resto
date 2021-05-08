package com.example.resto.ui.search.item

import com.bumptech.glide.Glide
import com.example.resto.R
import com.example.resto.models.NicePlace
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.recommend_collection.view.*
import kotlinx.android.synthetic.main.top_categories_item.view.*
import kotlinx.android.synthetic.main.top_categories_item.view.image_resto

class Item_Recommend (var nicePlace: NicePlace): Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        nicePlace.apply {
            imageUrl?.let {
                Glide.with(viewHolder.itemView).load(it).into(viewHolder.itemView.recommended_image)
            }
            title?.let { title ->
                viewHolder.itemView.title.text = title
            }
        }
    }

    override fun getLayout() = R.layout.recommend_collection
}