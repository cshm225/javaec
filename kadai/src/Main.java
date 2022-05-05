
public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Maze maze=new Maze();
		maze.allWall();
		maze.randomMap();
		System.out.println(maze.x+" "+maze.y);
		maze.dig();
		//maze.showMaze();
	}

}
