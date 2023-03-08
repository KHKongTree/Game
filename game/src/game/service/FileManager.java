package game.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import game.dto.UserState;

public class FileManager {
	// 객체를 파일에 저장하는 메소드
	public static void save() {
		try {
			// 파일 출력 스트림 생성
			FileOutputStream fos = new FileOutputStream("story.txt");
			// 객체 출력 스트림 생성
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// 객체 정보를 파일에 쓰기
			oos.writeObject(new UserState());
			// 스트림 닫기
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 파일에서 객체를 읽어오는 메소드
	public static void load() {
			try {
				// 파일 입력 스트림 생성
				FileInputStream fis = new FileInputStream("story.txt");
				// 객체 입력 스트림 생성
				ObjectInputStream ois = new ObjectInputStream(fis);
				// 파일에서 객체 정보 읽어오기
				UserState story = (UserState) ois.readObject();
				// 스트림 닫기
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
