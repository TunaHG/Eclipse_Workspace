package Workshop3;

public class Prob05 {

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		int d = Integer.parseInt(args[3]);
		
		Calc cc = new Calc();
		
		int sum = cc.calcSum(a, b, c, d);
		double avg = sum / 4.;
		
		char grade = ' ';
		if(avg <= 100 && avg >= 90) grade = 'A';
		else if(avg >= 80) grade = 'B';
		else if(avg >= 70) grade = 'C';
		else if(avg >= 60) grade = 'D';
		else grade = 'F';
		
		System.out.println(sum);
		System.out.println(avg);
		System.out.println(grade);
	}

}

class Calc {
	public int calcSum(int a, int b, int c, int d){
		return a + b + c + d;
	}
}