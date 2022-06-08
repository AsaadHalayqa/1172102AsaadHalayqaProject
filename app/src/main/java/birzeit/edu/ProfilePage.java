package birzeit.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ProfilePage extends AppCompatActivity {
    EditText UFName;
    EditText ULName;
    TextView UEmail;
    EditText UPass;
    EditText Uphone;
    TextView gender;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        dataBaseHelper = new DataBaseHelper(ProfilePage.this);
        String sql = "SELECT * FROM CUSTOMER WHERE EMAIL LIKE '%" + MainActivity.mail + "%'";

        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        final Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();


        Button update = findViewById(R.id.update);
        UFName =  findViewById(R.id.UFname);
        ULName =  findViewById(R.id.ULname);
        UEmail =  findViewById(R.id.Pemail);
        UPass =  findViewById(R.id.Upass);
        Uphone =  findViewById(R.id.Uphone);
        gender =  findViewById(R.id.gen);

        UFName.setText(cursor.getString(1));
        ULName.setText(cursor.getString(2));
        UEmail.setText(cursor.getString(0));
        Uphone.setText(cursor.getString(4));
        gender.setText(cursor.getString(5));

        update.setOnClickListener(new View.OnClickListener() {
            Customer customer;
            @Override
            public void onClick(View view) {
                if (!(UPass.getText().toString()).isEmpty() || !(UFName.getText().toString()).isEmpty()
                        || !(ULName.getText().toString()).isEmpty() || !(Uphone.getText().toString()).isEmpty())
                {
                    customer = new Customer(UEmail.getText().toString(),UFName.getText().toString(),
                            ULName.getText().toString(),UPass.getText().toString(),Uphone.getText().toString(),gender.getText().toString());
                    dataBaseHelper.updateCustomer(customer);

                    Toast.makeText(ProfilePage.this, "profile updated successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ProfilePage.this,Home.class);
                    ProfilePage.this.startActivity(intent);

                }else if ((UPass.getText().toString()).isEmpty()) {
                    customer = new Customer(UEmail.getText().toString(),UFName.getText().toString(),
                            ULName.getText().toString(),cursor.getString(3),Uphone.getText().toString(),gender.getText().toString());
                    dataBaseHelper.updateCustomer(customer);
                    Toast.makeText(ProfilePage.this, "profile updated successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ProfilePage.this,Home.class);
                    ProfilePage.this.startActivity(intent);

                }

            }
        });

    }

}