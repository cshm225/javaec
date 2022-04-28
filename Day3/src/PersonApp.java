import java.util.Scanner;

public class PersonApp {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Person p=new Person();
		
		try {
			p.setAge(-1);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			System.out.println(e.getMessage());
		}
		System.out.print("ファイル");
		String msg=new Scanner(System.in).nextLine();
		try {
			checkFormat(msg);
		} catch (UnsupportedMusicFileException e) {
			// TODO 自動生成された catch ブロック
			System.out.println(e.getMessage());
		}
		
	}
	static void checkFormat(String fileName) throws UnsupportedMusicFileException {
		String params[]=fileName.split("\\.");
		String est=params[params.length-1];
		if(!est.equals("mp3")) {
			throw new UnsupportedMusicFileException("mp3dehanai");
		}
	}
}
class Person{
	int age;
	public void setAge(int age) {
		if(age<0) {
			throw new IllegalArgumentException("不正");
		}
		this.age=age;
	}
}