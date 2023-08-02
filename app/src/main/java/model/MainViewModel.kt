package model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transferTech.remote.TransferTechApiService
import kotlinx.coroutines.launch
import remote.Repository
import remote.TurnoverApiService

enum class ApiStatus { LOADING, FOUND_RESULTS, ERROR }

open class MainViewModel : ViewModel() {

    private var api = TransferTechApiService.UserApi

    private var turnoverApi = TurnoverApiService.UserApi

    private val repository = Repository(api,turnoverApi)

    var bankAccRequest = repository.bankAccResponse

    var turnoverAccRequest = repository.turnoverAccResponse

    val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus : LiveData<ApiStatus>
        get() = _apiStatus

    fun getAccounts() {
        viewModelScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                repository.getAccounts()
                _apiStatus.value = ApiStatus.FOUND_RESULTS
            } catch (e:Exception) {
                _apiStatus.value = ApiStatus.ERROR
                Log.d("Error im ViewModel","${bankAccRequest.value}")
            }
        }
    }

    fun getTurnovers(accID:String) {
        viewModelScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                repository.getTurnovers(accID)
                _apiStatus.value = ApiStatus.FOUND_RESULTS
            } catch (e:Exception) {
                _apiStatus.value = ApiStatus.ERROR
                Log.d("Error im ViewModel","${turnoverAccRequest.value}")
            }
        }
    }
}