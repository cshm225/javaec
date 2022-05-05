public class Player {
	int walknum=0;
	public void walkSum(int walk) {
		this.walknum+=walk;
	}
	public void showScore() {
		System.out.println("Score "+this.walknum);
	}
}
