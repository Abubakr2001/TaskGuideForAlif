package com.leonardo.guideapp.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.leonardo.guideapp.data.Guide
import com.leonardo.guideapp.repository.GuideRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GuideRepository): ViewModel(){

    fun getGuides(): LiveData<List<Guide>>{
        return repository.getGuides()
    }
}

