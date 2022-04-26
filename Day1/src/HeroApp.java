
public class HeroApp {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Hero h=new Hero(100,"A");
		Wand wand=new Wand(10,"tue");
		Wizard w=new Wizard(50,20,"Baa",wand);
		w.heal(h);
		System.out.println(h);
	}

}
