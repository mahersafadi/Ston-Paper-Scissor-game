package com.play_v1.game;

/**
 * Each round between 2 players are recorded in this class, using
 * {@link #player1Choice} for the first player's choice and
 * {@link #player2Choice} for the second player's choice<br/>
 * It also provides a method {@link #getResult()} to return who is the winner in
 * this round, and as usual [1: means that player 1 is the winner in this round,
 * -1: means that player 2 is the winner in this round, and 0 if player 1 and
 * player choose the same choices]
 * 
 * @author maher
 *
 */
public final class Round {
	private final Choice player1Choice;
	private final Choice player2Choice;

	public Round(Choice player1Choice, Choice player2Choice) {
		if (player1Choice == null || player2Choice == null)
			throw new IllegalArgumentException();
		this.player1Choice = player1Choice;
		this.player2Choice = player2Choice;
	}

	/**
	 * Returns the result of current round
	 * 
	 * @return 1,-1,0 if player 1 wines, player 2 wines, equals respectively
	 */
	public int getResult() {
		return player1Choice.compareTo(player2Choice);
	}
}
