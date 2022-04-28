

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionLesson {

	public static void main(String[] args) {

		FileWriter fw=null;
		try {
			fw=new FileWriter("data.txt");
			fw.write("hello");
		}catch(Exception e){
			System.out.println("何らかの例外発生");
		}finally {
			if(fw!=null) {
				try {
					fw.close();
				}catch(IOException e) {
					;
				}
			}
		}
		try(FileWriter fw2=new FileWriter("data.txt");){
			fw2.write("hello2");
		}catch(Exception e) {
			System.out.println("何らかの例外が発生");

		}
		try {
			String s=null;
			System.out.println(s.length());
		} catch (NullPointerException e) {
			System.out.println("キャッチ");
			// TODO 自動生成された catch ブロック
			System.out.println("--スタックトレース--");
			e.printStackTrace();
			System.out.println("--スタックトレース--");
			
		}
		
		try {
			int num=Integer.parseInt("三");
		} catch (NumberFormatException e) {
			System.out.println("変化負荷");
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}		
	}
		static void sleep() throws Exception {
			Thread.sleep(3000);
		}

	}

