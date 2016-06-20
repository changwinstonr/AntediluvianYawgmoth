package badassapps.aaron.spindown;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentHolder);

        if (fragment == null) {
            fragment = new LifeCounterFragment();
            fragmentManager.beginTransaction().add(R.id.fragmentHolder, fragment).commit();
        }
    }
}
