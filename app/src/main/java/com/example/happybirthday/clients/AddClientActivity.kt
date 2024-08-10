package com.happybirthday.clients

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.happybirthday.R

class AddClientActivity : AppCompatActivity() {

    private lateinit var clientService: ClientService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_client)

        val dbHelper = DatabaseHelper(this)
        val repository = ClientRepository(dbHelper)
        clientService = ClientService(repository)

        val nameEditText: EditText = findViewById(R.id.editTextName)
        val idNumberEditText: EditText = findViewById(R.id.editTextIdNumber)
        val birthdayEditText: EditText = findViewById(R.id.editTextBirthday)
        val contactInfoEditText: EditText = findViewById(R.id.editTextContactInfo)

        val saveButton: Button = findViewById(R.id.buttonSave)
        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val idNumber = idNumberEditText.text.toString()
            val birthday = birthdayEditText.text.toString()
            val contactInfo = contactInfoEditText.text.toString()

            clientService.addClient(name, idNumber, birthday, contactInfo)
            finish() // 返回上一页
        }
    }
}
