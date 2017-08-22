import java.util.Collection;
import java.util.Iterator;

public class Character {
	private String name;
	private String element;
	private int health;
	private int horizontalIndex;
	private int verticalIndex;
	
	Character(String n, String e, int a, int h, int v) {
	name = n; element = e; health = a; horizontalIndex = h;	verticalIndex= v;
	}
	
	public String GetName()
		{return(name);}
	public void SetName(String n)
		{name = n;}
	
	public String GetElement()
		{return(element);}
	public void SetElement(String e)
		{element = e;}
	
	public int GetHealth()
		{return(health);}
	public void SetHealth(int a)
		{health = a;}
	
	public int GethorizontalIndex()
		{return(horizontalIndex);}
	public void SethorizontalIndex(int h)
		{horizontalIndex = h;}
	
	public int GetverticalIndex()
		{return(verticalIndex);}
	public void SetverticalIndex(int v)
		{verticalIndex = v;}
		
	public void Print()	{
		System.out.print(("("+GetName())); System.out.print(", ");
		System.out.print(GetElement());	System.out.print(", ");	
		System.out.print(GetHealth()); System.out.print(", ");
		System.out.print(GethorizontalIndex());	System.out.print(":");
		System.out.print(GetverticalIndex()); System.out.print(") ");
		System.out.println();
	}
	
	public static void PrintCollection(Collection<Character> c) {
		for (Iterator<Character> iter = c.iterator(); iter.hasNext();) {
			Character x = (Character)iter.next();
			x.Print();
		}System.out.println();
	}
}
