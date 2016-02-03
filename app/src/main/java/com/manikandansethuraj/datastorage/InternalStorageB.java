package com.manikandansethuraj.datastorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InternalStorageB extends AppCompatActivity {

    EditText usernameISB, passwordISB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage_b);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        usernameISB = (EditText) findViewById(R.id.usernameISBeditText);
        passwordISB = (EditText) findViewById(R.id.passwordISBeditText);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void loadISB (View view){

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = openFileInput("Mani.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read= fileInputStream.read()) != -1){

                buffer.append((char)read);
            }
            String text1 = buffer.substring(0,buffer.indexOf(" "));
            String text2 = buffer.substring(buffer.indexOf(" ")+1);

            usernameISB.setText(text1);
            passwordISB.setText(text2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this,"Loaded Successfully",Toast.LENGTH_SHORT);
    }

    public void previousISB (View view) {

        Toast.makeText(this,"Previous Called",Toast.LENGTH_SHORT);
        Intent intent = new Intent(this,InternalStorageA.class);
        startActivity(intent);

    }

}
