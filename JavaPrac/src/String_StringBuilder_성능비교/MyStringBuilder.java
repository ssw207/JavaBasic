package String_StringBuilder_���ɺ�;

import java.util.Arrays;

public class MyStringBuilder {
	int ���繮�ڼ�;
	char[] ���繮�ڹ迭; 
	
	@Override
	public String toString() {
		return new String(���繮�ڹ迭);
	}
	
	public MyStringBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	public MyStringBuilder(String �ʱⰪ) {
		// �ʱⰪ + 16 ��ŭ ���繮�ڹ迭 ����
		���繮�ڼ� = �ʱⰪ.length();
		���繮�ڹ迭 = new char[ �ʱⰪ.length()+16];
		// ���繮�ڿ��� �ʱⰪ �Է�
		�ʱⰪ.getChars(0, �ʱⰪ.length(), ���繮�ڹ迭, 0);
	}
	
	public void append(String �߰����ڿ�) {
		// 1.���ڿ��� �߰��ѵ� ���繮�ڹ迭�� ũ�⺸�� Ŀ���� ���繮�ڿ��� ũ�⸦ 2��� �ø���
		int �������ڼ� = ���繮�ڼ�; 
		���繮�ڼ� = �������ڼ� + �߰����ڿ�.length();
		if( ���繮�ڼ� > ���繮�ڹ迭.length ) {
			���繮�ڹ迭 = Arrays.copyOf(���繮�ڹ迭, ���繮�ڹ迭.length*2);
		}
		
		// 2.���繮�ڹ迭�� �߰����ڿ��� ���� ���Ѵ�.
		�߰����ڿ�.getChars(0, �߰����ڿ�.length(), ���繮�ڹ迭, �������ڼ�);
	}
}
