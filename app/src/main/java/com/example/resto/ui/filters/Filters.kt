package com.example.resto.ui.filters

import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.resto.R
import kotlinx.android.synthetic.main.filters_fragment.*

class Filters : Fragment() {

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
    }
    private fun progressBar(){
        progressBar.max= 4000
        val currentProgress = 2000
        ObjectAnimator.ofInt(progressBar,"progress",currentProgress)
            .setDuration(2000)
            .start()
    }

}