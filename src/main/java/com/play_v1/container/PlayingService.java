package com.play_v1.container;

import com.play_v1.game.Game;

/**
 * This service is responsible to handle all games in the application
 * concurrently.<br/>
 * DreamIT
 * @author maher
 *
 */
public interface PlayingService {
	/**
	 * Adding new game to the service
	 * 
	 * @param game
	 *            and must be not null, otherwise, method throws
	 *            {@link IllegalArgumentException}
	 */
	public void addNewGame(Game game);

	/**
	 * help to check if the game is exist or not by game id. it is useful to be
	 * used before call {@link #getGameById(Long)} to avoid throw
	 * {@link IllegalArgumentException} if game is not exist
	 * 
	 * @param gameId
	 * @return true if game with #gamId is added previously and false if game
	 *         with #gameId is not exist
	 */
	public boolean exist(Long gameId);

	/**
	 * Get game by it id, method throws {@link IllegalArgumentException} if game
	 * is not exist
	 * 
	 * @return the game that holds that Id.
	 */
	public Game getGameById(Long id);

	/**
	 * remove the game from the playing service, if game with the passed game id
	 * is not exist, then no thing is happened
	 * 
	 * @param gameId
	 */
	public void finishTheGame(Long gameId);
	
	/**
	 * 
	 * @return the number of games the {@link PlayingService} holds
	 */
	public int getGamesNumber();

}
