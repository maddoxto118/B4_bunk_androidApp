package com.b4_downstairs.akash_madhu.navigationdrawe1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Slide_show extends AppCompatActivity {


    private ViewPager mSlideviewpager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button mNext;
    private Button Mback;

    private int mcurrentPage;
    ViewPager.OnPageChangeListener viewListnerr = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicatior(i);

            mcurrentPage = i;
            if (i == 0) {
                mNext.setEnabled(true);
                Mback.setEnabled(false);
                Mback.setVisibility(View.INVISIBLE);

                mNext.setText("NEXT");
                Mback.setText("");

            } else if (i == mDots.length - 1) {
                mNext.setEnabled(true);
                Mback.setEnabled(true);
                Mback.setVisibility(View.VISIBLE);

                mNext.setText("Finish");
                mNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        SharedPreferences preff = getSharedPreferences("ActivityPREF1", Context.MODE_PRIVATE);
                        SharedPreferences.Editor ed = preff.edit();
                        ed.putBoolean("activity_executed1", true);
                        ed.commit();

                        Intent intent = new Intent(com.b4_downstairs.akash_madhu.navigationdrawe1.Slide_show.this,
                                com.b4_downstairs.akash_madhu.navigationdrawe1.GENDER.class);
                        startActivity(intent);
                        finish();
                    }
                });
                Mback.setText("Back");
            } else {

                mNext.setEnabled(true);
                Mback.setEnabled(true);
                Mback.setVisibility(View.VISIBLE);

                mNext.setText("NEXT");
                Mback.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show);

        SharedPreferences preff = getSharedPreferences("ActivityPREF1", Context.MODE_PRIVATE);
        if (preff.getBoolean("activity_executed1", false)) {
            Intent intent = new Intent(com.b4_downstairs.akash_madhu.navigationdrawe1.Slide_show.this,
                    com.b4_downstairs.akash_madhu.navigationdrawe1.GENDER.class);
            startActivity(intent);
            finish();
        } else {
            int trial = 1;
        }

        mSlideviewpager = findViewById(R.id.slideviewpager);
        mDotLayout = findViewById(R.id.dotslayout);

        mNext = (Button) findViewById(R.id.nextBtn);
        Mback = (Button) findViewById(R.id.prevBtn);


        sliderAdapter = new SliderAdapter(this);

        mSlideviewpager.setAdapter(sliderAdapter);


        addDotsIndicatior(0);
        mSlideviewpager.addOnPageChangeListener(viewListnerr);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideviewpager.setCurrentItem(mcurrentPage + 1);
            }
        });

        Mback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideviewpager.setCurrentItem(mcurrentPage - 1);
            }
        });


    }

    public void addDotsIndicatior(int position) {


        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colortransWhite));

            mDotLayout.addView(mDots[i]);


        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorwHITE));
        }

    }


//LAST LINE
}
