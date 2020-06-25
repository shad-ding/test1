package lesson;

import java.util.*;


public class Poker {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String cards;
		Competitor Black = new Competitor("Black");
		Competitor White = new Competitor("White");
		
		System.out.print("Black:");
		cards = in.nextLine();
		getInformation(Black, cards);
		
		System.out.print("White:");
		cards = in.nextLine();
		getInformation(White, cards);
		
		System.out.println(Result(Black, White));
		in.close();
	}
	public static Competitor getInformation(Competitor m, String string) {
		char number = 0; 
		char type = 0;
		int times;
		String cards;
		cards = string;
		times = initialize(m, number, type, cards);
		analyze(m, times);
		return m;
	}
	
	static int CardNumber(char number) {
		int a = 0;
		switch(number) {
			case '2': a = 2; break; 
			case '3': a = 3; break;
			case '4': a = 4; break;
			case '5': a = 5; break;
			case '6': a = 6; break;
			case '7': a = 7; break;
			case '8': a = 8; break;
			case '9': a = 9; break;
			case 'T': a = 10; break;
			case 'J': a = 11; break;
			case 'Q': a = 12; break;
			case 'K': a = 13; break;
			case 'A': a = 14; break;
		}
		return a;
	}
	
	static int CardType(char type) {
		int a = 0;
		switch(type) {
			case 'D': a = 0; break;
			case 'S': a = 1; break;
			case 'H': a = 2; break;
			case 'C': a = 3; break;
		}
		return a;
	}
	
	static int initialize(Competitor m, char number, char type, String cards) {
		int mark = 4;
		int times = 0;

		for(int j = 0; j < 15; j += 3) {
			number = cards.charAt(j);
			type = cards.charAt(j + 1);
			m.CardsNumber[CardNumber(number)]++;
			if(j == 0) 
				mark = CardType(type);
			if(mark == CardType(type))
				times++;
		}
		return times;
	}
	static void analyze(Competitor m, int times) {
		if(times == 5 && m.Straight() == true)
			m.level = 6;
		else if(times == 5 && m.Straight() == false)
			m.level = 5;
		else if(times != 5 && m.Straight() == true)
			m.level = 4;
		else {
			m.Three();
			if(m.level != 3)
				m.twoTwo();
		}
	}
	static String Result(Competitor a, Competitor b) {
		String result;
		if(a.level > b.level)
			result = a.name + " wins.";
		else if(a.level < b.level)
			result = b.name + " wins.";
		else {
			if(a.level == 2){
					if(a.max > b.max)
						result = a.name + " wins.";
					else if(a.max < b.max)
						result = b.name + " wins.";
					else
						{
							if(a.min > b.min)
								result = a.name + " wins.";
							else if(a.min < b.min)
								result = b.name + " wins.";
							else
								result = "Tie.";
						}
				}
			else if(a.level == 5 || a.level == 0) {
				result = ZeroCompare(a, b);
			}
			else 
				result = Compare(a, b);
		}
		return result;
	}
	static String Compare(Competitor m, Competitor n) {
		String result;
		if(m.max > n.max)
			result = m.name + " wins.";
		else if(m.max < n.max)
			result = n.name + " wins.";
		else
			result = "Tie.";
		return result;
	}
	static String ZeroCompare(Competitor m, Competitor n) {
		boolean s = true;
		String result = "";
		for(int i = 14; i > 2; i--) {
			if(m.CardsNumber[i] == 1 && n.CardsNumber[i] == 0)
				{
					result = m.name + " wins.";
					s = false;
					break;
				}
			else if(m.CardsNumber[i] == 0 && n.CardsNumber[i] == 1)
				{
					result = n.name + " wins.";
					s = false;
					break;
				}
		}
		if(s == true)
			result = "Tie.";
		
		return result;
	}
}


