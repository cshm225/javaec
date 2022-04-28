
public abstract class Animal {
	String name;
	Animal(String name){
		this.name=name;
	}
	public void introduce() {
		System.out.println("こんにちわ"+this.name);

	}
	abstract void makeNoise();

}
