import java.util.Random;

public class Society {

	public int population;
	public double chanceOfInfection;
	public Individual[] popArray;
	public int numberOfInfections = 0;
	public int initialInfections;
	
	public Society(int population, double chanceOfInfection, int initialInfections) {
		this.population = population;
		this.chanceOfInfection = chanceOfInfection;
		this.initialInfections = initialInfections;
		this.numberOfInfections += initialInfections;
	}
	
	public void randomizeIndividuals() {
		Individual ind1;
		for(int i = 0; i < this.population; i++) {
			if(i < this.initialInfections) {
				ind1 = new Individual(true);
			} else {
				ind1 = new Individual();
			}
			this.popArray[i] = ind1;
		}
		RandomizeLocation();
	}
	
	public void RandomizeLocation() {
		Random rand = new Random();
		for(int i = 0; i < this.population; i++) {
			this.popArray[i].x = rand.nextInt(100) + rand.nextDouble();
			this.popArray[i].y = rand.nextInt(100) + rand.nextDouble();
		}
	}
	
	public void MoveDaily() {
		Random rand = new Random();
		for(int i = 0; i < this.population; i++) {
			if(rand.nextInt(10) % 2 == 0) {
				this.popArray[i].x = this.popArray[i].x + rand.nextInt(5) + rand.nextDouble();
				this.popArray[i].y = this.popArray[i].y + rand.nextInt(5) + rand.nextDouble();
			} else {
				this.popArray[i].x = this.popArray[i].x - rand.nextInt(5) + rand.nextDouble();
				this.popArray[i].y = this.popArray[i].y - rand.nextInt(5) + rand.nextDouble();
			}
		}
	}
	
	public void printSociety() {
		System.out.println("Population: " + this.population);
		System.out.println("Number of infections: " + this.numberOfInfections);
	}
	
	public void printInfections() {
		System.out.println("Number of infections: " + this.numberOfInfections);
	}
}
