package com.jitusolution.adv160718004week4.view

import android.view.View
import com.jitusolution.adv160718004week4.model.Student

interface ButtonDetailClickListener {
    fun onButtonDetailClick(v:View)
}
interface ButtonSaveChangesClickListener {
    fun onButtonSaveChangesClick(v: View,obj:Student)
}