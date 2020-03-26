package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * FileInput/ouput Stream은 파일은 byte 단위로 읽는다.
 * FilreStreamBasic에서 파일을 읽을수는 있으나 내가 원하는 형태(int, String ...)로 읽어들일수 없다.
 * 대상으로부터 데이터를 읽음 -> 데이터를 가공해주는 클래스(FilterStream) 가 원하는 형태로 변환 -> 데이터 출력
 * FilterStream가 원하는 형태로 변경해 주기원해서는 원하는 Stream인스턴스를 알아야한다.
 * 
 * ori.txt ---> 입력스트림 ---> 필터스트림 ---> 자바프로그램
 */
public class FilterStream {
	public static void main(String[] args) {
		FilterStream f = new FilterStream();
		String path = "G:\\test.txt";
		f.write(path);
		f.read(path);
	}
	
	/**
	 * path의 경로에 파일을 생성한뒤 데이터를 입력한다.
	 * @param path
	 */
	public void write(String path) {
		try {
			//파일출력스트림 인스턴스를 생성하고 path의 경로에 파일을 생성한다.
			OutputStream out = new FileOutputStream(path);
			//파일출력스트림과 필터스트림(데이터출력스트림)을 연결한다.
			DataOutputStream filterOut = new DataOutputStream(out);
			
			//출력출력스트림에 int, double 형식으로 데이터를 입력한다.
			//출력필터스트림은 출력스트림에 byte 단위로 데이터를 전달한다.
			//출력스트림은 전달받은 byte단위 데이터를 파일에 출력한다.
			filterOut.writeInt(279);
			filterOut.writeDouble(45.79);
			filterOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void read(String path) {
		try {
			//경로로 부터 파일을 읽어 입력스트림으 생성한다.
			InputStream in = new FileInputStream(path);
			//입력스트림과 입력필터를 연결한다.
			DataInputStream filterIn = new DataInputStream(in);
			
			//입력필터는 입력스트림으로부터 byte단위 데이터를 읽여와 원하는 형태로 변경해 데이터를 읽는다. 
			int num1 = filterIn.readInt();
			double num2= filterIn.readDouble();
			filterIn.close();
			
			System.out.println(num1);
			System.out.println(num2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
