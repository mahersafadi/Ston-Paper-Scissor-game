package com.play_v1.game;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.play_v1.game.impl.GameImpl;
import com.play_v1.tools.ChoiceEnum;

@RunWith(Parameterized.class)
public class GameTest {
	private final int expectedWinner;
	private final Game game;
	
	public GameTest(Set<Round> rounds, int expectedWinner) {
		this.expectedWinner = expectedWinner;
		game = new GameImpl(1L);
		game.setFirstPlayer(new Player(1L, "TestPlayer1"));
		game.setSecondPlayer(new Player(2L, "TestPlayer2"));
		for (Round r : rounds)
			game.addRound(r);
	}
	
	@Test
	public void checkTheWinner(){
		assertEquals(game.getWinner(), expectedWinner);
		if(!game.isEqual()){
			System.out.println(game.getWinerPlayer() + " wins");
			if(game.getWinner() ==1)
				assertEquals(game.getWinerPlayer().getId(), game.getFirstPlayer().getId());
			else
				assertEquals(game.getWinerPlayer().getId(), game.getSecondPlayer().getId());
		}
		else{
			System.out.println("Game finied with equality between the players");
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] { { new HashSet<Round>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new Round(new Choice(ChoiceEnum.PAPER), new Choice(
						ChoiceEnum.STONE)));// 1-0
				add(new Round(new Choice(ChoiceEnum.PAPER), new Choice(
						ChoiceEnum.SCISSOR)));// 0-1
				add(new Round(new Choice(ChoiceEnum.STONE), new Choice(
						ChoiceEnum.STONE)));// 0-0
				add(new Round(new Choice(ChoiceEnum.PAPER), new Choice(
						ChoiceEnum.STONE)));// 1-0
				add(new Round(new Choice(ChoiceEnum.STONE), new Choice(
						ChoiceEnum.SCISSOR)));// 1-0
			}
		}, 1 }, { new HashSet<Round>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 2L;

			{
				add(new Round(new Choice(ChoiceEnum.SCISSOR), new Choice(
						ChoiceEnum.STONE)));// 0-1
				add(new Round(new Choice(ChoiceEnum.PAPER), new Choice(
						ChoiceEnum.PAPER)));// 0-0
				add(new Round(new Choice(ChoiceEnum.STONE), new Choice(
						ChoiceEnum.PAPER)));// 0-1
				add(new Round(new Choice(ChoiceEnum.PAPER), new Choice(
						ChoiceEnum.STONE)));// 1-0
				add(new Round(new Choice(ChoiceEnum.SCISSOR), new Choice(
						ChoiceEnum.STONE)));// 0-1
			}
		}, -1 }, { new HashSet<Round>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3L;

			{
				add(new Round(new Choice(ChoiceEnum.SCISSOR), new Choice(
						ChoiceEnum.STONE)));// 0-1
				add(new Round(new Choice(ChoiceEnum.PAPER), new Choice(
						ChoiceEnum.PAPER)));// 0-0
				add(new Round(new Choice(ChoiceEnum.STONE), new Choice(
						ChoiceEnum.PAPER)));// 0-1
				add(new Round(new Choice(ChoiceEnum.PAPER), new Choice(
						ChoiceEnum.STONE)));// 1-0
				add(new Round(new Choice(ChoiceEnum.STONE), new Choice(
						ChoiceEnum.SCISSOR)));// 1-0
			}
		}, 0 } });
	}
}
