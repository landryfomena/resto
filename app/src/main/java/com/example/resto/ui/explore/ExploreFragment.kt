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
import com.example.resto.models.NicePlace
import com.example.resto.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_explore.*
import kotlinx.android.synthetic.main.new_places_item.*
import java.util.*

class ExploreFragment : Fragment() {

    private lateinit var exploreViewModel: ExploreViewModel
    lateinit var dialog: Dialog
    lateinit var textView: TextView
    private var mRecyclerView: RecyclerView? = null
    private var mRecyclerView1: RecyclerView? = null
    private var mAdapter: RecyclerAdapter? = null
    private var mAdapter1: RecyclerAdapter? = null
    private var mMainActivityViewModel: MainActivityViewModel? = null
    private var mMainActivityViewModel1: MainActivityViewModel? = null
    private var dataSet = ArrayList<NicePlace>()
    private var dataSet1 = ArrayList<NicePlace>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
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

        setOnClickListener()
        openDialogPassword()
        initRecycleViewLiveDataNewPlaces()
        initRecycleViewLiveDataTopCategories()
    }
    private fun initRecycleViewLiveDataTopCategories(){
        setNicePlaces()
        mRecyclerView = topCategories
        mMainActivityViewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]
        mMainActivityViewModel!!.init(dataSet)

        mMainActivityViewModel!!.nicePlaces.observe(viewLifecycleOwner,
            { mAdapter!!.notifyDataSetChanged() })

        initRecyclerView()
    }
    private fun initRecyclerView() {
        mAdapter = RecyclerAdapter(requireContext(),
            mMainActivityViewModel!!.nicePlaces.value,
            R.layout.top_categories_item,R.id.image_resto,R.id.image_name)
        val linearLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false)
        mRecyclerView!!.layoutManager = linearLayoutManager
        mRecyclerView!!.adapter = mAdapter
    }
    private fun setNicePlaces() {
        dataSet.add(NicePlace(R.drawable.ic_burger, "Burger"))
        dataSet.add(NicePlace(R.drawable.ic_american, "American"))
        dataSet.add(NicePlace(R.drawable.ic_pizza, "Pizza"))
        dataSet.add(NicePlace(R.drawable.ic_barbecue, "Barbecue"))
        dataSet.add(NicePlace(R.drawable.ic_burger, "Burger"))
        dataSet.add(NicePlace(R.drawable.ic_american, "American"))
    }
    private fun initRecycleViewLiveDataNewPlaces(){
        setNicePlacesNewPlace()
        mRecyclerView1 = new_places_container
        mMainActivityViewModel1 = ViewModelProviders.of(this)[MainActivityViewModel::class.java]
        mMainActivityViewModel1!!.init(dataSet1)

        mMainActivityViewModel1!!.nicePlaces.observe(viewLifecycleOwner,
            { mAdapter1!!.notifyDataSetChanged() })

        initRecyclerViewNewPlace()
    }
    private fun initRecyclerViewNewPlace() {
        mAdapter1 = RecyclerAdapter(requireContext(),
            mMainActivityViewModel1!!.nicePlaces.value,
            R.layout.new_places_item,R.id.image_resto_new_place,R.id.image_name_new_place)
        val linearLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false)
        mRecyclerView1!!.layoutManager = linearLayoutManager
        mRecyclerView1!!.adapter = mAdapter1
    }
    private fun setNicePlacesNewPlace() {
        dataSet1.add(NicePlace(1, "Andy & Cindy s Diner"))
        dataSet1.add(NicePlace(2, "The Garage Bar & Grill"))

        dataSet1.add(NicePlace(3, "Tiong Bahru Bakery"))
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
        textView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                dialog.dismiss()
                //val show = Toast.makeText(requireContext(), cardView, Toast.LENGTH_SHORT).show
            }
        })
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }
}