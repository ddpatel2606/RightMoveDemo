package com.dixitpatel.rightmovedemo.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.dixitpatel.rightmovedemo.model.PropertiesResponse
import com.dixitpatel.rightmovedemo.network.APIRequestResponseHandler
import com.dixitpatel.rightmovedemo.network.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import timber.log.Timber
import java.net.UnknownHostException
import javax.inject.Inject

/**
 *  MainViewRepository class to call Main property API.
 */
class MainViewRepository @Inject constructor() : Repository
{

    // property listing API
    @WorkerThread
    suspend fun propertyApiCall(apiInterface : ApiInterface,
                                onSuccess: () -> Unit,
                                onError: (String?) -> Unit)
             = flow {

                try {
                    val response : Response<PropertiesResponse> = apiInterface.fetchPropertyList()
                    if(response.isSuccessful)
                    {
                       response.body()?.let {

                           emit(it.results)
                           onSuccess()
                       }
                    }else
                    {
                        onError(response.errorBody().toString())
                        Timber.e(response.errorBody().toString())
                    }
                } catch (e: UnknownHostException) {
                    onError(e.toString())
                    Timber.e(e.toString())
                } catch (e: Exception) {
                    onError(e.toString())
                    Timber.e(e.toString())
                }
    }.flowOn(Dispatchers.IO)
}