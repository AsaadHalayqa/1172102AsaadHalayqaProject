package birzeit.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button ConnectButton;
    static  List<Car> carList;
    public   static  String mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectButton = (Button)findViewById(R.id.connectbutton);
        ConnectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectionAsyncTask connectionAsyncTask= new ConnectionAsyncTask(MainActivity.this);
                connectionAsyncTask.execute("https://firebasestorage.googleapis.com/v0/b/advance-proj1.appspot.com/o/data.json?alt=media&token=503ffc5e-9131-4572-ab9f-49910746c63f");
            }
        });

    }
    public void setButtonText(String text)
    {
        ConnectButton.setText(text);
    }

    public void fillCars(List<Car> cars)
    {
        if (cars.isEmpty())
        {
            Toast.makeText(MainActivity.this, "Error in connection !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,MainActivity.class);
            MainActivity.this.startActivity(intent);
            finish();
        }else
        {
            carList = cars;
            Intent intent = new Intent(MainActivity.this,Login.class);
            MainActivity.this.startActivity(intent);
            finish();
        }


    }
}