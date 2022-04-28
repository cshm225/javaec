package pc;

public class PcAPP {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Pc pc=new Pc();
		pc.setUsb(new USBmemory());
		pc.executeUSB();
		pc.setUsb(new USBfan());
		pc.executeUSB();
		pc.setUsb(new USBmouse());
		pc.executeUSB();
	}

}
class USBmemory implements IUSB{

	@Override
	public void executeUSB() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("hozon");
	}

}
class USBfan implements IUSB{

	@Override
	public void executeUSB() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("kazedasimasu");
	}

}
class USBmouse implements IUSB{

	@Override
	public void executeUSB() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("mouse");
		
	}
	
}