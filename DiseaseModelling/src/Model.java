
public class Model {

	public static void main(String[] args) {
		
		int pop = 1000;
		double chance = 0.2;
		int initialCases = 1;
		int numDays = 30;
		
		Society society = new Society(pop, chance, initialCases);
		society.printSociety();
		society.popArray = new Individual[pop];
		System.out.println();
		
		society.randomizeIndividuals();
		society.RandomizeLocation();
		
		for(int i = 0; i < numDays; i++) {
			System.out.println("Day " + (i + 1) + ":");
			society.MoveDaily();
			for(int j = 0; j < pop; j++) {
				Individual ind1 = society.popArray[j];
				if(ind1.disease) {
					for(int k = 0; k < pop; k++) {
						if(k != j) {
							Individual ind2 = society.popArray[k];
							if(!ind2.disease) {
								if(ind1.isInRadius(ind2)) {
									if(ind2.getsDisease(chance)) {
										society.numberOfInfections++;
									}
								}
							}
						}
					}
				}
			}
			society.printInfections();
			System.out.println();
		}
	}
}
