package com.example.resto.ui.restaurant.item

import com.example.resto.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.photo_fragment.view.*

class Item_Photo : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.container.setOnClickListener {

        }

    }
    override fun getLayout()= R.layout.photo_fragment
}