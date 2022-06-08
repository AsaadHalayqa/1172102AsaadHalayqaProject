package birzeit.edu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context) {

        super(context, "1172102AsaadHalayqa", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CUSTOMER(EMAIL TEXT PRIMARY KEY,FIRSTNAME TEXT, LASTNAME TEXT,PASSWORD TEXT,PHONE TEXT,GENDER TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addCustomer (Customer customer){
        ContentValues newValues = new ContentValues();
        newValues.put("EMAIL",customer.getEmail());
        newValues.put("FIRSTNAME",customer.getFirstName());
        newValues.put("LASTNAME",customer.getLastName());
        newValues.put("GENDER",customer.getGendar());
        newValues.put("PASSWORD",customer.getPassword());
        newValues.put("PHONE",customer.getPhoneNumber());

        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        sqLiteDatabase.insert("CUSTOMER",null,newValues);
    }

    public void updateCustomer(Customer customer){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE CUSTOMER " +
                "SET FIRSTNAME = '" + customer.getFirstName() + "', LASTNAME = '" + customer.getLastName() + "', PHONE = '"
                + customer.getPhoneNumber() + "', PASSWORD = '" + customer.getPassword() +
                "' WHERE EMAIL = '" + customer.getEmail()+ "'");

    }

    public Cursor getCustomer(Customer customer){
        String em = "select * from " + "CUSTOMER" + " where "+ "EMAIL" + " = '" + customer.getEmail() +"'";
        SQLiteDatabase sql = this.getReadableDatabase();
        Cursor cu = sql.rawQuery(em, null);
        return cu;
    }


    public Cursor getAllCustomers(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cu= sqLiteDatabase.rawQuery("SELECT * FROM CUSTOMER",null);
        return cu;
    }



}
