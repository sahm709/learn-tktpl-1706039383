package id.ac.ui.cs.mobileprogramming.nadhirsyah.helloworld

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun themeIsChanged(){
        val activity = MainActivity()
        assertEquals(activity.changeThemeMessage(), "change theme")
    }
    @Test
    fun getButtonText(){
        val activity = MainActivity()
        assertEquals(activity.changeButtonMessage(), "Light Mode")
    }

}