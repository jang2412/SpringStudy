package study;

public class TestMethod {

	public static void main(String[] args) {
		fu1(3,"밀키스");
		line();
		//	사랑해요~~ 밀키스!! 5번 출력
		fu1(5,"밀키스");
		line();
		fu1(2,"코카콜라");
		
	}
	public static void fu1(int x, String y) {
		for(int i=0;i<x;i++) {
			System.out.println("사랑해요~~ "+y+"!!");
		}
	}
	public static void line() {
		System.out.println("--------------------");
	}
}
