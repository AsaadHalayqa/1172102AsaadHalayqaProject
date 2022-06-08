package birzeit.edu;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class MenuFragment extends Fragment implements  NavigationView.OnNavigationItemSelectedListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";
    NavigationView navigationView;


    public static MenuFragment newInstance()
    {
        return  new MenuFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getContext(), R.layout.fragment_menu, null);
        navigationView = ( NavigationView) view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        return view;
    }


    public void replaceFragment(Fragment fragment, String tag) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flContainerFragment, fragment,tag)
                .commit();

    }
    public void replaceFragment(int pos) {
        Fragment fragment = null;
        String str = null;

        switch (pos) {
            case 0:
                fragment = MenuFragment.newInstance();
                str = "0";
                break;
            case 1:
                fragment = MenuFragment.newInstance();
                str = "1";
                break;
            case 2:
                fragment = MenuFragment.newInstance();
                str = "1";
                break;

        }
        replaceFragment(fragment,str);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();
        if (id == R.id.nav_home){
            Intent intent = new Intent(getContext(),Home.class);
            MenuFragment.this.startActivity(intent);
        }else if (id == R.id.nav_car){

        }else if (id == R.id.nav_reser){

        }else if (id == R.id.nav_favorits){

        }else if (id == R.id.nav_profile){
            Intent intent = new Intent(getContext(),ProfilePage.class);
            MenuFragment.this.startActivity(intent);
        }else if (id == R.id.nav_call){
            Intent intent = new Intent(getContext(),CallUs.class);
            getContext().startActivity(intent);
        }else if (id == R.id.nav_logOut){
            Intent intent = new Intent(getContext(),Login.class);
            MenuFragment.this.startActivity(intent);
        }
        return true;
    }
}