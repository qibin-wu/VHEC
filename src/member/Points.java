package member;

import db.UpdateDB;
import house.ViewHouse;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Points {
	
	public Points(Member member)
	{
		Stage primaryStage = new Stage();
		FlowPane pane = new FlowPane(Orientation.VERTICAL, 5, 15);
		pane.setPadding(new Insets(11, 12, 13, 14));
//		
		pane.getChildren().add(new Label("My reamining points: " + member.getPoints()));
		
		HBox box=new HBox();
		
		Button btTopUp = new Button("Top up");
		btTopUp.setOnAction(e -> {

			TopUp(member);
			primaryStage.close();
		});
		
		Button btBack = new Button("Back");
		btBack.setOnAction(e -> {

			new ViewHouse(member);
			primaryStage.close();
		});
		
		box.getChildren().addAll(btTopUp,btBack );
		box.setSpacing(20);
		pane.getChildren().add(box);
	
		
		Scene scene = new Scene(pane, 300, 350);
		primaryStage.setTitle("My points"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
	
	private void TopUp(Member member)
	{
		Stage primaryStage = new Stage();
		
		
		FlowPane pane = new FlowPane(Orientation.VERTICAL, 5, 15);		
		pane.setPadding(new Insets(11, 12, 13, 14));	
		pane.getChildren().addAll(new Label("Name: " + member.getName()),new Label("Address: " + member.getAddress()),new Label("Phone Number: " + member.getPhoneNum()));
		
		HBox topup=new HBox();
		
		Label pointsLab =new Label("Top up points: ");
		TextField pointsTF = new TextField();		
		topup.getChildren().addAll(pointsLab, pointsTF);
		pane.getChildren().add(topup);
		
		Button btTopUp = new Button("Top up");
		btTopUp.setOnAction(e -> {	

			UpdateDB.EarnPoints(member, Double.parseDouble(pointsTF.getText()));
			member.earnPoints(Double.parseDouble(pointsTF.getText()));
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setContentText("Top up Successfully ");
			alert.showAndWait();
			
		
			
			new ViewHouse(member);
			primaryStage.close();
			
		});
		
		pane.getChildren().add(btTopUp);
		
		Scene scene = new Scene(pane, 600, 350);
		primaryStage.setTitle("ShowFlowPane"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
		
	}

}
