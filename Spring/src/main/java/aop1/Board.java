package aop1;

import java.util.ArrayList;

public class Board {
	public Integer insertBoard(int seq) {
		System.out.println(seq + "번째 게시물 등록");
		
		return seq;
	}
	
	public ArrayList<String> getList(){
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("게시물 목록 출력");
		list.add("1, 스프링 수업중");
		list.add("2, 안드로이드 수업중");
		list.add("3, 하둡 수업중");
		
		return list;
	}
}
