package com.jitusolution.adv160718004week4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jitusolution.adv160718004week4.model.Student
class DetailViewModel(application: Application): AndroidViewModel(application) {
    val studentLD = MutableLiveData<Student>()
    private val loadingLD = MutableLiveData<Boolean>()

    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun fetch(id:String)
    {
        loadingLD.value = true
        queue = Volley.newRequestQueue(getApplication())
        var url = "http://adv.jitusolution.com/student.php?id=" + id

        val stringRequest = StringRequest(
            Request.Method.GET,url,
            { response ->
                val sType = object : TypeToken<List<Student>>() { }.type
                val result = Gson().fromJson<Student>(response,
                Student::class.java)
                studentLD.value = result

                loadingLD.value = false
                Log.d("detailvolley",response.toString())
            },
            {
                loadingLD.value = false
                Log.d("detailvolley",it.toString())
            })

//        val student1 = Student("16055","Nonie","1998/03/28","5718444778",
//        "http://adv.jitusolution.com/student.php?id=[16055]")
//        studentLD.value = student1
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}