package com.b4_downstairs.akash_madhu.navigationdrawe1;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    public int[] slide_images = {

            R.drawable.welcome_1,
            R.drawable.why_1,
            R.drawable.benfits_1

    };
    public String[] slide_heading = {
            "Welcome",
            "Why...",
            "Benefits"
    };
    public String[] slide_desrp = {

            "B4 Bunk monitors your daily attendance and provides detailed report\n" +
                    "\n" +
                    "Honestly, it’s a Bunk Planner!",

            "- Simplified User Interface\n" +
                    "- Accurate data analysis\n" +
                    "- Great user experience\n" +
                    "- Just click and Intercept!",

            "For Employee & Students\n" +
                    "Track attendance accurately\n" +
                    "Highly Useful\n" +
                    "Simple and Interactive"
    };
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {

        return slide_heading.length;

    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideimagesview = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideheading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slidedesp = (TextView) view.findViewById(R.id.slide_desrp);

        slideimagesview.setImageResource(slide_images[position]);
        slideheading.setText(slide_heading[position]);
        slidedesp.setText(slide_desrp[position]);

        container.addView(view);


        return view;

    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout) object);
    }


}
