package id.ac.ui.cs.mobileprogramming.nadhirsyah.helloworld

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testHelloWorldExist() {
        onView(ViewMatchers.withId(R.id.text1)).check(ViewAssertions.matches(ViewMatchers.withText("Hello World!")))
    }
    @Test
    fun testWhenButtonIsNotClick() {
        onView(ViewMatchers.withId(R.id.button1)).check(ViewAssertions.matches(ViewMatchers.withText("Light Mode")))
    }
    @Test
    fun testWhenButtonIsClick() {
        onView(ViewMatchers.withId(R.id.button1)).perform(click()).check(ViewAssertions.matches(ViewMatchers.withText("Dark Mode")))
    }



    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("id.ac.ui.cs.mobileprogramming.nadhirsyah.helloworld", appContext.packageName)
    }
}