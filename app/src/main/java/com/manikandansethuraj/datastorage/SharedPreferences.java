package com.manikandansethuraj.datastorage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreferences extends AppCompatActivity {

    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        username = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void save (View view){

        android.content.SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Name",username.getText().toString());
        editor.putString("Password",password.getText().toString());

        editor.commit();


        Toast.makeText(this,"Data was saved successfully",Toast.LENGTH_LONG).show();
    }

    public void next(View view){


        Toast.makeText(this,"Next",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,SharedPreferencesB.class);
        startActivity(intent);

    }

}
