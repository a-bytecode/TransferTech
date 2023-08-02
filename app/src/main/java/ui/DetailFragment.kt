package ui

import adapter.TurnoverAccAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.transferTech.remote.TransferTechApiService
import com.example.transfer_tech.databinding.DetailFragmentBinding
import model.MainViewModel
import remote.ApiStatus
import remote.Repository
import remote.TurnoverApiService

class DetailFragment : Fragment() {

    private lateinit var binding: DetailFragmentBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DetailFragmentBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val accID = arguments?.let { DetailFragmentArgs.fromBundle(it).accID }

        val turnoverAdapter = TurnoverAccAdapter()

        binding.recyclerViewTurnover.adapter = turnoverAdapter

        viewModel.apiStatus.observe(viewLifecycleOwner) {

            when(it) {
                ApiStatus.LOADING -> {
                    binding.progressBarDetail.visibility = View.VISIBLE
                    binding.recyclerViewTurnover.visibility = View.GONE
                }

                ApiStatus.FOUND_RESULTS -> {
                    binding.progressBarDetail.visibility = View.GONE
                    binding.recyclerViewTurnover.visibility = View.VISIBLE
                }

                ApiStatus.ERROR -> {
                    binding.progressBarDetail.visibility = View.VISIBLE
                    binding.recyclerViewTurnover.visibility = View.GONE
                }
            }
        }

        viewModel.getTurnovers(accID ?: "It´s Empty!")

        viewModel.turnoverAccRequest.observe(viewLifecycleOwner) { turnoverAccList ->
            val filterList = turnoverAccList.filter { turnoverAcc ->
                turnoverAcc.account_id.toString() == accID
            }
            turnoverAdapter.submitlist(filterList)
        }
    }
}