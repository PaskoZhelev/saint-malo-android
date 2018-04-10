package com.pmz.saintmalogame;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.pmz.saintmalogame.utils.DiceRoller;

public class NormalGameActivity extends AppCompatActivity {

    private Animation rotationAnimation;
    private ImageView dieOne;
    private ImageView dieTwo;
    private ImageView dieThree;
    private ImageView dieFour;
    private ImageView dieFive;
    private DiceRoller diceRoller;

    private ImageView rollBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_game);
        hideNavigationBar();

        setupObjects();
        setupButtons();
        setupDiceViews();
    }



    @Override
    protected void onResume() {
        super.onResume();
        hideNavigationBar();
    }

    private void hideNavigationBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private int getDrawableImageIdByName(String resourceName){
        return getResources().getIdentifier(resourceName, "drawable", getPackageName());
    }

    private void setupObjects() {
        diceRoller = new DiceRoller();
    }

    private void setupButtons(){
        rollBtn = findViewById(R.id.rollBtn);

        rollBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                rollDiceAfterRollingAnimation();
            }
        });
    }

    private void setupDiceViews(){
        rotationAnimation = AnimationUtils.loadAnimation(
                NormalGameActivity.this,R.anim.rotateanimation);
        dieOne = findViewById(R.id.dieOne);
        dieTwo = findViewById(R.id.dieTwo);
        dieThree = findViewById(R.id.dieThree);
        dieFour = findViewById(R.id.dieFour);
        dieFive = findViewById(R.id.dieFive);

    }

    private void rollDiceAfterRollingAnimation() {
        applyAnimation(dieOne);
        applyAnimation(dieTwo);
        applyAnimation(dieThree);
        applyAnimation(dieFour);
        applyAnimation(dieFive);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rollDice();
            }
        }, 300);
    }

    private void rollDice(){
        diceRoller.rollDice();
        changeDiceImages();
    }

    private void changeDiceImages() {
        changeDieImageView(dieOne, diceRoller.getDieOne());
        changeDieImageView(dieTwo, diceRoller.getDieTwo());
        changeDieImageView(dieThree, diceRoller.getDieThree());
        changeDieImageView(dieFour, diceRoller.getDieFour());
        changeDieImageView(dieFive, diceRoller.getDieFive());

    }

    private void changeDieImageView(ImageView imageView, String die) {
        imageView.setImageResource(getDrawableImageIdByName(
                die));
    }

    private void applyAnimation(ImageView dieView) {
        dieView.startAnimation(rotationAnimation);
    }
}
