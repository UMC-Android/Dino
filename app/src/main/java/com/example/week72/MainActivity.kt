package com.example.week72

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnPlayPause: Button
    private lateinit var btnStop: Button
    private lateinit var tvCurrentTime: TextView
    private lateinit var seekBar: SeekBar
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var updateSeekBarThread: Thread
    private var isPlaying: Boolean = false

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlayPause = findViewById(R.id.btnPlayPause)
        btnStop = findViewById(R.id.btnStop)
        tvCurrentTime = findViewById(R.id.tvCurrentTime)
        seekBar = findViewById(R.id.seekBar)

        mediaPlayer = MediaPlayer.create(this, R.raw.sample_music)

        // 음악 재생/일시정지 버튼 클릭 시
        btnPlayPause.setOnClickListener {
            if (isPlaying) {
                pauseMusic()
            } else {
                playMusic()
            }
        }

        // 정지 버튼 클릭 시
        btnStop.setOnClickListener {
            stopMusic()
        }

        // SeekBar 변경 시
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

            // SeekBar 업데이트
            updateSeekBarThread = Thread {
                while (mediaPlayer != null && mediaPlayer.isPlaying) {
                    try {
                        Thread.sleep(1000)
                        runOnUiThread {
                            seekBar.progress = mediaPlayer.currentPosition
                            tvCurrentTime.text = formatTime(mediaPlayer.currentPosition)
                        }
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }

            // 음악 재생이 끝나면 처리
            mediaPlayer.setOnCompletionListener {
                stopMusic()
            }
        }

        private fun playMusic() {
            mediaPlayer.start()
            isPlaying = true
            btnPlayPause.text = "일시정지"

            // SeekBar 업데이트 스레드 시작
            updateSeekBarThread.start()
        }

        private fun pauseMusic() {
            mediaPlayer.pause()
            isPlaying = false
            btnPlayPause.text = "재생"
        }

        private fun stopMusic() {
            mediaPlayer.stop()
            mediaPlayer.reset()
            isPlaying = false
            btnPlayPause.text = "재생"
            tvCurrentTime.text = "00:00"
            seekBar.progress = 0
        }

        private fun formatTime(duration: Int): String {
            val minutes = (duration / 1000) / 60
            val seconds = (duration / 1000) % 60
            return String.format("%02d:%02d", minutes, seconds)
        }

        override fun onDestroy() {
            super.onDestroy()
            mediaPlayer.release()
            updateSeekBarThread.interrupt()
        }
    }
