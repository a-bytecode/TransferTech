package ui

import adapter.TurnoverAccAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.transfer_tech.databinding.DetailFragmentBinding
import model.MainViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: DetailFragmentBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DetailFragmentBinding.inflate(inflater)
        viewModel.getAccounts()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val accID = arguments?.let { DetailFragmentArgs.fromBundle(it).accID }

        val turnoverAdapter = TurnoverAccAdapter()

        binding.recyclerViewTurnover.adapter = turnoverAdapter

        viewModel.getAccounts()


        binding.headlineTurnoverTV.setOnClickListener {
            viewModel.getTurnovers(accID ?: "")
        }

        viewModel.turnoverAccRequest.observe(viewLifecycleOwner) { turnoverAccList ->
            turnoverAdapter.submitlist(turnoverAccList)
        }

    }
}