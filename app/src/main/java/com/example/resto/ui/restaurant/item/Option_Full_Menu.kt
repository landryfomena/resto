package com.example.resto.ui.restaurant.item

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.full_menu_collection.view.*

class Option_Full_Menu : Item() {
    var isvisible=false

    override fun bind(viewHolder: ViewHolder, position: Int) {
        initOption(viewHolder)
        viewHolder.itemView.option_popular.setOnClickListener{
            if(!isvisible){
                viewHolder.itemView.option_collection_full.visibility= View.VISIBLE
                isvisible=!isvisible
            }else{
                viewHolder.itemView.option_collection_full.visibility= View.GONE
                isvisible=!isvisible
            }
        }
    }
    override fun getLayout()= R.layout.full_menu_collection

    fun initOption(viewHolder: ViewHolder){
        var items= mutableListOf<Option>()

        items.add(Option())
        viewHolder.itemView.option_collection_full.apply {
            layoutManager = LinearLayoutManager(viewHolder.itemView.context,
                LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<com.xwray.groupie.ViewHolder>().apply{
                add(Section(items))
            }
        }

    }
}