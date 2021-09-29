package model;

public class SickSoldier extends Sick  {
	
	protected boolean IsArmed;
	public SickSoldier(String name, int tZ, String DateOfBirth,int dayOfSickness,boolean arm) throws Exception {
	    super(name,tZ,DateOfBirth,dayOfSickness);
	    this.IsArmed=arm;
		}
	
	
	public boolean isIsArmed() {
		return IsArmed;
	}



	public void setIsArmed(boolean isArmed) {
		IsArmed = isArmed;
	}


	@Override
	public String toString() {
		String toReturn;
		toReturn=super.toString();
		if(IsArmed==true) {
			return toReturn+"and is a Soldier With Wepon\n";
		}else {
		return toReturn+"and is a Soldier witout Wepone\n";
		}
	}


	@Override
	public Soldier getHealthy() throws Exception {
		Soldier NoDead=new Soldier(this.Name, this.TZ, this.DateOfBirth.toString(),this.IsArmed);
		return NoDead;
	}


	

}
