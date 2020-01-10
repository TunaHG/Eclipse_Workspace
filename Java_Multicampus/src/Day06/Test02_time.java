package Day06;

public class Test02_time {
	public static void main(String[] args) {
		Time t1 = new Time();
		//t1.hour = -13;
		t1.setHour(13);
		//t1.minute = 30;
		t1.setMinute(30);

		t1.print();
	}
	
	
}

class Time{
	private int hour;
	private int minute;
	private int second;
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if(hour >= 0 && hour < 24)
		    this.hour = hour;
	}
	public int getMinute() {
		return hour;
	}
	public void setMinute(int minute) {
		if(minute >= 0 && minute < 59)
		    this.minute = minute;
	}
	public int getSecond() {
		return hour;
	}
	public void setSecond(int second) {
		if(second >= 0 && second < 59)
		    this.second = second;
	}
	
	public void print() {
		System.out.printf("(%d시:%d분:%d초) %n",
				           this.hour,this.minute,this.second);
	}
}






