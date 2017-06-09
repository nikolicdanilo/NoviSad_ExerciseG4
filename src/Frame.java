public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int bonus;
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		bonus=0;
	}
	
	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	//returns the score of a single frame
	public int score(){
		//to be implemented
		return firstThrow+secondThrow;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		if(firstThrow==10){
			return true;
		}else{
			return false;
		}
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		if(firstThrow+secondThrow==10 && !isStrike()){
			return true;
		}else{
			return false;
		}
	}

	public int scoreWithBonus() {
		// TODO Auto-generated method stub
		return score()+bonus;
	}

	public void setBonus(int i) {
		// TODO Auto-generated method stub
		bonus=i;
	}
}
