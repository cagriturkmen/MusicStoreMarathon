package com.marathon.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.log4j.chainsaw.Main;

import com.marathon.controller.AdminController;
import com.marathon.controller.OrderController;
import com.marathon.controller.RecordController;
import com.marathon.controller.SingerController;
import com.marathon.controller.UserController;
import com.marathon.entity.AdminEntity;
import com.marathon.entity.OrderEntity;
import com.marathon.entity.RecordEntity;
import com.marathon.entity.SingerEntity;
import com.marathon.entity.UserEntity;
import com.marathon.types.Genre;
import com.marathon.types.Types;

public class TestMain {
	public static void main(String[] args) throws IOException {
		
		MainMethods mainMethods = new MainMethods();
		//createUserandLogin();
		//createSingerandRecord();
		mainMethods.createOrder();
		//adminLogin();
		//findRecord();
		
		
	}
	public static void adminLogin() {
		AdminController adminController = new AdminController();
		adminController.adminLogin(new AdminEntity("admin","qwerty")); 
		
		adminController.createUser("Çağrı1","12345");
	}
	public static void createUserandLogin() {
		UserController userController = new UserController();
		UserEntity user1 = new UserEntity("Çağrı","Türkmen","cagri@turkmen","1234","istanbul","325354");
		userController.create(user1);
		
		if(userController.login(new UserEntity("cagri@turkmen","1234"))) {
			System.out.println("Successfull login");
		}else {
			System.out.println("Mail or password is not correct");
		}
		}
	
	public static void createSingerandRecord() throws IOException {
		byte[] picture=Files.readAllBytes(Paths.get("maticpunk.jpg"));
		SingerController singerController = new SingerController();
		SingerEntity singer1 = new SingerEntity("Britney", "Spears", "PopSinger",Genre.POP);
		SingerEntity singer2 = new SingerEntity("Jennifer", "Lopez", "PopSinger",Genre.POP);

		singerController.create(singer1);
		singerController.create(singer2);

		RecordController recordController = new RecordController();
		RecordEntity record1 = new RecordEntity("Toxic", 100.0, 10.0, singer1,Types.CD);
		RecordEntity record2 = new RecordEntity("I am into you", 50.0, 10.0, singer2,Types.DVD);

		//record1.setPicture(picture);   
		//Hocam picture ekleniyor. find methodunu çalıştırınca  unable to show LobStream gibi bi hata veriyor. (Tostringden picture'ı çıkardım, yine de hata düzelmedi).
		recordController.create(record1);
		recordController.create(record2);
		
	}
	public static void findRecord() {
		//List<RecordEntity> recordList = null;
		RecordController recordController = new RecordController();
	    //SingerController singerController = new SingerController();
	    System.out.println(recordController.find(1L));
	    
	    
	}
	public static void listingTest() {
		List<RecordEntity> list = null;
	    
	    RecordController recordController = new RecordController();
	    SingerController singerController = new SingerController();
	    list = recordController.listBySalesCount();
	    
	    // list.forEach(System.out::println);
	    
	    list = recordController.listBySinger(singerController.find(3));
	   
	    // list.forEach(System.out::println);
	    
	    list = recordController.listByGenre("POP");
	    
	    // list.forEach(System.out::println);
	    
	    list = recordController.listDiscountedFifteenAlbum();
	    
	    // list.forEach(System.out::println);
	    
	    list = recordController.listLastTenRecord();
	    
	    list.forEach(System.out::println);
	    
	}
}
