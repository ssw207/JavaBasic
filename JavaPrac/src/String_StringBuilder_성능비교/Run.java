package String_StringBuilder_성능비교;

public class Run {
	public static void main(String[] args) {
		//MyStringBuilder작동테스트();
		String_StringBuilder속도테스트();
		
	}
	
	public static void MyStringBuilder작동테스트() {
		String 초기값 = "abc";
		MyStringBuilder sb = new MyStringBuilder(초기값);
		System.out.println(sb.toString());
		sb.append("def");
		System.out.println(sb.toString());
	}

	/*
	 * String 작업시간 : 53197400 // +연산할때마다 메모리에 값을 새로 할당하므로 느리다. 
	 * StringBuilder 작업시간 : 235700 
	 * MyStringBuilder 작업시간 : 722000 // char[]크기를 증가시키며 값을 입력하므로 인스턴스가 생성되지 않아 빠르다.
	 * 
	 */
	public static void String_StringBuilder속도테스트() {
		long 시작시간 = 0;
		long 종료시간 = 0;
		
		String s = "abc";
		StringBuilder sb = new StringBuilder("abc");
		MyStringBuilder msb = new MyStringBuilder("abc");

		시작시간 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			s += "a";
		}		
		종료시간 = System.nanoTime();

		System.out.println("String 작업시간 : "+ (종료시간 - 시작시간));
		
		시작시간 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			sb.append("a");
		}		
		종료시간 = System.nanoTime();
		
		System.out.println("StringBuilder 작업시간 : "+ (종료시간 - 시작시간));
		
		시작시간 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			msb.append("a");
		}		
		종료시간 = System.nanoTime();
		
		System.out.println("MyStringBuilder 작업시간 : "+ (종료시간 - 시작시간));
	}
	
}
