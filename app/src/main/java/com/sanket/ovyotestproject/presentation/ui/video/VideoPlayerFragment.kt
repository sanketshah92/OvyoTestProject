package com.sanket.ovyotestproject.presentation.ui.video

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.sanket.ovyotestproject.R
import com.sanket.ovyotestproject.databinding.FragmentVideoPlayerBinding
import com.universalvideoview.UniversalMediaController
import com.universalvideoview.UniversalVideoView

class VideoPlayerFragment : Fragment() {
    private lateinit var binding: FragmentVideoPlayerBinding
    private lateinit var videoView: UniversalVideoView
    private lateinit var controller: UniversalMediaController
    private lateinit var video: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_video_player, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getVideoPath()
        setupPlayer()
    }

    private fun setupPlayer() {
        videoView = binding.videoView
        controller = binding.mediaController
        videoView.setMediaController(controller)
        videoView.setVideoURI(Uri.parse(video))
        videoView.seekTo(1)
        videoView.start()
    }

    private fun getVideoPath() {
        val args: VideoPlayerFragmentArgs by navArgs()
        video = args.video
    }
}