package com.example.happybirthday.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "clients.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        // 创建数据库表
        val CREATE_CLIENTS_TABLE = ("CREATE TABLE clients (id INTEGER PRIMARY KEY, name TEXT, id_number TEXT, birthday TEXT, contact_info TEXT)")
        db.execSQL(CREATE_CLIENTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // 更新数据库表逻辑
        db.execSQL("DROP TABLE IF EXISTS clients")
        onCreate(db)
    }
}
