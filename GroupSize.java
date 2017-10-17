import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
/**
 * Author: pngo
 * Purpose: Develop an application to assist athletes.
 * Prompt user to enter number of people.
 * if numPeople is greater than 10, execute groupSize = numPeople / 2
 * else if numPeople is less than 10 and bigger than 3, execute groupSize = numPeople / 3;
 * Otherwise, display message "The number if people has to be at least 3."
 * Requirements:
 * Use VI and Terminal
 * Submit on Github
 * JavaDoc
*/


public class GroupSize extends Application{
        @Override
        public void start(Stage primaryStage){
                TextInputDialog dialog = new TextInputDialog();
                dialog.setHeaderText("Enter the number of people");
                Optional<String> numPeople1 = dialog.showAndWait();
                int numPeople = Integer.parseInt(numPeople1.get());
                int groupSize;

                if(numPeople > 10){
                        groupSize = numPeople / 2;
                        Alert alertTrue = new Alert(AlertType.INFORMATION);
                        alertTrue.setContentText("For a group of " + numPeople + " people, each group should contain " + groupSize + " members.");
                        alertTrue.showAndWait();

                } else if(numPeople > 3  &&  numPeople < 10) {
                        groupSize = numPeople / 3;
                        Alert smallGroup = new Alert(AlertType.INFORMATION);
                        smallGroup.setContentText("For a group of " + numPeople + " people, each group should contain " + groupSize + " members");
                        smallGroup.showAndWait();
                } else {
                        Alert alertFalse = new Alert(AlertType.INFORMATION);
                        alertFalse.setContentText("The number of people has to be at least 3");
                        alertFalse.showAndWait();
                }

        }

}
