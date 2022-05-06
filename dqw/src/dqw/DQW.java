package dqw;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DQW {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		final Scanner SC=new Scanner(System.in);
		Map<Card,Integer> cards=new LinkedHashMap<>(){
			{
				put(new Card('S',3,240),0);
				put(new Card('A',5,48),0);
				put(new Card('B',10,12),0);
				put(new Card('C',30,3),0);
				put(new Card('D',52,1),0);
			}
		};
		System.out.println("---合成シミュレーター---");
		while(true) {
			showMenu();
			int select=SC.nextInt();
			switch(select) {
			case 0:
				Card c =drawCard(cards);
				System.out.println(c.rank+"がでました");
				cards.put(c,cards.get(c)+1);
				showCards(cards);
				break;
			case 1:
				synthesizeCards(cards);
				System.out.println("合成しました");
				showCards(cards);
				break;
			case 2:
				System.out.println("カードを任意枚数にセットします");
				System.out.println("0,2,1,3,4 のように");
				System.out.println("カンマ区切りでS,A,B,C,Dの枚数を入力してください");
				System.out.print(">>");
				String numarr[]=SC.next().split(",");
				int[] cardcounts=new int[numarr.length];
				for(int i=0;i<numarr.length;i++) {
					cardcounts[i]=Integer.parseInt(numarr[i]);

				}
				setCards(cards,cardcounts);
				System.out.println("セットしました。");
				showCards(cards); 
			case 3:
				System.out.println("現在の状況からSが指定枚数できるまでの回数をシミュレーションします");
				System.out.print("Sの必要枚数を入力>>");
				int sCount=SC.nextInt();
				 System.out.print("シミュレーション回数を入力>>");
			       int tryCount=SC.nextInt();
				simulator(cards,sCount,tryCount);
				break;
				default:
					System.out.println("end");
					return;
				
			}
		}
	}
	 static void showMenu(){
		    final String[] MENU={"カードを引く","カードを合成する","カードをセットする","シミュレーションする","終了"};
		    for(int i=0;i<MENU.length;i++){
		      System.out.printf("%d:%s%n",i,MENU[i]);
		    }
		    System.out.print(">>");
		  }
	static  void showCards(Map<Card,Integer> cards) {
		for(Card c :cards.keySet()) {
			System.out.printf("%s(%d)", c.rank,cards.get(c));

		}
	}
	static Card drawCard(Map<Card,Integer> cards) {
		Card card=null;
		int n=(int)(Math.random()*100);
		for(Card c:cards.keySet()) {
			if(n-c.ratio<0) {
				card=c;
				break;
			}
			n-=c.ratio;
		}
		return card;
	}
	static void synthesizeCards(Map<Card,Integer> cards) {
		int totalpoint=0;
		for(Card c:cards.keySet()) {
			totalpoint+=c.point*cards.get(c);
		}
		for(Card c:cards.keySet()) {
			cards.put(c, totalpoint/c.point);
			totalpoint=totalpoint%c.point;
		}
	}
	static void setCards(Map<Card,Integer> cards,int[] cardcounts) {
		int idx=0;
		for(Card c:cards.keySet()) {
			cards.put(c, cardcounts[idx++]);
		}
	}
	
	static void simulator(Map<Card,Integer> cards,int sCount,int tryCount){
		int nowPoint=0;
		for(Card c:cards.keySet()) {
			nowPoint+=c.point*cards.get(c);
		}
		if(nowPoint>=sCount*240) {
			System.out.println("カードを引く必要はありません");
			return;
		}
		Map<Integer,Integer> result=new TreeMap<>();
		for(int i=0;i<tryCount;i++) {
			int count=0;
			int tempPoint=nowPoint;
			while(tempPoint<sCount*240) {
				count++;
				Card card=drawCard(cards);
				tempPoint+=card.point;
			}
			if(result.containsKey(count)) {
				result.put(count, result.get(count)+1);
			}else {
				result.put(count, 1);
			}
		}
		int total=0;
		for(int key:result.keySet()) {
			System.out.printf("%3d(%3d):",key, result.get(key));
			total+=key*result.get(key);
			for(int i=0;i<result.get(key);i++){
				System.out.print("*");
			}
			System.out.println();

		}
		System.out.printf("平均:%.1f回%n",total/(double)tryCount);
	}
}

class Card{
	Character rank;
	int ratio;
	int point;
	Card(Character rank,int ratio,int point){
		this.ratio=ratio;
		this.rank=rank;
		this.point=point;
	}
}