package be.fenego.android_spotshop.splash;


import android.content.Intent;

import android.app.Activity;

import android.os.Handler;

import android.os.Bundle;

import be.fenego.android_spotshop.R;
//import be.fenego.android_spotshop.home.HomeActivity;
import be.fenego.android_spotshop.menu.MenuActivity;


/**
 * Created by Thijs on 12/21/2016.
 */
@SuppressWarnings("DefaultFileTemplate")
public class SplashActivity extends Activity {

    /** Duur van splashscreen in ms **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    /** Functie die wordt aangeroepen wanneer de activity aangemaakt wordt */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //TODO: fix the screen before splash screen appears
        //https://www.bignerdranch.com/blog/splash-screens-the-right-way/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        startActivity(new Intent(this, MenuActivity.class));
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this,MenuActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
        super.onCreate(savedInstanceState);

    }
}