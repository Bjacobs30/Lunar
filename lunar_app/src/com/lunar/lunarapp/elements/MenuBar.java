package com.lunar.lunarapp.elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MenuBar extends Group {
	public static final String SKIN_JSON_UI = "skin/uiskin.json";
	protected static final Skin skin = new Skin(Gdx.files.internal(SKIN_JSON_UI));
	
	private static MenuBar instance;
	
	private boolean isSelected;
	
	public MenuBar() {
		
		setWidth(480);
		setHeight(30);
		
		isSelected = false;
		
		//background
		Texture texture = new Texture(Gdx.files.internal("data/background.png"));
		Image background = new Image(texture);
		background.setBounds(getX(), getY(), 480, 30);  
        addActor(background);
		
		//Menu Button
      	Texture texture1 = new Texture(Gdx.files.internal("data/MenuButton.png"));
      	Image menuButton = new Image(texture1);
      	
		menuButton.addListener( new InputListener()
        {
	       	 public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
	       		 isSelected = !isSelected;
	       		 return true;
	       	 }
        });
		menuButton.setPosition(getX(), getY());
		addActor(menuButton);
		
		//Lunar Icon
		Texture texture2 = new Texture(Gdx.files.internal("data/tinylogolunr.png"));
		Image icon = new Image(texture2);
		icon.setPosition(getX()+ getWidth()/2, getY());
		addActor(icon);
	}
	
	public static MenuBar getInstance(){
		if(instance == null){
                instance = new MenuBar();
        }
        return instance;
	}
	
	public boolean isSelected() {
		return isSelected;
	}
}

