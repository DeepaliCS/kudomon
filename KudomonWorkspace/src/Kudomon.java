import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Kudomon {
public static void main(String[] args) {


	//Scanner to input distance, Set a flow of game
	//Set coordinates so multiple people can access it
	//Health battle
	
	int max = 50;
	int defaultHealthForTrainers = 10;
	ArrayList<Character> CharacterList = new ArrayList<Character>();
	CharacterList.add(new Character ("Sourbulb", "grass", UI(0, max), UI(0, max),UI(0, max)));
	CharacterList.add(new Character ("Mancharred", "fire", UI(0, max), UI(0, max), UI(0, max)));
	CharacterList.add(new Character ("Chikapu", "electric", UI(0, max), UI(0, max), UI(0, max)));
	CharacterList.add(new Character ("Jellyflop", "rock", UI(0, max), UI(0, max), UI(0, max)));
	CharacterList.add(new Character ("Bluesun", "water", UI(0, max), UI(0, max), UI(0, max)));
	CharacterList.add(new Character ("Gunmetalflower", "psychic", UI(0, max), UI(0, max), UI(0, max)));
	CharacterList.add(new Character ("Fred", "Trainer", defaultHealthForTrainers, UI(0, max), UI(0, max)));
	CharacterList.add(new Character ("Jo", "Trainer", defaultHealthForTrainers, UI(0, max), UI(0, max)));
	CharacterList.add(new Character ("Benny", "Trainer", defaultHealthForTrainers, UI(0, max), UI(0, max)));
	
	Character.PrintCollection(CharacterList);
	//System.out.println("-->"+DistanceCalc(CharacterList, "Fred", "Sourbulb"));
	ArrayList<Character> TrainerList = new ArrayList<Character>();
	ArrayList<Character> KudomonList = new ArrayList<Character>();
	TrainerList= MultipleTrainerCheck(CharacterList);
	KudomonList = MultipleKudomoncheck(CharacterList);

	ArrayList<PairedChar> CloseBy = new ArrayList<PairedChar>();
	CloseBy = CloseList(TrainerList, KudomonList, CharacterList); 
	
	EnableMultipleCatches(CloseBy);
	
	HealthBattles(CharacterList, KudomonList, "Fred", "Chikapu");
}

static public void HealthBattles (ArrayList<Character> BattleAgainst, ArrayList<Character> KudomonList, String chosenName, String chosenName2) {
	int KudomonListValue = KudomonList.size();
	String player1 = "";
	String player2 = "";
	int Switch = UI(0,2);
	int setHarm1 =0;
	int setHarm2 =0;
	String ElementName = "Nothing";
	
	//Getting info if the character is a trainer or kudomon
	int indexofelement= BattleAgainst.indexOf(chosenName);
	String CheckElement =BattleAgainst.get(indexofelement).GetElement();	
	
	for (int i=0; i<BattleAgainst.size(); i++) {
		
		if (CheckElement == "Trainer") {
			
			player1=chosenName; player2=chosenName2;
			
			indexofelement= BattleAgainst.indexOf(chosenName);
			ElementName =BattleAgainst.get(indexofelement).GetElement();
			setHarm1 = SetHarmAssignment(ElementName);
			
			indexofelement= BattleAgainst.indexOf(chosenName2);
			ElementName =BattleAgainst.get(indexofelement).GetElement();
			setHarm2 = SetHarmAssignment(ElementName);
			
		}
			else  if (Switch == 1) {
				
				player1=chosenName;	player2=chosenName2;
				
				indexofelement= BattleAgainst.indexOf(chosenName);
				ElementName =BattleAgainst.get(indexofelement).GetElement();
				setHarm1 = SetHarmAssignment(ElementName);
				
				indexofelement= BattleAgainst.indexOf(chosenName2);
				ElementName =BattleAgainst.get(indexofelement).GetElement();
				setHarm2 = SetHarmAssignment(ElementName);
			}
				else {
					
					player1=chosenName2; player2=chosenName;
					
					indexofelement= BattleAgainst.indexOf(chosenName2);
					ElementName =BattleAgainst.get(indexofelement).GetElement();
					setHarm1 = SetHarmAssignment(ElementName);
					
					indexofelement= BattleAgainst.indexOf(chosenName);
					ElementName =BattleAgainst.get(indexofelement).GetElement();
					setHarm2 = SetHarmAssignment(ElementName);
					
				}
		}
		
	//Now youve got the player names and their harmrates
	//You need to get the game. By doing a for loop. 
	//How long does the for loop go?
	//OR You can do a while loop...until a win is decla
		

		
		
		
		//Set motion for health game.
		
}

static public int SetHarmAssignment (String ElementName) {
	
	int setHarm =0;
	String Elementname = ElementName;
	
	switch (Elementname) {
	case "water" : setHarm = 10;
	break;
	case "electric" : setHarm = 20;
	break;
	case "rock" : setHarm = 30;
	break;
	case "grass" : setHarm = 40;
	break;
	case "fire" : setHarm = 50;
	break;
	case "Trainer" : setHarm = UI(10,50);
	break;
	}
	return setHarm;
	
}

static public ArrayList<PairedChar> EnableMultipleCatches (ArrayList<PairedChar> coorChange ) {
	
	ArrayList<PairedChar> NewList = new ArrayList<PairedChar>();
	
	System.out.println("Cooor "+coorChange.size());
	
	for (int i=0; i < coorChange.size(); i++) {
		
		int Switch = UI(0,2);
		
		if (Switch ==1) {
		int change = coorChange.get(i).GetKverticalIndex();
		change++;
	
		NewList.add(new PairedChar (
		(coorChange .get(i).GetKName()), coorChange .get(i).GetKelement(), coorChange .get(i).GetKHealth(), coorChange .get(i).GetKhorizontalIndex(), (coorChange .get(i).GetKverticalIndex()+1), 
		coorChange .get(i).GetTName(), coorChange .get(i).GetTelement(), coorChange .get(i).GetTHealth(), coorChange .get(i).GetThorizontalIndex(),coorChange .get(i).GetTverticalIndex(),
		coorChange.get(i).GetDistance()));
		
		}
		else {
			NewList.add(new PairedChar (
			(coorChange .get(i).GetKName()), coorChange .get(i).GetKelement(), coorChange .get(i).GetKHealth(), (coorChange.get(i).GetKhorizontalIndex()+1), (coorChange .get(i).GetKverticalIndex()), 
			coorChange .get(i).GetTName(), coorChange .get(i).GetTelement(), coorChange .get(i).GetTHealth(), coorChange .get(i).GetThorizontalIndex(),coorChange .get(i).GetTverticalIndex(),
			coorChange.get(i).GetDistance()));
		}
	}
	
	//PairedChar.PrintCollection(coorChange); System.out.println();
	//PairedChar.PrintCollection(NewList);
	
return NewList;
	
}
static public ArrayList<PairedChar> CloseList (ArrayList<Character> Trainers, ArrayList<Character> Kudomons, ArrayList<Character> AllList) {

	
	int smallest =1000;
	int distancevalue=0;
	int num=0;
	
	//ArrayList<Integer> DistanceList = new ArrayList<Integer>();
	ArrayList<PairedChar> SmallSearchList = new ArrayList<PairedChar>();
	ArrayList<Integer> TempDistances = new ArrayList<Integer>();
	ArrayList<PairedChar> SmallFoundList = new ArrayList<PairedChar>();
	
	for (int i =0; i < Trainers.size(); i++) {
		
		for (int j =0; j< Kudomons.size(); j++) {
			
			distancevalue= DistanceCalc(AllList, Kudomons.get(j).GetName(), Trainers.get(i).GetName());			
			
			SmallSearchList.add(new PairedChar 
			(Kudomons.get(j).GetName(), Kudomons.get(j).GetElement(), Kudomons.get(j).GetHealth(), Kudomons.get(j).GethorizontalIndex(), Kudomons.get(j).GetverticalIndex(), 
			Trainers.get(i).GetName(), Trainers .get(i).GetElement(), Trainers.get(i).GetHealth(), Trainers.get(i).GethorizontalIndex(),Trainers.get(i).GetverticalIndex(),
			distancevalue));
			TempDistances.add(new Integer (distancevalue));
			
		}
		
		PairedChar.PrintCollection(SmallSearchList);
		num = Collections.min(TempDistances);
		System.out.println("--> "+num);
		
		
		int indexofvalue= TempDistances.indexOf(Collections.min(TempDistances));
		System.out.println(">>>"+indexofvalue);
		SmallFoundList.add(new PairedChar (
				(SmallSearchList.get(indexofvalue).GetKName()), SmallSearchList.get(indexofvalue).GetKelement(), SmallSearchList.get(indexofvalue).GetKHealth(), SmallSearchList.get(indexofvalue).GetKhorizontalIndex(), SmallSearchList.get(indexofvalue).GetKverticalIndex(), 
				SmallSearchList.get(indexofvalue).GetTName(), SmallSearchList .get(indexofvalue).GetTelement(), SmallSearchList.get(indexofvalue).GetTHealth(), SmallSearchList.get(indexofvalue).GetThorizontalIndex(),SmallSearchList.get(indexofvalue).GetTverticalIndex(),
				distancevalue)); //everything is right except the distancevalue. Its not references so its generating a random one.
		
		
		SmallSearchList.clear();
		TempDistances.clear();
	}
	PairedChar.PrintCollection(SmallFoundList);
	
	return SmallFoundList;
}

static public int DistanceCalc (ArrayList<Character> array, String chosenName, String chosenName2) {
int y =0; int x = 0; int y1 =0; int x1 =0; int Distance=0;

for (int i=0; i<array.size(); i++) {
	
	if (chosenName == array.get(i).GetName()) 
	{ y = array.get(i).GethorizontalIndex(); x = array.get(i).GetverticalIndex(); }
	
	if (chosenName2 == array.get(i).GetName())
	{ y1 = array.get(i).GethorizontalIndex(); x1 = array.get(i).GetverticalIndex();	}
	
	int xes= (int) Math.abs(Math.pow((x1-x),2)); int yes= (int) Math.abs(Math.pow((y1-y),2));
	Distance = (int) Math.abs(Math.sqrt(xes+yes));		
	}
return Distance;
}

static public ArrayList<Character> MultipleTrainerCheck (ArrayList<Character> array) {
ArrayList<Character> TrainerList = new ArrayList<Character>();

	for (int i=0; i<array.size(); i++) {
		
		if (array.get(i).GetElement() == "Trainer") {
			TrainerList.add(array.get(i)); 
		}
	}
	//Character.PrintCollection(TrainerList); 
	
	return TrainerList;
}

static public ArrayList<Character> MultipleKudomoncheck (ArrayList<Character> array) {
ArrayList<Character> KudomonList = new ArrayList<Character>();

	for (int i=0; i<array.size(); i++) {
		
		if (array.get(i).GetElement() != "Trainer") {
			KudomonList.add(array.get(i)); 
		}
	}
	//Character.PrintCollection(KudomonList); 
	
	return KudomonList;
}
	
	static public int UI(int aa,int bb)	{
		Random ran = new Random();
		int x = ran.nextInt(bb) + aa;	
	return x;
	}	
}





