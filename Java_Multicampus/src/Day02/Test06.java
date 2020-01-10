package Day02;

public class Test06 {
	public static void main(String[] args) {
		int num = 99;
		num = num +1; //100
		num += 1;     //101
		System.out.println(num % 10); //101 % 10 => 1
		System.out.println(num / 10); //
		System.out.println(num);//101
		System.out.println(++num);//
		//System.out.println(num++);
		System.out.println("----------------------");
		System.out.println(num);// 102
		
	    int jumsu = 70;
	    boolean flag = jumsu >= 80;
		System.out.println("우수 ? "+ flag );
        flag = jumsu >=0 && jumsu<=100;
        System.out.println("유효성  ? "+ flag );
		
        System.out.println("-----------------------");
        System.out.printf("%c => %d %n",'0',(int)'0');
        System.out.printf("%c => %d %n",'A',(int)'A'); //65
        System.out.printf("%c => %d %n",'a',(int)'a'); //97
        // 소 => 대   : 소문자인경유에만 -32
        char c = 'd';
		System.out.printf("숫자니? %b %n",Character.isDigit(c));
		flag = c>='0' && c<='9';
		System.out.printf("숫자니? %b %n",flag);
		flag = c>='a' && c<='z';
		System.out.printf("소문자니 %b %n",flag);
		System.out.printf(" %c =>%c %n",c,(char)(c-32));
		
		//삼항연산자
        int score = 50;
        String result = score >= 70 ?"pass":"재시험";
		System.out.println(score +" : "+result);
		System.out.println("-------------------------");
		char ch = 'x';
		char r = (ch>='a'&&ch<='z') ? (char)(ch-32):ch;
		System.out.println(ch +"=>"+r);
	}
}







