package id.ac.ui.cs.mobileprogramming.nadhirsyah.helloworld

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class MainActivity:AppCompatActivity() {
    private lateinit var wifiAdapter: WifiAdapter
    private lateinit var wifiManager: WifiManager
    private lateinit var wifiRC: RecyclerView
    private var wifiList = listOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wifiRC = findViewById(R.id.wifi_rc)
        wifiRC.layoutManager = LinearLayoutManager(this)
        wifiAdapter = WifiAdapter(emptyList())
        wifiRC.adapter = wifiAdapter

        scanButton.setOnClickListener{
            wifiManager = applicationContext?.getSystemService(Context.WIFI_SERVICE) as WifiManager
            if(!checkPermission()){
                requestPermission()
            } else {
                wifiScan()
            }
        }
        sendButton.setOnClickListener{
            sendRequest()
        }
    }
    private fun checkPermission(): Boolean {
        val result =
            applicationContext?.let { ContextCompat.checkSelfPermission(
                it,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) }
        return result == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        let {
            ActivityCompat.requestPermissions(
                it,
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_WIFI_STATE
                ),
                101
            )
        }
    }
    private fun wifiScan() {
        val wifiScanReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
                if (success) {
                    scanSuccess()
                } else {
                    scanFailure()
                }
            }
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        applicationContext.registerReceiver(wifiScanReceiver, intentFilter)

        val success = wifiManager.startScan()
        if (!success) {
            scanFailure()
        }
    }
    private fun scanSuccess() {
        val results = wifiManager.scanResults
        wifiList = emptyList()
        generateWifiAdapter(results)
    }

    private fun scanFailure() {
        Toast.makeText(this, "Failed to scan any Wi-Fi nearby", Toast.LENGTH_SHORT).show()
    }
    private fun generateWifiAdapter(results: List<ScanResult>){
        for (res in results){
            wifiList += res.SSID
        }
        wifiAdapter = WifiAdapter(wifiList)
        wifiRC.adapter = wifiAdapter

    }
    private fun sendRequest(){
        val thread = Thread {
            try{
                sendPostRequest(wifiList.toString())
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
        thread.start()
    }
    private fun sendPostRequest(content: String){
        val url = URL("https://482c9a5e3b3f1a878406cf14243e0ef9.m.pipedream.net")
        val con = url.openConnection() as HttpURLConnection
        con.requestMethod = "POST"
        con.setRequestProperty("Content-Type", "application/json; utf-8")
        con.setRequestProperty("Accept", "application/json")
        con.doOutput = true
        val jsonInputString: String = "{\"data\":$content}"

        con.outputStream.use { os->
            val input = jsonInputString.toByteArray(charset("utf-8"))
            os.write(input, 0 , input.size)
        }

        BufferedReader(InputStreamReader(con.inputStream, "utf-8")).use { br ->
            val response = java.lang.StringBuilder()
            var responseLine: String? = null
            while (br.readLine().also { responseLine = it } != null) {
                response.append(responseLine!!.trim { it <= ' ' })
            }
            println(response.toString())
        }
        this@MainActivity.runOnUiThread(java.lang.Runnable {
            Toast.makeText(getApplicationContext(),"Wifi Sent!",Toast.LENGTH_SHORT).show()
        })
    }
}