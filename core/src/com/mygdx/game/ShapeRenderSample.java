package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.common.SampleBase;
import com.mygdx.game.common.SampleInfo;
import com.mygdx.game.utils.GdxUtils;

public class ShapeRenderSample extends SampleBase {
    public static final SampleInfo SAMPLE_INFO = new SampleInfo(ShapeRenderSample.class);

    public static final float WORLD_HEIGHT = 40f;
    private static final float WORLD_WIDTH = 20f;

    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer renderer;

    private boolean drawGrid = true;
    private boolean drawCircles = true;
    private boolean drawRectangle = true;
    private boolean drawPoints = true;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        renderer = new ShapeRenderer();

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void render() {
        GdxUtils.clearScreen();
        renderer.setProjectionMatrix(camera.combined);

        if(drawGrid) drawGrid();
    }

    private void drawGrid() {
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.WHITE);

        int worldWidth = (int) WORLD_WIDTH;
        int worldHeight = (int) WORLD_HEIGHT;

        for(int x=-worldWidth; x<worldWidth; x++){
            renderer.line(x, -worldHeight,x, worldWidth);
        }

        for(int y=-worldHeight; y<worldHeight; y++){
            renderer.line(-worldWidth, y, worldHeight, y);
        }

        renderer.end();
    }

    @Override
    public void dispose() {

    }
}
