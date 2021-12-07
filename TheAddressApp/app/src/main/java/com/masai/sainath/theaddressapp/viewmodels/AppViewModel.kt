package com.masai.sainath.theaddressapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masai.sainath.theaddressapp.di.AppModule
import com.masai.sainath.theaddressapp.remote.ApiClient
import com.masai.sainath.theaddressapp.remote.responses.ResponseDTO
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AppViewModel : ViewModel() {


    var responseDTO: MutableLiveData<ResponseDTO> = MutableLiveData()

    fun getCityListObserver(): MutableLiveData<ResponseDTO> {
        return responseDTO
    }

    fun makeApiCall(query: String) { //query: String)
        val apiResponse = AppModule.provideApi().create(ApiClient::class.java)
        apiResponse.getResponse("airtel", query) // query
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getCityListObserverRxJava())
    }

    private fun getCityListObserverRxJava(): Observer<ResponseDTO> {
        return object : Observer<ResponseDTO> {
            override fun onSubscribe(d: Disposable) {
//progress bar show
            }

            override fun onNext(t: ResponseDTO) {
                responseDTO.postValue(t)
            }

            override fun onError(e: Throwable) {
                responseDTO.postValue(null)
            }

            override fun onComplete() {
//stop
            }

        }
    }


}