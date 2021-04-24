package com.example.resto

import android.content.Intent
import android.graphics.Bitmap
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.camera_option_fragment.*
import kotlinx.android.synthetic.main.profile_fragment.*

class CameraOption : BottomSheetDialogFragment() {

    companion object {
        fun newInstance() = CameraOption()
    }

    private lateinit var viewModel: CameraOptionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.camera_option_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CameraOptionViewModel::class.java)
        capturer_img.setOnClickListener{
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(intent, 123)
        }
        select_img.setOnClickListener{
            var intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 456)
        }
        setOnclickListener()
    }
    fun setOnclickListener(){
        capturer_img.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(CameraOptionDirections.actionCameraOptionToProfilefragment())
        }
        select_img.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(CameraOptionDirections.actionCameraOptionToProfilefragment())
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode : Int, data : Intent?){
        super.onActivityResult(requestCode,resultCode,data)
        if(requestCode == 123) {
            var bmp: Bitmap = data?.extras?.get("data") as Bitmap
            imageview.setImageBitmap(bmp)
        }
        else if(requestCode == 456){
            imageview.setImageURI(data?.data)
        }
    }
}