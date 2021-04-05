package com.example.resto.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.resto.R
import kotlinx.android.synthetic.main.profile_nav.*

class ProfileNav : Fragment() {

    companion object {
        fun newInstance() = ProfileNav()
    }

    private lateinit var viewModel: ProfileNavViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.profile_nav, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileNavViewModel::class.java)
        setOnClicListener()
    }

    fun setOnClicListener(){
        idLinearname.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ProfileNavDirections.navigationExplorerToProfilefragment())
        }
    }
}