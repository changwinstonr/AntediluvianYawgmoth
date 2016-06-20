package badassapps.aaron.spindown;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Declare our variables
    Spinner mSpinner;
    ArrayAdapter<CharSequence> mSpinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fragment Mgr.
        FragmentManager fragmentManager = getFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentHolder);

        if (fragment == null) {
            fragment = new LifeCounterFragment();
            fragmentManager.beginTransaction().add(R.id.fragmentHolder, fragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        MenuItem item = menu.findItem(R.id.spinner);

        mSpinner = (Spinner) MenuItemCompat.getActionView(item);
        mSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.numberPlayer, android.R.layout.simple_spinner_item);
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mSpinnerAdapter);

        return true;
    }
}
