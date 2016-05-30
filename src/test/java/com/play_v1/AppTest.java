package com.play_v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.play_v1.container.TestFinishAgame;
import com.play_v1.container.TestPlayingService;
import com.play_v1.container.TestPlayingServiceOver100ItemForMultiThreading;
import com.play_v1.container.TestPlayingServiceOver100ItemForSingleThread;
import com.play_v1.game.ChoiceTest;
import com.play_v1.game.GameTest;
import com.play_v1.game.InvalidPlayersToGame;
import com.play_v1.game.PlayerTest;
import com.play_v1.game.RoundTest;
import com.play_v1.tools.ChoiceEnumTest;

/**
 * Unit test for simple App.
 */
@RunWith(Suite.class)
@SuiteClasses({ ChoiceEnumTest.class, ChoiceTest.class, RoundTest.class,
		GameTest.class, PlayerTest.class, InvalidPlayersToGame.class,
		TestPlayingService.class,
		TestFinishAgame.class,
		TestPlayingServiceOver100ItemForSingleThread.class,
		TestPlayingServiceOver100ItemForMultiThreading.class})
public class AppTest {
}
