package com.example.socialapp.daos

import com.example.socialapp.models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


//To store user's entity in user database
class UserDao {
    //getting reference of user's database from firestore
    private val db = FirebaseFirestore.getInstance()
    private val userCollection = db.collection("users")

    fun addUser(user: User?){
        //if user not null then only let block will be excecuted
        user?.let {
            //Coroutine used -> to allocate id in background thread
            GlobalScope.launch(Dispatchers.IO) {
                userCollection.document(user.uid).set(it)
            }
        }
    }

    fun getUserById(uid: String): Task<DocumentSnapshot> {
        //.get() --> gives user's detail in Task<DocumentSnapshot> form
        return userCollection.document(uid).get()
    }
}