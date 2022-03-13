package Controllers;

import Service.CyclicRedundancyCode.CyclicRedundancyCodeService;
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

public class CyclicRedundancyCodeController
{
    @FXML
    private Text txt_ErrorMessage;
    @FXML
    private TextArea txt_GeneratorCode;
    @FXML
    private TextArea txt_InputMessage;
    @FXML
    private TextArea txt_EncodedMessage;

    private final CyclicRedundancyCodeService crcService = new CyclicRedundancyCodeService();

    public void goToMain(ActionEvent actionEvent) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void encodeMessage(ActionEvent actionEvent)
    {

        try {
            String remainder = crcService.encodeUsingCRC(txt_InputMessage.getText(), txt_GeneratorCode.getText());
            String encodedMsg = txt_InputMessage.getText().concat(remainder);
            txt_EncodedMessage.setText(encodedMsg);
        }
        catch (NumberFormatException numberFormatException)
        {
            txt_ErrorMessage.setText(numberFormatException.getMessage());
            txt_ErrorMessage.setFill(Color.RED);
        }
        catch (RuntimeException runtimeException)
        {
            txt_ErrorMessage.setText(runtimeException.getMessage());
            txt_ErrorMessage.setFill(Color.RED);
        }
    }

    public void typeText(KeyEvent keyEvent)
    {
        txt_ErrorMessage.setText("");
    }
}
