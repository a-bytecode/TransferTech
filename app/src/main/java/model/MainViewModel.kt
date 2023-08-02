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

open class MainViewModel : ViewModel() {

    private var api = TransferTechApiService.UserApi

    private var turnoverApi = TurnoverApiService.UserApi

    private val repository = Repository(api,turnoverApi)

    val bankAccRequest = repository.bankAccResponse

    val turnoverAccRequest = repository.turnoverAccResponse

    val apiStatus = repository.apiStatus

    fun getAccounts() {
        viewModelScope.launch {
            try {
                repository.getAccounts()
            } catch (e:Exception) {
                Log.d("Error im ViewModel","${bankAccRequest.value}")
            }
        }
    }

    fun getTurnovers(accID:String) {
        viewModelScope.launch {
            try {
                repository.getTurnovers(accID)
            } catch (e:Exception) {
                Log.d("Error im ViewModel","${turnoverAccRequest.value}")
            }
        }
    }
}