package com.project.terminkalender.games;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.project.terminkalender.tools.DialogActor;

public class GameDialog extends DialogActor {
	protected TeacherGame game;
	protected TextButton thisButton, actionButton;
	
	public GameDialog(Skin skin, final TeacherGame game, TextButton thisButton) {
		super("", skin);
		this.game = game;
		this.thisButton = thisButton;
	}
}

