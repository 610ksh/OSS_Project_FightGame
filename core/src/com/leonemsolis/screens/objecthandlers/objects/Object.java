package com.leonemsolis.screens.objecthandlers.objects;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Leonemsolis on 28/09/2017.
 */

public abstract class Object {
    private Rectangle bounds;
    public Object(float x, float y, float width, float height) {
        bounds = new Rectangle(x, y, width, height);
    }

    public void render(float delta) {

    }

    public void update() {

    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle newBounds) {
        bounds = newBounds;
    }
}