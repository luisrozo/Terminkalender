package com.project.terminkalender.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.project.terminkalender.Background;
import com.project.terminkalender.Main;
import com.project.terminkalender.chat.ChatActor;

public class ChatScreen extends AbstractScreen {
	private Background background;
	private ChatActor chatActor;
	private TextButton changeToRoomButton;
	
	public ChatScreen(ChatActor chatActor) {
		super();
		
		TextureRegion backgroundTexture = new TextureRegion(Main.assets.get("background.png", Texture.class));
		Skin skin = Main.assets.get("skins/uiskin.json", Skin.class);
		
		background = new Background(backgroundTexture);
		this.chatActor = chatActor;
		changeToRoomButton = new TextButton("ChatRoom", skin);
		
		stage.addActor(background);
		stage.addActor(chatActor);
		stage.addActor(changeToRoomButton);
		
		changeToRoomButton.setBounds(Main.WIDTH - 108, 8, 100, 50);
		
		changeToRoomButton.addListener(new ClickListener() {

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