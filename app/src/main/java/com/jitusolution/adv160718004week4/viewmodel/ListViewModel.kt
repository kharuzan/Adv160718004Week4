package com.jitusolution.adv160718004week4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jitusolution.adv160718004week4.model.Student

class ListViewModel:ViewModel() {
    val studentsLD = MutableLiveData<List<Student>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun refresh(){
        val student1 = Student("28-8407558","Bartie","2002/01/21","4322571753","http://dummyimage.com/100x75.png/ff4444/ffffff")
        val student2 = Student("09-1372145","Saunderson","1998/04/05","7562907013","http://dummyimage.com/100x75.jpg/5fa2dd/ffffff")
        val student3 = Student("45-9175161","Sunny","2007/04/03","3995074353","http://dummyimage.com/100x75.png/dddddd/000000")

        studentsLD.value =arrayListOf<Student>(student1,student2,student3)
//        val studentList =
        loadingErrorLD.value = false
        loadingDoneLD.value = true
    }
}