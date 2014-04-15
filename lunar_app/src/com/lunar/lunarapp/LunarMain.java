package com.lunar.lunarapp;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.lunar.lunarapp.windows.NewUserPage;

public class LunarMain extends Game {
	
	@Override
	public void create() {
		Texture.setEnforcePotImages(false);
		setScreen( new NewUserPage(this));
	}
	
	@Override
    public void setScreen(Screen screen )
    {
        super.setScreen( screen );
    }

	@Override
	public void dispose() {
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
