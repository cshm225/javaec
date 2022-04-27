
public class Lex {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String s="Java";
		if(s.matches("Java")) {
			System.out.println("true");

		}
		if(s.matches("J.va")) {
			System.out.println("true1");
		}
		if("Jaaaaaaaaaaavaa".matches("Ja*va")) {
			System.out.println("true2");
		}
		if("あいうxx019".matches(".*")) {
			System.out.println("true3");
		}
		if("urf".matches("[a-z] {3}" )) {
			System.out.println("true4");
		}
		s="ada,lkbj:fldj";
		String data[]=s.split("[,:]");
		for(String w:data) {
			System.out.print(w+"->");
		}
		System.out.println();
		String w=s.replaceAll("[beh]","X");
		System.out.println(w);
		Method(3,5,7,9);
		System.out.println(sumOf(1,3,4));


	}
	public static int sumOf(int...nums ) {
		int sum=0;
		for(int i:nums) {
			sum+=i;
		}
		return sum;
	}
	public static void Method(int... args) {
		for(int i:args) {
			System.out.println(i);
		}
	}
}
