package ui

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
        viewModel.getRequestFromAccount()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         // TODO:
    }
}