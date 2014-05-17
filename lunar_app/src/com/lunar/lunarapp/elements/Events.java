package com.lunar.lunarapp.elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Events extends Group{
	public static final String SKIN_JSON_UI = "purple skin/uiskin.json";
	protected static final Skin skin = new Skin(Gdx.files.internal(SKIN_JSON_UI));
	
	public Events(Image icon) {
		setWidth(400);
		setHeight(150);
		
		//background
		Texture texture = new Texture(Gdx.files.internal("data/background.png"));
		Image background = new Image(texture);
		background.setBounds(getX(), getY(), 400, 150);  
        addActor(background);
		
		//icon
		icon.setBounds(getX(), getY(), 150, 150);
		addActor(icon);
		
		Label labelName = new Label("Ladies Night at Flip flops", skin);
		labelName.size( 200, 50 );
		labelName.setPosition(getX()+150+5, getY()+75);  
        addActor(labelName); 
        
        Label labelDate = new Label("Today | 10:00pm", skin);
        labelDate.size( 200, 50 );
		labelDate.setPosition(getX()+150+5, getY() + 50);  
        addActor(labelDate);
        
        Label labelDist = new Label("2 miles away", skin);
        labelDist.size( 200, 50 );
		labelDist.setPosition(getX()+150+5, getY() + 25);  
        addActor(labelDist);
        
        Label labelPrice = new Label("$$", skin);
        labelPrice.size( 200, 50 );
		labelPrice.setPosition(getX()+150+5, getY() + 0);  
        addActor(labelPrice); 
	}
}
