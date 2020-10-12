package id.ac.ui.cs.mobileprogramming.nadhirsyah.helloworld.club

import java.util.ArrayList
import java.util.HashMap

object ClubContent {

    val ITEMS: MutableList<ClubItem> = ArrayList()


    val ITEM_MAP: MutableMap<String, ClubItem> = HashMap()

    private val ITEM_CLUB_DICT: MutableMap<String, String> = HashMap()

    init {
        generatesClubDummy()
        var count = 1
        for ((club, club_detail) in ITEM_CLUB_DICT) {
            addItem(createClubItem(count, club, club_detail))
            count++
        }
    }

    private fun addItem(item: ClubItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createClubItem(position: Int,club: String, clubDetail: String): ClubItem {
        return ClubItem(position.toString(), club, clubDetail)
    }

    private fun generatesClubDummy() {
        ITEM_CLUB_DICT["Bayern Munchen"] = "FC Bayern München, atau FC Bayern, adalah sebuah klub olahraga " +
                "Jerman yang berbasis di München, Bayern. Hal ini terkenal karena tim sepak "+
                "bola profesional, yang bermain di Bundesliga, peringkat teratas sistem liga "+
                "sepak bola Jerman, dan merupakan klub paling sukses dalam sejarah sepak bola "+
                "Jerman, setelah memenangkan rekor 30 gelar nasional dan 19 piala nasional."
        ITEM_CLUB_DICT["Liverpool"] = "Liverpool Football Club (dikenal pula sebagai Liverpool "+
                "atau The Reds) adalah sebuah klub sepak bola asal Inggris yang berbasis di "+
                "Kota Liverpool. Saat ini Liverpool adalah peserta Liga Utama Inggris. Liverpool "+
                "juga merupakan juara dari Liga Utama Inggris musim 2019–2020."
        ITEM_CLUB_DICT["Real Madrid"] = "Real Madrid Club de Fútbol, umumnya dikenal sebagai "+
                "Real Madrid, adalah klub sepak bola profesional yang berbasis di Madrid, Spanyol. Didirikan "+
                "pada tahun 1902 sebagai Madrid Football Club, secara tradisional mengenakan kostum kandang putih. "+
                "Kata Real dianugerahkan ke klub oleh Raja Alfonso XIII pada tahun 1920 bersama-sama dengan mahkota"+
                "kerajaan di lambang klub. Klub ini telah memainkan pertandingan andang di Stadion Santiago Bernabéu"+
                "dengan kapasitas 85.454 di pusat kota Madrid sejak tahun 1947."
        ITEM_CLUB_DICT["Barcelona"] = "Fútbol Club Barcelona, juga dikenal sebagai Barcelona atau Barça, adalah klub "+
                "sepak bola profesional yang berbasis di Barcelona, Catalunya, Spanyol.Didirikan pada tahun 1899 oleh sekelompok " +
                "pemain Swiss, Inggris, Jerman dan Katalan yang dipimpin oleh Joan Gamper, klub telah menjadi simbol budaya "+
                "Catalan dan Catalanisme, yang mempunyai motto \"Més que un club\" (Lebih dari sebuah klub)."
        ITEM_CLUB_DICT["Paris Saint-Germain"] = "Paris Saint-Germain Football Club atau dikenal luas dengan "+
                "sebutan PSG merupakan sebuah tim sepak bola Prancis yang bermain di Ligue 1, Prancis. "+
                "Bermarkas di Paris, Prancis. Klub ini didirikan pada 12 Agustus 1970, berkat penggabungan "+
                "Paris FC dan dengan Stade Saint-Germain."
    }


    data class ClubItem(val id: String, val club: String, val clubDetail: String) {
        override fun toString(): String = club
    }
}