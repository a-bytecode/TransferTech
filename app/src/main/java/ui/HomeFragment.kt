package ui

import BankAccAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.transfer_tech.databinding.HomeFragmentBinding
import model.MainViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HomeFragmentBinding.inflate(inflater)
        viewModel.getRequestFromAccount()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val bankAccAdapter = BankAccAdapter()

        binding.recyclerViewHF.adapter = bankAccAdapter

        viewModel.getRequestFromAccount()

        viewModel.bankAccRequest.observe(viewLifecycleOwner) { bankAccList ->
            // Hier die Daten im RecyclerView aktualisieren
            bankAccAdapter.submitlist(bankAccList)
        }
    }
}