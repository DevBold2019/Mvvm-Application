package com.example.backupapp

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.logging.Logger


@Database(entities =[ContactsModelClass::class],version = 1)
 abstract class ContactsDatabase : RoomDatabase() {

    abstract fun contactsdao(): ContactsDao


    companion object {

        private  var instance: ContactsDatabase? = null

          @Synchronized
         fun getInstance(context: Context): ContactsDatabase {

              if (instance== null){

                  instance= Room.databaseBuilder(context.applicationContext, ContactsDatabase::class.java, "contacts_db").fallbackToDestructiveMigration().addCallback(
                      roomcall).build()
              }

              return instance!!

          }

        private val roomcall: Callback = object : Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                val Log = Logger.getLogger(MainActivity::class.java.name)
                Log.warning( "On create invoked &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&.")
                populateToDbTask(instance!!).execute()
            }

        }

     /*   fun getInstance(context: Context):ContactsDatabase {

            if (instance == null) {

                synchronized(ContactsDatabase::class) {

                    instance = Room.databaseBuilder(context.applicationContext, ContactsDatabase::class.java, "contacts_db").fallbackToDestructiveMigration().build()

                }

            }
            return instance!!
        }*/
    }




    class  populateToDbTask(var db:ContactsDatabase): AsyncTask<Unit, Unit, Unit>(){

         lateinit var contactsDao:ContactsDao

        override fun doInBackground(vararg p0: Unit?) {
           contactsDao=db.contactsdao()
            contactsDao.addContacts(ContactsModelClass(0,"Amos","me@gmail.com","09876542"))
            contactsDao.addContacts(ContactsModelClass(0,"Amos","me@gmail.com","09876542"))

        }


    }














}





