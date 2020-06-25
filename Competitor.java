package lesson;

class Competitor {
	int[] CardsNumber = new int[15];
	int level = 0;
	int max;
	int min;
	String name;
	
	Competitor(String n){
		name = n;
	}
		
	boolean Straight() {
		boolean bool = true;
		around:
		for(int i = 2; i < 11; i++) {
			if(CardsNumber[i] == 1)
				{
					for(int j = i + 1; j < i + 5; j++)
						if(CardsNumber[j] != 1) {
								bool = false;
								break around;
							}
					max = CardsNumber[i + 4];
				}
		}
		return bool;
	}
	void Three() {
		for(int i = 2; i < CardsNumber.length; i++) {
			if(CardsNumber[i] == 3)
			{
				max = i;
				level = 3;
			}
		}
	}
	void twoTwo() {
		around:
		for(int i = 2; i < CardsNumber.length; i++) {
			if(CardsNumber[i] == 2) {
				for(int j = i + 1; j < CardsNumber.length; j++)
					if(CardsNumber[j] == 2)
					{
						max = j;
						min = i;
						level = 2;
						break around;
					}
				max = i;
				level = 1;
				break;
			}
		}
	}
	
}
