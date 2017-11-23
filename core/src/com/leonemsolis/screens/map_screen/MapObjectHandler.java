package com.leonemsolis.screens.map_screen;


import com.badlogic.gdx.graphics.Color;
import com.leonemsolis.main.MainGameClass;
import com.leonemsolis.screens.common_objects.DataHandler;
import com.leonemsolis.screens.map_screen.objects.MapButton;
import com.leonemsolis.screens.map_screen.objects.ParticleSystem;

import java.util.ArrayList;

/**
 * Created by Leonemsolis on 26/10/2017.
 */

public class MapObjectHandler {

    public MapButton fight1, fight2, boss, training, shop;
    private MainGameClass mainGameClass;
    public ArrayList<ParticleSystem>particleSystems;

    public MapObjectHandler(MainGameClass mainGameClass) {
        this.mainGameClass = mainGameClass;
        fight1 = new MapButton(160, MainGameClass.MID_POINT + 40, "Level 1", Color.BLACK);
        fight2 = new MapButton(200, MainGameClass.MID_POINT - 50, "Level 2", Color.GREEN);
        boss = new MapButton(240, 30, "Boss", Color.YELLOW);
        shop = new MapButton(0, 0, "Shop", Color.WHITE);
        training = new MapButton(90, MainGameClass.MID_POINT - 20, "Train", Color.BROWN);
        particleSystems = new ArrayList<ParticleSystem>();
    }

    public void update(float delta) {
        if(fight1.isActivated()) {
            mainGameClass.gotoFightScreen(1);
        }
        if(fight2.isActivated()) {
            mainGameClass.gotoFightScreen(2);
        }
        if(boss.isActivated()) {
            mainGameClass.gotoFightScreen(3);
        }
        if(shop.isActivated()) {
            //goto shop
        }
        if(training.isActivated()) {
            //goto training
        }



        if(fight1.isTouchedDown()) {
            particleSystems.add(new ParticleSystem(fight1.getX(), fight1.getY()));
        }

        if(fight2.isTouchedDown()) {
            particleSystems.add(new ParticleSystem(fight2.getX(), fight2.getY()));
        }

        if(boss.isTouchedDown()) {
            particleSystems.add(new ParticleSystem(boss.getX(), boss.getY()));
        }


        for (int i = 0; i < particleSystems.size(); ++i) {
            particleSystems.get(i).update(delta);
        }

        clearParticleSystems();
    }

    public void clearParticleSystems() {
        ArrayList<ParticleSystem> deadSystems = new ArrayList<ParticleSystem>();
        for (int i = 0; i < particleSystems.size(); ++i) {
            if(particleSystems.get(i).died) {
                deadSystems.add(particleSystems.get(i));
            }
        }

        if (!deadSystems.isEmpty()) {
            for (int i = 0; i < deadSystems.size(); ++i) {
                particleSystems.remove(deadSystems.get(i));
            }
        }
    }
}
