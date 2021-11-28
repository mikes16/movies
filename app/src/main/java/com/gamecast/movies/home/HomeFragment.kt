package com.gamecast.movies.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.gamecast.domain.models.Movies
import com.gamecast.movies.MyApplication
import com.gamecast.movies.databinding.FragmentHomeBinding
import com.gamecast.movies.home.adapter.HomeCardAdapter
import com.gamecast.movies.utils.ViewModelFactory
import com.gamecast.movies.utils.launchAndRepeatWithViewLifecycle
import com.gamecast.utils.Failure
import com.gamecast.utils.Result
import com.gamecast.utils.onSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        (requireActivity().applicationContext as MyApplication).appComponent.homeComponent()
            .create().inject(this)

        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            adapter = HomeCardAdapter()
        }

        launchAndRepeatWithViewLifecycle {
            viewModel.postStateFlow.collect { result ->
                result.onSuccess { success ->
                    val adapter = binding.recyclerView.adapter as? HomeCardAdapter
                    adapter?.submitList(success.movies)
                }
            }
        }
    }
}