package member;

import db.InsertDB;
import house.ViewHouse;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import teamPublic.index;

public class BecomeMember {
	
	public BecomeMember()
	{
		
		Stage primaryStage =new Stage();
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		
		Label accountNameLabel = new Label("Account Name ");
		TextField accountNameTF = new TextField();
		Label passwordLabel = new Label("Password ");
		TextField passwordTF = new TextField();
		Label nameLabel = new Label("Name ");
		TextField nameTF = new TextField();
		Label addressLabel = new Label("Address ");
		TextField addressTF = new TextField();
		Label phoneNumLabel = new Label("Phone Number ");
		TextField phoneNumTF = new TextField();



		// Place nodes in the pane
		pane.add(accountNameLabel, 0, 0);
		pane.add(accountNameTF, 1, 0);
		pane.add(passwordLabel, 0, 1);
		pane.add(passwordTF, 1, 1);
		pane.add(nameLabel, 0, 2);
		pane.add(nameTF, 1, 2);
		pane.add(addressLabel, 0, 3);
		pane.add(addressTF, 1, 3);
		pane.add(phoneNumLabel, 0, 4);
		pane.add(phoneNumTF, 1, 4);


		Button btSummit = new Button("Summit");
		btSummit.setOnAction(e -> {

			InsertDB.Register(accountNameTF.getText(),passwordTF.getText(),nameTF.getText(),addressTF.getText(),phoneNumTF.getText());
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");			
			alert.setContentText("Register successfully!");
			alert.showAndWait();
			
			Member member = new Member(accountNameTF.getText(),nameTF.getText(),addressTF.getText(),phoneNumTF.getText());
			new ViewHouse(member);
			primaryStage.close();

		});
		
		Button btBack = new Button("Back");
		btBack.setOnAction(e -> {

			
			
			index homepage=new index();
			homepage.start(primaryStage);
			

		});
		
		HBox buttonBox=new HBox();
		buttonBox.getChildren().addAll(btSummit,btBack);
		buttonBox.setSpacing(20);
		pane.add(buttonBox, 1, 7);
		
		
		pane.setAlignment(Pos.CENTER);
		BorderPane root =new BorderPane();
		BorderPane.setAlignment(pane, Pos.CENTER);
		root.setCenter(pane);
		// Create a scene and place it in the stage
		Scene scene = new Scene(root,1366,768);
		primaryStage.setTitle("Become member");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
