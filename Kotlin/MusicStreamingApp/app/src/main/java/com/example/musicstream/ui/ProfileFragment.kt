package com.example.musicstream.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicstream.R
import com.example.musicstream.adapter.AlbumAdapter
import com.example.musicstream.data.SampleData
import com.example.musicstream.databinding.FragmentProfileBinding
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar

/**
 * Profile screen — header avatar, bio, favorite genres chips and a horizontal
 * "recently played" row. Settings is reachable through the toolbar action.
 */
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        populateGenres()
        setupRecentlyPlayed()
    }

    private fun setupToolbar() = with(binding.profileToolbar) {
        setNavigationOnClickListener { findNavController().navigateUp() }
        setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_settings -> {
                    findNavController().navigate(R.id.action_profile_to_settings)
                    true
                }
                else -> false
            }
        }
    }

    private fun populateGenres() {
        val group = binding.genresChipGroup
        group.removeAllViews()
        val textColor = ContextCompat.getColor(requireContext(), R.color.alabaster_grey)
        SampleData.favoriteGenres.forEach { label ->
            val chip = Chip(requireContext()).apply {
                text = label
                isCheckable = true
                isChecked = true
                setChipBackgroundColorResource(R.color.dusk_blue)
                setTextColor(textColor)
                chipStrokeWidth = resources.displayMetrics.density * 1f
                setChipStrokeColorResource(R.color.dusty_denim)
            }
            group.addView(chip)
        }
    }

    private fun setupRecentlyPlayed() {
        val adapter = AlbumAdapter { album ->
            Snackbar.make(binding.root, "Playing ${album.title}", Snackbar.LENGTH_SHORT).show()
        }
        binding.recentRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recentRecycler.adapter = adapter
        adapter.submitList(SampleData.recentlyPlayed)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.recentRecycler.adapter = null
        _binding = null
    }
}
