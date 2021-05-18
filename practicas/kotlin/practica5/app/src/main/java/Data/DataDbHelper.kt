package Data

import Models.User
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataDbHelper (context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    private val db: SQLiteDatabase
    private val values: ContentValues

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "Users"
    }

    init {
        db = this.writableDatabase
        values = ContentValues()
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE "+Tables.Users.TABLE_NAME+" ("+
            Tables.Users._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT," +
            Tables.Users.USUARIO + " TEXT NOT NULL," +
            Tables.Users.PASSWORD + "TEXT NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insert(user: List<User>){
        values.put(Tables.Users.USUARIO, user[0].getUsuario())
        values.put(Tables.Users.PASSWORD, user[0].getPassword())
        db.insert(Tables.Users.TABLE_NAME, null, values)
    }

    fun getData(): MutableList<User>{
        Tables.Users.users.clear()
        val columnas = arrayOf(Tables.Users._ID, Tables.Users.USUARIO,Tables.Users.PASSWORD)
        val c = db.query(Tables.Users.TABLE_NAME, columnas, null, null, null, null, null)
        if(c.moveToFirst()){
            do {
                Tables.Users.users.add(User(c.getInt(0), c.getString(1), c.getString(2)))
            } while (c.moveToNext())
        }
        return Tables.Users.users
    }

}