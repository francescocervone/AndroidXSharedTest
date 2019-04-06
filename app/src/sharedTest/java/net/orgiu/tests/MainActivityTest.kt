package net.orgiu.tests

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@Category(DoNotRunOnJvm::class)
class MainActivityTest {
    @Test
    fun simple_test() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.fab)).check(matches(isDisplayed()))
    }

    @Test
    fun sharedApplication_test() {
        val applicationContext = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext

        assertThat(applicationContext, Matchers.instanceOf(TestApp::class.java))
    }
}