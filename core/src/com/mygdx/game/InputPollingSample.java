package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.common.SampleBase;
import com.mygdx.game.common.SampleInfo;
import com.mygdx.game.utils.GdxUtils;

import javax.swing.filechooser.FileView;

public class InputPollingSample extends SampleBase {
    public static final SampleInfo SAMPLE_INFO = new SampleInfo(InputPollingSample.class);

    private OrthographicCamera camera;
    private com.badlogic.gdx.utils.viewport.Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(1080, 720, camera);
        batch = new SpriteBatch();
        font  = new BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"));

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        GdxUtils.clearScreen();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw();

        batch.end();
    }

    private void draw() {
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.input.getY();

        boolean leftPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT);
        boolean rightPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT);

        font.draw(batch, "Mouse/Touch x="+ mouseX + " y="+mouseY,
                20f,
                720-20f);

        font.draw(batch, leftPressed ? "Left button pressed":"Left button not pressed",
                20f,
                720 - 70f);

        font.draw(batch, rightPressed ? "Right button pressed":"Right button not pressed",
                20f,
                720 - 110f);


        boolean wPressed = Gdx.input.isKeyPressed(Input.Keys.W);
        boolean sPressed = Gdx.input.isKeyPressed(Input.Keys.S);

        font.draw(batch, wPressed ? "W is pressed":"W is not pressed", 20f, 720 - 150f);

        font.draw(batch, sPressed ? "S is pressed":"S is not pressed", 20f, 720 - 190f);


    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
