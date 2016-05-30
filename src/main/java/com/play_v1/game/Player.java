package com.play_v1.game;

/**
 * This class is used in {@link Game}, Each Player {@link #id} and {@link #name}<br/>
 * Player implements {@link Comparable} to be compared with another player. This
 * compare is necessary to check if player is not playing with him/her self.<br/>
 * 
 * DreamIT
 * 
 * @author maher
 *
 */
public class Player implements Comparable<Player> {
	private long id;
	private String name;

	public Player() {

	}

	public Player(long l, String string) {
		this.id = l;
		this.name = string;
	}

	/**
	 * Returns Player id
	 * 
	 * @return long
	 */
	public long getId() {
		return id;
	}

	/**
	 * Returns the player's name, it could be null
	 */
	public String getName() {
		return name;
	}

	/**
	 * Player is same when id and name are same
	 * 
	 * @return 0 that means equal, 99 if not
	 */
	public int compareTo(Player arg0) {
		if (this.id == arg0.id && this.name.equalsIgnoreCase(arg0.name))
			return 0;
		return 99;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Id:").append(id).append(", name:")
				.append(name).toString();
	}
}
