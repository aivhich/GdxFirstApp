package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.ModelinfoSample;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncherModels {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		System.out.println("app "+ Gdx.app);
		System.out.println("input "+ Gdx.input);
		new LwjglApplication(new ModelinfoSample(), config);
	}
}
