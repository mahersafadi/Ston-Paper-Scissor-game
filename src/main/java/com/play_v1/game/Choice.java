package com.play_v1.game;

import com.play_v1.tools.ChoiceEnum;

/**
 * This class represents the player choice, this choice is represented in a
 * number inside this class, it implements {@link Comparable} to be compared
 * with other player choice.<br/>
 * Its constructor accepts a {@link ChoiceEnum} object as data member to avoid
 * passing unwanted values The result of comparing is either :<br/>
 * 1: means the current instance of {@link Choice} is stronger than the passed
 * choice<br/>
 * -1: means the current instance of {@link Choice} is weaker than the passed
 * choice<br/>
 * 0: means the current instance of {@link Choice} equals the passed choice<br/>
 * 
 * During creation, if the {@link ChoiceEnum} object passed as null then
 * {@link IllegalArgumentException} is raised <br/>
 * 
 * DreamIt
 * @author maher.safadi@gmail.com
 *
 */
public final class Choice implements Comparable<Choice> {
	private final Integer value;

	public Choice(ChoiceEnum choice) {
		if (choice == null)
			throw new IllegalArgumentException();

		this.value = choice.value();
	}

	public Integer getValue() {
		return value;
	}

	/**
	 * @return 1: the left part (the current) wins and the passed choice loose<br/>
	 *         0: equals left part (the current object) and right part (the
	 *         passed object) are same choice<br/>
	 *         -1: the left part (the current) looses and the passed choice wins<br/>
	 */
	public int compareTo(Choice o) {
		if (o == null || !(o instanceof Choice))
			throw new IllegalArgumentException();
		ChoiceEnum current = ChoiceEnum.fromInt(this.getValue());
		ChoiceEnum parameter = ChoiceEnum.fromInt(o.getValue());
		if (current.value() - parameter.value() == 0)
			return 0;
		else {
			if (current == ChoiceEnum.STONE) {
				if (parameter == ChoiceEnum.PAPER)
					return -1;
				else
					// it must be stone and scissor
					return 1;
			}
			if (current == ChoiceEnum.PAPER) {
				if (parameter == ChoiceEnum.STONE)
					return 1;
				else
					// it must be paper and scissor
					return -1;
			}
			if (current == ChoiceEnum.SCISSOR) {
				if (parameter == ChoiceEnum.STONE)
					return -1;
				else
					// it must be scissor and paper
					return 1;
			}
		}
		return 0;
	}
}