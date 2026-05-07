package com.example.musicstream.data

import androidx.annotation.DrawableRes

/**
 * Lightweight model representing an album/playlist tile.
 * In a real app this would be backed by a remote URL.
 */
data class Album(
    val id: String,
    val title: String,
    val artist: String,
    /** Themed gradient fallback used when no bitmap cover is supplied. */
    @DrawableRes val coverRes: Int? = null,
    /**
     * Resource name (without extension) of an optional bitmap cover.
     * Drop a PNG/JPG at res/drawable/<artBitmapName>.png and the adapter will
     * load it automatically; otherwise [coverRes] is used.
     */
    val artBitmapName: String? = null
)
