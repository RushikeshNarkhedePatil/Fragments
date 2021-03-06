package com.rushikeshnarkhede.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener, FragmentB.FragmentBListener {
    private FragmentA fragmentA = new FragmentA();
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentB = new FragmentB();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a, fragmentA)
                .replace(R.id.container_b, fragmentB)
                .commit();
    }

    @Override
    public void onInputASent(CharSequence input) {
        fragmentB.updateEditText(input);
    }

    @Override
    public void onInputBSent(CharSequence input) {
        fragmentA.updateEditText(input);
    }
}