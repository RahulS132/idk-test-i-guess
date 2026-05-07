package com.example.musicstream.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.musicstream.R

public class HomeFragmentDirections private constructor() {
  public companion object {
    public fun actionHomeToProfile(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_to_profile)
  }
}
