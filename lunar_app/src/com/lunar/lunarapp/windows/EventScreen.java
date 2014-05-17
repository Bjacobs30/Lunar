package com.lunar.lunarapp.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.lunar.lunarapp.LunarMain;
import com.lunar.lunarapp.elements.DropDownMenu;
import com.lunar.lunarapp.elements.Events;
import com.lunar.lunarapp.elements.MenuBar;

public class EventScreen extends AbstractScreen {
	private Table table;
	private ScrollPane scroller;
	private Table parent;
	private MenuBar menu;
	
	private Stage extendedMenu;
	
	private InputMultiplexer inputMultiplexer;
	
	public EventScreen(LunarMain l) {
		super(l);
		
	}
	
	public void show() {
		super.show();
		
		parent = new Table(super.getSkin());
		parent.setFillParent(true);
		
		//create menubar
		menu = new MenuBar();
		menu.toFront();
		parent.add(menu).spaceBottom(20);
		parent.row();
		
		//table for scroll pane
		table = new Table(super.getSkin());
		table.setFillParent( false );
		
		//populating list for scroll pane
		for (int i=0; i<30; i++) {
			Texture texture = new Texture(Gdx.files.internal("data/temp.png"));
			Image icon = new Image(texture);
			table.add(new Events(icon)).spaceBottom(10);
			table.row();
		}
		
		// register the button "more"
        TextButton moreButton = new TextButton( "More", super.getSkin());
        moreButton.addListener( new InputListener()
        {
        	 public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        		 return true;
        	 }
        });
        
        table.add(moreButton);
        table.row();
		
		//scroll pane
		scroller = new ScrollPane(table, super.getSkin());
		scroller.toBack();
		parent.add(scroller).colspan(2).spaceBottom(50);
		parent.row();
		
		stage.addActor(parent);
		
		//Logic for extended Menu
		extendedMenu = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		
		DropDownMenu m = DropDownMenu.getInstance();
		m.setPosition(0, 35);
		
		//FilterButton sends you to Filter screen
		m.setFilterActionListener(new InputListener()
        {
       	 public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
       		 lunar.setScreen(new FilterScreen(lunar));
       		 return true;
       	 }
        });

		extendedMenu.addActor(m);
		
		//Processing logic
		inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(extendedMenu);
		inputMultiplexer.addProcessor(stage);
		
		Gdx.input.setInputProcessor(inputMultiplexer);
	}
	
	@Override
	public void render(float delta) {
		
		// update the actors
        stage.act( delta );
        
        if(menu.isSelected()) {
        	extendedMenu.act(delta);
        }

        
        batch.begin();
        batch.draw(texture, 0, 0);
        batch.end();

        
        // draw the actors
        stage.draw();
        
        if(menu.isSelected()) {
        	extendedMenu.draw();
        }

        // draw the table debug lines
        Table.drawDebug( stage );
	}

}
