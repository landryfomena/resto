package com.example.resto.ui.paris_holiday

import android.animation.ObjectAnimator
import android.graphics.Insets.add
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.models.NicePlace
import com.example.resto.ui.collectionbyfozzy.CollectionByFozzyViewModel
import com.example.resto.ui.paris_holiday.item.Item_Reseau
import com.example.resto.ui.paris_holiday.item.Presentation_Item
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.collection_by_fozzy_fragment.view.*
import kotlinx.android.synthetic.main.paris_holiday_fragment.*

class ParisHoliday : Fragment() {

    var aPresentation_Item= mutableListOf<Presentation_Item>()

    companion object {
        fun newInstance() = ParisHoliday()
    }

    private lateinit var parisHolidayViewModel: ParisHolidayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        parisHolidayViewModel = ViewModelProvider(this).get(ParisHolidayViewModel::class.java)
        var root = inflater.inflate(R.layout.paris_holiday_fragment, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        parisHolidayViewModel = ViewModelProvider(this).get(ParisHolidayViewModel::class.java)
        // TODO: Use the ViewModel
        parisHolidayViewModel.apply {
            setPresentationItem()
        }
        observeViewModel()
        progressBar()
        initItemReseau()
    }
    private fun observeViewModel() {
        parisHolidayViewModel.newPresentation_Item.observe(viewLifecycleOwner,
            Observer { newPresentation ->
                initItemPresentation(newPresentation)
            })
    }
    private fun initItemPresentation(mPresentation: List<NicePlace>?) {
        aPresentation_Item= mutableListOf()
        mPresentation?.forEach { nicePlace ->
            aPresentation_Item.add(Presentation_Item(nicePlace))

        }

        item_presentation.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)

            adapter = GroupAdapter<ViewHolder>().apply {
                add(Section(aPresentation_Item))
            }
        }
    }
    private fun initItemReseau() {
        var items= mutableListOf<Item_Reseau>()
        (0..5).forEach{
            items.add(Item_Reseau())
        }

        item_reseau.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

            adapter = GroupAdapter<ViewHolder>().apply {
                add(Section(items))
            }
        }
    }


    private fun progressBar(){
        progressBar.max= 4000
        val currentProgress = 2000
        ObjectAnimator.ofInt(progressBar,"progress",currentProgress)
            .setDuration(2000)
            .start()
    }
}