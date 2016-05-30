package com.play_v1.tools;

import static org.junit.Assert.*;
import org.junit.Test;


public class ChoiceEnumTest {
	@Test
	public void testChoiceEnumValues() {
		int stone = 1, paper = 2, scissor = 3;
		assertEquals(stone, ChoiceEnum.STONE.value());
		assertEquals(paper, ChoiceEnum.PAPER.value());
		assertEquals(scissor, ChoiceEnum.SCISSOR.value());
	}
	
	@Test
	public void testValidConversionFromIntToEnum(){
		int stone = 1, paper = 2, scissor = 3;
		ChoiceEnum choice = ChoiceEnum.fromInt(stone);
		assertEquals(choice.value(), ChoiceEnum.STONE.value());
		choice = ChoiceEnum.fromInt(paper);
		assertEquals(choice.value(), ChoiceEnum.PAPER.value());
		choice = ChoiceEnum.fromInt(scissor);
		assertEquals(choice.value(), ChoiceEnum.SCISSOR.value());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidConversionFromIntToEnum(){
		int invalidNumber = 999;
		ChoiceEnum.fromInt(invalidNumber);
	}
}
