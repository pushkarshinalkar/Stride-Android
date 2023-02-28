package com.tutorial.courser.ui.activities



import android.content.pm.ActivityInfo
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.util.MimeTypes
import com.tutorial.courser.R


import android.net.Uri
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.util.Util

class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var playerView: PlayerView
    private lateinit var player: SimpleExoPlayer
    private var vid_link: String = "link"
    private var isFullscreen = false
    private lateinit var fullscreenButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        fullscreenButton = findViewById(R.id.fullscreenid)
        fullscreenButton.setOnClickListener {
            if (!isFullscreen){
                toggleFullscreen()
            }

        }

        val extras = getIntent().extras
        if (extras != null) {
            vid_link = extras.getString("vid_link_passed", "link")
//            Toast.makeText(this@VideoPlayerActivity, vid_link, Toast.LENGTH_SHORT).show()
            //The key argument here must match that used in the other activity
        }

        playerView = findViewById(R.id.player_view)

        // Create a new SimpleExoPlayer instance.
        player = SimpleExoPlayer.Builder(this).build()

        // Bind the player to the view.
        playerView.player = player

        // Build the media item.
        val mediaItem = buildMediaItem()

        // Add the media item to the player.
        player.setMediaItem(mediaItem)

        // Prepare the player.
        player.prepare()

        // Start playing the video.
        player.playWhenReady = true
    }

    private fun buildMediaItem(): MediaItem {
        // Replace the video URL with your own video URL.
        val videoUri = Uri.parse(vid_link)

        // Build a media item from the URI.
        return MediaItem.Builder()
            .setUri(videoUri)
            .build()
    }

    override fun onStart() {
        super.onStart()

        if (Util.SDK_INT >= 24) {
            player.playbackState
        }
    }

    override fun onResume() {
        super.onResume()

        if (Util.SDK_INT < 24 || player == null) {
            player.playbackState
        }
    }

    override fun onPause() {
        super.onPause()

        if (Util.SDK_INT < 24) {
            player.playWhenReady = false
        }
    }

    override fun onStop() {
        super.onStop()

        if (Util.SDK_INT >= 24) {
            player.playWhenReady = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        // Release the player.
        player.release()
    }

    private fun toggleFullscreen() {
        if (!isFullscreen) {
            // Set the resize mode to fill the entire screen.
            playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL)

            // Set the orientation to landscape mode.
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

            // Set the layout parameters to match the screen size.
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            val layoutParams = playerView.layoutParams
            layoutParams.width = displayMetrics.widthPixels
            layoutParams.height = displayMetrics.heightPixels
            playerView.layoutParams = layoutParams

            isFullscreen = true
        } else {
            // Set the resize mode to fit the video within the view.
            playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIT)

            // Set the orientation to portrait mode.
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

            // Reset the layout parameters to their original values.
            val layoutParams = playerView.layoutParams
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            playerView.layoutParams = layoutParams

            isFullscreen = false
        }
    }


    override fun onBackPressed() {
        if (isFullscreen) {
            toggleFullscreen()
        } else {
            super.onBackPressed()
        }
    }





}
