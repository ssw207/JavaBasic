package String_StringBuilder_���ɺ�;

public class Run {
	public static void main(String[] args) {
		//MyStringBuilder�۵��׽�Ʈ();
		String_StringBuilder�ӵ��׽�Ʈ();
		
	}
	
	public static void MyStringBuilder�۵��׽�Ʈ() {
		String �ʱⰪ = "abc";
		MyStringBuilder sb = new MyStringBuilder(�ʱⰪ);
		System.out.println(sb.toString());
		sb.append("def");
		System.out.println(sb.toString());
	}

	/*
	 * String �۾��ð� : 53197400 // +�����Ҷ����� �޸𸮿� ���� ���� �Ҵ��ϹǷ� ������. 
	 * StringBuilder �۾��ð� : 235700 
	 * MyStringBuilder �۾��ð� : 722000 // char[]ũ�⸦ ������Ű�� ���� �Է��ϹǷ� �ν��Ͻ��� �������� �ʾ� ������.
	 * 
	 */
	public static void String_StringBuilder�ӵ��׽�Ʈ() {
		long ���۽ð� = 0;
		long ����ð� = 0;
		
		String s = "abc";
		StringBuilder sb = new StringBuilder("abc");
		MyStringBuilder msb = new MyStringBuilder("abc");

		���۽ð� = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			s += "a";
		}		
		����ð� = System.nanoTime();

		System.out.println("String �۾��ð� : "+ (����ð� - ���۽ð�));
		
		���۽ð� = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			sb.append("a");
		}		
		����ð� = System.nanoTime();
		
		System.out.println("StringBuilder �۾��ð� : "+ (����ð� - ���۽ð�));
		
		���۽ð� = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			msb.append("a");
		}		
		����ð� = System.nanoTime();
		
		System.out.println("MyStringBuilder �۾��ð� : "+ (����ð� - ���۽ð�));
	}
	
}
