package com.lunar.lunarapp.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.lunar.lunarapp.LunarMain;
import com.lunar.lunarapp.elements.Events;
import com.lunar.lunarapp.elements.MenuBar;

public class EventScreen extends AbstractScreen {
	private Table table;
	private ScrollPane scroller;
	private Table parent;
	
	public EventScreen(LunarMain l) {
		super(l);
		
	}
	
	public void show() {
		super.show();
		
		parent = new Table(super.getSkin());
		parent.setFillParent(true);
		
		//create menubar
		createMenu(parent);

		//table for scroll pane
		table = new Table(super.getSkin());
		table.setFillParent( false );
		
		//populating list for scroll pane
		for (int i=0; i<30; i++) {
			Texture texture = new Texture(Gdx.files.internal("data/temp.png"));
			Image icon = new Image(texture);
			table.add(new Events(icon)).spaceBottom(0);
			table.row();
		}
		
		//scroll pane
		scroller = new ScrollPane(table, super.getSkin());
		parent.add(scroller).colspan(2).spaceBottom(50);
		parent.row();
		
		// register the button "more"
        TextButton moreButton = new TextButton( "More", super.getSkin());
        moreButton.addListener( new InputListener()
        {
        	 public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        		 //lunar.setScreen(new EventScreen(lunar));
        		 return true;
        	 }
        });
        parent.add( moreButton ).size( 100, 50 ).uniform().spaceBottom( 20 ).colspan(2);
        parent.row();
		
		stage.addActor(parent);
	}
	
	public void createMenu(Table parent) {
		
		parent.add(new MenuBar());
		parent.row();
	}

}
