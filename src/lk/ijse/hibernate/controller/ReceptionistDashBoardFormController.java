package lk.ijse.hibernate.controller;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class ReceptionistDashBoardFormController {
    public AnchorPane context;
    public Label lblRegistration;
    public Label lblStudent;
    public Label lblRoomsAvailability;
    public Button btnRoomAvailability;
    public Button btnStudent;
    public Button btnRegister;
    public Label lblChangePassword;
    public Button btnChangePwd;
    public Label lblDate;
    public Label lblTime;
    public Label lblReceptionistName;
    public AnchorPane optionContext;
    public Label lblRemainKeyMoney;
    public Button btnRemainKeyMoney;
    ObservableList obList = FXCollections.observableArrayList();

    public void initialize() {
        loadDateAndTime();
        lblReceptionistName.setText(LoginFormController.user.getName());
        obList.addAll(lblRoomsAvailability, btnRoomAvailability, lblStudent, btnStudent, lblRegistration, btnRegister, lblRemainKeyMoney, btnRemainKeyMoney, lblChangePassword, btnChangePwd);
    }

    private void loadDateAndTime(){
        lblDate.setText(new SimpleDateFormat("EEEE, MMMM dd, yyyy").format(new Date()));
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,(ev)-> {
            LocalTime currentTime = LocalTime.now();
            int hour = currentTime.getHour();
            String minute = currentTime.getMinute() < 10 ? "0" + currentTime.getMinute() : String.valueOf(currentTime.getMinute());
            String second = currentTime.getSecond() < 10 ? "0" + currentTime.getSecond() : String.valueOf(currentTime.getSecond());
            if (hour >= 12) {
                lblTime.setText(currentTime.getHour() + ":" + minute + ":" + second + " PM");
            } else {
                lblTime.setText(currentTime.getHour() + ":" + minute + ":" + second + " AM");
            }
        }),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void checkRoomsAvailabilityOnAction(ActionEvent event) {
        setColors(lblRoomsAvailability,btnRoomAvailability);
        setUI("CheckRoomsAvailabilityForm");
    }

    public void manageStudentOnAction(ActionEvent event) {
        setColors(lblStudent,btnStudent);
        setUI("ManageStudentForm");
    }

    public void makeRegistrationOnAction(ActionEvent event) {
        setColors(lblRegistration,btnRegister);
        setUI("RegistrationForm");
    }

    public void findRemainKeyMoneyStudentsOnAction(ActionEvent event) {
        setColors(lblRemainKeyMoney,btnRemainKeyMoney);
        setUI("FindRemainKeyMoneyStudentForm");
    }

    public void changePasswordOnAction(ActionEvent event) {
        setColors(lblChangePassword,btnChangePwd);
        setUI("ChangePasswordForm");
    }

    private void setUI(String fxmlFile) {
        try {
            optionContext.getChildren().clear();
            optionContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/" + fxmlFile + ".fxml")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setColors(Label label, Button btn) {
        for (Object obj : obList) {
            if (obj instanceof Label) {
                ((Label) obj).setStyle("-fx-background-color: null");
                if (((Label) obj).getId().equals(label.getId())) {
                    ((Label) obj).setStyle("-fx-background-color: #0097e6");
                }
            } else if (obj instanceof Button) {
                ((Button) obj).setStyle("-fx-background-color: null");
                if (((Button) obj).getId().equals(btn.getId())) {
                    ((Button) obj).setStyle("-fx-background-color: #0097e6");
                }
            }
        }
    }

    public void logOutOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
        stage.setTitle("Hostel Login");
        stage.show();
    }
}
