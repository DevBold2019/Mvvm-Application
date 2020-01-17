package com.example.backupapp

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.android.material.textfield.TextInputLayout


class AddNewContact : AppCompatActivity() {


   final val   Name:String="Amoh"
   final val Email:String="me@yahoo.com"
  final val Phone:String="07864512"



    lateinit var nameEditText: TextInputLayout
    lateinit var emailEditText: TextInputLayout
    lateinit var phoneEditText: TextInputLayout

    lateinit var savebutton: Button
    lateinit var database: ContactsDatabase
    lateinit var adapter: ContactsAdapter
    var list: ArrayList<ContactsModelClass> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_contact)


        nameEditText = findViewById(R.id.name)
        emailEditText = findViewById(R.id.email)
        phoneEditText = findViewById(R.id.phone)

        savebutton = findViewById(R.id.saveButton)

        savebutton.setOnClickListener(object : View.OnClickListener {

            override fun onClick(p0: View?) {

                saveContact()
            }


        })



    }

    fun saveContact() {

        if (nameEditText.editText!!.text.toString().trim().isEmpty() || emailEditText.editText!!.text.toString().trim().isEmpty() || phoneEditText.editText!!.text.toString().trim().isEmpty()) {
            Toast.makeText(applicationContext, "Can't Save null values", Toast.LENGTH_LONG).show()
            return

        }

        nameEditText.editText!!.text.clear()
        emailEditText.editText!!.text.clear()
        phoneEditText.editText!!.text.clear()

        intent = Intent()
        intent.putExtra(Name, nameEditText.editText!!.text.toString())
        intent.putExtra(Email, emailEditText.editText!!.text.toString())
        intent.putExtra(Phone, phoneEditText.editText!!.text.toString())

        setResult(Activity.RESULT_OK,intent)
        finish()


    }



}
