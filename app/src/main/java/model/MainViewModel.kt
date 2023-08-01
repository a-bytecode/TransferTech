package model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transferTech.remote.TransferTechApiService
import kotlinx.coroutines.launch
import remote.Repository
import remote.TurnoverApiService

class MainViewModel : ViewModel() {

    private var api = TransferTechApiService.UserApi

    private var turnoverApi = TurnoverApiService.UserApi

    private val repository = Repository(api,turnoverApi)

    var bankAccRequest = repository.bankAccResponse

    var turnoverAccRequest = repository.turnoverAccResponse

    val accountIdLiveData = MutableLiveData<String>()

    fun getAccounts() {
        viewModelScope.launch {
            try {
                repository.getAccounts()
                Log.d("SUCCESS IM VIEW MODEL??","${repository.bankAccResponse.value}")
            } catch (e:Exception) {
                Log.d("ERROR IM VIEW MODEL!!","ERROR ACCOUNTS!!")
            }
        }
    }

    fun getTurnovers(accID:String) {
        viewModelScope.launch {
            try {
                repository.getTurnovers(accID)
                Log.d("SUCCESS IM VIEW MODEL??","${repository.turnoverAccResponse.value}")
            } catch (e:Exception) {
                Log.d("ERROR IM VIEW MODEL!!","ERROR TURNOVERS!!")

            }
        }
    }

    fun setAccountId(id: String) {
        accountIdLiveData.value = id
    }

}