package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Field;
import com.badlogic.gdx.utils.reflect.Method;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.common.SampleBase;
import com.mygdx.game.common.SampleInfo;

import java.util.Arrays;

public class GdxReflactionSample extends SampleBase {
    public static final SampleInfo SAMPLE_INFO = new SampleInfo(GdxReflactionSample.class);


    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;

    private static final Logger logger = new Logger(InputListeningSample.class.getName(), Logger.DEBUG);

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        camera = new OrthographicCamera();
        viewport = new FitViewport(1080, 720, camera);
        batch = new SpriteBatch();
        font  = new BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"));

        debugReflection(GdxReflactionSample.class);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {

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

    private static  void debugReflection(Class<?> clazz){
        Field[] fields = ClassReflection.getDeclaredFields(clazz);
        Method[] methods = ClassReflection.getDeclaredMethods(clazz);

        logger.debug("==debug reflaction class " + clazz.getName());

        logger.debug("fields-count = "+ fields.length);

        for(Field field: fields){
            logger.debug("name "+ field.getName() + ", type "+field.getType());
        }

        logger.debug("methods-count = "+ methods.length);

        for(Method method: methods){
            logger.debug("name "+ method.getName() + ", type "+ Arrays.asList(method.getParameterTypes()));
        }

        logger.debug("===============");
    }
}
