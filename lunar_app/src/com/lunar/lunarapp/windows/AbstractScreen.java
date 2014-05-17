package com.lunar.lunarapp.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.lunar.lunarapp.LunarMain;

public class AbstractScreen implements Screen{
	protected final LunarMain lunar;
	private Skin skin;
	
	protected Stage stage;
	
	protected SpriteBatch batch;
    protected Texture texture;

	public AbstractScreen(LunarMain l) {
		lunar = l;
		
		this.stage = new Stage( Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true );
	}
	@Override
	public void render(float delta) {
		
		// update the actors
        stage.act( delta );
        
        batch.begin();
        batch.draw(texture, 0, 0);
        batch.end();
        
        // draw the actors
        stage.draw();

        // draw the table debug lines
        Table.drawDebug( stage );
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// set the stage as the input processor
        Gdx.input.setInputProcessor( stage );
        Texture.setEnforcePotImages(false);
        texture = new Texture(Gdx.files.internal("data/appbackground.png"));
        batch = new SpriteBatch();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		texture.dispose();
	}
	
	protected Skin getSkin()
    {
        if( skin == null ) {
            FileHandle skinFile = Gdx.files.internal( "skin/uiskin.json" );
            skin = new Skin( skinFile );
        }
        return skin;
    }
	
	protected void addActor(Actor a) {
		stage.addActor(a);
	}
}
