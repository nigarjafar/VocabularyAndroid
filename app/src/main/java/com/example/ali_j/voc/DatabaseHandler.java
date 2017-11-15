package com.example.ali_j.voc;


/**
 * Created by ali_j on 15.11.2017.
 */

        import android.content.ClipData;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;

/**
 * Created by student on 11/10/2017.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "vocabulary";

    // Contacts table name
    private static final String TABLE_VOCABULARY = "vocabulary";

    // Contacts Table Columns names
    private static final String WORD_AZ = "aze";
    private static final String WORD_ENG = "eng";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("error", "ilk");




    }

    public void create(){


            Log.e("error", "oncreare");
            SQLiteDatabase db = getWritableDatabase();

            String DELETE_VOCABULARY_TABLE ="DROP TABLE IF EXISTS "+TABLE_VOCABULARY;
            db.execSQL(DELETE_VOCABULARY_TABLE);

            String CREATE_VOCABULARY_TABLE =
                    "CREATE TABLE IF NOT EXISTS " + TABLE_VOCABULARY
                            + "("
                            + WORD_AZ + " TEXT," + WORD_ENG + " TEXT"
                            + ")";

            db.execSQL(CREATE_VOCABULARY_TABLE);

    }



    public void insert(String aze,String eng){
        Log.e("error", "insert");
        SQLiteDatabase db=getWritableDatabase();
        String INSERT_VOCABULARY="INSERT INTO "+TABLE_VOCABULARY+" VALUES('"+aze+"','"+eng+"')";
        db.execSQL(INSERT_VOCABULARY);
    }



    public StringBuilder readItem(String aze) {
        Log.e("log","read");
        SQLiteDatabase db=getWritableDatabase();
        Log.e("log","read2");
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_VOCABULARY+" WHERE "+WORD_AZ+" LIKE '"+aze+"'",null);
        Log.e("log",""+c.getCount());
        StringBuilder test=new StringBuilder();


        if (c != null ) {
            Log.e("error","if");
            if  (c.moveToFirst()) {
                Log.e("error","if 2");
                do {
                    Log.e("error","do");
                    String dir = c.getString(c.getColumnIndex("eng"));
                    test.append("" + dir);
                }while (c.moveToNext());
            }
        }

        return test;
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VOCABULARY);

        // Create tables again
        onCreate(db);
    }
}
