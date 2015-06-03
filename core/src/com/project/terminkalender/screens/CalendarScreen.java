package com.project.terminkalender.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.project.terminkalender.Background;
import com.project.terminkalender.Main;
import com.project.terminkalender.calendar.TasktableActor;
import com.project.terminkalender.calendar.TimetableActor;

public class CalendarScreen extends AbstractScreen {
	private Background background;
	private TimetableActor timetableActor;
	private TasktableActor tasktableActor;
	private TextButton changeToChatButton;

	public CalendarScreen() {
		super();
		
		TextureRegion backgroundTexture = new TextureRegion(Main.assets.get("background.png", Texture.class));
		Skin skin = Main.assets.get("skins/uiskin.json", Skin.class);
		DragAndDrop dragAndDrop = new DragAndDrop();
		
		background = new Background(backgroundTexture);
		timetableActor = new TimetableActor(dragAndDrop, skin);
		tasktableActor = new TasktableActor(dragAndDrop, skin);
		changeToChatButton = new TextButton("Chat", skin);
		
		stage.addActor(background);
		stage.addActor(timetableActor);
		stage.addActor(tasktableActor);
		stage.addActor(changeToChatButton);
		
		changeToChatButton.setBounds(8, 8, 100, 50);
		
		changeToChatButton.addListener(new ClickListener() {

			@Override 
			public void clicked(InputEvent event, float x, float y){
				Main.setNewScreen(Main.roomScreen);
			}
		});
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	} 
	
	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		stage.draw();
	}
}