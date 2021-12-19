package com.marathon;

import java.io.IOException;

import com.marathon.entity.UserEntity;
import com.marathon.util.HibernateUtil;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// VM Arguments
	// --module-path "C:\Users\cturk\Downloads\javafx-sdk-17.0.1\lib"--add-modules javafx.controls,javafx.fxml
	// 
	public class MainTest extends Application {
	  private static Scene scene;


	  public static void main(String[] args) {
//	    HibernateUtil util = new HibernateUtil();
//	    util.getSessionfactory();
	    launch();
	  }

	  @Override
	  public void start(Stage stage) throws Exception {
	    scene = new Scene(loadFXML("Login"), 1200, 600);
	    stage.setScene(scene);
	    stage.show();

	  }

	  public static void setRoot(String fxml) throws IOException {

	    scene.setRoot(loadFXML(fxml));
	  }

	  public static void setHomePage(UserEntity user) throws IOException {
	    FXMLLoader fxmlLoader = new FXMLLoader(MainTest.class.getResource("HomePage.fxml"));

	    scene.setRoot(fxmlLoader.load());

	   // HomePageController controller = fxmlLoader.getController();
	    //controller.initUserInfo(user);
	  }


	  private static Parent loadFXML(String fxml) throws IOException {
	    FXMLLoader fxmlLoader = new FXMLLoader(MainTest.class.getResource(fxml + ".fxml"));
	    return fxmlLoader.load();
	  }


}
