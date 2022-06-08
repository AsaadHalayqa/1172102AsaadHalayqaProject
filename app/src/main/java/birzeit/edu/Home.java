package birzeit.edu;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class Home extends AppCompatActivity  {
    Button button;
    LinearLayout linearLayout;
    List<Car> carList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        replaceFragment(0);

        carList = MainActivity.carList;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ImageView imageView1 = findViewById(R.id.imagemenu);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawer.openDrawer(GravityCompat.START);
            }
        });


        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                //replaceFragment2(0);

            }

            @Override
            public void onDrawerStateChanged(int newState) {

                InputMethodManager inputMethodManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

            }
        });

    }

    public void replaceFragment(Fragment fragment, String str) {

        getSupportFragmentManager()

                .beginTransaction()

                .replace(R.id.flContainerFragment, fragment,str)
                .commit();

        if (str.equals("0")){

            Log.d("Asaad", "1111111111111111");

        }else if (str.equals("1")){

            Log.d("Asaad", "222222222222222222222");

        }

    }

    public void replaceFragment(int pos) {
        Fragment fragment = null;
        String tag = null;

        switch (pos) {
            case 0:
                fragment = MenuFragment.newInstance();
                tag = "0";
                break;
        }
        replaceFragment(fragment,tag);
    }


}
