import java.util.Scanner;

public class Menu {
	public void rule(){
		System.out.printf("ゴールを目指すアプリです!\n『★』はプレイヤーで『G』がゴールです。\nスタート地点はプレイヤーの初期地点です。\n");
	}
	public void showMap(Maze maze) {
		maze.show();
	}
	public void playermenu(Maze maze) {
		while(true) {
			System.out.println("|0...進みます       |");
			System.out.println("|1...ルール表示    |");
			System.out.println("|2...マップ表示    |");
			System.out.println("|3...終了します    |");
			System.out.print("番号を入力>>");
			String num=new Scanner(System.in).nextLine();
			if(num.equals("3"))break;
			if(num.equals("1")) {
				this.rule();
			}
			if(num.equals("2")) {
				this.showMap(maze);
			}
			if(num.equals("0")) {
				//進みたい方向と入力された歩数をmapとプレイヤーに反映させる。
			}

		}
	}
}
