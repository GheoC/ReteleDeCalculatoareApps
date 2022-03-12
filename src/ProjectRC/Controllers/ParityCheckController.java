package Controllers;


import Service.ParityCheck.ParityCheckerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ParityCheckController {
    @FXML
    private TextArea txt_ResultMsg;
    @FXML
    private Text txt_ErrorMsg;
    @FXML
    private TextArea txt_InputText;

    private final ParityCheckerService parityChecker = new ParityCheckerService();

    public void checkParity(ActionEvent actionEvent) {

        System.out.println(txt_InputText.getText());
        txt_InputText.setWrapText(true);

        try {
            parityChecker.doSomething(txt_InputText.getText());
            txt_ResultMsg.setText(parityChecker.getEncodedMessage());
        } catch (RuntimeException e) {
            txt_ErrorMsg.setText(e.getMessage());
            txt_ErrorMsg.setFill(Color.RED);
        }
    }


    public void typeText(KeyEvent keyEvent)
    {
        txt_ErrorMsg.setText("");
    }

    public void goToMain(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
