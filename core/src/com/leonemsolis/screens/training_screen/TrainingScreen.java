package com.leonemsolis.screens.training_screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.leonemsolis.main.MainGameClass;

/**
 * Created by kmusw on 2017-11-21.
 */

public class TrainingScreen implements Screen {
    public MainGameClass mainGameClass;
    public TrainingObjectHandler handler;
    public TrainingRenderer renderer;
    public TrainingInputProcessor inputProcessor;

    public TrainingScreen(MainGameClass mainGameClass) {
        this.mainGameClass=mainGameClass;// render에 사용
        handler = new TrainingObjectHandler(mainGameClass);
        renderer = new TrainingRenderer(handler);
        inputProcessor = new TrainingInputProcessor(handler);

        Gdx.input.setInputProcessor(inputProcessor);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void render(float delta) {
        renderer.render(delta);
        if(handler.changeMap.isActivated())
            mainGameClass.switchScreen(1);

    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }


}