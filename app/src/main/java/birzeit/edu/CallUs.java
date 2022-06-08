package birzeit.edu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CallUs extends AppCompatActivity {
    Button call;
    Button email;
    Button map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_us);

        call = (Button) findViewById(R.id.call);
        map = (Button) findViewById(R.id.map);
        email = (Button) findViewById(R.id.emailr);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent newIntent = new Intent();
                        newIntent.setAction(Intent.ACTION_DIAL);
                        newIntent.setData(Uri.parse("tel:0599000000"));
                        startActivity(newIntent);

                    }
                });
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent();
                myIntent.setAction(Intent.ACTION_VIEW);
                myIntent.setData(Uri.parse("geo:19.076,72.8777"));
                startActivity(myIntent);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gmailIntent =new Intent();
                gmailIntent.setAction(Intent.ACTION_SENDTO);
                gmailIntent.setType("message/rfc822");
                gmailIntent.setData(Uri.parse("mailto:"));
                gmailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"CarDealer@cars.com"});
                gmailIntent.putExtra(Intent.EXTRA_SUBJECT,"My Subject");
                gmailIntent.putExtra(Intent.EXTRA_TEXT,"Content of the message");
                startActivity(gmailIntent);
            }
        });
    }

}