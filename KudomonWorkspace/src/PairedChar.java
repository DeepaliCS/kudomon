import java.util.Collection;
import java.util.Iterator;

//OBJECT PURPOSE: TO STORE ALL INFORMATION OF PAIRED CHARACTERS (ACCORDING TO DISTANCE, SEE KUDOMON CLASS)
public class PairedChar {
	
	private String Kname; private String Kelement;
	private int Khealth; private int KhorizontalIndex;
	private int KverticalIndex; 
	
	private String Tname; private String Telement; 
	private int Thealth; private int ThorizontalIndex; 
	private int TverticalIndex;
	
	private int Distance;
	
	PairedChar(
				
		String Tn, String Te, int Thea, int Thor, int Tv,
		String Kn, String Ke, int Khea, int Khor, int Kv,
		int d) 
	{
		//VIEW CHARACTER CLASS. VARAIBLES EXACTLY THE SAME, SEPARATED ACCORDING TO TRAINER (T) AND KUDOMON (K)
		Tname=Tn; Telement=Te; Thealth=Thea; ThorizontalIndex=Thor; TverticalIndex=Tv; 
		Kname=Kn; Kelement=Ke; Khealth=Khea; KhorizontalIndex=Khor; KverticalIndex=Kv;
		Distance=d;
	}
	
	public String GetTName()
		{return(Tname);}
	public void SetTName(String Tn)
		{Tname = Tn;}
	public String GetTelement()
		{return(Telement);}
	public void SetTelement(String Te)
		{Telement = Te;}
	public int GetTHealth()
		{return(Thealth);}
	public void SetTHealth(int Thea)
		{Thealth = Thea;}
	public int GetThorizontalIndex()
		{return(ThorizontalIndex);}
	public void SetThorizontalIndex(int Thor)
		{ThorizontalIndex = Thor;}
	public int GetTverticalIndex()
		{return(TverticalIndex);}
	public void SetTverticalIndex(int Tv)
		{TverticalIndex = Tv;}
	
	public String GetKName()
		{return(Kname);}
	public void SetKName(String Kn)
		{Kname = Kn;}
	public String GetKelement()
		{return(Kelement);}
	public void SetKelement(String Ke)
		{Kelement = Ke;}
	public int GetKHealth()
		{return(Khealth);}
	public void SetKHealth(int Khea)
		{Khealth = Khea;}
	public int GetKhorizontalIndex()
		{return(KhorizontalIndex);}
	public void SetKhorizontalIndex(int Khor)
		{KhorizontalIndex = Khor;}
	public int GetKverticalIndex()
		{return(KverticalIndex);}
	public void SetKverticalIndex(int Kv)
		{KverticalIndex = Kv;}
	
	public int GetDistance()
		{return(Distance);}
	public void SetDistanceh(int d)
		{Distance = d;}
	
	//PRINTING FORMAT TO DISPLAY ALL INFORMATION
	public void Print()	{
	System.out.print(("("+ GetTName())); System.out.print(", ");
	System.out.print(GetTelement()); System.out.print(", ");
	System.out.print(GetTHealth()); System.out.print(", ");
	System.out.print(GetThorizontalIndex()); System.out.print(":");
	System.out.print(GetTverticalIndex());	
	System.out.print((" ("+ GetKName())); System.out.print(", ");
	System.out.print(GetKelement()); System.out.print(", ");
	System.out.print(GetKHealth()); System.out.print(", ");
	System.out.print(GetKhorizontalIndex()); System.out.print(":");
	System.out.print(GetKverticalIndex()); 
	System.out.print(", Distance: ");
	System.out.print(GetDistance());
	System.out.print(") ");
	System.out.println();
	}

	//PRINTING ALL INFO OF EVERY INDEX IN OBJECT-ARRAYLIST (CALLED FROM KUDOMON CLASS)
	public static void PrintCollection(Collection<PairedChar> c) {
	for (Iterator<PairedChar> iter = c.iterator(); iter.hasNext();) {
		PairedChar x = (PairedChar)iter.next();
		x.Print();
	}
	System.out.println();
}
	
	
	
}
