package com.pmz.saintmalogame.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pmz.saintmalogame.R;
import com.pmz.saintmalogame.domain.board.Space;
import com.pmz.saintmalogame.domain.dice.Die;
import com.pmz.saintmalogame.domain.player.Player;
import com.pmz.saintmalogame.engine.impl.SoloGameEngine;
import com.pmz.saintmalogame.enums.DieType;
import com.pmz.saintmalogame.enums.Resource;
import com.pmz.saintmalogame.enums.SpaceSymbol;
import com.pmz.saintmalogame.utils.ImageUtils;
import com.pmz.saintmalogame.utils.SelectedSymbolHandler;

import java.util.ArrayList;
import java.util.List;

import static com.pmz.saintmalogame.constants.SaintMaloConstants.ARCHITECT_1_HOUSE_POINTS_INCREASE;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.ARCHITECT_2_HOUSE_POINTS_INCREASE;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.ARCHITECT_3_HOUSE_POINTS_INCREASE;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.CITIZEN_POINTS;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.NOBLE_POINTS;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.PIRATES_IMAGES_LIST;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.SOLDIER_DEFENCE_INCREASE;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE;
import static com.pmz.saintmalogame.enums.DieType.CHURCH;
import static com.pmz.saintmalogame.enums.DieType.PERSON;
import static com.pmz.saintmalogame.enums.DieType.PIRATE;
import static com.pmz.saintmalogame.enums.DieType.TREE;
import static com.pmz.saintmalogame.enums.DieType.WALL;
import static com.pmz.saintmalogame.enums.Resource.COINS;
import static com.pmz.saintmalogame.enums.Resource.DEFENCE;
import static com.pmz.saintmalogame.enums.Resource.POINTS;
import static com.pmz.saintmalogame.enums.Resource.TREES;
import static com.pmz.saintmalogame.enums.SpaceSymbol.CHURCH_LVL_1;
import static com.pmz.saintmalogame.enums.SpaceSymbol.CHURCH_LVL_2;
import static com.pmz.saintmalogame.enums.SpaceSymbol.CHURCH_LVL_3;
import static com.pmz.saintmalogame.enums.SpaceSymbol.CHURCH_LVL_4;
import static com.pmz.saintmalogame.enums.SpaceSymbol.CHURCH_LVL_5;
import static com.pmz.saintmalogame.enums.SpaceSymbol.PERSON_ARCHITECT;
import static com.pmz.saintmalogame.enums.SpaceSymbol.PERSON_CITIZEN;
import static com.pmz.saintmalogame.enums.SpaceSymbol.PERSON_JUGGLER;
import static com.pmz.saintmalogame.enums.SpaceSymbol.PERSON_MERCHANT;
import static com.pmz.saintmalogame.enums.SpaceSymbol.PERSON_NOBLE;
import static com.pmz.saintmalogame.enums.SpaceSymbol.PERSON_PRIEST;
import static com.pmz.saintmalogame.enums.SpaceSymbol.PERSON_SOLDIER;

public class SoloGameActivity extends AppCompatActivity {

    private static final String EMPTY_SYMBOL = "emptysymbol";
    private static final String CITIZEN_SYMBOL = "citizensymbol";
    private static final String SOLDIER_SYMBOL = "soldiersymbol";
    private static final String ARCHITECT_SYMBOL = "architectsymbol";
    private static final String MERCHANT_SYMBOL = "merchantsymbol";
    private static final String PRIEST_SYMBOL = "priestsymbol";
    private static final String JUGGLER_SYMBOL = "jugglersymbol";
    private static final String NOBLE_SYMBOL = "noblesymbol";
    private static final String WALL_SYMBOL = "wallsymbol";
    private static final String HOUSE_SYMBOL = "housesymbol";
    private static final String DEFAULT_ROLL_BUTTON_NAME = "rollbtn3";
    private static final int ROLL_PIRATES_DELAY = 1650;



    private Animation rotationAnimation;
    private ImageView dieOne;
    private ImageView dieTwo;
    private ImageView dieThree;
    private ImageView dieFour;
    private ImageView dieFive;

    private List<ImageView> allDiceImageViews;
    private SoloGameEngine gameEngine;

    private TextView player1Name;
    private TextView playerPoints;
    private TextView playerCoins;
    private TextView playerTrees;
    private TextView playerDefence;
    private TextView playerCannonsDestroyed;
    private TextView currentTurn;

    private LinearLayout piratesLayout;

    private List<ImageView> allSpaceViews;

    private ImageView rollBtn;
    private ImageView endTurnBtn;

    private boolean fillForBonus;
    private String chosenBonusPersonSymbol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo_game);
        hideNavigationBar();

        setupObjects();
        setupButtons();
        setupDiceViews();
        setupSpaceView();
        makeAllSpacesUnclickable();
        updatePlayerStats();
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

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            this.getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    private int getDrawableImageIdByName(String resourceName) {
        return getResources().getIdentifier(resourceName, "drawable", getPackageName());
    }

    private void setupObjects() {
        gameEngine = new SoloGameEngine();
        allDiceImageViews = new ArrayList<>();
        allSpaceViews = new ArrayList<>();

        playerPoints = findViewById(R.id.playerPoints);
        playerCoins = findViewById(R.id.playerCoins);
        playerTrees = findViewById(R.id.playerTrees);
        playerDefence = findViewById(R.id.playerDefence);
        playerCannonsDestroyed = findViewById(R.id.playerCannonsDestroyed);
        currentTurn = findViewById(R.id.currentTurn);
        piratesLayout = findViewById(R.id.piratesLayout);
    }

    private void setupButtons() {
        rollBtn = findViewById(R.id.rollBtn);
        endTurnBtn = findViewById(R.id.endTurnBtn);

        rollBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                rollDiceAfterRollingAnimation();
            }
        });

        endTurnBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //prevent player to use dice from previous turn again
                if((gameEngine.getRemainingRolls() != 3) && (gameEngine.getAllLockedDice().size() != 0)) {
                    endTurnButtonClicked();
                }

            }
        });
    }

    private void setupSpaceView() {
        allSpaceViews.add(0, null);
        for (int i = 1; i < 46; i++) {
            final int j = i;
            String spaceId = "space" + j;
            int resID = getResources().getIdentifier(spaceId, "id", getPackageName());
            final ImageView spaceView = findViewById(resID);
            spaceView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SelectedSymbolHandler symbolHandler = gameEngine.getSymbolHandler();
                    String symbolName = symbolHandler.getSymbolName();

                    fillSpaceWithSymbol(j, spaceView, symbolName);

                    if (symbolHandler.getNumberOfSymbolsToBeWritten() == 0 && !fillForBonus) {
                        resetTurn();
                    }

                }
            });
            allSpaceViews.add(i, spaceView);
        }

        makeImageViewUnclickable(allSpaceViews.get(21));
        makeImageViewUnclickable(allSpaceViews.get(22));
        makeImageViewUnclickable(allSpaceViews.get(26));
        makeImageViewUnclickable(allSpaceViews.get(31));
    }

    private void setupDiceViews() {
        rotationAnimation = AnimationUtils.loadAnimation(
                SoloGameActivity.this, R.anim.rotateanimation);
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

    private void fillSpaceWithSymbol(int index, ImageView space, String symbolName) {
        if(fillForBonus) {
            space.setImageResource(getDrawableImageIdByName(
                    chosenBonusPersonSymbol));
            gameEngine.getBoard().fillSpace(index,
                    SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.get(chosenBonusPersonSymbol));
            fillForBonus = false;

            activateEffectOfPersonIfAvailable(index, chosenBonusPersonSymbol);
            updatePlayerStats();
        }
        else {
            if (!symbolName.equals(EMPTY_SYMBOL)) {
                space.setImageResource(getDrawableImageIdByName(
                        symbolName));
                gameEngine.getBoard().fillSpace(index,
                        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.get(symbolName));
            }
                activateEffectOfPersonIfAvailable(index, symbolName);

                gameEngine.getSymbolHandler().decreaseNumberOfSymbolsToBeWritten();
            }
    }

    private void activateEffectOfPersonIfAvailable(int index, String symbolName) {
            switch (symbolName) {
                case WALL_SYMBOL:
                    checkForBonusIfAvailable(index);
                    break;
                case CITIZEN_SYMBOL:
                    collectPointsFromCitizen();
                    break;
                case SOLDIER_SYMBOL:
                    increaseDefenceFromSoldier();
                    break;
                case PRIEST_SYMBOL:
                    collectPointsFromPriest(index);
                    break;
                case ARCHITECT_SYMBOL:
                    gameEngine.getSymbolHandler().setSymbolName(HOUSE_SYMBOL);
                    break;
                case MERCHANT_SYMBOL:
                    collectCoinsFromMerchant(index);
                    break;
                case JUGGLER_SYMBOL:
                    collectPointsFromJuggler(index);
                    break;
                case NOBLE_SYMBOL:
                    collectPointsFromNoble();
                    break;
            }
        }

    private void clickDie(int dieNum) {
        ImageView dieImageView = allDiceImageViews.get(dieNum);
        if (gameEngine.getDie(dieNum).isLocked()) {
            gameEngine.unlockDie(dieNum);
            dieImageView.setBackgroundResource(0);
        } else {
            gameEngine.lockDie(dieNum);
            dieImageView.setBackgroundResource(R.drawable.buttonbackground2);
        }
    }

    private void rollDiceAfterRollingAnimation() {
        for (int i = 1; i < 6; i++) {
            Die die = gameEngine.getDie(i);
            ImageView dieView = allDiceImageViews.get(i);
            if (!die.isLocked()) {
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

    private void rollDice() {
        gameEngine.rollDice();
        changeDiceImages();
        changeRollButtonImage();
        lockRollButtonIfNoMoreRolls();
    }

    private void endTurnButtonClicked() {
        List<Die> lockedDice = gameEngine.getAllLockedDice();
        DieType dieType = lockedDice.get(0).getType();
        if (gameEngine.hasDifferentLockedDice()) {
            activateDifferentLockedDice();
        } else if (lockedDice.size() == 1) {
            activateChangeOrFillDialog();
        } else if (dieType == TREE) {
            activateCollectDialog();
        } else if ((dieType == DieType.PERSON) && (lockedDice.size() == 2)) {
            activateTwoPersonDialog();
        } else if ((dieType == DieType.PERSON) && (lockedDice.size() == 3)) {
            activateThreePersonDialog();
        } else {
            activateFillDialog();
        }

    }

    private void activateTwoPersonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_two_person, null);
        ImageView person1 = (ImageView) view.findViewById(R.id.person1);
        ImageView person2 = (ImageView) view.findViewById(R.id.person2);


        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        //Soldier Clicked
        person1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameEngine.populateSymbolHandlerForPerson(PERSON_SOLDIER);
                makeAllUnfilledSpacesClickable();
                dialog.dismiss();
            }
        });

        //Priest Clicked
        person2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameEngine.populateSymbolHandlerForPerson(PERSON_PRIEST);
                makeAllUnfilledSpacesClickable();
                dialog.dismiss();
            }
        });
    }

    private void activateThreePersonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_three_person, null);
        ImageView person1 = (ImageView) view.findViewById(R.id.person1);
        ImageView person2 = (ImageView) view.findViewById(R.id.person2);


        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        //Architect Clicked
        person1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activateHouseSelectionForArchitectDialog();
                dialog.dismiss();
            }
        });
        //Merchant Clicked
        person2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameEngine.populateSymbolHandlerForPerson(PERSON_MERCHANT);
                makeAllUnfilledSpacesClickable();
                dialog.dismiss();
            }
        });
    }

    private void activateChangeOrFillDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_change_or_fill, null);
        ImageView fillBtn = (ImageView) view.findViewById(R.id.fillSpaceBtn1);
        ImageView changeDieBtn = (ImageView) view.findViewById(R.id.changeDieBtn);



        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        fillBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Die> lockedDice = gameEngine.getAllLockedDice();
                DieType dieType = lockedDice.get(0).getType();
                if(dieType == TREE) {
                    activateCollectDialog();
                    dialog.dismiss();
                } else if (dieType == WALL) {
                    gameEngine.populateSymbolHandler();
                    makeAllOuterUnfilledSpacesClickable();
                    dialog.dismiss();
                } else {
                    gameEngine.populateSymbolHandler();
                    makeAllUnfilledSpacesClickable();
                    dialog.dismiss();
                }
            }
        });
        changeDieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameEngine.getPlayer().getCoins() >= 2) {
                    activateChangeDieDialog();
                    dialog.dismiss();
                }
            }
        });
    }

    private void activateFillDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_fill, null);
        ImageView fillBtn = (ImageView) view.findViewById(R.id.fillSpaceBtn2);

        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        fillBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Die> lockedDice = gameEngine.getAllLockedDice();
                DieType dieType = lockedDice.get(0).getType();
                if (dieType == WALL) {
                    gameEngine.populateSymbolHandler();
                    makeAllOuterUnfilledSpacesClickable();
                    dialog.dismiss();
                } else {
                    gameEngine.populateSymbolHandler();
                    makeAllUnfilledSpacesClickable();
                    dialog.dismiss();
                }
            }
        });
    }

    private void activateCollectDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_collect, null);
        ImageView collectBtn = (ImageView) view.findViewById(R.id.collectBtn);

        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        collectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player player = gameEngine.getPlayer();
                if (player.getCoins() >= 2) {
                    player.increaseResource(
                            Resource.TREES,
                            gameEngine.getAllLockedDice().size());
                    player.decreaseResource(Resource.COINS, 2);
                    resetTurn();
                    dialog.dismiss();
                } else {
                    activateNotEnoughCoinsDialog();
                }
            }
        });
    }

    private void activateChangeDieDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_change_die, null);
        ImageView changeToChurch = (ImageView) view.findViewById(R.id.changeToChurch);
        ImageView changeToCrate = (ImageView) view.findViewById(R.id.changeToCrate);
        ImageView changeToPerson = (ImageView) view.findViewById(R.id.changeToPerson);
        ImageView changeToTree = (ImageView) view.findViewById(R.id.changeToTree);
        ImageView changeToWall = (ImageView) view.findViewById(R.id.changeToWall);

        final Die die = gameEngine.getAllLockedDice().get(0);

        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        changeToChurch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                die.setType(CHURCH);
                gameEngine.getPlayer().decreaseResource(COINS, 2);
                changeDiceImages();
                updatePlayerStats();
                dialog.dismiss();
            }
        });
        changeToCrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                die.setType(DieType.CRATE);
                gameEngine.getPlayer().decreaseResource(COINS, 2);
                changeDiceImages();
                updatePlayerStats();
                dialog.dismiss();
            }
        });
        changeToPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                die.setType(PERSON);
                gameEngine.getPlayer().decreaseResource(COINS, 2);
                changeDiceImages();
                updatePlayerStats();
                dialog.dismiss();
            }
        });
        changeToTree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                die.setType(TREE);
                gameEngine.getPlayer().decreaseResource(COINS, 2);
                changeDiceImages();
                updatePlayerStats();
                dialog.dismiss();
            }
        });
        changeToWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                die.setType(WALL);
                gameEngine.getPlayer().decreaseResource(COINS, 2);
                changeDiceImages();
                updatePlayerStats();
                dialog.dismiss();
            }
        });
    }

    private void activateChoosePersonForBonusDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_choose_person_bonus, null);
        ImageView choseCitizen = (ImageView) view.findViewById(R.id.choseCitizen);
        ImageView choseSoldier = (ImageView) view.findViewById(R.id.choseSoldier);
        ImageView chosePriest = (ImageView) view.findViewById(R.id.chosePriest);
        ImageView choseArchitect = (ImageView) view.findViewById(R.id.choseArchitect);
        ImageView choseMerchant = (ImageView) view.findViewById(R.id.choseMerchant);

        makeAllUnfilledSpacesClickable();
        fillForBonus = true;

        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        choseCitizen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenBonusPersonSymbol = CITIZEN_SYMBOL;
                dialog.dismiss();
            }
        });
        choseSoldier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenBonusPersonSymbol = SOLDIER_SYMBOL;
                dialog.dismiss();
            }
        });
        chosePriest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenBonusPersonSymbol = PRIEST_SYMBOL;
                dialog.dismiss();
            }
        });
        choseArchitect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenBonusPersonSymbol = ARCHITECT_SYMBOL;
                dialog.dismiss();
            }
        });
        choseMerchant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenBonusPersonSymbol = MERCHANT_SYMBOL;
                dialog.dismiss();
            }
        });
    }

    private void activateHouseSelectionForArchitectDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_houses, null);
        ImageView houses1 = (ImageView) view.findViewById(R.id.houses1);
        ImageView houses2 = (ImageView) view.findViewById(R.id.houses2);
        ImageView houses3 = (ImageView) view.findViewById(R.id.houses3);

        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        houses1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int houses = 1;
                if(gameEngine.getPlayer().getTrees() >= houses) {
                    gameEngine.getPlayer().decreaseResource(TREES, houses);
                    gameEngine.getPlayer().increaseResource(POINTS, ARCHITECT_1_HOUSE_POINTS_INCREASE);
                    gameEngine.populateSymbolHandlerForArchitect(houses);
                    makeAllUnfilledSpacesClickable();
                    dialog.dismiss();
                }
            }
        });
        houses2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int houses = 2;
                if(gameEngine.getPlayer().getTrees() >= houses) {
                    gameEngine.getPlayer().decreaseResource(TREES, houses);
                    gameEngine.getPlayer().increaseResource(POINTS, ARCHITECT_2_HOUSE_POINTS_INCREASE);
                    gameEngine.populateSymbolHandlerForArchitect(houses);
                    makeAllUnfilledSpacesClickable();
                    dialog.dismiss();
                }
            }
        });

        houses3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameEngine.getPlayer().getTrees() >= 3) {
                    int houses = 3;
                    if(gameEngine.getPlayer().getTrees() >= houses) {
                        gameEngine.getPlayer().decreaseResource(TREES, houses);
                        gameEngine.getPlayer().increaseResource(POINTS, ARCHITECT_3_HOUSE_POINTS_INCREASE);
                        gameEngine.populateSymbolHandlerForArchitect(houses);
                        makeAllUnfilledSpacesClickable();
                        dialog.dismiss();
                    }
                }
            }
        });
    }

    private void activateNotEnoughCoinsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_not_enough_coins, null);

        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void activateDifferentLockedDice() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_different_locked_dice, null);

        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void lockRollButtonIfNoMoreRolls() {
        if (gameEngine.getRemainingRolls() == 0) {
            makeImageViewUnclickable(rollBtn);
        }
    }

    private void unlockRollButton() {
        makeImageViewClickable(rollBtn);
        changeImageView(rollBtn, DEFAULT_ROLL_BUTTON_NAME);
    }

    private void changeDiceImages() {
        for (int i = 1; i < 6; i++) {
            changeImageView(allDiceImageViews.get(i),
                    gameEngine.getDieStringName(i));
        }
    }

    private void changeImageView(ImageView imageView, String name) {
        imageView.setImageResource(getDrawableImageIdByName(
                name));
    }

    private void makeAllSpacesUnclickable() {
        List<Space> allSpaces = gameEngine.getBoard().getAllSpaces();
        for (Space space : allSpaces) {
            if (space != null) {
                makeImageViewUnclickable(allSpaceViews.get(space.getId()));
            }
        }
    }

    private void makeAllUnfilledSpacesClickable() {
        List<Space> allSpaces = gameEngine.getBoard().getAllSpaces();
        for (Space space : allSpaces) {
            if ((space != null) && (space.isEmpty())) {
                makeImageViewClickable(allSpaceViews.get(space.getId()));
            }
        }
    }

    private void makeAllOuterUnfilledSpacesClickable() {
        List<Space> outerSpaces = gameEngine.getBoard().getOuterSpaces();
        for (Space space : outerSpaces) {
            if (space != null && space.isEmpty()) {
                makeImageViewClickable(allSpaceViews.get(space.getId()));
            }
        }
    }

    private void makeImageViewClickable(ImageView imageView) {
        imageView.setClickable(true);
    }

    private void makeImageViewUnclickable(ImageView imageView) {
        imageView.setClickable(false);
    }

    private void applyAnimation(ImageView dieView) {
        dieView.startAnimation(rotationAnimation);
    }

    private void changeRollButtonImage() {
        String rollImage = ImageUtils.getRollButtonImageName(
                gameEngine.getRemainingRolls());
        changeImageView(rollBtn, rollImage);
    }

    private void resetTurn() {
        makeAllSpacesUnclickable();
        resetLockedDice();
        checkAndMarkPirates();
        updatePlayerStats();
        rollForPirates();
        gameEngine.increaseTurn();
    }

    private void resetLockedDice() {
        gameEngine.unlockAllDice();
        for (int i = 1; i < 6; i++) {
            ImageView dieView = allDiceImageViews.get(i);
            dieView.setBackgroundResource(0);
        }
    }

    private void hideDice() {
        for (int i = 1; i < 6; i++) {
            ImageView dieView = allDiceImageViews.get(i);
            dieView.setImageResource(0);
        }
    }

    private void updatePlayerStats() {
        currentTurn.setText(String.valueOf(gameEngine.getTurn()));
        playerPoints.setText(String.valueOf(gameEngine.getPlayer().getPoints()));
        playerCoins.setText(String.valueOf(gameEngine.getPlayer().getCoins()));
        playerTrees.setText(String.valueOf(gameEngine.getPlayer().getTrees()));
        playerDefence.setText(String.valueOf(gameEngine.getPlayer().getDefence()));
        playerCannonsDestroyed.setText(String.valueOf(gameEngine.getPlayer().getCannonsDestroyed()));

        String pirateImage = PIRATES_IMAGES_LIST.get(gameEngine.getPirates());
        piratesLayout.setBackgroundResource(getDrawableImageIdByName(pirateImage));
    }

    private void collectCoinsFromMerchant(int spaceNum) {
        Space currSpace = gameEngine.getBoard().getAllSpaces().get(spaceNum);
        List<Space> neighbouringSpaces = currSpace.getNeighbouringSpaces();
        int numCrates = 0;

        for (Space neighbouringSpace : neighbouringSpaces) {
            if((neighbouringSpace != null) && (neighbouringSpace.getSpaceSymbol() == SpaceSymbol.CRATE)) {
                numCrates++;
            }
        }

        gameEngine.getPlayer().increaseResource(COINS, numCrates);
    }

    private void collectPointsFromPriest(int spaceNum) {
        Space currSpace = gameEngine.getBoard().getAllSpaces().get(spaceNum);
        List<Space> neighbouringSpaces = currSpace.getNeighbouringSpaces();
        int numChurches = 0;

        for (Space neighbouringSpace : neighbouringSpaces) {
            if((neighbouringSpace != null) &&
                    ((neighbouringSpace.getSpaceSymbol() == CHURCH_LVL_1) ||
                            (neighbouringSpace.getSpaceSymbol() == CHURCH_LVL_2)
                    || (neighbouringSpace.getSpaceSymbol() == CHURCH_LVL_3)
                    || (neighbouringSpace.getSpaceSymbol() == CHURCH_LVL_4)
                    || (neighbouringSpace.getSpaceSymbol() == CHURCH_LVL_5))) {
                numChurches++;
            }
        }

        gameEngine.getPlayer().increaseResource(POINTS, numChurches);
    }

    private void collectPointsFromJuggler(int spaceNum) {
        Space currSpace = gameEngine.getBoard().getAllSpaces().get(spaceNum);
        List<Space> neighbouringSpaces = currSpace.getNeighbouringSpaces();
        int numPeople = 0;

        for (Space neighbouringSpace : neighbouringSpaces) {
            if((neighbouringSpace != null) &&
                    (
                                (neighbouringSpace.getSpaceSymbol() == PERSON_CITIZEN)
                            || (neighbouringSpace.getSpaceSymbol() == PERSON_SOLDIER)
                            || (neighbouringSpace.getSpaceSymbol() == PERSON_PRIEST)
                            || (neighbouringSpace.getSpaceSymbol() == PERSON_ARCHITECT)
                            || (neighbouringSpace.getSpaceSymbol() == PERSON_MERCHANT)
                                        || (neighbouringSpace.getSpaceSymbol() == PERSON_JUGGLER)
                                        || (neighbouringSpace.getSpaceSymbol() == PERSON_NOBLE)
                    )) {
                numPeople++;
            }
        }

        gameEngine.getPlayer().increaseResource(POINTS, numPeople * 2);
    }

    private void collectPointsFromCitizen() {
        gameEngine.getPlayer().increaseResource(POINTS, CITIZEN_POINTS);
    }

    private void collectPointsFromNoble() {
        gameEngine.getPlayer().increaseResource(POINTS, NOBLE_POINTS);
    }

    private void increaseDefenceFromSoldier() {
        gameEngine.getPlayer().increaseResource(DEFENCE, SOLDIER_DEFENCE_INCREASE);
    }

    private void checkForBonusIfAvailable(int index) {
        if(index <= 5) {
            if(gameEngine.getBoard().isPeopleBonusAvailable()){
                activateChoosePersonForBonusDialog();
                gameEngine.getPlayer().increaseResource(DEFENCE, 2);
            }
        } else if(index > 5 && index <= 10){
            if(gameEngine.getBoard().isCoinsBonus1Available()) {
                gameEngine.getPlayer().increaseResource(COINS, 2);
                gameEngine.getPlayer().increaseResource(DEFENCE, 2);
            }
        } else if (index > 10 && index <= 15){
            if(gameEngine.getBoard().isPointsBonusAvailable()) {
                gameEngine.getPlayer().increaseResource(POINTS, 3);
                gameEngine.getPlayer().increaseResource(DEFENCE, 2);
            }
        } else if (index > 15 && index <= 20){
            if(gameEngine.getBoard().isCoinsBonus2Available()) {
                gameEngine.getPlayer().increaseResource(COINS, 2);
                gameEngine.getPlayer().increaseResource(DEFENCE, 2);
            }
        }
    }

    private void rollForPirates() {
        rollDiceAfterRollingAnimation();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                checkAndMarkPirates();
                gameEngine.resetRemainingRolls();
                hideDice();
                unlockRollButton();
                updatePlayerStats();
            }
        }, ROLL_PIRATES_DELAY);
    }

    private void checkAndMarkPirates() {
        for (int i = 1; i < 4; i++) {
            Die die = gameEngine.getAllDice().get(i);
            if (die != null && die.getType() == PIRATE) {
                gameEngine.increasePirates(1);
                gameEngine.getPirateHandler().checkForAttack(gameEngine.getPlayer());
            }
        }
    }

}



