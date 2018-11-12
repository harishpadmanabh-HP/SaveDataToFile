package com.hp.hp.savedatatofile;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;

public class MainActivity extends AppCompatActivity {
    String resultstring; EditText result;
    Context context;
//give permission from setting to the app for storqe
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         result = findViewById(R.id.result);


    }

    public void savedatatofile(View view) {

        try {
            resultstring = result.getText().toString();//getting data from edit text or textview tostring
            File path = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS);//specify file path .its now in downloads
            File myFile = new File(path, "mytextfile.txt");//file name
            FileOutputStream fOut = new FileOutputStream(myFile, true);//write file
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
          //  myOutWriter.append(resultstring);//append data to be stored in file this will append with the previous text
            myOutWriter.write(resultstring);//will delete previous and write new. use according to use
            myOutWriter.close();//close file
            fOut.close();

            Toast.makeText(this, "Text file Saved !", Toast.LENGTH_LONG).show();
        } catch (java.io.IOException e) {

            //do something if an IOException occurs.
            Toast.makeText(this, "Check permission ERROR - Text co added", Toast.LENGTH_LONG).show();
        }
    }
}
