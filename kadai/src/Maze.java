import java.util.Random;

public class Maze{
	int h=0;
	Random rnd=new Random();
	int map[][]=new int[21][21];
	int x=0,y=0;//座標
	int sx=0;int sy=0;
	//初期化 1を壁0を道
	public void allWall() {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				map[i][j]=1;
			}
		}
	}

	//初期地点をランダムでキメる(x,y両方奇数);
	public void randomMap() {
		while(true) {
			this.x=rnd.nextInt(19)+1;
			this.y=rnd.nextInt(19)+1;
			if(this.x%2!=0&&this.y%2!=0) {
				sx=x;
				sy=y;
				break;
			}
		}
		this.map[this.y][this.x]=0;
		showMaze();
	}

	//迷路作成
	public void dig() {
		//0うえ1した2右3左
		h=rnd.nextInt(4);
			if(h==0&&y+2<20&&this.map[y+2][x]==1) {
				this.map[this.y+1][this.x]=0;
				y++;
				showMaze();
				dig();

			}
			if(h==1&&y-2>0&&this.map[y-2][x]==1&&this.map[y][x-1]==1) {
				this.map[this.y-1][this.x]=0;
				y--;
				showMaze();
				dig();

			}
			if(h==2&&x+2<20&&this.map[y][x+2]==1) {
				this.map[this.y][this.x+1]=0;
				x++;
				showMaze();
				dig();
			}
			if(h==3&&x-2>0&&this.map[y][x-2]==1) {
				this.map[this.y][this.x-1]=0;
				x--;
				showMaze();
				dig();
			}else if(isdig()) {
				dig();
		}else {
			return;
		}

	}

	//まだ掘れるか判定
	public boolean isdig() {
		for(this.y=1;this.y<map.length;this.y+=2) {
			for(this.x=1;this.x<map[this.y].length;this.x+=2) {
				if(this.map[y][x]==0&&this.y+2<20&&map[this.y+2][this.x]==0||this.map[y][x]==0&&this.y-2>0&&map[this.y-2][this.x]==0||this.map[y][x]==0&&this.x+2<20&&map[this.y][this.x+2]==0||this.map[y][x]==0&&this.x-2>0&&map[this.y][this.x-2]==0) {
					return true;
				}
			}
		}
		return false;
	}

	//迷路表示
	public void showMaze() {
		for(int i=0;i<this.map.length;i++) {
			for(int j=0;j<this.map[i].length;j++) {

				System.out.print(map[i][j]==0?"  ":"##");
			}
			System.out.println();
		}
		System.out.println();
	}


}
