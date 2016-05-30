package com.play_v1.game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.play_v1.TestPreperation;
import com.play_v1.game.Choice;
import com.play_v1.tools.ChoiceEnum;

public class ChoiceTest {
	private TestPreperation testPreperation;

	@Before
	public void initTest() {
		testPreperation = new TestPreperation();
	}

	@Test
	public void testCompareChoices() {
		Choice[] choicesPossible = new Choice[] { new Choice(ChoiceEnum.PAPER),
				new Choice(ChoiceEnum.STONE), new Choice(ChoiceEnum.SCISSOR) };
		for (int i = 0; i < choicesPossible.length; i++) {
			Choice choice1 = choicesPossible[i];
			for (int j = 0; j < choicesPossible.length; j++) {
				Choice choice2 = choicesPossible[j];
				assertEquals(choice1.compareTo(choice2),
						testPreperation.getExcpectedResult(choice1.getValue(),
								choice2.getValue()));
			}
		}
		
		//Old Test Code
		// Choice paperChoice = new Choice(ChoiceEnum.PAPER);
		// Choice stoneChoice = new Choice(ChoiceEnum.STONE);
		// Choice scissorChoice = new Choice(ChoiceEnum.SCISSOR);
		// // paper wins against stone
		// assertEquals(paperChoice.compareTo(stoneChoice), 1);
		// // paper looses against scissor
		// assertEquals(paperChoice.compareTo(scissorChoice), -1);
		// // paper equals with paper
		// assertEquals(paperChoice.compareTo(paperChoice), 0);
		//
		// // stone equals with stone
		// assertEquals(stoneChoice.compareTo(stoneChoice), 0);
		// // stone wines against scissor
		// assertEquals(stoneChoice.compareTo(scissorChoice), 1);
		// // stone looses against paper
		// assertEquals(stoneChoice.compareTo(paperChoice), -1);
		//
		// // scissor looses against stone
		// assertEquals(scissorChoice.compareTo(stoneChoice), -1);
		// // scissor equals against scissor
		// assertEquals(scissorChoice.compareTo(scissorChoice), 0);
		// // scissor wins against paper
		// assertEquals(scissorChoice.compareTo(paperChoice), 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidChoiceBuilding() {
		new Choice(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidCompareWithNull() {
		Choice scissorChoice = new Choice(ChoiceEnum.SCISSOR);
		// paper wins against stone
		assertEquals(scissorChoice.compareTo(null), 1);
	}
}
