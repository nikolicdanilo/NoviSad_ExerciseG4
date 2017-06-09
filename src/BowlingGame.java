import java.util.ArrayList;
import java.util.List;

// Before you commit and push write your student ID and finish time here.
// Finish time:
// Student ID:

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	// adds a frame to the game
	public void addFrame(Frame frame) throws BowlingException{
		if(frames.size()>=10){
			throw new BowlingException();
		}
		if(frame.getFirstThrow()+frame.getSecondThrow()>10){
			throw new BowlingException();
		}
		frames.add(frame);
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) throws BowlingException {
		//to be implemented
		if(frames.size()!=10){
			throw new BowlingException();
		}
		if(frames.get(frames.size()-1).isSpare()){
			if(secondThrow!=0 || firstThrow>10){
				throw new BowlingException();
			}
			frames.get(frames.size()-1).setBonus(firstThrow);
		}else if(frames.get(frames.size()-1).isStrike()){
			if(frames.get(frames.size()-2).isStrike()){
				frames.get(frames.size()-2).setBonus(10+firstThrow);
			}
			frames.get(frames.size()-1).setBonus(firstThrow+secondThrow);
		}
	}
	
	// Returns the game score
	public int score(){
		//to be implemented: should return game score 
		int score=0;
		for(int i=0;i<frames.size();i++){
			score+=frames.get(i).score();
		}
		return score;
	}

	public List<Frame> getFrames() {
		// TODO Auto-generated method stub
		return frames;
	}

	public int scoreWithBonus() {
		dodajBonuseFrejmovima();
		int score=0;
		for(int i=0;i<frames.size();i++){
			score+=frames.get(i).scoreWithBonus();
		}
		return score;
	}

	private void dodajBonuseFrejmovima() {
		for(int i=0;i<frames.size();i++){
			if(frames.get(i).isSpare() && i!=frames.size()-1){
				frames.get(i).setBonus(frames.get(i+1).getFirstThrow());
			}
			if(frames.get(i).isStrike()&& i!=frames.size()-1){
				if(frames.get(i+1).isStrike()){
					if(frames.size()-2!=i){
					frames.get(i).setBonus(frames.get(i+1).getFirstThrow()+frames.get(i+2).getFirstThrow());
					}
					
				}else{
				frames.get(i).setBonus(frames.get(i+1).getFirstThrow()+frames.get(i+1).getSecondThrow());
				}
			}
		}
		
		
	}
}
