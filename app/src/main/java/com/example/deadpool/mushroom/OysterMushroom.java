package com.example.deadpool.mushroom;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class OysterMushroom extends AppCompatActivity {

    CarouselView carouselView;

    int[] sampleImages = {R.drawable.oyster_1, R.drawable.oyster_2, R.drawable.oyster_3, R.drawable.oyster_4, R.drawable.oyster_5, R.drawable.oyster_6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyster_mushroom);

        ActionBar actionBar = getSupportActionBar();
        //get data from ListviewAdapter
        Intent intent = getIntent();
        String mActionBarTitle = intent.getStringExtra("actionBarTitle");
        //set Action bar
        actionBar.setTitle(mActionBarTitle);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
