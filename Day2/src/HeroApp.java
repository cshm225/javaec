
public class HeroApp {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Hero h1=new Hero("ロト",100);
		Hero h2=new Hero("ロト",200);
		Hero h3=new Hero("ト",100);
		if(h1!=h2) {
			System.out.println("同値ではありません");
		}
		if(h1.equals(h2)) {
			System.out.println("同価");
		}
		if(!h1.equals(h3)) {
			System.out.println("同価ではありません");
		}
	}

}
