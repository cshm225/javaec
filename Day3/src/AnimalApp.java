import java.util.ArrayList;
import java.util.List;

public class AnimalApp {


	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		List<Animal> list=new ArrayList<>();
		list.add(new Dog("A"));
		list.add(new Cat("B"));
		list.add(new Pig("C"));
		list.add(new Pigeon("D"));
		list.add(new Eagle("E"));
		for(Animal a:list) {
			a.introduce();
			a.makeNoise();
			if(a instanceof Cat) {
				((Cat) a).sleep();
			}
			if(a instanceof Flyable) {
				((Flyable) a).Fly();
			}
		}
	}

}
