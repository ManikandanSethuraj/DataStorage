package com.manikandansethuraj.datastorage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalStorageA extends AppCompatActivity {


    EditText userNameISA, passwordISA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userNameISA = (EditText) findViewById(R.id.usernameISAedit);
        passwordISA = (EditText) findViewById(R.id.passwordISAedit);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void saveISA (View view){

        String text1 = userNameISA.getText().toString();
        String text2 = passwordISA.getText().toString();

        text1 = text1 + " ";
        FileOutputStream fileOutputStream = null;
        File file = null;
        try {

            file = getFilesDir();
            fileOutputStream = openFileOutput("Mani.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text1.getBytes());
            fileOutputStream.write(text2.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this,"Saved Text Successfully"+file+"/Mani.txt",Toast.LENGTH_SHORT).show();
    }

    public void nextISA (View view){


        Toast.makeText(this,"Next Called",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, InternalStorageB.class);
        startActivity(intent);
    }

}
