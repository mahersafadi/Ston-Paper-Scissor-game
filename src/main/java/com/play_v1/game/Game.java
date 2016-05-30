package com.play_v1.game;

/**
 * This class represents the set of rounds between 2 players and return the
 * winner. it contains {@link #rounds}, List of Rounds. and provides the winner
 * 
 * DreamIT
 * 
 * @author maher
 *
 */
public interface Game {
	/**
	 * Add new game to the round, maximum rounds are 100 rounds. inserting more
	 * rounds than maximum will throw {@link IndexOutOfBoundsException}
	 * 
	 * @param r
	 *            the current round to be inserted, It must be not null,
	 *            otherwise method will throw {@link IllegalArgumentException}
	 */
	public void addRound(Round r);

	/**
	 * Returns the winner of the game<br/>
	 * 0: no winner, sum of player choices are equals<br/>
	 * 1: Player one wines<br/>
	 * -1: player two wines<br/>
	 * 
	 * @return
	 */
	public int getWinner();

	/**
	 * set the game's first player
	 * 
	 * @param player
	 *            . must not be null otherwise method will throw
	 *            {@link IllegalArgumentException}
	 */
	public void setFirstPlayer(Player player);

	/**
	 * set the game's first player
	 * 
	 * @param player
	 *            . must not be null otherwise method will throw
	 *            {@link IllegalArgumentException}
	 */
	public void setSecondPlayer(Player player);

	/**
	 * check if the game ends with same number of total round wines it must be
	 * used before {@link #getWinerPlayer()} to avoid exception when call
	 * {@link Game#getWinerPlayer()} and no winner is exist (equal case)
	 * 
	 * @return
	 */
	public boolean isEqual();

	/**
	 * Return the player as object, if game ends with equals (no winner) then
	 * {@link RuntimeException} is raised
	 * 
	 * @return the winning player in the game
	 */
	public Player getWinerPlayer();
	
	public Player getFirstPlayer();

	public Player getSecondPlayer();
	
	public Long getId();
	
	/**
	 * 
	 * @return number of rounds played until method call
	 */
	public int getRounds();
}
