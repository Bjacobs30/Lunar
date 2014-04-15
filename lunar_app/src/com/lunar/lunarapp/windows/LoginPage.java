package com.lunar.lunarapp.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.lunar.lunarapp.LunarMain;

public class LoginPage extends AbstractScreen{
	private Table table;
	
	public LoginPage(LunarMain l) {
		super(l);
		
		table = new Table(super.getSkin());
		table.setFillParent( true );
	}
	
	public void show() {
		super.show();
		
		//background
		Texture texture = new Texture(Gdx.files.internal("data/icon.png"));
		Image icon = new Image(texture);
		
		table.add(icon).spaceBottom( 100 ).spaceTop(300).colspan(2);
        table.row();
        
        //Email field
        table.add("Email: ");
        TextField username = new TextField("", super.getSkin());
        table.add(username).size(300, 50).spaceBottom(20);
        table.row();
        
        //Password field
        table.add("Password: ");
        TextField password = new TextField("", super.getSkin());
        password.setPasswordMode(true);
        password.setPasswordCharacter('*');
        table.add(password).size(300, 50).spaceBottom(10);
        table.row();
        
        // register the button "Login button"
        TextButton LoginButton = new TextButton( "Login", super.getSkin());
        LoginButton.addListener( new InputListener()
        {
        	 public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        		 lunar.setScreen(new EventScreen(lunar));
        		 return true;
        	 }
        });
        table.add( LoginButton ).size( 100, 50 ).uniform().spaceBottom( 50 ).colspan(2).align(Align.right);
        table.row();
        
        // register the button "facebook"
        TextButton facebookButton = new TextButton( "Login with Facebook", super.getSkin());
        facebookButton.addListener( new InputListener()
        {
        	 public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        		 return true;
        	 }
        });
        table.add( facebookButton ).size( 200, 50 ).uniform().spaceBottom( 10 ).colspan(2);
        table.row();
        
        stage.addActor(table);
	}
}
