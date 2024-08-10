package com.example.happybirthday.service

import com.example.happybirthday.repository.ClientRepository
import android.content.Context
import com.example.happybirthday.repository.Client
import com.example.happybirthday.repository.ClientsRepository

class ClientService<ClientRepository> private constructor(private val repository: ClientRepository) {

    companion object {
        fun from(context: Context): ClientService<Any?> {
            val repository = ClientsRepository(context)
            return ClientService(repository)
        }
    }

    fun addClient(name: String, idNumber: String, birthday: String, contactInfo: String) {
        repository.insertClient(name, idNumber, birthday, contactInfo)
    }

    fun getClients(): List<Client> {
        return repository.getAllClients()
    }
}

// MockClientsRepository 需要实现 ClientRepository 接口或继承 ClientRepository
class MockClientsRepository : ClientRepository {
    override fun insertClient(name: String, idNumber: String, birthday: String, contactInfo: String) {
        // Mock 实现
    }

    override fun getAllClients(): List<Client> {
        // 返回模拟的客户端数据
        return listOf()
    }
}

// 使用
val context: Context = /* 你的上下文实例，例如 `this` 或 `getApplicationContext()` */
val clientService = ClientService.from(context)
val clients = clientService.getClients()

// 如果你在测试中，并且不需要 Context，你可以直接传递一个 Mock 的 ClientsRepository
val clientServiceForTest = ClientService(MockClientsRepository())
val testClients = clientServiceForTest.getClients()
