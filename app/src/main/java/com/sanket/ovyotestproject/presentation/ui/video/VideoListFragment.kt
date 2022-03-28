package com.sanket.ovyotestproject.presentation.ui.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sanket.ovyotestproject.R
import com.sanket.ovyotestproject.data.models.Video
import com.sanket.ovyotestproject.databinding.FragmetVideoListBinding
import com.sanket.ovyotestproject.presentation.ui.MainActivity
import com.sanket.ovyotestproject.presentation.viewmodel.VideoViewModel

class VideoListFragment : Fragment(), OnVideoSelect {
    private var viewModel: VideoViewModel? = null
    private val adapter: VideoListAdapter = VideoListAdapter(this)
    private lateinit var binding: FragmetVideoListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragmet_video_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        binding.rvMovies.adapter = adapter
    }

    private fun setupViewModel() {
        viewModel = (activity as MainActivity).viewModel
        loadPage()
    }

    private fun loadPage() {
        viewModel?.let {
            it.getMovies(1).observe(viewLifecycleOwner, Observer { videoData ->
                videoData?.let { result ->
                    adapter.addVideos(result.videos)
                    binding.progressVideoList.visibility = View.GONE
                    binding.rvMovies.visibility = View.VISIBLE
                }
            })
        }
    }

    override fun onVideoSelected(video: Video) {
        val action = VideoListFragmentDirections.actionVideoListFragmentToVideoPlayerFragment(video.videoFiles[0].link)
        findNavController().navigate(action)
    }
}