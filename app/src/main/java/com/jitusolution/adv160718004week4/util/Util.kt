package com.jitusolution.adv160718004week4.util

import android.opengl.Visibility
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.jitusolution.adv160718004week4.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

fun ImageView.loadImage(url: String, progressBar: ProgressBar) {
    Picasso.get()
            .load(url)
            .resize(400,400)
            .centerCrop()
            .error(R.drawable.ic_baseline_error_24)
            .into(this, object:Callback {
                override fun onSuccess() {
                    progressBar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {

                }

            })
}
@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadPhotoUrl(v:ImageView, url:String, pb:ProgressBar) {
    v.loadImage(url,pb)
}