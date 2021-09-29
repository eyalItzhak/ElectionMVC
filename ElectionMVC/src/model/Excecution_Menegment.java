package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Excecution_Menegment {

	public static ArrayList<KalpiGeneric<Citizen>> allCitizenKalpi = new ArrayList<KalpiGeneric<Citizen>>();
	public static ArrayList<KalpiGeneric<SickCitizen>> allSickCitizenKalpi = new ArrayList<KalpiGeneric<SickCitizen>>();
	public static ArrayList<KalpiGeneric<SickSoldier>> allSickSoldierKalpi = new ArrayList<KalpiGeneric<SickSoldier>>();
	public static ArrayList<KalpiGeneric<Soldier>> allSoldierKalpi = new ArrayList<KalpiGeneric<Soldier>>();

	public static SetCitizen<Citizen> allCitizens = new SetCitizen<Citizen>();

	public static LocalDate electionDate;
	public static List<Party> partyList = new ArrayList<Party>();

	public static Citizen addCitizen(String name, String Birthday, int year, int TZ, boolean isCarryWeapon,
			boolean isSick, int sicknessDays) throws Exception {
		Citizen dude;
		if (year >= 1999 && year < 2002) {
			if (isSick) {
				dude = new SickSoldier(name, TZ, Birthday, sicknessDays, isCarryWeapon);
			} else {
				dude = new Soldier(name, TZ, Birthday, isCarryWeapon);
			}
		} else if (isSick) {
			dude = new SickCitizen(name, TZ, Birthday, sicknessDays);
		} else {
			dude = new Citizen(name, TZ, Birthday);
		}

		allCitizens.addCitizen(dude);

		return dude;
	}

	public static String showAllKalpi() {
		StringBuffer str = new StringBuffer();
		str.append("-All Kalpi for Citizen:\n");
		for (int i = 0; i < allCitizenKalpi.size(); i++) {
			str.append(allCitizenKalpi.get(i).showKalpi());
			str.append("\n");
		}
		str.append("-All Kalpi for Sick Citizen:\n");
		for (int i = 0; i < allSickCitizenKalpi.size(); i++) {
			str.append(allSickCitizenKalpi.get(i).showKalpi());
			str.append("\n");
		}
		str.append("-All Kalpi for Soldier:\n");
		for (int i = 0; i < allSoldierKalpi.size(); i++) {
			str.append(allSoldierKalpi.get(i).showKalpi());
			str.append("\n");
		}
		str.append("-All Kalpi for Sick Soldier:\n");
		for (int i = 0; i < allSickSoldierKalpi.size(); i++) {
			str.append(allSickSoldierKalpi.get(i).showKalpi());
			str.append("\n");
		}
		return str.toString();
	}

	public static void addCitizenToKalpi(Citizen dude, int choice) {

		if (dude.getClass() == Soldier.class) {
			allSoldierKalpi.get(choice).addVoter((Soldier) dude);
		} else if (dude.getClass() == SickSoldier.class) {
			allSickSoldierKalpi.get(choice).addVoter((SickSoldier) dude);
		} else if (dude.getClass() == Citizen.class) {
			allCitizenKalpi.get(choice).addVoter((Citizen) dude);
		} else if (dude.getClass() == SickCitizen.class) {
			allSickCitizenKalpi.get(choice).addVoter((SickCitizen) dude);
		} else if (dude.getClass() == Candidate.class) {
			allCitizenKalpi.get(choice).addVoter((Candidate) dude);
		}
	}

	public static String showAvailableKalpi(Citizen dude) {
		StringBuffer str = new StringBuffer();
		//str.append("All Kalpi for Current Citizen:\n");
		if (dude.getClass() == Citizen.class || dude.getClass() == Candidate.class) {
			for (int i = 0; i < allCitizenKalpi.size(); i++) {
				str.append((i + 1) + " " + allCitizenKalpi.get(i).getAddress() + "\n");
			}
		}
		if (dude.getClass() == Soldier.class) {
			for (int i = 0; i < allSoldierKalpi.size(); i++) {
				str.append((i + 1) + " " + allSoldierKalpi.get(i).getAddress() + "\n");
			}
		}
		if (dude.getClass() == SickCitizen.class) {
			for (int i = 0; i < allSickCitizenKalpi.size(); i++) {
				str.append(allSickCitizenKalpi.get(i).getAddress() + "\n");

			}
		}
		if (dude.getClass() == SickSoldier.class) {
			for (int i = 0; i < allSickSoldierKalpi.size(); i++) {
				str.append(allSickSoldierKalpi.get(i).getAddress() + "\n");

			}
		}
		return str.toString();
	}

	public static void addNewKalpi(String type, String address) {
		//"Citizen", "Sick Citizen", "Soldier", "Sick Soldier"
		if (type.equals("Citizen"))
			allCitizenKalpi.add(new KalpiGeneric<Citizen>(address));
		else if (type.equals("Sick Citizen"))
			allSickCitizenKalpi.add(new KalpiGeneric<SickCitizen>(address));
		else if (type.equals("Soldier"))
			allSoldierKalpi.add(new KalpiGeneric<Soldier>(address));
		else if (type.equals("Sick Soldier"))
			allSickSoldierKalpi.add(new KalpiGeneric<SickSoldier>(address));

	}

	// check (and making) population sick before election
	public static void preElction() throws Exception {
		resetLastElction();
		ArrayList<Citizen> TotalList = allCitizens.getAllCitizen();
		SickStatistics(50, 20, TotalList);
		UpdateNumberOFparty();
		NewElctionTimeMade();
	}

	private static void resetLastElction() {
		for (int i = 0; i < allCitizenKalpi.size(); i++) {
			allCitizenKalpi.get(i).resetData();
		}
		for (int i = 0; i < allSickCitizenKalpi.size(); i++) {
			allSickCitizenKalpi.get(i).resetData();
		}
		for (int i = 0; i < allSoldierKalpi.size(); i++) {
			allSoldierKalpi.get(i).resetData();
		}
		for (int i = 0; i < allSickSoldierKalpi.size(); i++) {
			allSickSoldierKalpi.get(i).resetData();
		}
	}

	private static void UpdateNumberOFparty() {
		int numOfparty = partyList.size();
		for (int i = 0; i < allCitizenKalpi.size(); i++) {
			allCitizenKalpi.get(i).setNumOfParties(numOfparty);
		}
		for (int i = 0; i < allSickCitizenKalpi.size(); i++) {
			allSickCitizenKalpi.get(i).setNumOfParties(numOfparty);
		}
		for (int i = 0; i < allSoldierKalpi.size(); i++) {
			allSoldierKalpi.get(i).setNumOfParties(numOfparty);
		}
		for (int i = 0; i < allSickSoldierKalpi.size(); i++) {
			allSickSoldierKalpi.get(i).setNumOfParties(numOfparty);
		}
	}

	private static void SickStatistics(int BecomeSick, int becomeBetter, ArrayList<Citizen> TotalList)
			throws Exception {

		Random rand = new Random();
		if (BecomeSick > 100 || BecomeSick < 0) {
			BecomeSick = 0;
		}

		if (becomeBetter > 100 || becomeBetter < 0) {
			becomeBetter = 0;
		}

		for (int i = 0; i < TotalList.size(); i++) {

			Citizen cheak = TotalList.get(i);

			if (cheak.getClass().getSimpleName().equals("SickCitizen")) {
				if (rand.nextInt(100) <= becomeBetter) {
					Citizen newMan = allCitizens.changCondision((SickCitizen) cheak); // change status in the main and
																						// real list
					removeFromList(cheak, 2); // remove from the last list .
					allCitizenKalpi.get(randomNum(allCitizenKalpi.size())).addVoter(newMan);
				}

			} else if (cheak.getClass().getSimpleName().equals("SickSoldier")) {
				if (rand.nextInt(100) <= becomeBetter) {
					Citizen newMan = allCitizens.changCondision((SickSoldier) cheak); // change condsion in the main
																						// list
					removeFromList(cheak, 4); // remove from the last list .
					allSoldierKalpi.get(randomNum(allSoldierKalpi.size())).addVoter((Soldier) newMan);
				}
			} else if (cheak.getClass().getSimpleName().equals("Citizen")) {
				if (rand.nextInt(100) <= BecomeSick) {
					Citizen newMan = allCitizens.changCondision((Citizen) cheak); // change condsion in the main list
					removeFromList(cheak, 1); // remove from the last list .
					allSickCitizenKalpi.get(randomNum(allSickCitizenKalpi.size())).addVoter((SickCitizen) newMan);
				}
			}
			if (cheak.getClass().getSimpleName().equals("Soldier")) {
				if (rand.nextInt(100) <= BecomeSick) {
					Citizen newMan = allCitizens.changCondision((Soldier) cheak); // change condsion in the main list
					removeFromList(cheak, 3); // remove from the last list .
					allSickSoldierKalpi.get(randomNum(allSickSoldierKalpi.size())).addVoter((SickSoldier) newMan);
				}
			}
		}
	}

	private static int randomNum(int size) {
		Random rand = new Random();
		return rand.nextInt(size);
	}

	private static boolean removeFromList(Citizen change, int list) {

		switch (list) {

		case 1: // remove in list Citizen
			for (int i = 0; i < allCitizenKalpi.size(); i++) {
				if (allCitizenKalpi.get(i).removeVoter(change)) {
					return true;
				}

			}

			return false;
		case 2: // remove in list citizen corona
			for (int i = 0; i < allSickCitizenKalpi.size(); i++) {
				if (allSickCitizenKalpi.get(i).removeVoter((SickCitizen) change)) {
					return true;
				}

			}
			return false;

		case 3: // remove in list Soldier
			for (int i = 0; i < allSoldierKalpi.size(); i++) {
				if (allSoldierKalpi.get(i).removeVoter((Soldier) change)) {
					return true;
				}

			}
			return false;

		case 4: // remove in list SoldierSick
			for (int i = 0; i < allSickSoldierKalpi.size(); i++) {
				if (allSickSoldierKalpi.get(i).removeVoter((SickSoldier) change)) {
					return true;
				}

			}
			return false;

		default:
			return false;
		}

	}

	public static void NewElctionTimeMade() {
		electionDate = LocalDate.now();
	}

	public static String showAllCitizence() {
		String toPrint = "\n";
		for (int i = 0; i < allCitizens.getAllCitizen().size(); i++) {
			toPrint = toPrint + (i + 1) + ": " + allCitizens.getAllCitizen().get(i).toString() + "\n";
		}
		return toPrint;
	}

	// *******************Adding a Candidate
	public static Candidate addCandidate(String name, int tZ, String birthday, int i) throws Exception {
		Candidate cand = new Candidate(name, tZ, birthday, false, partyList.get(i));
		allCitizens.addCitizen(cand);
		partyList.get(i).addCandidateToParty(cand);
		return cand;
	}

	public static boolean checkChoiceForParty(int index) {
		index--;
		for (int i = 0; i < partyList.size(); i++) {
			if (index == i) {
				return true;
			}
		}
		return false;
	}

	public static String showAllParties() {
		String toprint = "";
		for (int i = 0; i < partyList.size(); i++) {
			toprint = toprint + (i + 1)+ " "  + partyList.get(i).toString() + "\n";
		}
		return toprint;
	}

	//////////////////////////////////
	// ******************* adding party************//
	public static void addParty(String name, String politicalBranch, String CreationDate) {
		Party newOne = new Party(name, politicalBranch, CreationDate);
		partyList.add(newOne);
	}

	public static String showParyOptions() {
		String op = "";
		for (int i = 0; i < partyList.size(); i++) {
			op = op + (i + 1) + ": " + partyList.get(i).getPartyName() + "\n";
		}
		return op;
	}

	public static String ShowKalpiResult() {
		int[] totalVote = new int[partyList.size()];
		StringBuffer result = new StringBuffer("The result of elction " + electionDate.toString() + "\n");

		for (int i = 0; i < allCitizenKalpi.size(); i++) {
			result.append("In kalpi " + allCitizenKalpi.get(i).getAddress() + " voted "
					+ allCitizenKalpi.get(i).getNumOfVotedPeople() + "\n");
			for (int j = 0; j < allCitizenKalpi.get(i).getNumOfVotesPerParties().length; j++) {
				totalVote[j] = totalVote[j] + allCitizenKalpi.get(i).getNumOfVotesPerParties()[j];
			}
		}
		for (int i = 0; i < allSickCitizenKalpi.size(); i++) {
			result.append("In kalpi " + allSickCitizenKalpi.get(i).getAddress() + " voted "
					+ allSickCitizenKalpi.get(i).getNumOfVotedPeople() + "\n");
			for (int j = 0; j < allSickCitizenKalpi.get(i).getNumOfVotesPerParties().length; j++) {
				totalVote[j] = totalVote[j] + allSickCitizenKalpi.get(i).getNumOfVotesPerParties()[j];
			}
		}

		for (int i = 0; i < allSickSoldierKalpi.size(); i++) {
			result.append("In kalpi " + allSickSoldierKalpi.get(i).getAddress() + " voted "
					+ allSickSoldierKalpi.get(i).getNumOfVotedPeople() + "\n");
			for (int j = 0; j < allSickSoldierKalpi.get(i).getNumOfVotesPerParties().length; j++) {
				totalVote[j] = totalVote[j] + allSickSoldierKalpi.get(i).getNumOfVotesPerParties()[j];
			}
		}

		for (int i = 0; i < allSoldierKalpi.size(); i++) {
			result.append("In kalpi " + allSoldierKalpi.get(i).getAddress() + " voted "
					+ allSoldierKalpi.get(i).getNumOfVotedPeople() + "\n");
			for (int j = 0; j < allSoldierKalpi.get(i).getNumOfVotesPerParties().length; j++) {
				totalVote[j] = totalVote[j] + allSoldierKalpi.get(i).getNumOfVotesPerParties()[j];
			}
		}

		for (int i = 0; i < partyList.size(); i++) {
			result.append("For Party " + partyList.get(i).getPartyName() + " Voted " + totalVote[i] + " Citizens\n");
		}

		return result.toString();
	}

}
