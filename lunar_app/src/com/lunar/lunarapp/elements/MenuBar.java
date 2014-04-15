package com.lunar.lunarapp.elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MenuBar extends Group {
	public static final String SKIN_JSON_UI = "skin/uiskin.json";
	protected static final Skin skin = new Skin(Gdx.files.internal(SKIN_JSON_UI));
	
	public MenuBar() {
		
		setWidth(480);
		setHeight(30);
		
		//background
		Texture texture = new Texture(Gdx.files.internal("data/background.png"));
		Image background = new Image(texture);
		background.setBounds(getX(), getY(), 480, 30);  
        addActor(background);
		
		//Menu Button
		TextButton menuButton = new TextButton("menu picture here", skin);
		menuButton.addListener( new InputListener()
        {
	       	 public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
	       		 return true;
	       	 }
        });
		menuButton.setPosition(getX(), getY());
		addActor(menuButton);
		
		//Lunar Icon
		Label l = new Label("Lunar icon", skin);
		l.setPosition(getX()+ menuButton.getPrefWidth(), getY());
		addActor(l);
		
	}
}
