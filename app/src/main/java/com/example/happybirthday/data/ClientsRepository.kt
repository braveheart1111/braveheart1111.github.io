package com.example.happybirthday.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.happybirthday.ClientsDatabaseHelper

class ClientsRepository(context: Context) {
    private val dbHelper = ClientsDatabaseHelper(context)

    fun insertClient(name: String, idNumber: String, birthday: String, contactInfo: String): Long {
        val db = dbHelper.writableDatabase
        val contentValues = ContentValues().apply {
            put("name", name)
            put("id_number", idNumber)
            put("birthday", birthday)
            put("contact_info", contactInfo)
        }
        val result = db.insert("clients", null, contentValues)
        db.close()
        return result
    }

    fun getAllClients(): List<Client> {
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            "clients",
            arrayOf("id", "name", "id_number", "birthday", "contact_info"),
            null, null, null, null, null
        )

        val clients = mutableListOf<Client>()
        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow("id"))
                val name = getString(getColumnIndexOrThrow("name"))
                val idNumber = getString(getColumnIndexOrThrow("id_number"))
                val birthday = getString(getColumnIndexOrThrow("birthday"))
                val contactInfo = getString(getColumnIndexOrThrow("contact_info"))
                clients.add(Client(id, name, idNumber, birthday, contactInfo))
            }
        }
        cursor.close()
        db.close()
        return clients
    }
}

data class Client(val id: Int, val name: String, val idNumber: String, val birthday: String, val contactInfo: String)
