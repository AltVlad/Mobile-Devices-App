package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;

/**
 * Created by AltVlad on 1/13/2015.
 */
public class Homepage extends Activity {
    //ParseObject userLogged;
    EditText userLogin = (EditText) findViewById(R.id.editText);
    EditText passLogn = (EditText) findViewById(R.id.editText2);
    String ViewUsername;
    int back;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParseAnalytics.trackAppOpenedInBackground(getIntent());

        ParseQuery<ParseObject> query = ParseQuery.getQuery("UserN");
        query.whereEqualTo("Username",userLogin);
        query.whereEqualTo("Password",passLogn);
        query.getFirstInBackground(new GetCallback<ParseObject>() {

            public void done(ParseObject LogedUser, com.parse.ParseException e) {
                if (LogedUser == null) {
                    Log.d("score", "The getFirst request failed.");
                } else {

                    Log.d("score", "Retrieved the object.");
                   ViewUsername= LogedUser.getString("Username");
                    back=LogedUser.getInt("Background");

                }
            }


        });
        RelativeLayout homepage= new RelativeLayout(this);
        TextView wlcom= new TextView(this);
        wlcom.setText("Welcome");
        TextView username= new TextView(this);
        username.setText(ViewUsername);
        if ( back==1){
            homepage.setBackground((getResources().getDrawable(R.drawable.dark)));
        }
        else {
            homepage.setBackground((getResources().getDrawable(R.drawable.light)));
        }



    }
}
