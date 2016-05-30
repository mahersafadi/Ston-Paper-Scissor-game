package com.play_v1.container;

import com.play_v1.game.Game;

/**
 * This factory is responsible about get a new game and set id for it, game
 * produced from this factory has not players yet<br/>
 * 
 * DreamIT
 * @author maher
 *
 */
public interface GameFactory {
	public Game get();
}
