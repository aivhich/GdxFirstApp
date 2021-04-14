package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.InputPollingSample;
import com.mygdx.game.MyGdxGame;

public class InputPollingGame {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
		config.height = 700;
		new LwjglApplication(new InputPollingSample(), config);
	}
}
