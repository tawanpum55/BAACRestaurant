package appbaac.tawan.baacrestaurant;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    //Explicit
    private ImageView mokeyImageView;
    private AnimationDrawable objAnimationDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Show Animage
        mokeyImageView = (ImageView) findViewById(R.id.imvMonkey);
        mokeyImageView.setBackgroundResource(R.anim.monkey);
        objAnimationDrawable = (AnimationDrawable) mokeyImageView.getBackground();
        objAnimationDrawable.start();


        //Auto Thread
        Handler objHandler = new Handler();
        objHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        }, 8000);

        //Sound Effect
        MediaPlayer introPlayer = MediaPlayer.create(getBaseContext(), R.raw.intro_tata );
        introPlayer.start();

    }   // OnCreate


}   //Main Class
