package house;

import db.InsertDB;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import member.Member;
import member.Points;
import occupancy.MyRequest;
import occupancy.ResponseRequest;
import rating.PreformRating;
import teamPublic.index;

public class AddHouse {
	
	public AddHouse(Member member)
	{
		Stage primaryStage = new Stage();

		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));

		HBox tophBox = new HBox();
		VBox buttonhBox=new VBox();
		HBox buttonhBox1 = new HBox();
		HBox buttonhBox2 = new HBox();
		Button btAdd = new Button("Add House");
		btAdd.setOnAction(e -> {

			new AddHouse(member);

			primaryStage.close();

		});
		btAdd.setPrefWidth(150);
		Button btView = new Button("View House");
		btView.setOnAction(e -> {

		});
		btView.setPrefWidth(150);
		Button btMR = new Button("My Request");
		btMR.setOnAction(e -> {

			new MyRequest(member);
			primaryStage.close();
		});
		btMR.setPrefWidth(150);

		Button btRR = new Button("Resoponse Request");
		btRR.setOnAction(e -> {
			
			new ResponseRequest(member);
			primaryStage.close();

		});

		Button btRate = new Button("Rating");
		btRate.setOnAction(e -> {
			new PreformRating(member);
			primaryStage.close();

		});
		btRate.setPrefWidth(150);
		
		Button btPoint = new Button("Points");
		btPoint.setOnAction(e -> {
			
			new Points(member);
			primaryStage.close();

		});
		btPoint.setPrefWidth(150);
		Button btLogOut = new Button("Log out");
		btLogOut .setOnAction(e -> {
			
			index main=new index();
			main.start(primaryStage);

		});
		btLogOut .setPrefWidth(150);
		
		Label vhecLeabel = new Label("Vacation House Exchange Club");
		vhecLeabel.setFont(new Font(20));
		vhecLeabel.setTextFill(Color.GREEN);
		vhecLeabel.setStyle("-fx-font-weight: bold");

		buttonhBox1.getChildren().addAll(btView, btAdd, btMR, btRR, btRate);
		buttonhBox1.setSpacing(30);
		
		buttonhBox2.getChildren().addAll(btPoint, btLogOut);
		buttonhBox2.setSpacing(30);
		
		buttonhBox.getChildren().addAll(buttonhBox1, buttonhBox2);
		buttonhBox.setSpacing(20);
		tophBox.getChildren().addAll(vhecLeabel, buttonhBox);
		tophBox.setSpacing(150);
		vBox.getChildren().add(tophBox);
		
		
		/*
		 -----------------------------------------------------------------------------------
		 */
		
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		Label cityLabel = new Label("City ");
		TextField  cityTF = new TextField();			
		Label distanceLabel = new Label("Distance to city centre (km)");	
		TextField distanceTF = new TextField();	
		Label pTransportLabel = new Label("Availability of public transport ");	
		ComboBox<String> pTransportCbo = new ComboBox<>();
		pTransportCbo.getItems().addAll("Yes", "No");
		pTransportCbo.setValue(" ");
		Label roomNumLabel = new Label("Number of rooms ");	
		TextField roomNumTF = new TextField();	
		Label heatingLabel = new Label("Heating facilities ");	
		ComboBox<String> heatingCbo = new ComboBox<>();
		heatingCbo.getItems().addAll("Yes", "No");
		heatingCbo.setValue(" ");
		Label swimmingPoolLabel = new Label("Swimming pool ");	
		ComboBox<String> swimmingPoolCbo = new ComboBox<>();
		swimmingPoolCbo.getItems().addAll("Yes", "No");
		swimmingPoolCbo.setValue(" ");
		Label imageLabel = new Label("Image of the house ");	
		TextField imageTF = new TextField();	
		Label pointsRequireLabel = new Label("Points need for a week ");	
		TextField pointsRequireTF = new TextField();	
		Label discountLabel = new Label("Discounts for long stays(%) ");	
		TextField discountTF = new TextField();	
		Label mapLabel = new Label("Map of the house ");	
		TextField mapTF = new TextField();	
		Label rateLabel = new Label("Rating require(-10 to 10) ");	
		TextField rateTF = new TextField();	

		
		pane.add(cityLabel, 0, 0);
		pane.add(cityTF, 1, 0);
		pane.add(distanceLabel, 0, 2);
		pane.add(distanceTF, 1, 2);
		pane.add(pTransportLabel, 0, 3);
		pane.add(pTransportCbo, 1, 3);
		pane.add(roomNumLabel, 0, 4);
		pane.add(roomNumTF, 1, 4);
		pane.add(heatingLabel, 0, 5);
		pane.add(heatingCbo, 1, 5);
		pane.add(swimmingPoolLabel, 0, 6);
		pane.add(swimmingPoolCbo, 1, 6);
		pane.add(imageLabel, 0, 7);
		pane.add(imageTF, 1, 7);
		pane.add(pointsRequireLabel, 0, 8);
		pane.add(pointsRequireTF, 1, 8);
		pane.add(discountLabel, 0, 9);
		pane.add(discountTF, 1, 9);
		pane.add(mapLabel, 0, 10);
		pane.add(mapTF, 1, 10);
		pane.add(rateLabel, 0, 11);
		pane.add(rateTF, 1, 11);

		Button btSummit = new Button("Summit");
		btSummit.setOnAction(e -> {

		House house =new House(cityTF.getText(),Double.parseDouble(distanceTF.getText()),pTransportCbo.getValue(),Integer.parseInt(roomNumTF.getText()),heatingCbo.getValue(),swimmingPoolCbo.getValue(),imageTF.getText(),Double.parseDouble(pointsRequireTF.getText()),Double.parseDouble(discountTF.getText())/100,mapTF.getText(),member,Double.parseDouble(rateTF.getText()));
		InsertDB.insertHouse(house);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message");			
		alert.setContentText("Add house successfully!");
		alert.showAndWait();
		
		new ViewHouse(member);
		primaryStage.close();

		});
		pane.add(btSummit, 1, 12);
		
		vBox.getChildren().add(pane);
		VBox.setMargin(pane, new Insets(100,0,0,500));					
		Scene scene = new Scene(vBox,1366,768);
		primaryStage.setTitle("Welcome");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
