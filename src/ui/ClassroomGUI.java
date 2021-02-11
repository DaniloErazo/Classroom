package ui;

import java.io.IOException;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import model.Classroom;

public class ClassroomGUI {
	
	@SuppressWarnings("unused")
	private Classroom classroom;
	
	public ClassroomGUI(Classroom cr) {
		classroom = cr;
	}
	
	
	public void initialize() {
		
	}
	
	@FXML
    private BorderPane mainPanel;

    @FXML
    public void loadCreateAccount(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createAccount.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent createPane = fxmlLoader.load();
		
		mainPanel.getChildren().clear();
    	mainPanel.setTop(createPane);
    	

    }

    @FXML
    public void loadLogin(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		
		fxmlLoader.setController(this);
		Parent loginPane = fxmlLoader.load();
    	
		mainPanel.getChildren().clear();
    	mainPanel.setCenter(loginPane);

    }

    @FXML
    public void showAbout(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Classroom");
	    alert.setHeaderText("Credits");
	    alert.setContentText("Danilo Erazo\nAlgorithms II");
	
	    alert.showAndWait();
    }
	
	@FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private TextField txtPhotoC;

    @FXML
    void loginAccount(ActionEvent event) {

    }

    @FXML
    public void signUpWindow(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createAccount.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent createPane = fxmlLoader.load();
		
		mainPanel.getChildren().clear();
    	mainPanel.setTop(createPane);
    }
    
    @FXML
    public void browseFile(ActionEvent event) {
    
    	FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Search image");
        File imgFile = fileChooser.showOpenDialog(null);
        
        if (imgFile != null) {
            txtPhotoC.setText(imgFile.getAbsolutePath());
        }

    }
    
    @FXML
    public void signInAfterCreate(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		
		fxmlLoader.setController(this);
		Parent loginPane = fxmlLoader.load();
    	
		mainPanel.getChildren().clear();
    	mainPanel.setCenter(loginPane);
    }
    
    
}
