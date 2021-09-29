package model;

public class Soldier extends Citizen implements  SickEnabale {
	protected boolean IsArmed;
	
	
	public Soldier(String name, int tZ, String DateOfBirth,boolean arm) throws Exception {
		super(name,tZ,DateOfBirth);
		this.IsArmed=arm;
	}


	@Override
	public String toString() {
		
		if(IsArmed==true) {
			return super.toString()+"is a Soldier With Wepon\n";
		}
		return super.toString()+"is a Soldier witout Wepon\n";
	}

	

	@Override
	public Citizen getSick() throws Exception {
		SickSoldier deadOrAlive =new SickSoldier(this.Name,this.TZ,this.DateOfBirth.toString(),0,this.IsArmed);
		return deadOrAlive;
	}
	
}
