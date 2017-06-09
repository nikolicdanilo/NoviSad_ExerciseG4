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
	@Test
	public void testScoreFrameWithBonus() {
		testFrame=new Frame(10,0);
		testFrame.setBonus(2);
		assertEquals(12,testFrame.scoreWithBonus());
		
	}
	@Test
	public void testAddFrame() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(4,3));
		
		assertEquals(1,testGame.getFrames().size());
		
	}
	@Test
	public void testGameScore() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(4,3));
		
		assertEquals(7,testGame.score());
		
	}
	@Test
	public void testGameMultipleFrameScore() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		
		assertEquals(14,testGame.score());	
	}
	@Test(expected=BowlingException.class)
	public void testGameAdd11Frame() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		
	}
	@Test
	public void testGameSpare() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(5,5));
		testGame.addFrame(new Frame(4,3));
		
		assertEquals(21,testGame.scoreWithBonus());	
	}
	@Test
	public void testGameStrike() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(4,3));
		
		assertEquals(24,testGame.scoreWithBonus());	
	}
	@Test
	public void testGameStrikeMultiple() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(4,3));
		
		assertEquals(48,testGame.scoreWithBonus());	
	}
	

}
