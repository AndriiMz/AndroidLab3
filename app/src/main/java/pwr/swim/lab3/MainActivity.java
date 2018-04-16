package pwr.swim.lab3;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Fragment1.OnWyborOpcjiListener {
    private static final String TAG_F11 = "Fragment11";
    private static final String TAG_F12 = "Fragment12";

    private boolean savedInstanceState;

    Fragment11 f11;
    Fragment12 f12;
    FragmentTransaction transakcja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            f11 = new Fragment11();
            f12 = new Fragment12();
            transakcja = getSupportFragmentManager().beginTransaction();
            transakcja.add(R.id.contener, f11, MainActivity.TAG_F11);
            transakcja.detach(f11);
            transakcja.add(R.id.contener, f12, MainActivity.TAG_F12);
            transakcja.detach(f12);
            transakcja.commit();
        } else {
            f11 = (Fragment11)getSupportFragmentManager().findFragmentByTag(MainActivity.TAG_F11);
            f12 = (Fragment12)getSupportFragmentManager().findFragmentByTag(MainActivity.TAG_F12);
        }

    }

    @Override
    public void onWyborOpcji(int opcja) {
        FragmentTransaction transakcja = getSupportFragmentManager().beginTransaction();
        switch (opcja) {
            case 1:
                transakcja.detach(f12);
                transakcja.attach(f11);
                break;
            case 2:
                transakcja.detach(f11);
                transakcja.attach(f12);
                break;
            default:
                break;
        }
        transakcja.commit();
    }

    public void openAct2(View view) {
        final Intent intencja = new Intent(this, Activity2.class);
        startActivity(intencja);
    }
}
