package com.b4_downstairs.akash_madhu.navigationdrawe1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;

public class about_us extends AppCompatActivity {


    Button version, website, more_aaps, feedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        version = findViewById(R.id.btn_Version);
        more_aaps = findViewById(R.id.more_app);
        feedback = findViewById(R.id.feedback);
        website = findViewById(R.id.website);


        version.setText(Html.fromHtml("<big>" + "Version" + "</big>" + "<br />" +
                "<small>" + "Version 1.01(Market)" + "</small>" + "<br />"));

        more_aaps.setText(Html.fromHtml("<big>" + "More apps" + "</big>" + "<br />" +
                "<small>" + "More apps" + "</small>" + "<br />"));

        feedback.setText(Html.fromHtml("<big>" + "Feedback" + "</big>" + "<br />" +
                "<small>" + "Give your feedaback on play store" + "</small>" + "<br />"));

        website.setText(Html.fromHtml("<big>" + "Official Website" + "</big>" + "<br />" +
                "<small>" + "www.OrdinaryOutstander.com" + "</small>" + "<br />"));

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://ordinaryoutstander.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

}
