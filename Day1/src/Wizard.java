
public class Wizard {
	private int hp;
	private int mp;
	private String name;
	private Wand wand;
	public Wizard(int hp,int mp,String name,Wand wand) {
		setHp(hp);
		setMp(mp);
		setName(name);
		setWand(wand);
	}
	public void heal(Hero h) {
		int basePoint=10;
		int recovPoint=(int)(basePoint*this.getWand().getPower());
		h.setHp(h.getHp()+recovPoint);
		System.out.println(h.getName()+"のhpを"+recovPoint+"回復した");
	}
	public void setHp(int hp) {
		this.hp=hp;
	}
	public int getHp() {
		return this.hp;
	}
	public void setMp(int mp) {
		if(mp<0) {
			throw new IllegalArgumentException("huseimp");
		}
		this.mp=mp;
	}
	public int getMp() {
		return this.mp;
	}
	public void setName(String name) {
		if(name.length()<3||name==null) {
			throw new IllegalArgumentException("名前が不正3文字以上");
		}
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setWand(Wand wand) {
		if(wand==null) {
			throw new IllegalArgumentException("名前が不正3文字以上");
		}
		this.wand=wand;
	}
	public Wand getWand() {
		return this.wand;

	}

}
