import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {
	BowlingGame testGame;
	Frame testFrame;
	@Test
	public void testFrameScore() {
		testFrame=new Frame(2,3);
		assertEquals(5,testFrame.score());
	}
	@Test
	public void testStrike() {
		testFrame=new Frame(10,0);
		assertTrue(testFrame.isStrike());
		
	}
	@Test
	public void testSpare() {
		testFrame=new Frame(5,5);
		assertTrue(testFrame.isSpare());
		
	}
	@Test
	public void testSpareForStrike() {
		testFrame=new Frame(10,0);
		assertFalse(testFrame.isSpare());
		
	}

}
