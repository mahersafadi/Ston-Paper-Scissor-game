package com.play_v1.game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.play_v1.TestPreperation;
import com.play_v1.tools.ChoiceEnum;

public class RoundTest {
	private TestPreperation testPreperation;

	@Before
	public void initTest() {
		testPreperation = new TestPreperation();
	}

	@Test
	public void testRoundRessult() {
		Choice[] choicesPossible = new Choice[] { new Choice(ChoiceEnum.PAPER),
				new Choice(ChoiceEnum.STONE), new Choice(ChoiceEnum.SCISSOR) };
		for (int i = 0; i < choicesPossible.length; i++) {
			Choice choice1 = choicesPossible[i];
			for (int j = 0; j < choicesPossible.length; j++) {
				Choice choice2 = choicesPossible[j];
				Round r = new Round(choice1, choice2);
				assertEquals(r.getResult(), testPreperation.getExcpectedResult(
						choice1.getValue(), choice2.getValue()));
			}
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPassInvalidItems(){
		new Round(null, null);
	}
}
