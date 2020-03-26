package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 스트림과 버퍼스트림을 연결해 데이터를 우선 버퍼에 입출력후 버퍼가 가득 차면 한번에 전달한다.
 * 파일(물리적)이 아니라 버퍼러부터(소프트웨어) 데이터를 입출력하므로 속도가 빠르다
 * 
 * 자바프로그램 ---- 입력스트림 ----- 필터스트림 ---- 버퍼스트림 ----- 파일
 * 자바프로그램 ---- 출력스트림 ----- 필터스트림 ---- 버퍼스트림 ----- 파일
 */
public class BufferStream {

	public static void main(String[] args) throws Exception {
		BufferStream bs = new BufferStream();
		String path = "G:\\test.txt";
		bs.write(path);
		bs.read(path);
	}
	
	public void read (String path) throws Exception {
		//파일경로로 부터 파일을 읽어 입력 스트림을 생성한다.
		InputStream in = new FileInputStream(path);
		//속도향상을 위해 데이터를 입출력할 버퍼를 연결한다
		BufferedInputStream bIn = new BufferedInputStream(in);
		//원하는 형테로 데이터를 읽기 위해 필터스트림을 연결한다.
		DataInputStream dIn= new DataInputStream(bIn);
		
		//데이터 출력
		int num1 = dIn.readInt();
		double num2 = dIn.readDouble();
		//스트림을 닫는다.
		dIn.close();
		
		System.out.println(num1);
		System.out.println(num2);
	}
	
	public void write (String path) throws Exception {
		//파일경로로 부터 파일을 생성하고 출력스트림을 생성한다.
		OutputStream out = new FileOutputStream(path);
		//속도향상을 위해 데이터를 입출력할 버퍼를 연결한다
		BufferedOutputStream bOut = new BufferedOutputStream(out);
		//원하는 형테로 데이터를 쓰기위해 필터스트림을 연결한다.
		DataOutputStream dOut = new DataOutputStream(bOut);
		
		//데이터 출력
		dOut.writeInt(229);
		dOut.writeDouble(49.75);
		
		//스트림을 닫는다.
		dOut.close(); 
	}
}

