
public class Hero {
	private int hp;
	private String name;
	public Hero(int hp,String name){
		setHp(hp);
		setName(name);
	}
	public void setHp(int hp) {
		this.hp=hp;
	}
	public int getHp() {
		return this.hp;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	@Override
	public String toString() {
		return "名前:"+this.name+"/HP:"+this.hp;
	}
}
