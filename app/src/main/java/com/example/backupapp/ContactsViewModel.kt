package com.example.backupapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ContactsViewModel(application: Application) : AndroidViewModel(application) {

    var repository: ContactRepository = ContactRepository(application)
    var allContacts: LiveData<List<ContactsModelClass>> = repository.getEveryContact()


    fun add(modelClass: ContactsModelClass) {

        repository.addNewContact(modelClass)

    }

    fun getAllDigits(): LiveData<List<ContactsModelClass>> {

        return allContacts
    }


}