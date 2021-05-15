package com.example.resto.ui.favourite


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resto.R
import com.example.resto.adapters.RecyclerAdapter
import com.example.resto.models.NicePlace
import com.example.resto.ui.restaurant.item.Item_Feature_Boon
import com.example.resto.viewmodels.MainActivityViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_favourite.*
import java.util.ArrayList


class MyFavouriteFragment : Fragment() {

    private lateinit var myFavouriteViewModel: MyFavouriteViewModel
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerAdapter? = null
    private var mMainActivityViewModel: MainActivityViewModel? = null
    private val dataSet = ArrayList<NicePlace>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        myFavouriteViewModel =
                ViewModelProvider(this).get(MyFavouriteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_favourite, container, false)

        return root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setNicePlaces()
        setOnClickListener()
        initRecycleViewLiveData()
    }
    private fun initRecycleViewLiveData(){
        mRecyclerView = favourite_container

        mMainActivityViewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]

        mMainActivityViewModel!!.init(dataSet)

        mMainActivityViewModel!!.nicePlaces.observe(viewLifecycleOwner,
            { mAdapter!!.notifyDataSetChanged() })

        initRecyclerView()
    }
    private fun initRecyclerView() {
        mAdapter = RecyclerAdapter(requireContext(),
            mMainActivityViewModel!!.nicePlaces.value,
            R.layout.restaurant_item,R.id.image_resto,R.id.image_name)
        val linearLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        mRecyclerView!!.layoutManager = linearLayoutManager
        mRecyclerView!!.adapter = mAdapter
    }
    private fun setNicePlaces() {
        dataSet.add(NicePlace(1, "Little Creatures - Club Street"))
        dataSet.add(NicePlace(2, "Yanti Nasi Padang"))
        dataSet.add(NicePlace(3, "Tiong Bahru Bakery"))
    }
    fun setOnClickListener(){
        food.setOnClickListener{
            initRecycleviewpFood()
            food.setBackground(resources.getDrawable(R.drawable.rounded_shape_cardview_20dp))
            food.setTextColor(resources.getColor(R.color.white))
            places.setBackground(resources.getDrawable(R.drawable.rounded_shape_item_favourite))
            places.setTextColor(resources.getColor(R.color.gris_clear))
        }
        places.setOnClickListener{
            initRecycleViewLiveData()
            places.setBackground(resources.getDrawable(R.drawable.rounded_shape_cardview_20dp))
            places.setTextColor(resources.getColor(R.color.white))
            food.setBackground(resources.getDrawable(R.drawable.rounded_shape_item_favourite))
            food.setTextColor(resources.getColor(R.color.gris_clear))
        }
        text1.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(MyFavouriteFragmentDirections.actionNavigationFavouriteToChocolatSpiceRestaurant(NicePlace()))
        }
        arrowback.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }

    fun initRecycleviewpFood(){
        var items= mutableListOf<Item_Feature_Boon>()
        (0..7).forEach{
            items.add(Item_Feature_Boon())
        }
        favourite_container.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }

}