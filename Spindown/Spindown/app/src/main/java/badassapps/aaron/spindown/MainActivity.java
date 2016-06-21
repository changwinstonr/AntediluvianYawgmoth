package badassapps.aaron.spindown;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Declare our variables
    Spinner mSpinner;
    ArrayAdapter<CharSequence> mSpinnerAdapter;
    FragmentManager fragmentManager;
    Fragment fragment, fragmentTwo, fragmentThree, fragmentFour;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Create our  menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate our spinner
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        MenuItem item = menu.findItem(R.id.spinner);

        mSpinner = (Spinner) MenuItemCompat.getActionView(item);
        mSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.numberPlayer, android.R.layout.simple_spinner_item);
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mSpinnerAdapter);
        mSpinner.setOnItemSelectedListener(this);

        return true;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        fragmentManager = getFragmentManager();
        fragment = fragmentManager.findFragmentById(R.id.fragmentHolder);
        linearLayout = (LinearLayout) findViewById(R.id.life_counter);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linearLayout
                .getLayoutParams();
        switch(position){
            case 0:
                //Fragment Mgr.
                if (fragment == null) {
                    fragment = new LifeCounterFragment();
                    fragmentManager.beginTransaction().add(R.id.fragmentHolder, fragment).commit();
                }

                Toast.makeText(MainActivity.this, "One Player", Toast.LENGTH_SHORT).show();

                break;
            case 1:
                fragmentTwo = new LifeCounterFragment();
                params.weight = 3.0f;
                linearLayout.setLayoutParams(params);
                fragmentManager.beginTransaction().add(R.id.fragmentHolder,fragmentTwo).commit();

                Toast.makeText(MainActivity.this, "Two Players", Toast.LENGTH_SHORT).show();
                break;

            case 2:

                Toast.makeText(MainActivity.this, "Three Players", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this, "Four Players", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(MainActivity.this, "No Players..?", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
