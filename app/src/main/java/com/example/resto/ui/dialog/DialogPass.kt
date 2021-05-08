package com.example.resto.ui.dialog

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.resto.R

class DialogPass : Fragment() {

    companion object {
        fun newInstance() = DialogPass()
    }

    private lateinit var viewModel: DialogPassViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.dialog_pass_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DialogPassViewModel::class.java)
        // TODO: Use the ViewModel
    }
//    fun openAccessibility(layoutInflater: LayoutInflater, context: Context, action: () -> Unit) {
//        if (!PermissionChecked.isAccessibilitySettingsOn(context)) {
//            var view = layoutInflater.inflate(R.layout.permission_ask_accessibility_step_1, null)
//            val alert = simpleAlert(view)
//            view.apply {
//                this.permission_accessibility_btn_continue.setOnClickListener {
//                    alert.dismiss()
//                    var view =
//                        layoutInflater.inflate(R.layout.permission_ask_accessibility_step_2, null)
//                    val alert = simpleAlert(view)
//                    view.apply {
//                        this.permission_accessibility_step2_btn_proceed.setOnClickListener {
//                            alert.dismiss()
//                            val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
//                            context.startActivity(intent)
//                        }
//                    }
//                }
//            }
//        } else {
//            action()
//        }
//    }
}