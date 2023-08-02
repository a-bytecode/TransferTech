package ui

import BankAccAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.transferTech.remote.TransferTechApiService
import com.example.transfer_tech.databinding.HomeFragmentBinding
import model.MainViewModel
import remote.ApiStatus
import remote.Repository
import remote.TurnoverApiService

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HomeFragmentBinding.inflate(inflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bankAccAdapter = BankAccAdapter()

        binding.recyclerViewHF.adapter = bankAccAdapter

        viewModel.getAccounts()

        viewModel.apiStatus.observe(viewLifecycleOwner) {
            when(it) {
                ApiStatus.LOADING -> {
                    binding.progressBarHome.visibility = View.VISIBLE
                    binding.recyclerViewHF.visibility = View.GONE
                }

                ApiStatus.FOUND_RESULTS -> {
                    binding.progressBarHome.visibility = View.GONE
                    binding.recyclerViewHF.visibility = View.VISIBLE
                }

                ApiStatus.ERROR -> {
                    binding.progressBarHome.visibility = View.VISIBLE
                    binding.recyclerViewHF.visibility = View.GONE
                }
            }
        }

        viewModel.bankAccRequest.observe(viewLifecycleOwner) { bankAccList ->

            bankAccAdapter.submitlist(bankAccList)

        }
    }


}