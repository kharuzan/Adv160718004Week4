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

class ListViewModel(application: Application):AndroidViewModel(application) {
    val studentsLD = MutableLiveData<List<Student>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private val TAG = "volleyTag"
    private var queue:RequestQueue ?= null

    fun refresh(){
        //hardcoded
//        val student1 = Student("28-8407558","Bartie","2002/01/21","4322571753","http://dummyimage.com/100x75.png/ff4444/ffffff")
//        val student2 = Student("09-1372145","Saunderson","1998/04/05","7562907013","http://dummyimage.com/100x75.jpg/5fa2dd/ffffff")
//        val student3 = Student("45-9175161","Sunny","2007/04/03","3995074353","http://dummyimage.com/100x75.png/dddddd/000000")
//
//        studentsLD.value =arrayListOf<Student>(student1,student2,student3)
////        val studentList =
//        loadingErrorLD.value = false
//        loadingLD.value = true

        //bukan hardcoded
        loadingErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        var url = "http://adv.jitusolution.com/student.php"

        val stringRequest = StringRequest(Request.Method.GET,url,
            { response ->
                val sType = object : TypeToken<List<Student>>() { }.type
                val result = Gson().fromJson<List<Student>>(response, sType)
                studentsLD.value = result

                loadingLD.value = false
                Log.d("showvolley",response.toString())
            },
            {
                loadingErrorLD.value = true
                loadingLD.value = false
                Log.d("showvolley",it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}