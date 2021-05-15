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
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.models.NicePlace
import com.example.resto.ui.explore.item.ItemTopCategories
import com.example.resto.ui.explore.item.Item_Resto_Extended
import com.example.resto.ui.search.item.Item_Recommend
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_explore.*
import kotlinx.android.synthetic.main.fragment_explore.main_searchView
import kotlinx.android.synthetic.main.fragment_explore.recommend_collection

class ExploreFragment : Fragment() {

    private lateinit var exploreViewModel: ExploreViewModel
    lateinit var dialog: Dialog
    lateinit var textView: TextView
    var aTopCategories = mutableListOf<ItemTopCategories>()
    var aNicePlaces = mutableListOf<Item_Resto_Extended>()


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
        dialog = Dialog(requireContext())
        exploreViewModel.apply {
            setNicePlaces()
            setNicePlacesNewPlace()
            setRecommendedPlaces()
        }
        observeViewModel()
        setOnClickListener()
        openDialogPassword()
    }

    private fun observeViewModel() {
        exploreViewModel.newPlaces.observe(viewLifecycleOwner, Observer { newPlaces ->
            initNewPlaces(newPlaces)
        })
        exploreViewModel.topCategories.observe(viewLifecycleOwner, Observer { topCategories ->
            initTopCategories(topCategories)
        })
        exploreViewModel.recommmended.observe(viewLifecycleOwner, Observer { recommended ->
            initRecommend(recommended)
        })
    }
    private fun initTopCategories(mtopCategories: List<NicePlace>?) {
        aTopCategories = mutableListOf()
        mtopCategories?.forEach { nicePlace ->
            aTopCategories.add(ItemTopCategories(nicePlace))
        }

        topCategories.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = GroupAdapter<ViewHolder>().apply {
                add(Section(aTopCategories))
            }
        }
    }

    private fun initNewPlaces(newPlaces: List<NicePlace>?) {
        aNicePlaces = mutableListOf()
        newPlaces?.forEach { nicePlace ->
            aNicePlaces.add(Item_Resto_Extended(nicePlace))
        }

        new_places_container.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = GroupAdapter<ViewHolder>().apply {
                add(Section(aNicePlaces))
            }
        }
    }

    fun initRecommend(list: List<NicePlace>) {
        var items = mutableListOf<Item_Recommend>()
        list.forEach {
            items.add(Item_Recommend(it))
        }
        recommend_collection.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = GroupAdapter<ViewHolder>().apply {
                add(Section(items))
            }
        }
    }

    private fun setOnClickListener() {
        main_searchView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ExploreFragmentDirections.actionNavigationHomeToSearch())
        }
        page_title.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ExploreFragmentDirections.actionNavigationHomeToBoonLayFragment(NicePlace()))
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
        textView = dialog.findViewById(R.id.card)
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