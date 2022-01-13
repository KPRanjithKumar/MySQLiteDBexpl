package ran.am.mysqlitedbexpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHplr extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;
    public DbHplr(Context context) {
        super(context, "details.db", null, 1);
        sqLiteDatabase=getWritableDatabase();
        // db name , db version number
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /// query for creating table
        db.execSQL("create table students (Name text, Location text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void savedataa(String name, String loc){

        ContentValues cv = new ContentValues();
        cv.put("Name",name);
        cv.put("Location",loc);

        sqLiteDatabase.insert("students",null,cv);

    }

    public String retrvloc(String sna2) {

        Cursor c;
        c= sqLiteDatabase.query("students",null,"Name=?",new String[]{sna2},
                null,null,null);

        c.moveToFirst();

        if(c.getCount()<1){
            return "not exist";
        }

        String v= c.getString(c.getColumnIndex("Location"));

        return v;
    }
}
