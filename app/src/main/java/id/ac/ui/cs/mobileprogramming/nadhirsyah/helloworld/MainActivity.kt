package id.ac.ui.cs.mobileprogramming.nadhirsyah.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.list_club_fragment, ItemClubFragment()).commit()

    }
    override fun onBackPressed() {
        if(supportFragmentManager.findFragmentById(R.id.list_club_fragment) is ClubsFragment){
            supportFragmentManager.beginTransaction().replace(R.id.list_club_fragment, ItemClubFragment()).commit()
        } else{
            super.onBackPressed()
        }
    }

}