package com.example.register

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.lang.Exception

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){


    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME ="payapp.db"
        private const val TBL_USERS = "tbl_users"
        private const val ID = "id"
        private const val NAME = "name"
        private const val EMAIL = "email"

    }


    override fun onCreate(p0: SQLiteDatabase?) {
        val createTblUsers = ("CREATE TABLE" + TBL_USERS + "(" + ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"
                + EMAIL + " TEXT" + ")")
        p0?.execSQL(createTblUsers)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS $TBL_USERS")
        onCreate(p0)
    }

    fun insertUser(usr: UserModel): Long{

        Log.i("Register", "insertUser fun started")
        val db = this.writableDatabase
        Log.i("Register", "Debug One")
        val contentValues = ContentValues()
        contentValues.put(ID, usr.id)
        contentValues.put(NAME, usr.name)
        contentValues.put(EMAIL, usr.email)
        Log.i("Register", "Debug Two")
        val success = db.insert(TBL_USERS, null, contentValues)
        Log.i("Register", "Debug Three")
        db.close()
        return success
    }

    /* fun getAllUsers(): ArrayList<UserModel>{
        val usrList: ArrayList<UserModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TBL_USERS"
        val p0 = this.readableDatabase

        val cursor: Cursor?

        try{
            cursor = p0.rawQuery(selectQuery,null)
        }catch (e: Exception){
            e.printStackTrace()
            p0.execSQL(selectQuery)
            return ArrayList()

        }

        var id: Int
        var name: String
        var email: String

        if(cursor.moveToFirst()){
            do{
                id = cursor.getInt(cursor.getColumnIndex("id"))
                name = cursor.getString(cursor.getColumnIndex("name"))
                email = cursor.getString(cursor.getColumnIndex("email"))

                val usr = UserModel(id=id, name=name, email=email)
                usrList.add(usr)
            }while (cursor.moveToNext())

        }
        return usrList
    }*/
}

