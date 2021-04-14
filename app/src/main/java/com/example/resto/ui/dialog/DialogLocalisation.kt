package com.example.resto.ui.dialog

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.resto.R

class DialogLocalisation : Fragment() {

    companion object {
        fun newInstance() = DialogLocalisation()
    }

    private lateinit var viewModel: DialogLocalisationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.dialog_localisation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DialogLocalisationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}