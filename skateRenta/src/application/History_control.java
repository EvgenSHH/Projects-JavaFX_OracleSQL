package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class History_control {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button back;

	@FXML
	private TextArea history;

	BaseControl bs = new BaseControl();

	@FXML
	void initialize() {
		try {
			history.appendText(bs.getInfo());
		} catch (SQLException e) {
			history.appendText("Пусто");
		}

		FXMLLoader loader = new FXMLLoader();
		back.setOnAction(event -> {// Назад
			back.getScene().getWindow().hide();

			loader.setLocation(getClass().getResource("Options.fxml"));
			LoaderFXML(loader);

		});
	}

	public void LoaderFXML(FXMLLoader loader) {
		try {
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Parent root = loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
	}
}
