package com.example.utslecture.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.utslecture.R
import com.google.firebase.auth.FirebaseAuth

open class BaseAuth : Fragment() {
    private lateinit var auth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser == null) {
            redirectToLogin()
        } else if (isUserBlocked()) {
            redirectToLogin()
        }
    }
    private fun isUserBlocked(): Boolean {
        return false
    }
    private fun redirectToLogin() {
        findNavController().navigate(R.id.loginFragment)
    }
}