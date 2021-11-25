package com.gamecast.movies.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gamecast.movies.MyApplication
import com.gamecast.movies.databinding.FragmentHomeBinding
import com.gamecast.movies.di.ViewModelFactory
import com.gamecast.movies.home.adapter.HomeCardAdapter
import com.gamecast.movies.home.adapter.MovieItem
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
            adapter = HomeCardAdapter(
                arrayOf(
                    MovieItem(
                        "/cinER0ESG0eJ49kXlExM0MEWGxW.jpg",
                        "Shang Shi",
                        "Shang-Chi and the Legend of the Ten Rings"
                    ),
                    MovieItem("/iUgygt3fscRoKWCV1d0C7FbM9TP.jpg", "No Time to Die", "No Subtitle"),
                    MovieItem("/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg", "Venom", "Let There Be Carnage"),
                    MovieItem("/jKuDyqx7jrjiR9cDzB5pxzhJAdv.jpg", "Finch", "Test 2"),
                    MovieItem("/chTkFGToW5bsyw3hgLAe4S5Gt3.jpg", "Apex", "Other"),
                    MovieItem("/lyvszvJJqqI8aqBJ70XzdCNoK0y.jpg", "Eternals", "Nooooo")
                )
            )
        }
    }
}