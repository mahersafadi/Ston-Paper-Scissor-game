package com.play_v1.tools;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Each game in the application has its own number and game is handled based on
 * this number, cause application is built to handle more than one application
 * in the same time.
 * 
 * DreamIT
 * 
 * @author maher
 */
public class GameIdGenerator {
	private AtomicLong atomicLong = new AtomicLong();

	public GameIdGenerator() {
	}

	/*
	 * return a unique id, cause it is in-memory application then id starts from
	 * 1 each time.
	 */
	public Long getId() {
		return atomicLong.incrementAndGet();
	}
}
