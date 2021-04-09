package com.example.resto.ui.explorer

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.explorer.item.ItemTopCategories
import com.example.resto.ui.explorer.item.Item_Resto_Extended
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_explorer.*
import kotlinx.android.synthetic.main.new_places_item.*

class ExplorerFragment : Fragment() {

    private lateinit var explorerViewModel: ExplorerViewModel
    lateinit var dialog: Dialog
    lateinit var cardView: CardView
    lateinit var recent: TextView
    private  lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
        explorerViewModel=
                ViewModelProvider(this).get(ExplorerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_explorer, container, false)
        explorerViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //bottomSheet()
        setOnClickListener()
        initRecycleview()
        initTopCategories()
       // openDialogPassword()
    }
   fun setOnClickListener(){
        view_all_title.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ExplorerFragmentDirections.actionNavigationExplorerToCollectionByFozzy())
        }
        icon_search.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ExplorerFragmentDirections.actionNavigationExplorerToExplorerSecondFragment())
        }
       main_searchView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ExplorerFragmentDirections.actionNavigationExplorerToSearch())
        }
       view_all_title.setOnClickListener{
           Navigation.findNavController(it)
               .navigate(ExplorerFragmentDirections.actionNavigationExplorerToBoonLayFragment())
       }
       pageTitle.setOnClickListener {
           Navigation.findNavController(it)
               .navigate(ExplorerFragmentDirections.actionNavigationExplorerToFiltersFullFragment())
       }
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
        topCategories.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }

/*
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
    }*/
    /*
    fun bottomSheet(){
        bottomSheetBehavior = BottomSheetBehavior.from(filter_bottomsheet)

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                TODO("Not yet implemented")
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState){
                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(this@HomeFragment , "STATE_COLLAPSED", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_EXPANDED -> Toast.makeText(this@HomeFragment, "STATE_EXPANDED", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_DRAGGING -> Toast.makeText(this@HomeFragment, "STATE_EXPANDED", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_HIDDEN -> Toast.makeText(this@HomeFragment, "STATE_EXPANDED", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(this@HomeFragment, "OTHER_STATE", Toast.LENGTH_SHORT).show()
                }
            }
         })
    }
    fun bottomsheetOnClick(){
        setOnClickListener()
        if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        else
            bottomSheetBehavior.state= BottomSheetBehavior.STATE_EXPANDED
    }*/

}