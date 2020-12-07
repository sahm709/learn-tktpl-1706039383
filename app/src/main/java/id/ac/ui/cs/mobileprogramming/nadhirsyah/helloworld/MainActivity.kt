package id.ac.ui.cs.mobileprogramming.nadhirsyah.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private external fun processPower(number: Int): Int
    private var number: Int = 0
    private lateinit var numberEditText: EditText
    private lateinit var numberTextView: TextView
    private lateinit var numberButton: Button
    companion object {
        init {
            System.loadLibrary("jni")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberEditText= findViewById(R.id.editText1)
        numberTextView= findViewById(R.id.text1)
        numberButton = findViewById(R.id.numberButton)

        numberButton.setOnClickListener{
            number = processPower(numberEditText.text.toString().toInt())
            Log.d("power", number.toString())
            numberTextView.text = number.toString()

        }
    }

}