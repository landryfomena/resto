package com.example.resto.ui.filtersfull

import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.resto.R
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.filters_full_fragment.*

class filters_full_fragment : Fragment() {

    companion object {
        fun newInstance() = filters_full_fragment()
    }

    private lateinit var viewModel: FiltersFullFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.filters_full_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FiltersFullFragmentViewModel::class.java)
        // TODO: Use the ViewModel
        progressBar()
    }
    fun progressBar(){
        progressBar.max= 4000
        val currentProgress = 2000
        ObjectAnimator.ofInt(progressBar,"progress",currentProgress)
            .setDuration(2000)
            .start()
    }

}