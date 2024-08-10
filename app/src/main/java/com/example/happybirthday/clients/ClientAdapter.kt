package com.happybirthday.clients

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.happybirthday.R

class ClientAdapter(private var clients: List<Client>) :
    RecyclerView.Adapter<ClientAdapter.ClientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_client, parent, false)
        return ClientViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val client = clients[position]
        holder.nameTextView.text = client.name
        holder.idNumberTextView.text = client.idNumber
        holder.birthdayTextView.text = client.birthday
        holder.contactInfoTextView.text = client.contactInfo
    }

    override fun getItemCount(): Int = clients.size

    fun updateClients(newClients: List<Client>) {
        clients = newClients
        notifyDataSetChanged()
    }

    class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.client_name)
        val idNumberTextView: TextView = itemView.findViewById(R.id.client_id_number)
        val birthdayTextView: TextView = itemView.findViewById(R.id.client_birthday)
        val contactInfoTextView: TextView = itemView.findViewById(R.id.client_contact_info)
    }
}
