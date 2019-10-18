package member;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import teamPublic.*;

import house.ViewHouse;

public class login {

	public login() {

		Stage primaryStage = new Stage();

		BorderPane root = new BorderPane();
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);

		// Place nodes in the pane

		Label vhecLeabel = new Label("Vacation House Exchange Club");
		vhecLeabel.setFont(new Font(20));
		vhecLeabel.setTextFill(Color.GREEN);
		vhecLeabel.setStyle("-fx-font-weight: bold");

		Label accountNamelab = new Label("Account Name ");
		Label passwordlab = new Label("Password ");
		TextField accountNameTxt = new TextField();
		PasswordField passwordNameTxt = new PasswordField();
		pane.add(accountNamelab, 0, 0);
		pane.add(accountNameTxt, 1, 0);
		pane.add(passwordlab, 0, 1);
		pane.add(passwordNameTxt, 1, 1);
		Button btLog = new Button("Login");
		btLog.setOnAction(e -> {

			VHEC vhec = new VHEC(accountNameTxt.getText(), passwordNameTxt.getText());
			new ViewHouse(vhec.getMember());
			primaryStage.close();

		});	
		Button btBack = new Button("Back");
		btBack.setOnAction(e -> {

			
			
			index homepage=new index();
			homepage.start(primaryStage);
			

		});
		
		HBox buttonBox=new HBox();
		buttonBox.getChildren().addAll(btLog,btBack);
		buttonBox.setSpacing(20);
		pane.add(buttonBox, 1, 2);
		
		// Create a scene and place it in the stage

		BorderPane.setAlignment(vhecLeabel, Pos.BOTTOM_CENTER);

		root.setTop(vhecLeabel);
		root.setCenter(pane);
		Scene scene = new Scene(root, 1366, 768);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
