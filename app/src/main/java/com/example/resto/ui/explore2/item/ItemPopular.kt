package com.example.resto.ui.explore2.item

import com.example.resto.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder

class ItemPopular  : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
    }
    override fun getLayout()= R.layout.popular_this_week_item
}