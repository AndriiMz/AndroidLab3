package pwr.swim.lab3;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity implements ActionBar.TabListener {

    Fragment11 f11;
    Fragment12 f12;
    FragmentTransaction transakcja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        f11 = new Fragment11();
        f12 = new Fragment12();
        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.kontener2, f11);
        transakcja.detach(f11);
        transakcja.add(R.id.kontener2, f12);
        transakcja.detach(f12);
        transakcja.commit();


        ActionBar aBar = getSupportActionBar();
        aBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab;
        tab = aBar.newTab();
        tab.setText("Opcja 1");
        tab.setTabListener(this);
        aBar.addTab(tab);
        tab = aBar.newTab();
        tab.setText("Opcja 2");
        tab.setTabListener(this);
        aBar.addTab(tab);

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        FragmentTransaction transakcja = getSupportFragmentManager().beginTransaction();
        switch (tab.getPosition()) {
            case 0:
                transakcja.attach(f11);
                break;
            case 1:
                transakcja.attach(f12);
                break;
            default:
                break;
        }
        transakcja.commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        FragmentTransaction transakcja = getSupportFragmentManager().beginTransaction();
        switch (tab.getPosition()) {
            case 0:
                transakcja.detach(f11);
                break;
            case 1:
                transakcja.detach(f12);
                break;
            default:
                break;
        }
        transakcja.commit();
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
