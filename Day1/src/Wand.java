
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
		this.name=name;
	}
	public void setPower(double power) {
		this.power=power;
	}
	public double getPower() {
		return this.power;
	}
}


