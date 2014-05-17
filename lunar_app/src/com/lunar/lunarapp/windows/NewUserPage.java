package com.lunar.lunarapp.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.lunar.lunarapp.LunarMain;

public class NewUserPage extends AbstractScreen {
	private Table table;
	
	public NewUserPage(LunarMain l) {
		super(l);
		
		table = new Table(super.getSkin());
		table.setFillParent( true );
	}
	
	public void show() {
		super.show();

		//lunar icon
		Texture texture = new Texture(Gdx.files.internal("data/icon.png"));
		Image icon = new Image(texture);
		
		table.add(icon).spaceBottom(100).spaceTop(200).height(225).width(225);
        table.row();
        
        // register the button "Facebook button"
        TextButton FacebookButton = new TextButton( "Sign up with Facebook", super.getSkin());
        FacebookButton.addListener( new InputListener()
        {
        	 public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        		 return true;
        	 }
        });
        table.add( FacebookButton ).size( 400, 90 ).uniform().spaceBottom( 10 );
        table.row();
        
        // register the button "Email button"
        TextButton EmailButton = new TextButton( "Sign up with Email", super.getSkin());
        EmailButton.addListener( new InputListener()
        {
        	 public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        		 return true;
        	 }
        });
        table.add( EmailButton ).size( 400, 90 ).uniform().spaceBottom( 10 );
        table.row();
        
        // register the button "Login button"
        TextButton LoginButton = new TextButton( "Already have an account", super.getSkin());
        LoginButton.addListener( new InputListener()
        {
        	 public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        		 lunar.setScreen(new LoginPage(lunar));
        		 return true;
        	 }
        });
        table.add( LoginButton ).size( 400, 90 ).uniform().spaceBottom( 10 );
        table.row();
        
        stage.addActor(table);
	}
	
}
