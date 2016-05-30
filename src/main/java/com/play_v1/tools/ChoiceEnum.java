package com.play_v1.tools;

/**
 * This enum is responsible about holding the values of states<br/>
 * 1: represents stone state<br/>
 * 2: represents paper state<br/>
 * 3: represents scissor state<br/>
 * DreamIT
 * @author maher
 */
public enum ChoiceEnum {
	STONE(1), PAPER(2), SCISSOR(3);
	private final int val;

	private ChoiceEnum(int val) {
		this.val = val;
	}

	public int value() {
		return this.val;
	}

	public static ChoiceEnum fromInt(int choiceNum) {
		for(ChoiceEnum current : ChoiceEnum.values())
			if(current.val == choiceNum)
				return current;
		throw new IllegalArgumentException(String.valueOf(choiceNum));
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.val);
	}
}
