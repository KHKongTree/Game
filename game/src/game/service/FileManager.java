package game.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import game.dto.UserState;

public class FileManager {

	public static void Save() {
		try {
			// 파일 출력 스트림 생성
			FileOutputStream fos = new FileOutputStream("object.txt");
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

	// 객체를 파일에 저장하는 메소드
	public static void saveObjectToFile(Object obj, String filename) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/userinfo/filename.txt"))) {
			out.writeObject(obj);
		}
	}

	// 파일에서 객체를 읽어오는 메소드
	public static Object loadObjectFromFile(String filename) throws IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("/userinfo/filename.txt"))) {
			return in.readObject();
		}
	}
	
//	    public class LoadObject {
//	        public static void main(String[] args) {
//	            try {
//	                // 파일 입력 스트림 생성
//	                FileInputStream fis = new FileInputStream("object.txt");
//	                // 객체 입력 스트림 생성
//	                ObjectInputStream ois = new ObjectInputStream(fis);
//	                // 파일에서 객체 정보 읽어오기
//	                Person p1 = (Person)ois.readObject();
//	                Person p2 = (Person)ois.readObject();
//	                
//	                 System.out.println(p1); // 홍길동 20 출력 
//	                 System.out.println(p2); // 김철수 30 출력 
//	                 
//	                 //스트림 닫기 
//	                 ois.close(); 
//	            } catch (Exception e) { 
//	                 e.printStackTrace(); 
//	            } 
//	        } 
//	    }

	public static void fileReader() {
		File folder = new File("/userinfo");
		File[] files = folder.listFiles();

		for (File file : files) {
			if (file.isFile() && file.getName().endsWith(".txt")) {
				System.out.println(file.getName());
			}
		}

	}

}
