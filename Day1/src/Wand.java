
public class Wand {
	private String name;
	private double power;
	public Wand(double power,String name) {
		setName(name);
		setPower(power);
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		if(name.length()<3||name==null) {
			throw new IllegalArgumentException("名前が不正3文字以上");

		}
		this.name=name;
	}
	public void setPower(double power) {
		if(power>101||power<0.5) {
			throw new IllegalArgumentException("不正です");
		}
		this.power=power;
	}
	public double getPower() {
		return this.power;
	}
}


