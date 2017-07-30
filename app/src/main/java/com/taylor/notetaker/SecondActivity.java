package com.taylor.notetaker;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class SecondActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Checking that we are using the activity that has the layout
        // named fragment_container
        if (findViewById(R.id.fragment_container) != null){

            // Checks to see if this activity is brand new or being restored
            // from a previous state, It will prevent an overlapping fragment
            if(savedInstanceState != null){
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            ListViewFragment firstFragment = new ListViewFragment();


            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }
}
