package com.example.changelanguage.activites

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.changelanguage.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

private const val LANGUAGE = "LANGUAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = resources.getText(R.string.app_name)
        when (getLanguageApp()) {
            "en" -> {
                btnVietnamese.isEnabled = true
                btnEnglish.isEnabled = false
            }
            else -> {
                btnEnglish.isEnabled = true
                btnVietnamese.isEnabled = false
            }
        }
        btnEnglish.setOnClickListener {
            setUpLanguage("en")
            Toast.makeText(this, "English", Toast.LENGTH_SHORT).show()
        }
        btnVietnamese.setOnClickListener {
            setUpLanguage("vi")
            Toast.makeText(this, "Vietnamese", Toast.LENGTH_SHORT).show()
        }

    }

    @Suppress("DEPRECATION")
    private fun setUpLanguage(language: String) {
        val config = resources.configuration
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(Locale(language))
        } else {
            config.locale = Locale(language)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            createConfigurationContext(config)
        }
        resources.updateConfiguration(config, resources.displayMetrics)

        putLanguageToApp(language)

        val intent = Intent(baseContext, MainActivity::class.java)
        finish()
        startActivity(intent)
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)

    }

    private fun putLanguageToApp(language: String) {
        val sharedPreferences = getSharedPreferences(LANGUAGE, MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        edit.putString("language", language)
        edit.apply()
    }

    private fun getLanguageApp(): String {
        val sharedPreferences = getSharedPreferences(LANGUAGE, MODE_PRIVATE)
        return sharedPreferences.getString("language", "en").toString()
    }

}