package com.example.resto.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.resto.R
import kotlinx.android.synthetic.main.profile_fragment.*

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        setOnClickListener()
    }
    fun setOnClickListener(){
        backup.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ProfileFragmentDirections.popupToParent())
        }
        idDone.setOnClickListener{
            Navigation.findNavController(it)
                .navigate(ProfileFragmentDirections.actionProfilefragmentToNavigationProfile())
        }
    }
}