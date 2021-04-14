package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.common.SampleBase;
import com.mygdx.game.common.SampleInfo;

import java.util.Vector;

public class MyGdxGame extends SampleBase {
	public Environment environment;
	public PerspectiveCamera camera;
	public ModelBatch modelBatch;
	public ModelInstance boxInstance;

	public static final SampleInfo SAMPLE_INFO = new SampleInfo(MyGdxGame.class);


	@Override
	public void create () {
		modelBatch = new ModelBatch();

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));


		DirectionalLight dLight = new DirectionalLight();
		Color lightColor = new Color(0.75f, 0.75f, 0.75f, 1);
		Vector3 lightVector = new Vector3(-1.0f, -0.75f, -0.25f);
		dLight.set(lightColor, lightVector);
		environment.add(dLight);


		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.near = 0.1f;
		camera.far = 1000f;
		camera.position.set(10f, 10f, 10f);
		camera.lookAt(0,0,0);
		camera.update();

		modelBatch = new ModelBatch();

		ModelBuilder modelBuilder = new ModelBuilder();

		Material boxMaterial = new Material();
		boxMaterial.set(ColorAttribute.createDiffuse(Color.BLUE));

		int usageCode = VertexAttributes.Usage.Position + VertexAttributes.Usage.ColorPacked + VertexAttributes.Usage.Normal;
		Model boxModel = modelBuilder.createBox(5, 5, 5, boxMaterial, usageCode);
		boxInstance  = new ModelInstance(boxModel);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glViewport(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		modelBatch.begin(camera);
		modelBatch.render(boxInstance, environment);
		modelBatch.end();
	}
	
	@Override
	public void dispose () {

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
}
