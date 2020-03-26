package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamBasic {
	public static void main(String[] args) throws IOException {
		FileStreamBasic s = new FileStreamBasic();
		s.copyFileByByteArr();
	}

	/**
	 * 단일 바이트로 파일복사
	 */
	public void copyFileBasic() {
		// 경로의 파일을 읽어 입력스트림을 생성한다.
		try {
			InputStream in = new FileInputStream("G:\\test.txt");
			OutputStream out = new FileOutputStream("G:\\copy.txt");

			int readByte = 0;
			int copyByte = 0;

			while (true) {
				// 스트림에서 1바이트씩 읽어온다. int는 4바이트지만 실질적으로 끝에 1바이트만 데이터가 담겨있다.
				readByte = in.read();

				// 읽을 데이터가 없으면 -1을 전달한다.
				if (readByte == -1)
					break;

				// copy.txt 파일에 test.txt에 서 읽어온 파일정보를 1바이트씩 쓴다.(시간이 오래걸림)
				out.write(readByte);
				copyByte++;
			}

			// 스트림을 닫는다.
			in.close();
			out.close();
			System.out.println("복사된 바이트크기 " + copyByte);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 단일 바이트로 파일복사
	 */
	public void copyFileByByteArr() {
		// 경로의 파일을 읽어 입력스트림을 생성한다.
		try {
			InputStream in = new FileInputStream("G:\\test.txt");
			OutputStream out = new FileOutputStream("G:\\copy.txt");

			int copyByte = 0;
			int readLen = 0;
			byte[] buf = new byte[1024]; // 입력스트림에서 읽은 데이터를 담을 버퍼

			while (true) {
				//한번에 1k단위로 읽는다(1000배 빠름)
				readLen = in.read(buf);
				
				if (readLen == -1)
					break;

				// 읽어온 데이터를 읽은갯수만큼 한번에 출력스트림에 쓴다.
				out.write(buf, 0, readLen);
				copyByte+=readLen;
			}

			// 스트림을 닫는다.
			in.close();
			out.close();
			System.out.println("복사된 바이트크기 " + copyByte);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
