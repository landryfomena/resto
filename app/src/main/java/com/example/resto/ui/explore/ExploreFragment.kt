package com.example.resto.ui.explore

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resto.R
import com.example.resto.adapters.RecyclerAdapter
import com.example.resto.ui.explore.item.Item_Resto_Extended
import com.example.resto.viewmodels.MainActivityViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_explore.*

class ExploreFragment : Fragment() {

    private lateinit var exploreViewModel: ExploreViewModel
    lateinit var dialog: Dialog
    lateinit var textView: TextView
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerAdapter? = null
    private var mMainActivityViewModel: MainActivityViewModel? = null
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
        initRecycleview()
        setOnClickListener()
        openDialogPassword()
        initRecycleViewLiveData()
    }
    private fun initRecycleViewLiveData(){
        mRecyclerView = topCategories

        mMainActivityViewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]

        mMainActivityViewModel!!.init()

        mMainActivityViewModel!!.nicePlaces.observe(viewLifecycleOwner,
            { mAdapter!!.notifyDataSetChanged() })

        initRecyclerView()
    }
    private fun initRecyclerView() {
        val i:Int
        mAdapter = RecyclerAdapter(requireContext(), mMainActivityViewModel!!.nicePlaces.value,R.layout.top_categories_item)
        val linearLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        mRecyclerView!!.layoutManager = linearLayoutManager
        mRecyclerView!!.adapter = mAdapter
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
    private fun setOnClickListener(){
        main_searchView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ExploreFragmentDirections.actionNavigationHomeToSearch())
        }
        page_title.setOnClickListener {
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
        topCat.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ExploreFragmentDirections.actionNavigationExploreToFilters())
        }
    }
    private fun openDialogPassword() {
        dialog.setContentView(R.layout.dialog_localisation_fragment)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(UCharacter.JoiningType.TRANSPARENT))
        textView=dialog.findViewById(R.id.card)
        textView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(view: View) {
               dialog.dismiss()
                //val show = Toast.makeText(requireContext(), cardView, Toast.LENGTH_SHORT).show
            }
        })
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }
}