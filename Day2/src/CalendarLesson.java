import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class CalendarLesson {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Date now=new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(now);
		int day=c.get(Calendar.DATE);
		c.set(Calendar.DATE, day+100);
		Date d=c.getTime();
		SimpleDateFormat f=new SimpleDateFormat("西暦yyyy年MM月dd日");
		String result=f.format(d);
		System.out.println(result);
		
		
	}

}
