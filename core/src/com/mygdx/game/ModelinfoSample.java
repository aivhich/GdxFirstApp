package com.mygdx.game;


import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Logger;
import com.mygdx.game.common.SampleBase;
import com.mygdx.game.common.SampleInfo;


public class ModelinfoSample extends SampleBase {
	private static final Logger logger = new Logger(ModelinfoSample.class.getName(), Logger.DEBUG);

	public static final SampleInfo SAMPLE_INFO = new SampleInfo(ModelinfoSample.class);


	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		logger.debug("app = "+ Gdx.app);
		logger.debug("audio = "+Gdx.audio);
		logger.debug("graphics = "+Gdx.graphics);
		logger.debug("file = "+ Gdx.files);
		logger.debug("net = "+ Gdx.net);
		logger.debug("input = "+Gdx.input);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}
