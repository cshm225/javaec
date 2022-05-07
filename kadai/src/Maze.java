import java.util.Random;

public class Maze{
	final int SIZE=21;//マップの大きさ
	Random rnd=new Random();
	int h;//掘るときに見る方向をキメる変数
	int map[][]=new int[SIZE][SIZE];
	int x=0,y=0;//座標
	int px=0;int py=0;//プレイヤーの初期地点
	int gx=0,gy=0;//ゴール地点
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
			this.x=rnd.nextInt(SIZE-2)+1;
			this.y=rnd.nextInt(SIZE-2)+1;
			if(this.x%2!=0&&this.y%2!=0) {
				px=x;
				py=y;
				break;
			}
		}
		this.map[this.y][this.x]=0;
	}

	//迷路作成
	public void dig() {
		//0下(y++)1上(y--)2右(x++)3左(x--)
		h=rnd.nextInt(4);
		if(h==0&&isdigdownable()){
			this.map[this.y+1][this.x]=0;
			y++;
			dig();
		}
		if(h==1&&isdigupable()) {
			this.map[this.y-1][this.x]=0;
			y--;
			dig();
		}
		if(h==2&&isdigrightable()||isdigrightable()) {
			this.map[this.y][this.x+1]=0;
			x++;
			dig();
		}
		if(h==3&&isdigleftable()||isdigleftable()) {
			this.map[this.y][this.x-1]=0;
			x--;
			dig();
		}
		if(isdigleftable()||isdigupable()||isdigdownable()||isdigrightable()) {
			dig();
		}
		if(isdig()) {
			dig();
		}
		gx=x;
		gy=y;
		return;


	}
	//今のところから4方を見て掘れるかの判定
	public boolean isdigdownable() {//下(y++)
		if(this.y+2<SIZE&&this.y+1<SIZE&&this.x+1<SIZE&&this.x-1>-1) {
			if(this.map[y+2][x]==1&&this.map[y+1][x]==1) {
				if(this.map[y+1][x+1]==1&&this.map[y+1][x-1]==1) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean isdigupable() {//上(y--)
		if(this.y-2>-1&&this.y+1<SIZE&&this.x+1<SIZE&&this.x-1>-1) {
			if(this.map[y-2][x]==1&&this.map[y-1][x]==1) {
				if(this.map[y-1][x+1]==1&&this.map[y-1][x-1]==1) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean isdigrightable() {//右(x++)
		if(this.x+2<SIZE&&this.y+1<SIZE&&this.x+1<SIZE&&this.x-1>-1) {
			if(this.map[y][x+2]==1&&this.map[y][x+1]==1) {
				if(this.map[y+1][x+1]==1&&this.map[y-1][x+1]==1) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean isdigleftable() {//左(x--)
		if(this.x-2>-1&&this.y+1<SIZE&&this.x+1<SIZE&&this.x-1>-1) {
			if(this.map[y][x-2]==1&&this.map[y][x-1]==1) {
				if(this.map[y+1][x-1]==1&&this.map[y-1][x-1]==1) {
					return true;
				}
			}
		}
		return false;
	}

	//まだ掘れるか判定
	public boolean isdig() {
		while(true) {
			x=rnd.nextInt(19)+1;
			y=rnd.nextInt(19)+1;
			if(this.map[y][x]==0&&this.map[y-1][x]==1||this.map[y][x]==0&&this.map[y+1][x]==1||this.map[y][x]==0&&this.map[y][x-1]==1||this.map[y][x]==0&&this.map[y][x+1]==1) {
				break;
			}

		}
		if(this.map[y][x]==0&&this.map[y+1][x]==1&&isdigdownable()) {
			h=0;
			return true;
		}
		if(this.map[y][x]==0&&this.map[y][x-1]==1&&isdigleftable()) {
			h=3;
			return true;
		}
		if(this.map[y][x]==0&&this.map[y-1][x]==1&&isdigupable()) {
			h=1;
			return true;
		}
		if(this.map[y][x]==0&&this.map[y][x+1]==1&&isdigrightable()) {
			h=2;
			return true;
		}
		return false;
	}

	//迷路表示
	public void showMaze() {
		for(int i=0;i<this.map.length;i++) {
			for(int j=0;j<this.map[i].length;j++) {
				if(i==py&&j==px) {
					System.out.print("PP");
				}else if(i==gy&&j==gx){
					System.out.print("GG");
				}else {
					System.out.print(map[i][j]==0?"  ":"##");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
