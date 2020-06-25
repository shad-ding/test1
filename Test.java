package lesson;

import org.jupiter.api.Test;
import java.util.*;

class Test {
	
	@Test
	void shouldReturnWhitewins(){
		Poker n = new Poker();
		Competitor a = new Competitor("a");
		Competitor b = new Competitor("b");
		a = n.getInformation(a, "2H 3D 5S 9C KD ");
		b = n.getInformation(b, "2C 3H 4S 8C AH ");
		assertEquals("White wins", n.Result(a,b));
	}
	@Test
	void shouldReturnBlackwins1(){
		Poker n = new Poker();
		Competitor a = new Competitor("a");
		Competitor b = new Competitor("b");
		a = n.getInformation(a, "2H 3H 5H 9H KH ");
		b = n.getInformation(b, "2C 3H 4S 5C 6H ");
		assertEquals("Black wins", n.Result(a,b));
	}
	void shouldReturnWhitewins2(){
		Poker n = new Poker();
		Competitor a = new Competitor("a");
		Competitor b = new Competitor("b");
		a = n.getInformation(a, "2H 4S 4C 2D 4H ");
		b = n.getInformation(b, "2S 8S AS QS 3S ");
		assertEquals("White wins", n.Result(a,b));
	}
	void shouldReturnTie(){
		Poker n = new Poker();
		Competitor a = new Competitor("a");
		Competitor b = new Competitor("b");
		a = n.getInformation(a, "2H 3D 5S 9C KD ");
		b = n.getInformation(b, "2D 3H 5C 9S KH ");
		assertEquals("Tie", n.Result(a,b));
	}
}
