package com.pmz.saintmalogame.activities;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.pmz.saintmalogame.R;
import com.pmz.saintmalogame.domain.dice.Die;
import com.pmz.saintmalogame.utils.DiceRoller;

import java.util.ArrayList;
import java.util.List;

public class NormalGameActivity extends AppCompatActivity {

    private Animation rotationAnimation;
    private ImageView dieOne;
    private ImageView dieTwo;
    private ImageView dieThree;
    private ImageView dieFour;
    private ImageView dieFive;
    private List<ImageView> allDiceImageViews;
    private DiceRoller diceRoller;
    private int currentPlayer;
    private TextView player1Name;
    private TextView player2Name;

    private ImageView rollBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo_game);
        hideNavigationBar();

        setupObjects();
        setupPlayers();
        setupButtons();
        setupDiceViews();
        highlightCurrentPlayer();
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

    private void setupPlayers() {
        currentPlayer = 1;     //assign 1 to player 1 and -1 to player 2
        player1Name = findViewById(R.id.player1name);
    }

    private void setupObjects() {
        diceRoller = new DiceRoller();
        allDiceImageViews = new ArrayList<>();
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

        allDiceImageViews.add(0, null);
        allDiceImageViews.add(1, dieOne);
        allDiceImageViews.add(2, dieTwo);
        allDiceImageViews.add(3, dieThree);
        allDiceImageViews.add(4, dieFour);
        allDiceImageViews.add(5, dieFive);

        for (int i = 1; i < 6; i++) {
            final int j = i;
            allDiceImageViews.get(i).setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    clickDie(j);
                }
            });
        }
    }

    private void clickDie(int dieNum){
        ImageView dieImageView = allDiceImageViews.get(dieNum);
        if(diceRoller.getAllDice().get(dieNum).isLocked()){
            diceRoller.unlockDie(dieNum);
            dieImageView.setBackgroundResource(0);
        } else {
            diceRoller.lockDie(dieNum);
            dieImageView.setBackgroundResource(R.drawable.buttonbackground2);
        }
    }

    private void rollDiceAfterRollingAnimation() {
        for (int i = 1; i < 6; i++) {
            Die die = diceRoller.getAllDice().get(i);
            ImageView dieView = allDiceImageViews.get(i);
            if(!die.isLocked()){
                applyAnimation(dieView);
            }
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rollDice();
            }
        }, 300);
    }

    private void rollDice(){
        diceRoller.rollAllUnlockedDice();
        changeDiceImages();
        changePlayersTurn();
        highlightCurrentPlayer();
    }

    private void changeDiceImages() {
        for (int i = 1; i < 6; i++) {
            changeDieImageView(allDiceImageViews.get(i),
                    diceRoller.getAllDice().get(i).getType().toString());
        }
    }

    private void changeDieImageView(ImageView imageView, String die) {
        imageView.setImageResource(getDrawableImageIdByName(
                die));
    }

    private void applyAnimation(ImageView dieView) {
        dieView.startAnimation(rotationAnimation);
    }

    private void changePlayersTurn() {
        currentPlayer *= -1;
    }

    private void highlightCurrentPlayer(){
        if(currentPlayer == 1) {
            player1Name.setBackgroundResource(R.drawable.buttonbackground);
            player1Name.setTextColor(Color.WHITE);
            player2Name.setBackgroundResource(0);
            player2Name.setTextColor(Color.BLACK);
        } else {
            player1Name.setBackgroundResource(0);
            player1Name.setTextColor(Color.BLACK);
            player2Name.setBackgroundResource(R.drawable.buttonbackground);
            player2Name.setTextColor(Color.WHITE);
        }
    }
}
