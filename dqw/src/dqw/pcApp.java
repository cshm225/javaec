package dqw;

public class pcApp {
	public static void main(String[] args) {
		PC pc=new PC();
		UsbMemory um=new UsbMemory();
		pc.executeUSB(um);
		pc.executeUSB(new Iusb(){

			@Override
			public void execute() {
				// TODO 自動生成されたメソッド・スタブ
				System.out.println("senpuki~");
			}});

	}
}
interface Iusb{
	void execute();
}
class PC{
	void executeUSB(Iusb usb) {
		usb.execute();
	}
}

class UsbMemory implements Iusb{

	@Override
	public void execute() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("kakikomi~");

	}

}