import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
/**
 * ' import javafx.scene.control.*; ' will import everything under scene.control to avoid single class imports
 *
 */

public class Authentication extends Application{

    private int attempt = 0;/** Set the initial attempt to 0 inside CLASS to use 'attempt++' later to count attempts */

    public enum AccountType{
        SelectAccount, Administrator, Student, Staff, Guest
    }

    public static void main(String[]args){
        launch(args);//launch will call start
    }


    @Override
    public void start(Stage primaryStage)   {


        /** This takes place of a DATABASE
         *  Set correctUsername to 'phung' and correctPassword to 'ngo'
         *  And the correctAcType of the username and password to Student
         *  Set the limit attempt to 3 to avoid fraud
         */
        String correctUsername = "phung";
        String correctPassword = "ngo";
        AccountType correctAcType = AccountType.Student;
        final int LIMIT = 3;


        /**
         *  TextField allow user to enter a small amount of text, used for 'usernameTxt'.
         *  PasswordField hides the character, used for passwordField.
         *  ComboBox provide a popup list for user to choose from, used for AccountType.
         */
        TextField usernameTxt = new TextField();
        usernameTxt.setText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setText("password");
        ComboBox <AccountType> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(AccountType.SelectAccount, AccountType.Administrator, AccountType.Student, AccountType.Staff, AccountType.Guest);
        comboBox.setValue(AccountType.SelectAccount);
        comboBox.setVisible(false);
        Button submitBtn = new Button("Log in");

        /** Make sure the user enter the right username and password with the right account type using if-else.
         *  ' submitBtn.setOnAction(e-> ' set what will happen when user press the button 'submitBtn'.
         *  Declaring alert outside 'if' will help avoid repeating declaration.
         *  If username and password are entered correctly with the account, it is successful.
         *  Else if the attempt are still under or equal to 3, it will ask again until it reach the LIMIT.
         *  Else if the attempt are over three(LIMIT), the account is locked.
         */
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        submitBtn.setOnAction(e->{

            if(usernameTxt.getText().equals(correctUsername) && passwordField.getText().equals(correctPassword) && attempt<=LIMIT){
                comboBox.setVisible(true);

            } else if(attempt < LIMIT) {
                alert.setContentText("Your username or password is incorrect!");
                alert.showAndWait();
                attempt++;
            } else if( attempt >= LIMIT) {
                            alert.setContentText("Please contact administrator to unlock your account!");
                            alert.showAndWait();
            }
        });/** submitBtn.setOnAction(e->{...}' set what will happen when user entered right username and password */


        comboBox.setOnAction(e->{
                if(comboBox.getValue().equals(correctAcType)){
                    alert.setContentText("Welcome " + correctUsername + "!");
                    alert.showAndWait();
                } else  {
                    alert.setContentText("Wrong Account type! Please select correct account type.");
                    alert.showAndWait();
            }

        });/** 'comboBox.setOnAction(e->{...}' set what will happen when user chose the right account type */

        VBox pane = new VBox();
        pane.getChildren().addAll(usernameTxt, passwordField, comboBox, submitBtn);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Authentication");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


}

