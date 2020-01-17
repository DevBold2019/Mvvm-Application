package com.example.backupapp

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class ContactRepository {

   lateinit var dao:ContactsDao
    lateinit var  allContacts:LiveData<List<ContactsModelClass>>


    constructor(application: Application) {

        var contactsDatabase: ContactsDatabase=ContactsDatabase.getInstance(application)

        dao=contactsDatabase.contactsdao()
        allContacts=dao.getContacts()

    }

    fun  addNewContact(modelClass: ContactsModelClass){

        AddContactsAsync(dao).execute(modelClass)


    }
    fun  updateContact(modelClass: ContactsModelClass){



    }

    fun  deleteContact(modelClass: ContactsModelClass){



    }

    fun  getAContact(modelClass: ContactsModelClass){



    }

    fun getEveryContact():LiveData<List<ContactsModelClass>>{



        return allContacts

    }

    class AddContactsAsync(var dao: ContactsDao): AsyncTask<ContactsModelClass, Unit, Unit>() {

        override fun doInBackground(vararg p0: ContactsModelClass?) {

            dao.addContacts(p0[0]!!)

            return
        }


    }





}