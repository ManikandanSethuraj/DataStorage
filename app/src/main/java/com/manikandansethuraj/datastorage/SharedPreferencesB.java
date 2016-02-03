package com.manikandansethuraj.datastorage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPreferencesB extends AppCompatActivity {

    TextView userNametextView, passwordTextView;
    public static final String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_b);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userNametextView = (TextView) findViewById(R.id.usernametext);
        passwordTextView = (TextView) findViewById(R.id.passowrdtext);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void load (View view) {

        android.content.SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
         String name = sharedPreferences.getString("Name", DEFAULT);
         String password = sharedPreferences.getString("Password", DEFAULT);

        if (name.equals(DEFAULT) || password.equals(DEFAULT)){

            Toast.makeText(this,"No Values are found", Toast.LENGTH_SHORT);
        }else {

            userNametextView.setText(name);
            passwordTextView.setText(password);
            Toast.makeText(this,"Shown data successfully",Toast.LENGTH_SHORT);
        }

    }


    public void previous(View view){

        android.content.SharedPreferences sharedPreferences = getSharedPreferences("MyData",Context.MODE_PRIVATE);

        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(this,"Previous",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, SharedPreferences.class);
        startActivity(intent);
    }

}
