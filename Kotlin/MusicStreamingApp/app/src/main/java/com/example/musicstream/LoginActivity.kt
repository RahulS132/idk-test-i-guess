package com.example.musicstream

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.musicstream.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

/**
 * Sign-in entry point. Validates email + password locally and (on success)
 * launches [MainActivity].
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindUi()
    }

    private fun bindUi() = with(binding) {
        loginBtn.setOnClickListener { attemptLogin() }

        forgotPasswordBtn.setOnClickListener {
            Snackbar.make(root, "Password reset link sent.", Snackbar.LENGTH_SHORT).show()
        }

        googleBtn.setOnClickListener {
            Snackbar.make(root, "Google sign-in coming soon.", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun attemptLogin() = with(binding) {
        val email = emailInput.text?.toString().orEmpty().trim()
        val password = passwordInput.text?.toString().orEmpty()

        // Reset errors
        emailLayout.error = null
        passwordLayout.error = null

        // Test credential shortcut for development.
        if (email.equals("test", ignoreCase = true) && password == "test") {
            goToMain()
            return
        }

        var valid = true

        if (email.isEmpty()) {
            emailLayout.error = getString(R.string.error_email_required)
            valid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailLayout.error = getString(R.string.error_email_invalid)
            valid = false
        }

        if (password.isEmpty()) {
            passwordLayout.error = getString(R.string.error_password_required)
            valid = false
        } else if (password.length < 6) {
            passwordLayout.error = getString(R.string.error_password_short)
            valid = false
        }

        if (valid) goToMain()
    }

    private fun goToMain() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }
}
