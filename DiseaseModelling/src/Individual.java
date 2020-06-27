import java.util.Random;

public class Individual {
	
	public double x;
	public double y;
	public boolean disease;
	
	public Individual(double x, double y, boolean disease) {
		this.x = x;
		this.y = y;
		this.disease = disease;
	}
	
	public Individual() {
		this.disease = false;
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public Individual(boolean disease) {
		this.disease = disease;
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public boolean getsDisease(double percent) {
		double per = 100 * percent;
		Random rand = new Random();
		int cent = rand.nextInt(101);
		if(cent < per) {
			this.disease = true;
			return true;
		}
		return false;
	}
	
	public boolean isInRadius(Individual ind1) {
		double x1 = this.x;
		double y1 = this.y;
		double x2 = ind1.x;
		double y2 = ind1.y;
		
		double changeX = x2 - x1;
		double changeY = y2 - y1;
		
		double changeXsquared = changeX * changeX;
		double changeYsquared = changeY * changeY;
		
		double sum = changeXsquared + changeYsquared;
		
		double distance = Math.sqrt(sum);
		
		if((distance > 0) && (distance < 6)) {
			return true;
		}
		return false;
	}
	
	public void printIndividual() {
		System.out.println("x coordinate: " + this.x + " y coordinate: " + this.y + " disease: " + disease);
	}
	
}
