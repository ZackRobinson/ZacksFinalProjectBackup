package com.zackeryrobinson.finalprojecttest;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements PayFragment.OnFragmentInteractionListener, BenefitsFragment.OnFragmentInteractionListener, TrainingFragment.OnFragmentInteractionListener, MarketingFragment.OnFragmentInteractionListener{


    private AccountFragment frag;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_account:

                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new AccountFragment(), "frag").commit();
                    return true;
                case R.id.navigation_pay:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new PayFragment(), "frag").commit();



                    return true;
                case R.id.navigation_benefits:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new BenefitsFragment(), "frag").commit();

                    return true;
                case R.id.navigation_training:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new TrainingFragment(), "frag").commit();

                    return true;
                case R.id.navigation_marketing:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new MarketingFragment(), "frag").commit();

                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        frag = new AccountFragment();

        fragmentTransaction.replace(R.id.content, frag).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
