package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.common.SampleBase;
import com.mygdx.game.common.SampleInfo;
import com.mygdx.game.utils.GdxUtils;

public class InputListeningSample extends SampleBase{

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(InputListeningSample.class);
    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;
    private static final Logger logger = new Logger(InputListeningSample.class.getName(), Logger.DEBUG);

    private  static final int MAX_MESSAGE_COUNT = 15;

    private final Array<String> messages = new Array<String>();

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        camera = new OrthographicCamera();
        viewport = new FitViewport(1080, 720, camera);
        batch = new SpriteBatch();
        font  = new BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"));

        InputMultiplexer multiplexer = new InputMultiplexer();

        InputAdapter firstProcessor = new InputAdapter(){
            @Override
            public boolean keyDown(int keycode) {
                logger.debug("first - keyDown keyCode "+ keycode);
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                logger.debug("first - keyUp keyCode "+ keycode);
                return false;
            }
        };
        InputAdapter secondProcessor = new InputAdapter(){
            @Override
            public boolean keyDown(int keycode) {
                logger.debug("second - keyDown keyCode "+ keycode);
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                logger.debug("second - keyUp keyCode "+ keycode);
                return false;
            }
        };

        multiplexer.addProcessor(firstProcessor);
        multiplexer.addProcessor(secondProcessor);

        Gdx.input.setInputProcessor(multiplexer);

//        Gdx.input.setInputProcessor(new InputAdapter(){
//            @Override
//            public boolean keyDown(int keycode){
//                logger.debug("KeyDown keyCode"+ keycode);
//                return true;
//            }
//        });
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

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    void draw() {
        for(int i=0; i<messages.size; i++){
            font.draw(batch, messages.get(i), 20.0f, 720-40f*(i+1));
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    private void addMessage(String message){
        messages.add(message);

        if(messages.size> MAX_MESSAGE_COUNT){
            messages.removeIndex(0);
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        String message = "KeyDown keyCode = "+ keycode;
        logger.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        String message = "KeyUp keyCode = "+ keycode;
        logger.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        String message = "KeyTyped keyCode = "+ character;
        logger.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        String message = "TouchDown screenX = "+ screenX+"screenY = "+screenY;
        logger.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        String message = "TouchUp screenX = "+ screenX+"screenY = "+screenY;
        logger.debug(message);
        addMessage(message);
        return true;    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        String message = "TouchDragged screenX = "+ screenX+"screenY = "+screenY;
        logger.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        String message = "MouseMoved = "+ screenX+"screenY = "+screenY;
        logger.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        String message = "Scrolled screenX = "+ amountX+"screenY = "+amountY;
        logger.debug(message);
        addMessage(message);
        return true;
    }
}
