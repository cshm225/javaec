import java.util.Scanner;

public class Menu {
	Scanner sc=new Scanner(System.in);
	String num;
	public void rule(){
		System.out.printf("ゴールを目指すアプリです!\n PP はプレイヤーで GG がゴールです。\nスタート地点はプレイヤーの初期地点です。\n## は壁です。\n\n");
	}
	public void showMap(Maze maze) {
		maze.showMaze();
	}
	public void playermenu(Maze maze) {
		while(true) {
			System.out.println("|0...進みます      |");
			System.out.println("|1...ルール表示    |");
			System.out.println("|2...マップ表示    |");
			System.out.println("|3...終了します    |");
			System.out.print("番号を入力>>");
			num=sc.nextLine();
			System.out.println();
			if(num.equals("3"))break;
			if(num.equals("1")) {
				this.rule();
			}
			if(num.equals("2")) {
				this.showMap(maze);
			}
			if(num.equals("0")) {
				//進みたい方向と入力された歩数をmapに反映させる。
				this.walkmenu(maze);
			}
		if(maze.px==maze.gx&&maze.py==maze.gy) {
			System.out.println("clear~");
			return;
		}
		}
	}
	public void walkmenu(Maze maze) {
		int select,walk=0;
		while(true) {
			System.out.println("|0...上|");
			System.out.println("|1...下|");
			System.out.println("|2...右|");
			System.out.println("|3...左|");
			System.out.print("進みたい方向の番号を入力>>");
			select=sc.nextInt();
			if(select<4&&select>-1)break;
		}
		while(true) {
			int i=0,count=0;
			while(true) {
				System.out.print("進む歩数を入力(5歩まで)>>");
				walk=sc.nextInt();sc.nextLine();
				System.out.println();
				if(walk<6&&walk>-1) break;
			}
			if(select==0) {
				for(i=1;i<walk+1;i++) {
					if(maze.map[maze.py-i][maze.px]==1) {
						System.out.println("不正です。やり直してください");
						//walkmenu(maze);
					}else {
						count++;
					}
				}
				if(i==walk+1&&count==walk) {
					maze.py-=walk;
					break;
				}
			}
			if(select==1) {
				for(i=1;i<walk+1;i++) {
					if(maze.map[maze.py+i][maze.px]==1) {
						System.out.println("不正です。やり直してください");
						//walkmenu(maze);
					}else {
						count++;
					}
				}
				if(i==walk+1&&count==walk) {
					maze.py+=walk;
					break;
				}
			}
			if(select==2) {
				for(i=1;i<walk+1;i++) {
					if(maze.map[maze.py][maze.px+i]==1) {
						System.out.println("不正です。やり直してください");
						//walkmenu(maze);
					}else {
						count++;
					}
				}
				if(i==walk+1&&count==walk) {
					maze.px+=walk;
					break;
				}
			}
			if(select==3) {
				for(i=1;i<walk+1;i++) {
					if(maze.map[maze.py][maze.px-i]==1) {
						System.out.println("不正です。やり直してください");
						//walkmenu(maze);
					}else {
						count++;
					}
				}
				if(i==walk+1&&count==walk) {
					maze.px-=walk;
					break;
				}
			}
		}
		this.showMap(maze);
	}
}
