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

public class ApplicationListenerSample extends SampleBase {

	public static final SampleInfo SAMPLE_INFO = new SampleInfo(ApplicationListenerSample.class);

	private static final Logger logger = new Logger(ApplicationListenerSample.class.getName(), Logger.DEBUG);
	private boolean renderInterrupted = false;

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		logger.debug("create()");
	}

	@Override
	public void resize(int width, int height) {
		logger.debug("resize()");
	}

	@Override
	public void render() {
		if(renderInterrupted) {
			logger.debug("render()");
			renderInterrupted = false;
		}
	}

	@Override
	public void pause() {
		logger.debug("pause()");
		renderInterrupted = true;
	}

	@Override
	public void resume() {
		logger.debug("resume()");
		renderInterrupted = true;
	}

	@Override
	public void dispose() {
		logger.debug("dispose()");
	}
}
