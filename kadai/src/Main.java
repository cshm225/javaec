
public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Maze maze=new Maze();
		Menu menu=new Menu();
		maze.allWall();
		maze.randomMap();
		maze.dig();
		maze.showMaze();
		menu.playermenu(maze);
	}

}
