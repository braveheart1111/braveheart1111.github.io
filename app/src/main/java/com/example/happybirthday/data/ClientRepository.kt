import com.example.happybirthday.data.DatabaseHelper
import com.example.happybirthday.repository.Client

class ClientRepository(private val dbHelper: DatabaseHelper) {

    fun getAllClients(): List<Client> {
        val db = dbHelper.readableDatabase
        val cursor = db.query("clients", null, null, null, null, null, null)
        val clients = mutableListOf<Client>()

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val idNumber = cursor.getString(cursor.getColumnIndexOrThrow("id_number"))
            val birthday = cursor.getString(cursor.getColumnIndexOrThrow("birthday"))
            val contactInfo = cursor.getString(cursor.getColumnIndexOrThrow("contact_info"))
            clients.add(Client(id, name, idNumber, birthday, contactInfo))
        }
        cursor.close()
        return clients
    }

    fun insertClient(name: String, idNumber: String, birthday: String, contactInfo: String) {

    }
}
