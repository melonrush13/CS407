package com.example.melonrush13.quizapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;


public class SecondQ extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private Boolean mParam1;
    private Boolean q2correct;
    private Button btn;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private CheckBox cb5;
    private CheckBox cb6;
    private Button  quitButton;


    public static SecondQ newInstance(Boolean param1) {
        SecondQ fragment = new SecondQ();
        Bundle args = new Bundle();
        args.putBoolean(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public SecondQ() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getBoolean(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_second_q, container, false);
        btn = (Button) myView.findViewById(R.id.qTwoSubmit);
        cb1 = (CheckBox) myView.findViewById(R.id.goldenRetrieverBox);
        cb2 = (CheckBox) myView.findViewById(R.id.pugBox);
        cb3 = (CheckBox) myView.findViewById(R.id.dalmatianBox);
        cb4 = (CheckBox) myView.findViewById(R.id.poodleBox);
        cb5 = (CheckBox) myView.findViewById(R.id.chihuahuaBox);
        cb6 = (CheckBox) myView.findViewById(R.id.beagleBox);

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                        q2correct = cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked()
                                && !cb4.isChecked() && !cb5.isChecked() && !cb6.isChecked();
                        //pick message you want to announce
                        if (mParam1 == true && q2correct) {
                            builder.setMessage("You scored a 100%! Good job!");
                        }
                        if (mParam1 == true && !q2correct) {
                            builder.setMessage("You answered correctly to only Question #1");
                        }
                        if (mParam1 == false && q2correct) {
                            builder.setMessage("You answered correctly to only Question #2");
                        }
                        if (mParam1 == false && !q2correct) {
                            builder.setMessage("You did not answer any questions correctly.");
                        }

                            builder.setPositiveButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            getActivity().finish();
                                        }
                                    });
                            builder.setNegativeButton(getString(R.string.retry), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new FirstQ()).commit();

                                }
                            });
                        builder.show();
                    }


                }
        );
        return myView;
    }

}


