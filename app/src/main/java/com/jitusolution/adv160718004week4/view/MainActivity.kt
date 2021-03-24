package com.jitusolution.adv160718004week4.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jitusolution.adv160718004week4.R
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var observable = Observable.just("hellow","world","!!")
        val observer = object: Observer<String> {
            override fun onSubscribe(d: Disposable?) { // memberitahui bahwa observer memulai subscribe
                Log.d("Messages","Start subscribe")
            }

            override fun onNext(t: String?) {
                Log.d("Messages","Start subscribe")
            }

            override fun onError(e: Throwable?) {
            }

            override fun onComplete() {
            }

        }
    }
}