package com.example.musicstream.data

import com.example.musicstream.R

/**
 * Static sample data used to populate the UI.
 *
 * Each [Album] declares an [Album.artBitmapName] referring to a bitmap
 * resource (e.g. `art_in_rainbows`). If you drop a PNG/JPG with that exact
 * name into `res/drawable/`, the adapter will display it automatically;
 * otherwise it falls back to the themed gradient supplied via [Album.coverRes].
 */
object SampleData {

    val trending: List<Album> = listOf(
        Album("t1", "In Rainbows", "Radiohead",
            R.drawable.cover_in_rainbows, "art_in_rainbows"),
        Album("t2", "10,000 Days", "Tool",
            R.drawable.cover_10000_days, "art_10000_days"),
        Album("t3", "Remember That You Will Die", "Polyphia",
            R.drawable.cover_remember_die, "art_remember_die"),
        Album("t4", "Deliverance", "Opeth",
            R.drawable.cover_deliverance, "art_deliverance"),
        Album("t5", "Kid A", "Radiohead",
            R.drawable.cover_kid_a, "art_kid_a")
    )

    val newReleases: List<Album> = listOf(
        Album("n1", "Fear Inoculum", "Tool",
            R.drawable.cover_fear_innoculum, "art_fear_inoculum"),
        Album("n2", "A Moon Shaped Pool", "Radiohead",
            R.drawable.cover_a_moon_shaped_pool, "art_a_moon_shaped_pool"),
        Album("n3", "New Levels New Devils", "Polyphia",
            R.drawable.cover_new_levels, "art_new_levels"),
        Album("n4", "Ghost Reveries", "Opeth",
            R.drawable.cover_ghost_reveries, "art_ghost_reveries"),
        Album("n5", "Hail to the Thief", "Radiohead",
            R.drawable.cover_hail_to_thief, "art_hail_to_thief")
    )

    val madeForYou: List<Album> = listOf(
        Album("m1", "OK Computer", "Radiohead",
            R.drawable.cover_ok_computer, "art_ok_computer"),
        Album("m2", "Lateralus", "Tool",
            R.drawable.cover_lateralus, "art_lateralus"),
        Album("m3", "Blackwater Park", "Opeth",
            R.drawable.cover_blackwater_park, "art_blackwater_park"),
        Album("m4", "Muting the Noise", "Polyphia",
            R.drawable.cover_muting_noise, "art_muting_noise"),
        Album("m5", "Undertow", "Tool",
            R.drawable.cover_undertow, "art_undertow"),
        Album("m6", "In Rainbows", "Radiohead",
            R.drawable.cover_in_rainbows, "art_in_rainbows")
    )

    val recentlyPlayed: List<Album> = listOf(
        Album("r1", "Lateralus", "Tool",
            R.drawable.cover_lateralus, "art_lateralus"),
        Album("r2", "Kid A", "Radiohead",
            R.drawable.cover_kid_a, "art_kid_a"),
        Album("r3", "Ghost Reveries", "Opeth",
            R.drawable.cover_ghost_reveries, "art_ghost_reveries"),
        Album("r4", "Remember That You Will Die", "Polyphia",
            R.drawable.cover_remember_die, "art_remember_die")
    )

    val favoriteGenres: List<String> = listOf(
        "Progressive Rock", "Alternative", "Progressive Metal", "Math Rock",
        "Art Rock", "Death Metal"
    )
}
