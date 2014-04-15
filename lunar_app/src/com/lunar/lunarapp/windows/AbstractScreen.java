package com.lunar.lunarapp.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.lunar.lunarapp.LunarMain;

public class AbstractScreen implements Screen{
	protected final LunarMain lunar;
	private Skin skin;
	
	protected Stage stage;
	
	private SpriteBatch batch;
    private Texture texture;
    private TextureRegion region;

	public AbstractScreen(LunarMain l) {
		lunar = l;
		
		this.stage = new Stage( 480,800, true );
	}
	@Override
	public void render(float delta) {
		
		// update the actors
        stage.act( delta );
        
        //Paint screen purple
		//Gdx.gl.glClearColor( 0.190f, 0.105f, 0.235f, .5f );
        //Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        
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

}
