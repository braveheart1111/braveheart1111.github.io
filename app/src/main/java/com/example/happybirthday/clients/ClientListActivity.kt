package com.example.happybirthday.clients

import ClientRepository
import com.example.happybirthday.data.DatabaseHelper
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthday.R
import com.example.happybirthday.service.ClientService
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.happybirthday.clients.ClientAdapter

class ClientAdapter {

}

class AddClientActivity {

}

class ClientListActivity : AppCompatActivity() {

    private lateinit var clientService: ClientService
    private lateinit var clientAdapter: ClientAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_list)

        val dbHelper = DatabaseHelper(this)
        val repository = ClientRepository(dbHelper)
        clientService = ClientService(repository)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        clientAdapter = ClientAdapter(clientService.getClients())
        recyclerView.adapter = clientAdapter

        val fab: FloatingActionButton = findViewById(R.id.fab_add_client)
        fab.setOnClickListener {
            startActivity(Intent(this, AddClientActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        clientAdapter.updateClients(clientService.getClients())
    }
}
