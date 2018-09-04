package com.b4_downstairs.akash_madhu.navigationdrawe1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.Button;

public class conactUSS extends AppCompatActivity {


    Button revieww, emaill, more_aaps, feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conact_uss);


        revieww = findViewById(R.id.reivew_btn);
        emaill = findViewById(R.id.email_btn);


        revieww.setText(Html.fromHtml("<big>" + "Write a review..." + "</big>" + "<br />" +
                "<small>" + "Do write . We want your feedback!" + "</small>" + "<br />"));

        emaill.setText(Html.fromHtml("<big>" + "Contact us via Email" + "</big>" + "<br />" +
                "<small>" + "We'll shoot back within 24 hours" + "</small>" + "<br />"));


    }
}
