package com.example.resto.ui.home

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.home.item.ItemTopCategories
import com.example.resto.ui.home.item.Item_Resto_Extended
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.math.round
import kotlinx.android.synthetic.main.fragment_home.icon_search as icon_search1

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    lateinit var dialog: Dialog
    lateinit var cardView: CardView
    lateinit var recent: TextView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       dialog= Dialog(requireContext())
        initRecycleview()
        initTopCategories()
        setOnClickListener()
        openDialogPassword()
      // showDialog1(requireView())

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
   fun setOnClickListener(){
        icon_search.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(HomeFragmentDirections.actionNavigationHomeToSearch())
        }
        show.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(HomeFragmentDirections.actionNavigationHomeToBoonLayFragment())
        }
        topCat.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(HomeFragmentDirections.actionNavigationHomeToChocolatSpiceRestaurant())
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
   /* fun showDialog1(view: View){
        val builder=AlertDialog.Builder(requireContext())
        builder.setTitle("yo man")
        builder.setMessage("trop fort toi")
        builder.show()
    }*/
}