package birzeit.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private Button signIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button createAcc = findViewById(R.id.create);

        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,SignUp.class);
                Login.this.startActivity(intent);
            }
        });

        Email = findViewById(R.id.emailText);
        Password = findViewById(R.id.TextPassword);
        signIn = findViewById(R.id.signin);

        final CheckBox checkBox = findViewById(R.id.remmber);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){

                    SharedPreferences set1 = PreferenceManager.getDefaultSharedPreferences(Login.this);
                    SharedPreferences.Editor editorq = set1.edit();
                    editorq.putString("ISCHECK", "1");
                    editorq.commit();

                    SharedPreferences set2 = PreferenceManager.getDefaultSharedPreferences(Login.this);
                    SharedPreferences.Editor editor = set2.edit();
                    editor.putString("email", String.valueOf(Email.getText()));
                    editor.commit();

                    SharedPreferences set3 = PreferenceManager.getDefaultSharedPreferences(Login.this);
                    SharedPreferences.Editor editors = set3.edit();
                    editors.putString("password", String.valueOf(Password.getText()));
                    editors.commit();
                }else {
                    SharedPreferences set4 = PreferenceManager.getDefaultSharedPreferences(Login.this);
                    SharedPreferences.Editor editorq = set4.edit();
                    editorq.putString("ISCHECK", "0");
                    editorq.commit();
                }
            }
        });

        SharedPreferences set5 = PreferenceManager.getDefaultSharedPreferences(Login.this);
        String ISCHECK = set5.getString("ISCHECK", "0");
        if (ISCHECK.equals("1")){

            SharedPreferences set6 = PreferenceManager.getDefaultSharedPreferences(Login.this);
            String email = set6.getString("email", "0");

            SharedPreferences set7 = PreferenceManager.getDefaultSharedPreferences(Login.this);
            String password = set7.getString("password", "0");

            Email.setText(email);
            Password.setText(password);
            checkBox.setChecked(true);
        }

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                Cursor cursor = dataBaseHelper.getAllCustomers();

                if(Email.getText().toString().isEmpty() || Password.getText().toString().isEmpty()) {
                    Toast.makeText(Login.this, "Empty Field! Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!(Email.getText().toString().isEmpty())){
                    if(!(Password.getText().toString().isEmpty())) {
                        validCustomer(String.valueOf(Email.getText()), String.valueOf(Password.getText()));
                    }
                }
            }
        });
    }

    private void validCustomer(String userName, String userPassword){

        DataBaseHelper dbh = new DataBaseHelper(Login.this);
        Customer customer = new Customer(userName.trim(),"","",userPassword.trim(),"","");
        Cursor  temp   =   dbh.getCustomer(customer);

        if(temp!=null){
            android.util.Log.d("Result",cursor2String(temp));

            String string = cursor2String(temp);
            String[] array= string.split(",");
            if(userName.equalsIgnoreCase(array[0])&& userPassword.equalsIgnoreCase(array[3]))
            {
                MainActivity.mail=userName;

                Intent intent = new Intent(Login.this,Home.class);
                Login.this.startActivity(intent);
                Login.this.finish();
            }
            else {
                Toast.makeText(Login.this, "Enter Correct the email/password !", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    public String cursor2String(Cursor cursor){
        String strCursor = "";
        if (cursor.moveToFirst() ){
            String[] columnNames = cursor.getColumnNames();

            for (String name: columnNames) {
                strCursor += String.format("%s,", cursor.getString(cursor.getColumnIndex(name)));
            }
        }
        return strCursor;
    }
}