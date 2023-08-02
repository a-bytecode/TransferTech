package remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import bankacc.TurnoverAcc
import com.example.transferTech.remote.TransferTechApiService
import kotlinx.coroutines.delay
import kredit.BankAcc


class Repository(private val api: TransferTechApiService.UserApi, private val turnoverApi : TurnoverApiService.UserApi) {

    private val _bankAccResponse = MutableLiveData<List<BankAcc>>()
    val bankAccResponse: LiveData<List<BankAcc>>
        get() = _bankAccResponse

    private val _turnoverAccResponse = MutableLiveData<List<TurnoverAcc>>()
    val turnoverAccResponse : LiveData<List<TurnoverAcc>>
            get() = _turnoverAccResponse

    suspend fun getAccounts() {
        try {
            val response = api.retrofitService.getServerResponseBankAcc()
            _bankAccResponse.value = response
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun getTurnovers(accID: String) {
        try {
            val responseTurnover = turnoverApi.retrofitService.getTurnovers(accID)
            _turnoverAccResponse.value = responseTurnover
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}