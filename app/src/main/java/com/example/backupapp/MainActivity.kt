package com.example.backupapp

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {


    var ResultCode:Int=1
    lateinit var recyclerView: RecyclerView
    var adapter: ContactsAdapter = ContactsAdapter()
    lateinit var viewModel: ContactsViewModel

   val newContact: AddNewContact = AddNewContact()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        recyclerView=findViewById(R.id.recyclerview)
        recyclerView.layoutManager=LinearLayoutManager(applicationContext)
        recyclerView.setHasFixedSize(true)

        recyclerView.adapter=adapter

        viewModel=ViewModelProviders.of(this@MainActivity).get(ContactsViewModel::class.java)
        viewModel.getAllDigits().observe(this@MainActivity, object : Observer<List<ContactsModelClass>> {
            override fun onChanged(t: List<ContactsModelClass>?) {

                //Updating our recyclerview here
                Toast.makeText(this@MainActivity,"On changed",Toast.LENGTH_LONG).show()
                adapter.addNew(t!!)

            }


        })





    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==ResultCode && resultCode== Activity.RESULT_OK){

            val name:String=data!!.getStringExtra(newContact.Name)
            val email:String=data!!.getStringExtra(newContact.Email)
            val phone:String=data!!.getStringExtra(newContact.Phone)

            val modelClass:ContactsModelClass= ContactsModelClass(0,name, email, phone)
            viewModel.add(modelClass)

            Toast.makeText(this@MainActivity,"Saved\n"+name,Toast.LENGTH_LONG).show()

        }else{

            Toast.makeText(this@MainActivity,"Not Saved",Toast.LENGTH_LONG).show()



        }


    }
    fun goToNext(view: View) {

        intent= Intent(applicationContext,AddNewContact::class.java)
        startActivityForResult(intent,ResultCode)


    }




}
