import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;
public class ScoreApp {

	public static void main(String[] args) throws Exception{
		// TODO 自動生成されたメソッド・スタブ
			Integer max=0;
			File old=new File("data.csv");
			File fnew=new File("data1.csv");
			old.renameTo(fnew);
		FileInputStream fis=new FileInputStream("data.csv");
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");
		BufferedReader br=new BufferedReader(isr);
		FileOutputStream fos=new FileOutputStream("data1.csv",true);
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		BufferedWriter bw=new BufferedWriter(osw);
		String line=br.readLine();
		System.out.println("****乱数ゲーム****");
		//fileyomikomi
		System.out.println(line);
		Scanner sc=new Scanner(System.in);
		while(true) {
			String ans;
			System.out.print("やりますかyes…y no…n>");
			ans=sc.next();
			if(ans.equals("n"))break;
			int	num=new Random().nextInt(100000);
			System.out.println(num);
			if(max<num) {
				System.out.println("highscore");
				max=num;
				//filekakikomi
			}
		}
		String str=max.toString();
		bw.write(str);
		
		bw.close();
		br.close();
	}

}
