package com.example.resto.ui.filters

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import com.example.resto.MainActivity
import com.example.resto.R
import com.example.resto.models.NicePlace
import com.example.resto.ui.explore.ExploreFragmentDirections
import com.example.resto.ui.restaurant.AsiaRestaurantFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.filters_fragment.*
import kotlinx.android.synthetic.main.fragment_explore.*

class Filters : BottomSheetDialogFragment() {
    lateinit var cardView: CardView
    companion object {
        fun newInstance() = Filters()
    }

    private lateinit var viewModel: FiltersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.filters_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FiltersViewModel::class.java)
        // TODO: Use the ViewModel
        progressBar()
        setOnClickListener()
    }
    private fun setOnClickListener() {
//        asia_filter.setOnClickListener {
//            var intent= Intent(this@Filters, AsiaRestaurantFragment::class.java)
//            startActivity(intent)
//        }
        asia_filter.setOnClickListener {

            Navigation.findNavController(it)
                .navigate(FiltersDirections.actionFiltersToAsiaRestaurantFragment(NicePlace()))
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