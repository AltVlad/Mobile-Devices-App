package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;

public class ParseStarterProjectActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ParseAnalytics.trackAppOpenedInBackground(getIntent());

    }

    EditText userLogin = (EditText) findViewById(R.id.editText);
    EditText passLogn = (EditText) findViewById(R.id.editText2);
    Button blog = (Button) findViewById(R.id.button);
    Button breg = (Button) findViewById(R.id.breg);
    Button background= (Button) findViewById(R.id.switch1);

    public void registerForm(View v){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    public void login(View v){
        final Intent h = new Intent(this, Homepage.class);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("UserN");
        query.whereEqualTo("Username",userLogin);
        query.whereEqualTo("Password",passLogn);
        query.getFirstInBackground(new GetCallback<ParseObject>() {

            public void done(ParseObject LogedUser, com.parse.ParseException e) {
                if (LogedUser == null) {
                    Log.d("score", "The getFirst request failed.");
                } else {

                    startActivity(h);
                    Log.d("score", "Retrieved the object.");

                }
            }


        });



    }
}

