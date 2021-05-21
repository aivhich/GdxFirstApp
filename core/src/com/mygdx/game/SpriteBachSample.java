package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.common.SampleBase;
import com.mygdx.game.common.SampleInfo;
import com.mygdx.game.utils.GdxUtils;

import java.awt.*;

public class SpriteBachSample extends SampleBase {
    public static final SampleInfo SAMPLE_INFO = new SampleInfo(SpriteBachSample.class);

    private static final float WORLD_WIDTH = 10.0F;
    private static final float WORLD_HEIGHT = 7.2F;

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;

    private Texture texture;
    private Color oldColor;

    private int wicth = 1;
    private int height = 1;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new FillViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("raw/character.png"));
    }

    @Override
    public void render() {
        GdxUtils.clearScreen();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
