package com.example.musicstream.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.musicstream.R

public class ProfileFragmentDirections private constructor() {
  public companion object {
    public fun actionProfileToSettings(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profile_to_settings)
  }
}
