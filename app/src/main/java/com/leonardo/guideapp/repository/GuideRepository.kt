package com.leonardo.guideapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.leonardo.guideapp.data.Guide
import com.leonardo.guideapp.data.Guides
import com.leonardo.guideapp.interfaces.GuidesApi
import com.leonardo.guideapp.interfaces.GuidesDoa
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GuideRepository @Inject constructor(private val service: GuidesApi,private val dao: GuidesDoa) {

    fun getGuides(): LiveData<List<Guide>> {
        GlobalScope.launch {
            val result = service.getGuidesAsync().await()
            if (result.isSuccessful){
                dao.insertAll(result.body()?.data!!)
            }
        }


        return dao.getAll()
    }
}