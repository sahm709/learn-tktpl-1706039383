package id.ac.ui.cs.mobileprogramming.nadhirsyah.helloworld

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private var seconds = 0
    private var running = false
    private var buttonPressedTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
        }
        val exitButton : Button = findViewById(R.id.exit_button)
        runTimer()
        exitButton.setOnClickListener{
            exitFunction()
        }
    }
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt("seconds", seconds)
        savedInstanceState.putBoolean("running", running)
    }
    private fun exitFunction(){
        if (buttonPressedTime + 3000 > System.currentTimeMillis()){
            super.onBackPressed()
        } else {
            Toast.makeText(applicationContext, "Press exit button again", Toast.LENGTH_SHORT).show()
        }
        buttonPressedTime = System.currentTimeMillis()
    }

    override fun onBackPressed() {
        Toast.makeText(this@MainActivity, "Use exit button", Toast.LENGTH_SHORT).show()
    }
    //Start the stopwatch running when the Start button is clicked.
    fun onClickStart(view: View?) {
        running = true
    }

    //Stop the stopwatch running when the Stop button is clicked.
    fun onClickStop(view: View?) {
        running = false
    }

    //Reset the stopwatch when the Reset button is clicked.
    fun onClickReset(view: View?) {
        running = false
        seconds = 0
    }

    //Sets the number of seconds on the timer.
    private fun runTimer() {
        val timeView = findViewById<View>(R.id.time_view) as TextView
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = seconds % 3600 / 60
                val secs = seconds % 60
                val time = String.format(
                    Locale.getDefault(),
                    "%02d:%02d:%02d", hours, minutes, secs
                )
                timeView.text = time
                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        })
    }
}