package com.example.musicstream.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.musicstream.LoginActivity
import com.example.musicstream.R
import com.example.musicstream.databinding.FragmentSettingsBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

/**
 * Settings screen — grouped into Account, Playback, Notifications, and
 * Appearance sections. Rows are inflated via <include> for consistency.
 */
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.settingsToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        setupAccountGroup()
        setupPlaybackGroup()
        setupNotificationsGroup()
        setupAppearanceGroup()
    }

    private fun setupAccountGroup() {
        with(binding.rowEditProfile) {
            rowIcon.setImageResource(R.drawable.ic_account)
            rowTitle.text = getString(R.string.settings_edit_profile)
            root.setOnClickListener { snackbar(R.string.settings_edit_profile) }
        }
        with(binding.rowChangePassword) {
            rowIcon.setImageResource(R.drawable.ic_lock)
            rowTitle.text = getString(R.string.settings_change_password)
            root.setOnClickListener { snackbar(R.string.settings_change_password) }
        }
        with(binding.rowLogout) {
            rowIcon.setImageResource(R.drawable.ic_logout)
            rowTitle.text = getString(R.string.settings_logout)
            root.setOnClickListener { confirmLogout() }
        }
    }

    private fun setupPlaybackGroup() {
        with(binding.rowAudioQuality) {
            rowIcon.setImageResource(R.drawable.ic_tune)
            rowTitle.text = getString(R.string.settings_audio_quality)
            rowValue.text = getString(R.string.settings_audio_quality_value)
            root.setOnClickListener { snackbar(R.string.settings_audio_quality) }
        }
        with(binding.rowDownloadWifi) {
            rowIcon.setImageResource(R.drawable.ic_tune)
            rowTitle.text = getString(R.string.settings_download_wifi)
            rowSwitch.isChecked = true
            rowSwitch.setOnCheckedChangeListener { _, checked ->
                Snackbar.make(
                    binding.root,
                    if (checked) "Wi-Fi only enabled" else "Wi-Fi only disabled",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setupNotificationsGroup() {
        with(binding.rowPushNotifications) {
            rowIcon.setImageResource(R.drawable.ic_notifications)
            rowTitle.text = getString(R.string.settings_push)
            rowSwitch.isChecked = true
            rowSwitch.setOnCheckedChangeListener { _, checked ->
                Snackbar.make(
                    binding.root,
                    if (checked) "Notifications on" else "Notifications off",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setupAppearanceGroup() {
        with(binding.rowTheme) {
            rowIcon.setImageResource(R.drawable.ic_palette)
            rowTitle.text = getString(R.string.settings_theme)
            rowValue.text = getString(R.string.settings_theme_value)
            root.setOnClickListener { snackbar(R.string.settings_theme) }
        }
    }

    private fun confirmLogout() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.settings_logout)
            .setMessage("Sign out and return to the login screen?")
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(R.string.settings_logout) { _, _ ->
                val intent = Intent(requireContext(), LoginActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                }
                startActivity(intent)
                requireActivity().finish()
            }
            .show()
    }

    private fun snackbar(stringRes: Int) {
        Snackbar.make(binding.root, getString(stringRes), Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
