package com.example.socialapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogoutDialog: AppCompatDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setTitle("Alert")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("OK", DialogInterface.OnClickListener{
                    dialogInterface: DialogInterface, i: Int ->
                    Firebase.auth.signOut()
                    val intent = Intent(activity, SignInActivity::class.java)
                    startActivity(intent)
                })
        return builder.create()
    }
}