package com.sanket.ovyotestproject.presentation.ui.video

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sanket.ovyotestproject.R
import com.sanket.ovyotestproject.databinding.ItemMovieBinding
import com.sanket.ovyotestproject.data.models.Video

class VideoListAdapter(private val onVideoSelect: OnVideoSelect) :
    RecyclerView.Adapter<VideoListAdapter.ViewHolder>() {
    private val videos = mutableListOf<Video>()
    fun addVideos(updatedVideos: List<Video>) {
        videos.addAll(updatedVideos)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemMovieBinding, val onVideoSelect: OnVideoSelect) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Video) {
            val names = data.user.name.split(" ")
            var updatedName = ""
            updatedName = if (names.size > 1) {
                names[0].first().toString() + names[1].first().toString()
            } else {
                names[0].first().toString()
            }
            binding.txtUserAvatar.text = updatedName
            binding.txtUseName.text = data.user.name
            binding.txtUserHandle.text = data.user.url

            Glide.with(binding.imgMovieBanner.context).load(data.image)
                .override(720, 640)
                .placeholder(R.drawable.ic_launcher_background).into(binding.imgMovieBanner)

            binding.itemVideo.setOnClickListener {
                onVideoSelect.onVideoSelected(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemMovieBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_movie, parent, false)
        return ViewHolder(binding, onVideoSelect)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(videos[position])
    }

    override fun getItemCount(): Int {
        return videos.size
    }
}

interface OnVideoSelect {
    fun onVideoSelected(video: Video)
}