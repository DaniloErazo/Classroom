package ui;

import java.io.IOException;
import java.time.LocalDate;
import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import model.Classroom;
import model.UserAccount;

public class ClassroomGUI {
	
	private Classroom classroom;
	
	public ClassroomGUI(Classroom cr) {
		classroom = cr;
	}
	
	
	
	@FXML
    private BorderPane mainPanel;

	
	
	//FXML elements and control for main pane
    @FXML
    public void loadCreateAccount(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		
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
	
    //FXML elements for login page
    @FXML
    private TextField txtUsernameL;

    @FXML
    private PasswordField txtPasswordLogin;

   
    
    @FXML
    public void loginAccount(ActionEvent event) throws IOException {
    	
    	if(!blanksRequiredL()) {
    		
    		Alert alert = new Alert(AlertType.WARNING);
    	    alert.setTitle("Classroom");
    	    alert.setHeaderText("Problem with registration");
    	    alert.setContentText("All blanks are required, please verify");

    	    alert.showAndWait();
    		
    	}else {
	    	String user = txtUsernameL.getText();
	    	String password = txtPasswordLogin.getText();
	    	if(classroom.searchForAccount(user)) {
	    		if(classroom.verifyPassword(password, user)) {
	    			
	    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
	    			
	    			fxmlLoader.setController(this);
	    			Parent accountList = fxmlLoader.load();
	    	    	
	    			mainPanel.getChildren().clear();
	    	    	mainPanel.setCenter(accountList);
	    	    	usernameAccountList.setText(user);
	    	    	
	    	    	File imagePath = new File(classroom.getUserImage(user));
	    	    	Image userImage = new Image(imagePath.toURI().toString());
	    	    	imageUser.setImage(userImage);
	    	    	
	    	    	initializeTableView();
	    	    	
	    	    	
	    			
	    			
	    		}else {
	    			
	    			Alert alert = new Alert(AlertType.WARNING);
	        	    alert.setTitle("Classroom");
	        	    alert.setHeaderText("Problem with password");
	        	    alert.setContentText("Wrong password, please verify");
	
	        	    alert.showAndWait();
	    			
	    		}
	    	}else {
	    		
	    		Alert alert = new Alert(AlertType.WARNING);
	    	    alert.setTitle("Classroom");
	    	    alert.setHeaderText("Problem with login");
	    	    alert.setContentText("The username isn´t resgistered, please verify");
	
	    	    alert.showAndWait();
	    		
	    	}
    	}

    }

    @FXML
    public void signUpWindow(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createAccount.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent createPane = fxmlLoader.load();
		
		mainPanel.getChildren().clear();
    	mainPanel.setTop(createPane);
    }
    
    
    //FXML elements and control for register
    
    @FXML
    private TextField txtUsernameC;

    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private TextField txtPhotoC;
    
    @FXML
    private RadioButton maleBttn;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton otherBttn;

    @FXML
    private RadioButton femaleBttn;
    
    @FXML
    private CheckBox softwareCheck;

    @FXML
    private CheckBox telematicsCheck;

    @FXML
    private CheckBox industrialCheck;
    
    @FXML
    private DatePicker txtBirthday;
    
    @FXML
    private MenuButton browserMenu;
    
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
    public void toChrome(ActionEvent event) {
    	browserMenu.setText("CHROME");
    }

    @FXML
    public void toEdge(ActionEvent event) {
    	browserMenu.setText("EDGE");
    }

    @FXML
    public void toModzilla(ActionEvent event) {
    	browserMenu.setText("MOZILLA");
    }

    @FXML
    public void toOpera(ActionEvent event) {
    	browserMenu.setText("OPERA");
    }
    
    @FXML
    public void createAccount(ActionEvent event) {
    	if(!blanksRequired()) { //Validation for checking if all the blanks are filled
    	    Alert alert = new Alert(AlertType.WARNING);
    	    alert.setTitle("Classroom");
    	    alert.setHeaderText("Problem with registration");
    	    alert.setContentText("All blanks are required, please verify");

    	    alert.showAndWait();
    	} else {
    		String username = txtUsernameC.getText(); //get data from user to create account
    		if(!classroom.searchForAccount(username)) {
    			String password = txtPassword.getText();
    			String image =  txtPhotoC.getText();
    			String genderS = ((RadioButton)gender.getSelectedToggle()).getText().toUpperCase();
    			String career = "";
    			if(softwareCheck.isSelected()) {
    				career += softwareCheck.getText();
    			}else if (telematicsCheck.isSelected()) {
    				career += telematicsCheck.getText();
    			}else if (industrialCheck.isSelected()) {
    				career += industrialCheck.getText();
    			}
    			
    			LocalDate birthday = txtBirthday.getValue();
    			String browser = browserMenu.getText();
    			
    			classroom.addAccount(username, password, image, genderS, career, birthday, browser);
    			
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Account created");
    			alert.setHeaderText(null);
    			alert.setContentText("The account has been created succesfully");

    			alert.showAndWait();
    			} else {
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Information Dialog");
    			alert.setHeaderText(null);
    			alert.setContentText("This username is already registered, please try again");

    			alert.showAndWait();
    			}
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
    
    //FXML elements and controls for account-list
    
    @FXML
    private TableView<UserAccount> accounts;

    @FXML
    private TableColumn<UserAccount, String> tvUser;

    @FXML
    private TableColumn<UserAccount, String> tvGender;

    @FXML
    private TableColumn<UserAccount, String> tvCareer;

    @FXML
    private TableColumn<UserAccount, String> tvBirthday;

    @FXML
    private TableColumn<UserAccount, String> tvBrowser;

    @FXML
    private Label usernameAccountList;

    @FXML
    private ImageView imageUser;

    @FXML
    public void logOut(ActionEvent event) throws IOException {
    	loadLogin(null);
    }

    private void initializeTableView() {
    	ObservableList<UserAccount> observableList;
    	observableList = FXCollections.observableArrayList(Classroom.getAccounts());
    	
		accounts.setItems(observableList);
		tvUser.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("username"));
		tvGender.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("gender"));
		tvCareer.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("degree"));
		tvGender.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("gender"));
		tvBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("date"));
		tvBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("browser"));
    }
    //Validations
    
    public boolean blanksRequired() {
    	boolean ready= true;
    	if (txtUsernameC.getText().equals(" ")|| txtUsernameC.getText().equals("")) {
			ready=false;
		}else if (txtPassword.getText().equals(null)|| txtPassword.getText().equals("")) {
			ready=false;
		}else if (txtPhotoC.getText().equals(" ")|| txtPhotoC.getText().equals("")) {
			ready = false;
		}else if(!maleBttn.isSelected() && !femaleBttn.isSelected() && !otherBttn.isSelected()) {
			ready=false;
		}else if(!softwareCheck.isSelected() && !telematicsCheck.isSelected() && !industrialCheck.isSelected()) {
			ready=false;
		}else if(txtBirthday.getValue()==null) {
			ready=false;
		}else if (browserMenu.getText().equals("Browsers")) {
			ready=false;
		}
		return ready;
    	
    }
    
    public boolean blanksRequiredL() {
    	boolean ready=true;
    	
    	if (txtUsernameL.getText().equals(" ") || txtUsernameL.getText().equals("")) {
    		ready=false;
    	}else if (txtPasswordLogin.getText().equals(null)|| txtPasswordLogin.getText().equals("")) {
			ready=false;
    	}
    	return ready;
    }
    
}
