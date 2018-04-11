package com.example.rodneytressler.week2assessment;

import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements WelcomeFragment.WelcomeCallback {

    @BindView(R.id.input_email)
    protected EditText email;
    @BindView(R.id.input_name)
    protected EditText yourName;

    private List<Account> accountsList = new ArrayList<>();

    private WelcomeFragment fragment;

    public static final String REGISTRATION_DATA = "YOUR DATA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void toastRegistrationFailure() {
        Toast.makeText(this, "Please enter all fields first!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button_register)
    protected void onClickRegister() {
        String names = yourName.getText().toString();
        String myEmail = email.getText().toString();

        if (TextUtils.isEmpty(myEmail) || TextUtils.isEmpty(names)) {
            toastRegistrationFailure();
        } else {


            fragment = fragment.newInstance();
            fragment.attachView(this);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_holder, fragment).addToBackStack("add_questions").commit();

            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(REGISTRATION_DATA, (ArrayList<? extends Parcelable>) accountsList);
            fragment.setArguments(bundle);




        }
    }

    @Override
    public void welcomeTraveler(String hi) {
    }
}