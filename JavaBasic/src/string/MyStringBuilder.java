package string;

import java.util.Arrays;

public class MyStringBuilder {

	int 현재문자수;
	char[] 현재문자배열;

	@Override
	public String toString() {
		return new String(현재문자배열);
	}

	public MyStringBuilder() {}

	public MyStringBuilder(String 초기값) {
			// 초기값 + 16 만큼 현재문자배열 생성
			현재문자수 = 초기값.length();
			현재문자배열 = new char[ 초기값.length()+16];
			// 현재문자열에 초기값 입력
			초기값.getChars(0, 초기값.length(), 현재문자배열, 0);
		}

	public void append(String 추가문자열) {
		// 1.문자열을 추가한뒤 현재문자배열의 크기보다 커지면 현재문자열의 크기를 2배로 늘린다
		int 이전문자수 = 현재문자수;
		현재문자수 = 이전문자수 + 추가문자열.length();
		if (현재문자수 > 현재문자배열.length) {
			현재문자배열 = Arrays.copyOf(현재문자배열, 현재문자배열.length * 2);
		}

		// 2.현재문자배열에 추가문자열의 값을 더한다.
		추가문자열.getChars(0, 추가문자열.length(), 현재문자배열, 이전문자수);
	}
}
