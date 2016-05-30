package com.play_v1.game.impl;

import java.util.ArrayList;
import java.util.List;

import com.play_v1.game.Game;
import com.play_v1.game.Player;
import com.play_v1.game.Round;

public class GameImpl implements Game {
	private final List<Round> rounds;
	private Long id;
	private Player firstPlayer;

	private Player secondPlayer;

	public GameImpl(Long id) {
		this.rounds = new ArrayList<Round>();
		this.id = id;
	}

	public void addRound(Round r) {
		if (this.rounds.size() == 100)
			throw new ArrayIndexOutOfBoundsException(
					"Can not enter more than 100 rounds");
		this.rounds.add(r);
	}

	public int getWinner() {
		int total = 0;
		for (Round round : rounds) {
			total += round.getResult();
		}
		return total > 0 ? 1 : total < 0 ? -1 : 0;
	}

	public void setFirstPlayer(Player player) {
		beforSetPlayer(player);
		this.firstPlayer = player;
		afterSetPlayer();
	}

	public void setSecondPlayer(Player player) {
		beforSetPlayer(player);
		this.secondPlayer = player;
		afterSetPlayer();
	}

	private void beforSetPlayer(Player player) {
		if (player == null)
			throw new IllegalArgumentException();
	}

	private void afterSetPlayer() {
		if (firstPlayer != null && secondPlayer != null
				&& firstPlayer.compareTo(secondPlayer) == 0)
			throw new IllegalArgumentException(
					"can not accept a game with aplayer playes with him/her self");
	}

	public boolean isEqual() {
		return this.getWinner() == 0 ? true : false;
	}

	public Player getWinerPlayer() {
		if (isEqual())
			throw new RuntimeException(
					"Game result is equals, user isEqual() befor to check the result befor get ther result");
		return this.getWinner() == 1 ? firstPlayer : secondPlayer;
	}

	public Player getFirstPlayer() {
		return this.firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public Long getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Game #")
				.append(this.id)
				.append(", Between: [")
				.append(this.firstPlayer)
				.append("] and [")
				.append(this.secondPlayer)
				.append("]. number Of Round Untill now:")
				.append(this.rounds.size())
				.append(", Result unill Now [0: Equality,1: first player Wines, -1: Second player winds]:")
				.append(this.getWinner()).toString();
	}

	public int getRounds() {
		return this.rounds.size();
	}
}
