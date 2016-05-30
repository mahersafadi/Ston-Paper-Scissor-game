package com.play_v1;

import java.util.HashSet;
import java.util.Set;

import com.play_v1.tools.ChoiceEnum;

/**
 * This is a test database, which is a list rows, each row contains choice1 and
 * choice2 and the correct result<br/>
 * if same choice then expected result is 0<br/>
 * if choice 1 is stronger than choice 2 then the expected result is 1<br/>
 * if choice 1 is weaker than choice 2 then the expected result is -1<br/>
 * <br/>
 * DreamIT
 * @author maher
 *
 */
public class TestPreperation {
	Set<TestRecord> set;

	public TestPreperation() {
		set = new HashSet<TestPreperation.TestRecord>();
		// stone equals stone --> 0
		set.add(new TestRecord(ChoiceEnum.STONE, ChoiceEnum.STONE, 0));
		// stone is weaker than paper --> -1
		set.add(new TestRecord(ChoiceEnum.STONE, ChoiceEnum.PAPER, -1));
		// stone is stronger than scissor --> 1
		set.add(new TestRecord(ChoiceEnum.STONE, ChoiceEnum.SCISSOR, 1));

		// paper is stronger than stone --> 1
		set.add(new TestRecord(ChoiceEnum.PAPER, ChoiceEnum.STONE, 1));
		// paper is equals paper --> 0
		set.add(new TestRecord(ChoiceEnum.PAPER, ChoiceEnum.PAPER, 0));
		// paper is weaker than scissor --> -1
		set.add(new TestRecord(ChoiceEnum.PAPER, ChoiceEnum.SCISSOR, -1));

		// scissor is weaker than stone --> -1
		set.add(new TestRecord(ChoiceEnum.SCISSOR, ChoiceEnum.STONE, -1));
		// scissor is stronger than paper --> 1
		set.add(new TestRecord(ChoiceEnum.SCISSOR, ChoiceEnum.PAPER, 1));
		// scissor equals scissor --> 0
		set.add(new TestRecord(ChoiceEnum.SCISSOR, ChoiceEnum.SCISSOR, 0));
	}

	public Set<TestRecord> getTestingSet() {
		return set;
	}

	public int getExcpectedResult(int val1, int val2) {
		for (TestRecord testRecord : this.set) {
			if (testRecord.getP1().value() == val1
					&& testRecord.getP2().value() == val2)
				return testRecord.getWinner();
		}
		throw new IndexOutOfBoundsException("Could not find the passed values "
				+ val1 + ", " + val2 + " in the set");
	}

	public static class TestRecord {
		public TestRecord(ChoiceEnum p1, ChoiceEnum p2, int winner) {
			this.p1 = p1;
			this.p2 = p2;
			this.winner = winner;
		}

		private ChoiceEnum p1;
		private ChoiceEnum p2;
		private int winner;// 1: p1, 2: p2, 0: equal

		public ChoiceEnum getP1() {
			return p1;
		}

		public ChoiceEnum getP2() {
			return p2;
		}

		public int getWinner() {
			return winner;
		}
	}
}
