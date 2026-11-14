package com.kalinexus.launcher

import android.content.Intent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LauncherIntentTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun manifestDeclaresHomeIntentFilter() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val homeIntent = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME)
        val matches = context.packageManager.queryIntentActivities(homeIntent, 0)
        assertTrue(
            "MainActivity must resolve ACTION_MAIN + CATEGORY_HOME",
            matches.any { it.activityInfo.packageName == context.packageName }
        )
    }

    @Test
    fun bottomNavigationSwitchesBetweenAllFiveSections() {
        composeTestRule.onNodeWithText("HOME").assertIsDisplayed()
        composeTestRule.onNodeWithText("SYSTEM").performClick()
        composeTestRule.onNodeWithText("System Hardware").assertIsDisplayed()

        composeTestRule.onNodeWithText("SECURITY").performClick()
        composeTestRule.onNodeWithText("Security Posture").assertIsDisplayed()

        composeTestRule.onNodeWithText("GAMING").performClick()
        composeTestRule.onNodeWithText("Gaming Hub").assertIsDisplayed()

        composeTestRule.onNodeWithText("SETTINGS").performClick()
        composeTestRule.onNodeWithText("Launcher Settings").assertIsDisplayed()
    }
}
