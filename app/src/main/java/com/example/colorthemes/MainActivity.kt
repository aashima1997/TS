package com.example.colorthemes

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    val themeKey = "currentTheme"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(
            "ThemePref",
            Context.MODE_PRIVATE
        )
        when (sharedPreferences.getString(themeKey, "red")) {
            "lightGreen" ->  theme.applyStyle(R.style.OverlayThemeLime, true)
            "red" ->  theme.applyStyle(R.style.OverlayThemeRed, true)
            "green" ->  theme.applyStyle(R.style.OverlayThemeGreen, true)
            "blue" ->  theme.applyStyle(R.style.OverlayThemeBlue, true)
        }
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.lightGreen -> {
                sharedPreferences.edit().putString(themeKey, "lightGreen").apply()

            }
            R.id.red -> {
                sharedPreferences.edit().putString(themeKey, "red").apply()
            }
            R.id.green -> {
                sharedPreferences.edit().putString(themeKey, "green").apply()
            }
            R.id.blue -> {
                sharedPreferences.edit().putString(themeKey, "blue").apply()
            }
        }
        val intent = intent // from getIntent()
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()
        startActivity(intent)
    }
}