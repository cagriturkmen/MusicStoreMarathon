package com.marathon.fx.controller;

import java.io.IOException;
import java.util.Optional;

import com.marathon.controller.UserController;
import com.marathon.entity.UserEntity;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginFxController {
  private UserEntity user;

  // private OpenScene openScene;
  @FXML
  private Button btn_login;

  @FXML
  private TextField edt_user_email;

  @FXML
  private PasswordField edt_user_password;

  @FXML
  private Button register_btn;

  @FXML
  private TextField register_edt_email;

  @FXML
  private PasswordField register_edt_pasword;

  @FXML
  private PasswordField register_edt_re_password;

  @FXML
  private TextField register_edt_username;


  @FXML
  void onRegisterClick(MouseEvent event) {
    register_btn.setDisable(true);
    UserController dao = new UserController();

    Alert alert = new Alert(AlertType.INFORMATION);

    if (regexUserInformation()) {
      //if (dao.create(user)) {
        alert.setAlertType(AlertType.INFORMATION);
        alert.setTitle("Kayıt Başarılı");

      } else {
        alert.setAlertType(AlertType.WARNING);
        alert.setTitle("Kayıt Başarısız");
        alert.setHeaderText("Lütfen Bilgilerinizi kontrol ediniz.");
      }
      register_btn.setDisable(false);
      alert.show();
    }


 // }

  private boolean regexUserInformation() {
    String username = register_edt_username.getText();
    String email = register_edt_email.getText();
    String password = register_edt_pasword.getText();
    String rePassword = register_edt_re_password.getText();

   // user = new UserEntity(username, email, password);

    if (password.equals(rePassword)) {
      return true;
    } else {
      Alert alert = new Alert(AlertType.WARNING);
      alert.setTitle("Şifreler Eşleşmiyor");
      alert.show();
    }
    return false;
  }

  @FXML
  void onClickBtnLogin(MouseEvent event) {

    btn_login.setDisable(!btn_login.isDisable());
    UserController dao = new UserController();
    String email = edt_user_email.getText();
    String password = edt_user_password.getText();

    

    if (dao.login(new UserEntity(email, password))) {
      btn_login.setDisable(!btn_login.isDisable());

//      try {
//
//       // MainTest.setHomePage(opt.get());
//      } catch (IOException e) {
//
//      }


    } else {
      Alert alert = new Alert(AlertType.WARNING);
      btn_login.setDisable(!btn_login.isDisable());
      alert.setHeaderText("Email ya da Şifre Hatalı");
      alert.setTitle("Giriş Başarısız");
      alert.show();
    }


  }

}