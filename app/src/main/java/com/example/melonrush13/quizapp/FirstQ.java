package com.example.melonrush13.quizapp;


import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;


public class FirstQ extends Fragment {

    private Button btn;
    private EditText et;
    private boolean q1correct;
    private String text;
    public FirstQ() {
        // Required empty public constructor
    }


    //provides layout for the fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        //inflate the layout for the fragment
        View myView = inflater.inflate(R.layout.fragment_first_q, container, false);
        btn = (Button) myView.findViewById(R.id.submitButton);
        et = (EditText) myView.findViewById(R.id.userInput);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text = et.getText().toString();
                        //is the text right?
                        if (text.equals("dog")) {
                            q1correct = true;
                        }
                        else {
                            q1correct = false;
                        }

                        getFragmentManager().beginTransaction().replace(R.id.fragment_container,new SecondQ().newInstance(q1correct)).commit();



                    }
                }
        );



        return myView;

        //fragTwo.setArguments(getIntent().getExtras());
        //fragmentTransaction.replace(R.id.fragment_container, fragTwo).commit();
    }
}
