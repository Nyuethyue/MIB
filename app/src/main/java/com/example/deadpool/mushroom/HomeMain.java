package com.example.deadpool.mushroom;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class HomeMain extends AppCompatActivity implements OnClickListener{

    private CardView ediableM, non_ediableM, ed_preM, home_madeM, factsM;

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting non-rotatable only portrait mode only
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //setting logo icon in action Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_android_black_24dp);


        //Defining Cards
        ediableM = (CardView) findViewById(R.id.ediable);
        non_ediableM = (CardView) findViewById(R.id.non_ediable);
        ed_preM = (CardView) findViewById(R.id.ediable_pre);
        home_madeM = (CardView) findViewById(R.id.home_made);
        factsM = (CardView) findViewById(R.id.facts);
        //add Click Listener to the cards
        ediableM.setOnClickListener(this);
        non_ediableM.setOnClickListener(this);
        ed_preM.setOnClickListener(this);
        home_madeM.setOnClickListener(this);
        factsM.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()){
            case R.id.ediable:
                intent = new Intent(this, Ediable.class);
                startActivity(intent);
                break;

            case R.id.non_ediable:
                intent = new Intent(this, OysterMushroom.class);
                startActivity(intent);
                break;

            case R.id.ediable_pre:
                intent = new Intent(this, AgaricusMushroom.class);
                startActivity(intent);
                break;

            case R.id.home_made:
                intent = new Intent(this, AgaricusMushroom.class);
                startActivity(intent);
                break;

            case R.id.facts:
                intent = new Intent(this, AgaricusMushroom.class);
                startActivity(intent);
                break;
        }
    }

    //Exiting when double tapping or pressing twice to exit
    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else {
            backToast = Toast.makeText(getBaseContext(),"Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}
