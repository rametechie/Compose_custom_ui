package com.kpit.demo

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kpit.demo.ui.DemoScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CustomWidgetsUiTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun customButton_clickTriggersAction() {
        composeRule.onNodeWithText("Click Me").assertExists().performClick()
    }

    @Test
    fun customDropDown_selectOption_updatesSelectedText() {
        composeRule.onNodeWithText("Select an option").performClick()
        composeRule.onNodeWithText("Option 1").performClick()
        composeRule.onNodeWithText("Option 1").assertExists()
    }

    @Test
    fun dropdown_SelectsNewOption() {
        // Initial state
        composeRule.onNodeWithText("Select an option").assertExists().performClick()

        // Select an item from the dropdown
        composeRule.onNodeWithText("Option 2").performClick()

        // Verify the selection updated
        composeRule.onNodeWithText("Option 2").assertExists()
    }

    @Test
    fun customInputField_typesText_showsStrength() {
        composeRule.onNodeWithText("Enter password").performTextInput("Abc123!@#456")
        composeRule.onNodeWithText("Strength: STRONG").assertExists()
    }
}