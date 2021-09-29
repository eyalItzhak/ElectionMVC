package model;

import java.util.ArrayList;
import java.util.Set;

public class SetCitizen<T extends Citizen> implements Comparable<T> {
	private ArrayList<T> allCitizen;

	public SetCitizen() {
		allCitizen = new ArrayList<T>();
	}

	@Override
	public int compareTo(T Citzen) {
		// if in the list return pos else return -1 (mining is not on the list)
		if (allCitizen.isEmpty() == true) {
			return -1;
		} else {
			for (int i = 0; i < allCitizen.size(); i++) {
				if (allCitizen.get(i).equals(Citzen)) {
					return i;
				}
			}
			return -1;
		}

	}

	// crated list of citzen
	public String listInfo() {

		if (allCitizen.isEmpty() == true) {
			return "";
		} else {

			String info = "";
			for (int i = 0; i < allCitizen.size(); i++) {
				info = info + allCitizen.get(i).toString();
			}
			return info;
		}

	}

	public T CitzenReturnFromPos(int pos) {
		return allCitizen.get(pos);
	}

	public ArrayList<T> getAllCitizen() {
		return allCitizen;
	}

	public void setAllCitizen(ArrayList<T> allCitizen) {
		this.allCitizen = allCitizen;
	}

	public boolean addCitizen(T Citzen) { // add citizen to the list

		int pos = compareTo(Citzen);
		if (pos == -1) {
			allCitizen.add(Citzen);
			return true;
		} else {
			return false; // alrdy on the list
		}
	}

	public boolean removeCitizen(T Citzen) {
		int pos = compareTo(Citzen);
		if (pos > -1) {
			allCitizen.remove(pos);
			return true;
		} else {
			return false;
		}
	}

	private boolean addCitizenToLoction(T Citzen, int pos) throws Exception { // add citizen to the list
		allCitizen.add(pos, Citzen);
		return true;
	}

	// if before election a citizen would become sick or healthy, this is its status
	// change.
	public T changCondision(T civ) throws Exception {
		int loction = 0;

		if (civ.getClass().getSimpleName().equals("SickCitizen")) {
			loction = compareTo(civ);
			Citizen change = ((SickCitizen) civ).getHealthy();
			this.removeCitizen((T) change);
			this.addCitizenToLoction((T) change, loction);
			return (T) change;
		} else if (civ.getClass().getSimpleName().equals("SickSoldier")) {
			loction = compareTo(civ);
			Soldier change = ((SickSoldier) civ).getHealthy();
			this.removeCitizen((T) change);
			this.addCitizenToLoction((T) change, loction);
			return (T) change;
		} else if (civ.getClass().getSimpleName().equals("Citizen")) {
			loction = compareTo(civ);
			SickCitizen change = (SickCitizen) ((Citizen) civ).getSick();
			this.removeCitizen((T) change);
			this.addCitizenToLoction((T) change, loction);
			return (T) change;
		} else if (civ.getClass().getSimpleName().equals("Soldier")) {
			loction = compareTo(civ);
			SickSoldier change = (SickSoldier) civ.getSick();
			this.removeCitizen((T) change);
			this.addCitizenToLoction((T) change, loction);
			return (T) change;
		}
		return null;
	}

}
