package com.example.backupapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter: RecyclerView.Adapter<ContactsAdapter.viewholder>() {

     var  list:List<ContactsModelClass> = ArrayList()




    class viewholder(view:View):RecyclerView.ViewHolder(view) {

        var name:TextView=view.findViewById(R.id.nameTextView)
        var email:TextView=view.findViewById(R.id.emailTextView)
        var phone:TextView=view.findViewById(R.id.phoneTextView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        var view:View

        view=LayoutInflater.from(parent.context).inflate(R.layout.contact_holder,parent,false)

        return  viewholder(view)
    }

    override fun getItemCount(): Int {

      return list.size

    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var model=list.get(position)

        holder.name.text=model.name
        holder.email.text=model.email
        holder.phone.text=model.phone


    }

    fun  addNew(modelList:List<ContactsModelClass>) {

        this.list = modelList
        notifyDataSetChanged()
    }



}