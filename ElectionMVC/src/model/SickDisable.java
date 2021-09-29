package model;

// Assumption::: Isolated people without symptoms consider sick
public interface SickDisable{
	Citizen getHealthy()throws Exception;
}
