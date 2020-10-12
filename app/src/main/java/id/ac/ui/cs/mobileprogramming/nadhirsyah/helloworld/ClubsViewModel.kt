package id.ac.ui.cs.mobileprogramming.nadhirsyah.helloworld

import android.telecom.Call
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.nadhirsyah.helloworld.club.ClubContent

class ClubsViewModel : ViewModel() {

    var club: String = ""
    var clubDetail: String = ""
    fun setClub(club: String, clubDetail:String){
        this.club = club
        this.clubDetail=clubDetail
    }}