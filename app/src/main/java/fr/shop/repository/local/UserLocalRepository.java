package fr.shop.repository.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chendjou on 18/07/2017.
 */

public class UserLocalRepository extends SQLiteOpenHelper{

    String CREATE_TABLE_QUERY = "CREATE TABLE(" +
            "id INTEGER PRIMARYKEY " +
            "name       VARCHAR(255) " +
            "suname     VARCHAR(255) " +
            "email      VARCHAR(255) " +
            "password   VARCHAR(255) " +
            "image      VARCHAR(255) " +
            "gender     VARCHAR(255) " +
            ")";
    public UserLocalRepository(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
