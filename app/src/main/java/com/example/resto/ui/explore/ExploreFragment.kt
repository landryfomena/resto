package com.example.resto.ui.explore

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.explore.item.ItemTopCategories
import com.example.resto.ui.explore.item.Item_Resto_Extended
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_explore.*
import kotlinx.android.synthetic.main.top_categories_item.*
import kotlinx.android.synthetic.main.top_categories_item.view.*

class ExploreFragment : Fragment() {

    private lateinit var exploreViewModel: ExploreViewModel
    lateinit var dialog: Dialog
    lateinit var cardView: CardView
    lateinit var testeur: TextView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
        exploreViewModel =
                ViewModelProvider(this).get(ExploreViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_explore, container, false)
        exploreViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       dialog= Dialog(requireContext())
        pageTitle.setText("cool")
        initRecycleview()
        initTopCategories()
        setOnClickListener()
        openDialogPassword()

    }
    fun initRecycleview(){
        var items= mutableListOf<Item_Resto_Extended>()
        (0..5).forEach{
          items.add(Item_Resto_Extended())
        }
        new_places_container.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
    fun initTopCategories(){
        var items= mutableListOf<ItemTopCategories>()
        (0..5).forEach{
            items.add(ItemTopCategories())
        }
       /* fun modif(view: View) {
            var contenu= title.text.toString().toString()
            contenu="cool"
            title.text= "$contenu"
        }*/
        topCategories.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
    private fun setOnClickListener(){
        main_searchView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ExploreFragmentDirections.actionNavigationHomeToSearch())
        }
        pageTitle.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ExploreFragmentDirections.actionNavigationHomeToBoonLayFragment())
        }
        show.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ExploreFragmentDirections.actionNavigationExploreToCollectionByFozzy2())
        }
        icon_search.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ExploreFragmentDirections.actionNavigationExploreToNavigationMyOrder())
        }
    }
    private fun openDialogPassword() {
        dialog.setContentView(R.layout.dialog_localisation_fragment)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(UCharacter.JoiningType.TRANSPARENT))
        cardView=dialog.findViewById(R.id.card)
        cardView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(view: View) {
               dialog.dismiss()
                //val show = Toast.makeText(requireContext(), cardView, Toast.LENGTH_SHORT).show
            }
        })
        dialog.show()
    }

   /*var mytitle=title.text.toString()
            mytitle="cool"
            title.text=mytitle
             pageTitle.setText("cool")
   fun diminuer(view: View) {
        var contenu= findViewById<TextView>(R.id.textView).text.toString().toString()
        contenu="cool"
        findViewById<TextView>(R.id.textView).text= "$contenu"
    }*/
}