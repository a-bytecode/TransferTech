package model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.radiosharp.remote.TransferTechApiService
import kotlinx.coroutines.launch
import remote.Repository

class MainViewModel : ViewModel() {

    private var api = TransferTechApiService.UserApi

    private val repository = Repository(api)

    var bankAccRequest = repository.bankACCResponse

    fun getRequestFromAccount() {
        viewModelScope.launch {
            try {
                repository.getConnection()
                Log.d("SUCCESS Im ViewModel??","${repository.bankACCResponse.value}")
            } catch (e:Exception) {
                Log.d("ERROR IM VIEW MODEL","ERROR ERROR ERROR")
            }
        }
    }
}