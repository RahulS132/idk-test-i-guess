package com.example.musicstream.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicstream.R
import com.example.musicstream.data.Album
import com.example.musicstream.databinding.ItemAlbumBinding

/**
 * Reusable adapter for any list/grid of [Album]s.
 *
 * @param onAlbumClick optional click handler invoked when a card is tapped.
 */
class AlbumAdapter(
    private val onAlbumClick: ((Album) -> Unit)? = null
) : ListAdapter<Album, AlbumAdapter.AlbumViewHolder>(DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = ItemAlbumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class AlbumViewHolder(
        private val binding: ItemAlbumBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album) = with(binding) {
            albumTitle.text = album.title
            albumArtist.text = album.artist

            val ctx = root.context
            val bitmapResId = album.artBitmapName?.let {
                ctx.resources.getIdentifier(it, "drawable", ctx.packageName)
            } ?: 0

            when {
                bitmapResId != 0 -> {
                    // Real album-art bitmap supplied by the user. Clear any
                    // tint so the colors render correctly.
                    albumCover.setBackgroundResource(R.drawable.bg_album_placeholder)
                    albumCover.imageTintList = null
                    albumCover.setImageResource(bitmapResId)
                    albumCover.setPadding(0, 0, 0, 0)
                }
                album.coverRes != null -> {
                    // Themed gradient fallback (applied as background).
                    albumCover.setBackgroundResource(album.coverRes)
                    albumCover.imageTintList = null
                    albumCover.setImageDrawable(null)
                    albumCover.setPadding(0, 0, 0, 0)
                }
                else -> {
                    // Generic placeholder vinyl — keep the accent tint here.
                    albumCover.setBackgroundResource(R.drawable.bg_album_placeholder)
                    albumCover.imageTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(ctx, R.color.dusty_denim)
                    )
                    albumCover.setImageResource(R.drawable.ic_album_placeholder)
                    val pad = (root.resources.displayMetrics.density * 36).toInt()
                    albumCover.setPadding(pad, pad, pad, pad)
                }
            }

            root.setOnClickListener { onAlbumClick?.invoke(album) }
        }
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Album>() {
            override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean =
                oldItem == newItem
        }
    }
}
