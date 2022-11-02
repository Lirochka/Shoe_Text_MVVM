package com.example.showtext_mvvm.show.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShowTextViewModel : ViewModel(){
  private var _enterText: MutableLiveData<String>? = MutableLiveData<String>("")
    val enterText: LiveData<String>? = _enterText

    fun saveText(enter: String){
        _enterText?.value = enter
    }
}