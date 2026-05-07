package com.example.musicstream.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicstream.R
import com.example.musicstream.adapter.AlbumAdapter
import com.example.musicstream.data.SampleData
import com.example.musicstream.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

/**
 * Home tab — shows trending, new releases and a 2-column "Made for You" grid.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

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

        binding.greetingText.text = greetingForTimeOfDay()

        setupTrending()
        setupNewReleases()
        setupMadeForYou()

        binding.profileAvatar.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_profile)
        }

        binding.searchBar.setOnClickListener {
            Snackbar.make(binding.root, "Search coming soon.", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setupTrending() {
        val adapter = AlbumAdapter { album ->
            Snackbar.make(binding.root, "Playing ${album.title}", Snackbar.LENGTH_SHORT).show()
        }
        binding.trendingRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.trendingRecycler.adapter = adapter
        adapter.submitList(SampleData.trending)
    }

    private fun setupNewReleases() {
        val adapter = AlbumAdapter { album ->
            Snackbar.make(binding.root, "Playing ${album.title}", Snackbar.LENGTH_SHORT).show()
        }
        binding.newReleasesRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.newReleasesRecycler.adapter = adapter
        adapter.submitList(SampleData.newReleases)
    }

    private fun setupMadeForYou() {
        val adapter = AlbumAdapter { album ->
            Snackbar.make(binding.root, "Playing ${album.title}", Snackbar.LENGTH_SHORT).show()
        }
        binding.madeForYouRecycler.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.madeForYouRecycler.adapter = adapter
        adapter.submitList(SampleData.madeForYou)
    }

    private fun greetingForTimeOfDay(): String {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val resId = when (hour) {
            in 5..11 -> R.string.greeting_morning
            in 12..17 -> R.string.greeting_afternoon
            else -> R.string.greeting_evening
        }
        return getString(resId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.trendingRecycler.adapter = null
        binding.newReleasesRecycler.adapter = null
        binding.madeForYouRecycler.adapter = null
        _binding = null
    }
}
