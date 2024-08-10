package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.happybirthday.service.ClientService
import com.example.happybirthday.ui.theme.HappybirthdayTheme

class MainActivity : ComponentActivity() {
    // 创建 ClientService 实例
    private lateinit var clientService: ClientService<Any?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 初始化 ClientService
        clientService = ClientService(repository = this)

        // 插入示例数据
        insertSampleClientData()

        // 查询并查看数据
        queryAndLogClientData()

        setContent {
            HappybirthdayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun insertSampleClientData() {
        // 通过 ClientService 插入示例数据
        clientService.addClient("John Doe", "123456789", "1980-01-01", "john@example.com")
    }

    private fun queryAndLogClientData() {
        // 通过 ClientService 查询客户数据
        val clients = clientService.getClients()
        clients.forEach { client ->
            // 使用日志输出客户数据
            println("Client: ${client.id}, Name: ${client.name}, ID Number: ${client.idNumber}, Birthday: ${client.birthday}, Contact Info: ${client.contactInfo}")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HappybirthdayTheme {
        Greeting("Android")
    }
}
