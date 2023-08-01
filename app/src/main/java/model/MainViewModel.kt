package model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.radiosharp.remote.TransferTechApiService
import kotlinx.coroutines.launch
import kredit.BankAcc
import remote.Repository

class MainViewModel : ViewModel() {

    private var api = TransferTechApiService.UserApi

    private val repository = Repository(api)

    var bankAccRequest = repository.bankACCResponse

    fun getRequest() {
        viewModelScope.launch {
            try {
                repository.getConnection()
                Log.d("SUCCESS Im ViewModel??","${repository.bankACCResponse.value}")
            } catch (e:Exception) {
                Log.d("ERROR IM VIEW MODEL","ERROR ERROR ERROR")
            }
        }
    }

    fun observeResponse() {
        bankAccRequest.observeForever { bankAccList ->
            Log.d("SUCCESS??", "${bankAccList}")
        }
    }
}