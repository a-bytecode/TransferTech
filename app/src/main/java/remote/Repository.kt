package remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import bankacc.TurnoverAcc
import com.example.transferTech.remote.TransferTechApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kredit.BankAcc


enum class ApiStatus { LOADING, FOUND_RESULTS, ERROR }

class Repository(private val api: TransferTechApiService.UserApi, private val turnoverApi : TurnoverApiService.UserApi) {

    private val _bankAccResponse = MutableLiveData<List<BankAcc>>()
    val bankAccResponse: LiveData<List<BankAcc>>
        get() = _bankAccResponse

    private val _turnoverAccResponse = MutableLiveData<List<TurnoverAcc>>()
    val turnoverAccResponse : LiveData<List<TurnoverAcc>>
            get() = _turnoverAccResponse

    val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus : LiveData<ApiStatus>
        get() = _apiStatus

    suspend fun getAccounts() {
        try {
            _apiStatus.value = ApiStatus.LOADING
            val response = api.retrofitService.getServerResponseBankAcc()
            _bankAccResponse.value = response
            _apiStatus.value = ApiStatus.FOUND_RESULTS
        } catch (e: Exception) {
            _apiStatus.value = ApiStatus.ERROR
            e.printStackTrace()
        }
    }

    suspend fun getTurnovers(accID: String) {
        try {
            _apiStatus.value = ApiStatus.LOADING
            val responseTurnover = turnoverApi.retrofitService.getTurnovers(accID)
            _turnoverAccResponse.value = responseTurnover
            _apiStatus.value = ApiStatus.FOUND_RESULTS
        } catch (e: Exception) {
            _apiStatus.value = ApiStatus.ERROR
            e.printStackTrace()
        }
    }

}