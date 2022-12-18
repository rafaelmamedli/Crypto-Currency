package com.example.udemy_retrofit_kripto.service

import io.reactivex.Observable
import com.example.udemy_retrofit_kripto.model.CryptoModel
import retrofit2.http.GET


interface CryptoAPI {

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData(): Observable<List<CryptoModel>>

}