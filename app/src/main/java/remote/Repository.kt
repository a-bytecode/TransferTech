package remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.radiosharp.remote.TransferTechApiService
import kredit.BankAcc

class Repository(private val api: TransferTechApiService.UserApi) {

    private val _bankACCResponse = MutableLiveData<List<BankAcc>>()
    val bankACCResponse: LiveData<List<BankAcc>>
        get() = _bankACCResponse

    suspend fun getConnection() {
        try {

            val response = api.retrofitService.getServerResponse()
            _bankACCResponse.value = response

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}