package com.taylor.notetaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Tnayr on 8/2/2016.
 */
public final class DatabaseContract extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notes.db";
    public static final String TABLE_NOTES = "Notes";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "_title";
    public static final String COLUMN_MESSAGE = "_message";

    public DatabaseContract(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NOTES + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_MESSAGE + " TEXT, " +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(sqLiteDatabase);
    }

    //Add a new row to the table
    public void addNote(Notes notes){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, notes.get_title());
        values.put(COLUMN_MESSAGE, notes.get_message());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NOTES, null, values);
        db.close();
    }

    //Delete a note from the database
    public void deleteNote(String noteName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NOTES + " WHERE " + COLUMN_TITLE + "=\"" + noteName + "\";" );
    }

}
