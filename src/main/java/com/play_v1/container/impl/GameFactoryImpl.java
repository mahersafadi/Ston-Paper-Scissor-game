package com.play_v1.container.impl;

import javax.inject.Inject;

import com.play_v1.container.GameFactory;
import com.play_v1.game.Game;
import com.play_v1.game.impl.GameImpl;
import com.play_v1.tools.GameIdGenerator;

public class GameFactoryImpl implements GameFactory{
	@Inject
	private GameIdGenerator gameIdGenerator;
	
	public Game get() {
		return new GameImpl(gameIdGenerator.getId());
	}
}
