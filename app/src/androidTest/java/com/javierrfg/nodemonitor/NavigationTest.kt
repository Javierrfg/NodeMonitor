package com.javierrfg.nodemonitor

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.javierrfg.nodemonitor.ui.MainActivity
import com.javierrfg.nodemonitor.R

@RunWith(AndroidJUnit4::class)
class NavigationTest {

    // Lanzamos la pantalla de inicio
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testNavigationToDashboard() {
        // Simulamos un clic en el botón "Ingresar al Panel"
        onView(withId(R.id.btnEnter)).perform(click())

        // Verificamos que la lista de servidores ahora es visible
        onView(withId(R.id.recyclerViewServers)).check(matches(isDisplayed()))
    }
}