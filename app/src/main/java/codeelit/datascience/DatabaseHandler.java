package codeelit.datascience;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
// Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "dataManager";

    //  table name
    private static final String TABLE_DATA = "data";

    //  Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_IMG_URL = "ImgFavourite";
    private static final String KEY_IS_FAVOURITE = "IsFavourite";

    public DatabaseHandler(Context context) {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_DATA + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_IMG_URL + " TEXT,"
                + KEY_IS_FAVOURITE + " INTEGER" + ")";
        db.execSQL( CREATE_TABLE );
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_DATA );

        // Create tables again
        onCreate( db );
    }


    // Adding new data
    public void addData(int KEY_ID,String KEY_IMG_URL, int KEY_IS_FAVOURITE) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( this.KEY_IMG_URL,KEY_IMG_URL  );
        values.put( this.KEY_IS_FAVOURITE,KEY_IS_FAVOURITE  );

        // Inserting Row
        db.insert( TABLE_DATA, null, values );
        db.close(); // Closing database connection
    }

}