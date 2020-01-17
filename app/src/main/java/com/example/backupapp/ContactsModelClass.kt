package com.example.backupapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Name of the table
@Entity(tableName = "Contacts")
class ContactsModelClass(
    //Name of the column
    @ColumnInfo(name = "contactId")
    //Increment on the Id
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    @ColumnInfo(name = "contactName")
    var name:String,
    @ColumnInfo(name = "contactEmail")
    var email:String,
    @ColumnInfo(name = "contactPhone")
    var phone:String


) {
}