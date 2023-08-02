package com.example.transfer_tech

import android.os.Build
import com.example.transferTech.remote.TransferTechApiService
import org.junit.Test
import org.junit.Assert.*
import remote.Repository
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.mockk
import model.MainViewModel
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.robolectric.annotation.Config
import remote.TurnoverApiService

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.Q])
class FuncTests {

    private var api = TransferTechApiService.UserApi
    private var turnoverApi = TurnoverApiService.UserApi
    private lateinit var viewModel : MainViewModel
    private lateinit var repository: Repository

    @Before
    fun setup() {
        // Initialisierung deiner Repository-Klasse und anderer notwendiger Komponenten
        repository = mockk()
        viewModel = MainViewModel()
        repository = Repository(api,turnoverApi)
    }

    @Test
    fun getTurnoverTest() {

        assertEquals(viewModel.getTurnovers("1"),viewModel.getTurnovers("1"))

    }

}
