package birzeit.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText firstname;
    EditText lastname;
    EditText email;
    EditText password;
    EditText confipass;
    EditText phoneN;
    Spinner spinnergender;
    Button signupB;

    String strFirst;
    String strLast;
    String strEmail;
    String strPass;
    String strConfPass;
    String strPhone;
    String strGender;

    char[] number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char [] capital= { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'G', 'J','K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    char [] small = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r','s', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char [] special = {'!','#','$','%','&','(',')','*','+',',','-','.','/',':',';','<','=','>','?','@','[',']','^',',','|','}','~'};
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstname = (EditText) findViewById(R.id.Fname);
        lastname = (EditText) findViewById(R.id.Lname);
        email = (EditText) findViewById(R.id.emailT);
        password = (EditText) findViewById(R.id.passT);
        confipass = (EditText) findViewById(R.id.conPassT);
        phoneN = (EditText) findViewById(R.id.phoneT);
        spinnergender = (Spinner) findViewById(R.id.spinner);

        signupB = (Button) findViewById(R.id.signup);

        String[] str = {"Male", "Female"};
        ArrayAdapter objGenderArr = new ArrayAdapter(SignUp.this,android.R.layout.simple_spinner_item,str);
        spinnergender.setAdapter(objGenderArr);


        signupB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flag=0;
                strFirst = firstname.getText().toString();
                strLast = lastname.getText().toString();
                strEmail = email.getText().toString();
                strPass = password.getText().toString();
                strConfPass = confipass.getText().toString();
                strPhone = phoneN.getText().toString();
                strGender = spinnergender.getSelectedItem().toString();
                int con1=0,con2=0,con3=0,con4=0;

                if(strFirst.isEmpty() || strEmail.isEmpty() || strLast.isEmpty() || strPass.isEmpty() ||
                        strConfPass.isEmpty() || strPhone.isEmpty() || strGender.isEmpty() ) {

                    Toast.makeText(SignUp.this, "Empty Field! Please fill all fields ", Toast.LENGTH_SHORT).show();
                    flag=1;
                    return;
                }
                if( !strFirst.isEmpty() && !strLast.isEmpty()) {
                    if(strFirst.length() < 2 ) {
                        Toast.makeText(SignUp.this, "First Name should be at least two characters! ", Toast.LENGTH_SHORT).show();
                        flag=1;
                        return;
                    }
                    if(strLast.length()< 2 ) {
                        Toast.makeText(SignUp.this, "Last Name should be at least two characters!", Toast.LENGTH_SHORT).show();
                        flag=1;
                        return;
                    }
                }
                if( !strPass.isEmpty() && !strConfPass.isEmpty() ){
                    if(strPass.length()<3) {
                        Toast.makeText(SignUp.this, "Password should be at least three characters!", Toast.LENGTH_SHORT).show();
                        flag=1;
                        return;
                    }
                    if (!strConfPass.equals(strPass)){
                        Toast.makeText(SignUp.this, "Password does not match!", Toast.LENGTH_SHORT).show();
                        flag=1;
                        return;
                    }
                    for(int i=0;i<strPass.trim().length();i++) {
                        for(int x=0;x<number.length;x++) {
                            if(strPass.charAt(i)==number[x]) {
                                con1=1;
                                Log.d("Asaad", "11111111111111");
                            }
                        }

                        for(int x=0;x<capital.length;x++) {
                            if(strPass.charAt(i)==capital[x]) {
                                con2=1;
                                Log.d("Asaad", "2222222222222");
                            }
                        }
                        for(int x=0;x<small.length;x++) {
                            if(strPass.charAt(i)==small[x]) {
                                con3=1;
                                Log.d("Asaad", "33333333333333");
                            }
                        }

                        for(int x=0;x<special.length;x++) {
                            if(strPass.charAt(i)==special[x]) {
                                con4=1;
                                Log.d("Asaad", "44444444444444");
                            }
                        }
                    }

                }
                if(con1!=1) {
                    Toast.makeText(SignUp.this, "Password should be have at least one Number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(con2!=1) {
                    Toast.makeText(SignUp.this, "Password should be have at least one Capital letter!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(con3!=1) {
                    Toast.makeText(SignUp.this, "Password should be have at least one Small letter! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(con4!=1) {
                    Toast.makeText(SignUp.this, "Password should be have at least one Special character! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (phoneN.length() != 10 || strPhone.charAt(0)!='0' || strPhone.charAt(1)!='5') {
                    flag = 1;
                    Toast.makeText(SignUp.this, "Phone no. should be 10-digits and starting with 05!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(flag==0 & con4==1 & con3==1 & con2==1 & con1==1 )
                {
                    Toast.makeText(SignUp.this, "Registration completed successfully", Toast.LENGTH_SHORT).show();

                    Customer customer= new Customer(strEmail,strFirst,strLast,strPass,strPhone,strGender);
                    DataBaseHelper dataBaseHelper = new DataBaseHelper(SignUp.this);
                    dataBaseHelper.addCustomer(customer);

                    Intent intent = new Intent(SignUp.this,Login.class);
                    SignUp.this.startActivity(intent);

                }

            }
        });


    }
}



















