import java.util.Calendar;
import java.util.Date;


public class TimeLesson {
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		String str="java";
		for(int i=0;i<10000;i++) {
			str+="Java";
		}
		long end=System.currentTimeMillis();
		System.out.println("time"+(end-start));
		start=System.currentTimeMillis();
		StringBuilder sb=new StringBuilder("Java");
		for(int i=0;i<10000000;i++) {
			sb.append("Java");
		}
		String s=sb.toString();
		end=System.currentTimeMillis();
		System.out.println("time"+(end-start));
		
		Date now=new Date();
		System.out.println(now);
		System.out.println(now.getTime());
		
		Calendar c=Calendar.getInstance();
		c.set(2019,8,22,1,23,45);
		c.set(Calendar.MONTH,9);
		Date d=c.getTime();
		System.out.println(d);
		now=new Date();
		c.setTime(now);
		int y=c.get(Calendar.YEAR);
		System.out.println("いまは"+y);
		
	}
}

