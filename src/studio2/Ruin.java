package studio2;
import java.util.Scanner;
import java.lang.Math;
public class Ruin {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.print("Your start amount? ");
		int startAmount=in.nextInt();
		System.out.print("Your win Chance? ");
		double winChance=in.nextDouble();
		System.out.print("Your win limit? ");
		int winLimit=in.nextInt();
		System.out.print("Your total simulations? ");
		int totalSimulations=in.nextInt();
		int money= startAmount;
		int loseTimes=0;//set outside from for loop
		for(int i=0;i<=totalSimulations;i++) {
			money=startAmount;//Reset
			String ending="WIN";
			int count=0;
			while(money>0&&money<winLimit) {//if money in this range, continue playing
				if(Math.random()<=winChance) {//you win at this part
					money++;	
				}
				else {
					money--;
					ending="LOSE";
				}
				count++;
			}
			
			if (ending.equals("LOSE")) {
				loseTimes++;
				
			}
			
			System.out.println("Simulation"+i+" :"+count+" "+ending);
			
		}
		double a=(1-winChance)/winChance;
		double expectedRuin;
		if(winChance==0.5) {
			expectedRuin=1-(startAmount)/(double)(winLimit);//(double)加括号CAST
		}
		else {
			expectedRuin=(Math.pow(a, startAmount)-Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
		}
		System.out.println("Losses: "+loseTimes+" Simulations: "+totalSimulations);
		System.out.println("Ruin rate from simulation: "+(double)loseTimes/totalSimulations+" Expected Ruin Rate: "+expectedRuin);
		
		

	}

}
