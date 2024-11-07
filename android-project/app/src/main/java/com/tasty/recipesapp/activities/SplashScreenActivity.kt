package com.tasty.recipesapp.activities
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.tasty.recipesapp.databinding.ActivitySplashScreenBinding
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashScreenBinding
    companion object {const val SPLASH_TIME_OUT: Long= 2000}
    val TAG = "SplashScreenActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")



        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startAnimations()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets -> insets }
    }
//        binding.startButton.setOnClickListener{
//            //ha megnyomjuk a gombot
//            val intetnt = Intent(this, MainActivity::class.java)
//            intetnt.putExtra("KEY", binding.inputText.text)
//            startActivity(intetnt)
//            finish()
//            //Log.i(TAG, "Start button clicked")
//            //binding.inputText.text = getString(R.string.app_name)
//        }

    private fun startAnimations() {
        // Initially set the TextView's alpha to 0 for fade-in effect
        binding.taglineTextView.alpha = 0f
        binding.taglineTextView.visibility = View.INVISIBLE

        // Animate the TextView
        binding.taglineTextView.visibility = View.VISIBLE
        binding.taglineTextView.animate()
            .alpha(1f)
            .setDuration(1000)
            .setInterpolator(AccelerateInterpolator())
            .withEndAction {
                val handlerThread = HandlerThread("SplashHandlerThread", -10)
                handlerThread.start()
                val handler = Handler(handlerThread.looper)
                handler.postDelayed({
                    val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }, SPLASH_TIME_OUT)
            }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onCreate")
    }
}