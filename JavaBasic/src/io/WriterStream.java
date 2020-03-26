package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * 문자열 스트림은 본질적으로 바이트스트림과 차이가 없다.
 * 바이트 스트림은 인코딩을 바꾸지않고 자바에서 인코딩(유니코드?)기준으로 입출력을한다.
 * OS의 인코딩은 자바의 인코딩과 다르므로 자바기준으로 인코딩된 데이터는 OS에서 읽을수가 없다.
 * 이런 문제를 해결하기 위해서 문자열 인코딩을 사용한다.
 * 따라서 OS와 입출력하지 않는다면 문자열스트림을 굳이 사용할 필요는 없다. 
 *
 */
public class WriterStream {
	public static void main(String[] args) throws Exception {
		WriterStream ws = new WriterStream();
		String path = "G:\\test.txt";
		ws.write(path);
		ws.read(path);
	}
	
	public void read(String path) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(path));
		
		while (true) {
			String s = in.readLine();
			if (s == null)
				break;
			
			System.out.println(s);
		}
	}
	
	public void write(String path) throws Exception {
		BufferedWriter o = new BufferedWriter(new FileWriter(path));
		o.write("테스트입니다.");
		o.write("\n 개행이되지 않습니다.");
		o.write("문자열 스트림은 자바 인코딩이 아니라 OS 기준으로 인코딩을 하기 때문입니다.");
		o.write("실제 파일을 열어보면 인코딩일 깨지지 않고 내용을 읽을수 있습니다.");
		o.newLine();
		o.write("newLine은 운영체재에 맞는 개행문자를 삽입하니다.");
		o.newLine();
		
		PrintWriter p = new PrintWriter(o);
		p.println("PrintWriter도 Writer클래스를 상속받았기 때문에 이렇게도 출력 가능합니다.");
		p.println("println은 OS의 개행문자를 자동으로 삽입합니다.");
		
		o.close();
	}
}
