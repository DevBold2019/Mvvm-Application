package com.example.backupapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactsDao {

    @Insert
   fun addContacts(contact:ContactsModelClass)

    @Update
    fun updateContact(contact:ContactsModelClass)

    @Delete
    fun deleteContact(contact:ContactsModelClass)

    @Query("select * from Contacts")
    fun getContacts(): LiveData<List<ContactsModelClass>>

    @Query("select * from Contacts where contactId== :Contact_Id")
    fun getContact(Contact_Id:Long): ContactsModelClass




}