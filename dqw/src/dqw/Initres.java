package dqw;

public class Initres {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new ClassB();
	}

}
class classA{
	static {
		System.out.println("A static init");

	}
	{
		System.out.println("A instance init");

	}
	classA(){
		System.out.println("A construct init");
	}
}
class ClassB extends classA{
	static {
		System.out.println("B static init");

	}
	{
		System.out.println("B instance init");

	}
	ClassB(){
		super();
		System.out.println("B construct init");
	}
}
