package model;

public class SickCitizen extends Sick {
	   
	public SickCitizen(String name, int tZ, String DateOfBirth,int dayOfSickness) throws Exception {
	    super(name,tZ,DateOfBirth,dayOfSickness);
		}
	
	@Override
	public String toString() {
	return super.toString()+"\n";
	}
	
	@Override
	public Citizen getHealthy() throws Exception {
		 Citizen liveCiv=new Citizen(this.Name,this.TZ,this.DateOfBirth.toString());
		 return liveCiv;
	}
}
