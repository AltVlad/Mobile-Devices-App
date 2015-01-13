package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.parse.ParseAnalytics;
import com.parse.ParseObject;

/**
 * Created by AltVlad on 1/13/2015.
 */
public class RegisterActivity extends Activity {

    EditText user = (EditText) findViewById(R.id.UserR);
    EditText pass = (EditText) findViewById(R.id.UserRP);
    Button breg = (Button) findViewById(R.id.breg);
   Switch background= (Switch) findViewById(R.id.switch1);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

    public void register(View v){
        int Usernr=0;
        ParseObject UserN = new ParseObject("User");
        if(background.isChecked()){
         UserN.put("Background", 1);  //sets the background to dark
        }
        else {
            UserN.put("Background", 2);  //sets the backgroudn to light
        }

        UserN.put("Username",user);
        UserN.put("Password",pass);
        UserN.put("UserNumber",Usernr);
        Usernr++;
        UserN.saveInBackground();
    }
}