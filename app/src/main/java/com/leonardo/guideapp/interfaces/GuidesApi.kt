package com.leonardo.guideapp.interfaces

import com.leonardo.guideapp.data.Guides
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface GuidesApi {
    @GET("upcomingGuides/")
    fun getGuidesAsync(): Deferred<Response<Guides>>
}