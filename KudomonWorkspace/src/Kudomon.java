import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Kudomon {
public static void main(String[] args) {

	//MAX IS ABOUT HOW BIG THE CANVAS IS TO IDENTIFY LOCATION
	int max = 50;
	//DEFAULT TRAINER HEALTH (HUMANS)
	int defaultHealthForTrainers = 10;
	
	//OBJECT ARRAYLIST (CHARACTER - KUDOMON/TRAINER). VIEW CHARACTER CLASS TO VIEW FIELDS
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
	
	System.out.println("***PART 1***");
	//CALLING THE PRINT METHOD TO PRINT ALL INFO IN CHARACTER ARRAYLIST
	Character.PrintCollection(CharacterList);
	
		//DISTANCE TEST BETWEEN FRED AND SOURBULB (UNCOMMENT TO TEST)
		//System.out.println("Distance: "+DistanceCalc(CharacterList, "Fred", "Sourbulb"));
	
		//OBJECT-ARRAYLIST CREATION TO SEPARATE KUDOMON AND TRAINERS
		ArrayList<Character> TrainerList = new ArrayList<Character>();
		ArrayList<Character> KudomonList = new ArrayList<Character>();
		TrainerList= MultipleTrainerCheck(CharacterList);
		KudomonList = MultipleKudomoncheck(CharacterList);

	System.out.println("***PART 2***");
	//0BJECT-ARRAYLIST TO COMBINE KUDOMON TO TRAINERS ACCORDING TO THEIR FIRST CLOSEST KUDOMON
	ArrayList<PairedChar> CloseBy = new ArrayList<PairedChar>();
	CloseBy = CloseList(TrainerList, KudomonList, CharacterList); 
	PairedChar.PrintCollection(CloseBy);
	
	System.out.println("***PART 3***");
	//CALLING THIS METHOD TO ADJUST KUDOMON COORDINATES SO TRAINERS HAVE THEIR TAILORED MAP TO CATCH THE KUDOMON
	PairedChar.PrintCollection(EnableMultipleCatches(CloseBy));
	
	System.out.println("***PART 4***");
	//CALLING THIS METHOD TO FOR A BATTLE
	String player1 = "Fred"; String player2 = "Chikapu"; 
	ArrayList<Character> DisplayPlayers = new ArrayList<Character>();
	int i = IndexFinder(CharacterList, player1);int j = IndexFinder(CharacterList, player2);
	DisplayPlayers.add(new Character (CharacterList.get(i).GetName(),CharacterList.get(i).GetElement(),CharacterList.get(i).GetHealth(),CharacterList.get(i).GethorizontalIndex(), CharacterList.get(i).GetverticalIndex()));
	DisplayPlayers.add(new Character (CharacterList.get(j).GetName(), CharacterList.get(j).GetElement(), CharacterList.get(j).GetHealth(), CharacterList.get(j).GethorizontalIndex(), CharacterList.get(j).GetverticalIndex())); 
	Character.PrintCollection(DisplayPlayers);
	System.out.println(HealthBattles(CharacterList, player1, player2));
	System.out.println("inmain--");
	
	
}


	//+++METHODS+++

	static public String HealthBattles (ArrayList<Character> BattleAgainst, String chosenName, String chosenName2) {
	
		//PLAYERS WILL BE DECIDED BY WHAT THE ELEMENT IS (KUDOMON OR TRAINER)
		String player1 = "";
		String player2 = "";
	
		//THIS IS USED TO RANDOMLY SELECT THE FIRST PLAYER BETWEEN KUDOMON
		int Switch = UI(0,2);
	
		//THIS WILL BE THE AMOUNT OF AFFLICTION THE KUDOMON WILL GIVE TO EACH OTHER 
		int setHarm1 =0;
		int setHarm2 =0;
		
		//USED TO HELP COLLECT THE CORRESPONDING AFFLICTION TO THE ELEMENT. E.G-FIRE=50.
		String ElementName = "";
		int player1score=0;
		int player2score=0;
		
		//GETTING THE ELEMENT INFO FROM THE CHARACTERLIST OF 'CHOSENNAME' (IF ITS A TRAINER OR A KUDOMON)		
		int indexofelement= IndexFinder (BattleAgainst, chosenName);		
		String CheckElement =BattleAgainst.get(indexofelement).GetElement();	
	
		
		//IF 'CHOSENNAME' IS A TRAINER THEN HUMAN PLAYS FIRST
			if (CheckElement == "Trainer") {
			
				player1=chosenName; 
				indexofelement= IndexFinder (BattleAgainst, chosenName);	
				ElementName =BattleAgainst.get(indexofelement).GetElement();
				setHarm1 = SetHarmAssignment(ElementName);
				player1score = BattleAgainst.get(indexofelement).GetHealth();
			
				player2=chosenName2;
				indexofelement= IndexFinder (BattleAgainst, chosenName);	
				ElementName =BattleAgainst.get(indexofelement).GetElement();
				setHarm2 = SetHarmAssignment(ElementName);
				player2score= BattleAgainst.get(indexofelement).GetHealth();
			
			}
System.out.println("afterfirstif--");	
			//GETTING THE ELEMENT INFO FROM THE CHARACTERLIST OF 'CHOSENNAME2' (IF ITS A TRAINER OR A KUDOMON)
			indexofelement= IndexFinder (BattleAgainst, chosenName);	
			CheckElement =BattleAgainst.get(indexofelement).GetElement();
		
			//IF 'CHOSENNAME2' IS A TRAINER THEN HUMAN PLAYS FIRST
			if (CheckElement == "Trainer") {
			
				player1=chosenName2; 
				indexofelement= IndexFinder (BattleAgainst, chosenName);	
				ElementName =BattleAgainst.get(indexofelement).GetElement();
				setHarm2 = SetHarmAssignment(ElementName);
				player2score = BattleAgainst.get(indexofelement).GetHealth();
			
				player2=chosenName;
				indexofelement= IndexFinder (BattleAgainst, chosenName);	
				ElementName =BattleAgainst.get(indexofelement).GetElement();
				setHarm1 = SetHarmAssignment(ElementName);
				player1score= BattleAgainst.get(indexofelement).GetHealth();
			}
		
			//IF NONE OF THE GIVEN NAMES ARE TRAINERS THEN A RANDOM KUDOMON IS CHOSEN TO BE PLAYER 1 AND 2
			if (Switch == 1) {
			
				player1=chosenName;	
				indexofelement= IndexFinder (BattleAgainst, chosenName);	
				ElementName =BattleAgainst.get(indexofelement).GetElement();
				setHarm1 = SetHarmAssignment(ElementName);
				player1score = BattleAgainst.get(indexofelement).GetHealth();
			
				player2=chosenName2;
				indexofelement= IndexFinder (BattleAgainst, chosenName);	
				ElementName =BattleAgainst.get(indexofelement).GetElement();
				setHarm2 = SetHarmAssignment(ElementName);
				player2score= BattleAgainst.get(indexofelement).GetHealth();
			}
				else {
				
					player1=chosenName2; 
					indexofelement= IndexFinder (BattleAgainst, chosenName);	
					ElementName =BattleAgainst.get(indexofelement).GetElement();
					setHarm1 = SetHarmAssignment(ElementName);
					player1score = BattleAgainst.get(indexofelement).GetHealth();
				
					player2=chosenName;
					indexofelement= IndexFinder (BattleAgainst, chosenName);	
					ElementName =BattleAgainst.get(indexofelement).GetElement();
					setHarm2 = SetHarmAssignment(ElementName);
					player2score= BattleAgainst.get(indexofelement).GetHealth();
				
				}
	
System.out.println("afterallifs--");
			//SETTING THE MOTION FOR THE ACTUAL BATTLE
			String win = "none";
			while (win == "none") {
			
				//PLAYER 1 INFLICTS HARM FIRST, UPDATES THE HEALTH SCORE
				player2score= setHarm1-player2score;
			
				//PLAYER 2 INFLICTS HARM SECOND, UPDATES THE HEALTH SCORE
				player1score=setHarm2-player1score;
			
			
				//RETURNING WINNERS!
				if (player1score <=0) {	win = "win"; return "Winner is " + player1; }
				else if (player2score <=0) { win = "win"; return "Winner is " + player2;	}
		}
		return "";
	}

	
	static public int SetHarmAssignment (String ElementName) {
	
		//SWTICH STATEMENT TO ASSIGN THE AMOUNT OF HARM EACH RESPECTIVE ELEMENT CAN AFFLICT
		int setHarm =0;
		String Elementname = ElementName;
	
		switch (Elementname) {
		case "water" : setHarm = 10; break;
		case "electric" : setHarm = 20; break;
		case "rock" : setHarm = 30; break;
		case "grass" : setHarm = 40; break;
		case "fire" : setHarm = 50; break;
		case "Trainer" : setHarm = UI(10,50); break;
		
		}
		return setHarm;
	
	}

	static public ArrayList<PairedChar> EnableMultipleCatches (ArrayList<PairedChar> coorChange ) {
	
		//OBJECT-ARRAYLIST TO STORE NEW/CHANGED COORDINATES OR KUDOMON ACCORDING TO CLOSEST TRAINER
		ArrayList<PairedChar> NewList = new ArrayList<PairedChar>();
	
		for (int i=0; i < coorChange.size(); i++) {
		
			//RANDOMLY SELECT THE VERTICAL OR HORIZONTAL COORDINATES TO CHANGE AND RETURN
			int Switch = UI(0,2);
		
			if (Switch ==1) {
				int change = coorChange.get(i).GetKverticalIndex();
				change++;
	
				NewList.add(new PairedChar (
					(coorChange .get(i).GetTName()), coorChange .get(i).GetTelement(), coorChange .get(i).GetTHealth(), coorChange .get(i).GetThorizontalIndex(), (coorChange .get(i).GetTverticalIndex()), 
					coorChange .get(i).GetKName(), coorChange .get(i).GetKelement(), coorChange .get(i).GetKHealth(), coorChange .get(i).GetKhorizontalIndex(),coorChange .get(i).GetKverticalIndex()+1,
					coorChange.get(i).GetDistance()));
		
			}
			else {
				NewList.add(new PairedChar (
						(coorChange .get(i).GetTName()), coorChange .get(i).GetTelement(), coorChange .get(i).GetTHealth(), (coorChange.get(i).GetThorizontalIndex()), (coorChange .get(i).GetTverticalIndex()), 
						coorChange .get(i).GetKName(), coorChange .get(i).GetKelement(), coorChange .get(i).GetKHealth(), coorChange .get(i).GetKhorizontalIndex()+1,coorChange .get(i).GetKverticalIndex(),
						coorChange.get(i).GetDistance()));
			}
		}
	
		//PairedChar.PrintCollection(coorChange); System.out.println();
		//PairedChar.PrintCollection(NewList);
	
		return NewList;
	
	}
	static public ArrayList<PairedChar> CloseList (ArrayList<Character> Trainers, ArrayList<Character> Kudomons, ArrayList<Character> AllList) {

		int distancevalue=0;
		int num=0;
		
		//TWO OBJECT-ARRAYLIST. ONE TO STORE ALL SMALL DISTANCED KUDOMON AND OTHER TO STORE SELECTED DETAILS AND RETURN <<DOES THIS MAKE SENSE? LOL
		ArrayList<PairedChar> SmallSearchList = new ArrayList<PairedChar>();
		ArrayList<PairedChar> SmallFoundList = new ArrayList<PairedChar>();
		
		//USED TO STORE ALL DISTANCE VALUES AND USED TO SMALLEST DISTANCE BETWEEN A TRAINER AND KUDOMON
		ArrayList<Integer> TempDistances = new ArrayList<Integer>();
		
		//RUNNING FOR ALL TRAINERS. FIND THE KUDOMON WITH SMALLEST DISTANCE TO ME
		for (int i =0; i < Trainers.size(); i++) {
		
			//COLLECT THE COORDINATES OF KUDOMON AND COMPARE IT TO OTHER KUDOMON
			for (int j =0; j< Kudomons.size(); j++) {
			
				//CALCULATE THE DISTANCE BETWEEN TRAINER AND KUDOMON
				distancevalue= DistanceCalc(AllList, Kudomons.get(j).GetName(), Trainers.get(i).GetName());			
			
				//ADD IT IN THE FORMAT OF THE 'PAIREDCHAR' OBJECT-ARRAYLIST
				SmallSearchList.add(new PairedChar 
						(Kudomons.get(j).GetName(), Kudomons.get(j).GetElement(), Kudomons.get(j).GetHealth(), Kudomons.get(j).GethorizontalIndex(), Kudomons.get(j).GetverticalIndex(), 
						Trainers.get(i).GetName(), Trainers .get(i).GetElement(), Trainers.get(i).GetHealth(), Trainers.get(i).GethorizontalIndex(),Trainers.get(i).GetverticalIndex(),
						distancevalue));
				
						//ADD THE DISTANCE TO THE INTEGER ARRAYLIST
						TempDistances.add(new Integer (distancevalue));
			
			}
		
			//PairedChar.PrintCollection(SmallSearchList);
			
			//COMPARE DISTANCES OF KUDOMON TO ASSIGN TO THE TRAINER
			num = Collections.min(TempDistances);
			//System.out.println("--> "+num);
		
			//FIND THE INDEX OF THE SMALLEST DISTANCE AND ADD IT TO THE 'SMALLFOUNDLIST' TO RETURN
			int indexofvalue= TempDistances.indexOf(Collections.min(TempDistances));
			//System.out.println(">>>"+indexofvalue);
			SmallFoundList.add(new PairedChar (
					(SmallSearchList.get(indexofvalue).GetKName()), SmallSearchList.get(indexofvalue).GetKelement(), SmallSearchList.get(indexofvalue).GetKHealth(), SmallSearchList.get(indexofvalue).GetKhorizontalIndex(), SmallSearchList.get(indexofvalue).GetKverticalIndex(), 
					SmallSearchList.get(indexofvalue).GetTName(), SmallSearchList .get(indexofvalue).GetTelement(), SmallSearchList.get(indexofvalue).GetTHealth(), SmallSearchList.get(indexofvalue).GetThorizontalIndex(),SmallSearchList.get(indexofvalue).GetTverticalIndex(),
					distancevalue)); //everything is right except the distancevalue. Its not references so its generating a random one.
		
			//CLEAR LISTS FOR NEXT ITERATION
			SmallSearchList.clear();
			TempDistances.clear();
		}
		//PairedChar.PrintCollection(SmallFoundList);
	
		return SmallFoundList;
	}

	static public int DistanceCalc (ArrayList<Character> array, String chosenName, String chosenName2) {
		
		//USING THE PYTHAGORAS THEORAM TO FIND THE SMALLEST DISTANCE. HORIZONTAL/VERTICAL REPRESENTING COORDINATES
		int y =0; int x = 0; int y1 =0; int x1 =0; int Distance=0;

		for (int i=0; i<array.size(); i++) {
	
			//COLLECTING AND INITIALISING RELEVANT VARIABLE
			if (chosenName == array.get(i).GetName()) 
			{ y = array.get(i).GethorizontalIndex(); x = array.get(i).GetverticalIndex(); }
	
			if (chosenName2 == array.get(i).GetName())
			{ y1 = array.get(i).GethorizontalIndex(); x1 = array.get(i).GetverticalIndex();	}
	
			//PYTHAGORAS FORMULA CODED
			int xes= (int) Math.abs(Math.pow((x1-x),2)); int yes= (int) Math.abs(Math.pow((y1-y),2));
			Distance = (int) Math.abs(Math.sqrt(xes+yes));		
		}
		return Distance;
	}

	static public ArrayList<Character> MultipleTrainerCheck (ArrayList<Character> array) {
		
		//CREATING THIS LIST TO RETURN TRAINERS ONLY LIST
		ArrayList<Character> TrainerList = new ArrayList<Character>();

		//RUN THROUGH WHOLE LIST AND PICK OUT 'TRAINERS' AND ADD IT TO 'TRAINERLIST'
		for (int i=0; i<array.size(); i++) {
		
			if (array.get(i).GetElement() == "Trainer") {
				TrainerList.add(array.get(i)); 
			}
		}
		//Character.PrintCollection(TrainerList); 
	
		return TrainerList;
	}

	static public ArrayList<Character> MultipleKudomoncheck (ArrayList<Character> array) {
		
		//CREATING THIS LIST TO RETURN KUDOMON ONLY LIST
		ArrayList<Character> KudomonList = new ArrayList<Character>();

		//RUN THROUGH WHOLE LIST AND PICK OUT 'KUDOMON' AND ADD IT TO 'KUDOMONLIST'
		for (int i=0; i<array.size(); i++) {
		
			if (array.get(i).GetElement() != "Trainer") {
				KudomonList.add(array.get(i)); 
			}
		}
		//Character.PrintCollection(KudomonList); 
	
		return KudomonList;
	}
	
	static public int UI(int aa,int bb)	{
		
		//GENERATE A RANDOM NUMBER BETWEEN TWO VALUES
		Random ran = new Random();
		int x = ran.nextInt(bb) + aa;	
	return x;
	}	
	
	//METHOD IS USED TO FIND THE INDEX OF A NAME (USED IN HEALTH BATTLES)
	static public int IndexFinder(ArrayList<Character> array, String name)	{
		
		for (int i = 0; i < array.size(); i++) 		{
			   if (array.get(i).GetName() == name) {
			    //System.out.println(i);
				return i;
			  }
		}
		return 0;
	}
}






