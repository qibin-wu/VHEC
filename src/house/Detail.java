package house;

import java.math.BigDecimal;
import java.time.LocalDate;

import db.InsertDB;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import member.Member;
import occupancy.MyRequest;
import occupancy.OccupancyRequest;
import teamPublic.*;

public class Detail {

	public Detail(House house) // non-member see detail
	{
		Stage primaryStage = new Stage();
		VBox root = new VBox();

		HBox imageBox = new HBox();
		imageBox.setSpacing(50);
		Image image = new Image("file:" + System.getProperty("user.dir") + "/images/" + house.getImage() + "");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setFitWidth(480);
		imageView.setFitHeight(320);

		Image map = new Image("file:" + System.getProperty("user.dir") + "/images/" + house.getMap() + "");
		ImageView mapView = new ImageView();
		mapView.setImage(map);
		mapView.setFitWidth(480);
		mapView.setFitHeight(320);
		imageBox.getChildren().addAll(imageView, mapView);

		VBox detail = new VBox();
		detail.setSpacing(20);

		double dicount, Points, distance;

		dicount = new BigDecimal(house.getDiscount()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		Points = new BigDecimal(house.getPointsRequire()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		distance = new BigDecimal(house.getDistance()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

		Label cityLabel = new Label("City: " + house.getCity());	
		Label distanceLabel = new Label("Distance to city centre (km):" + distance);
		Label pTransportLabel = new Label("Availability of public transport: " + house.getpTransport());
		Label roomNumLabel = new Label("Number of rooms: " + house.getRoomNum());
		Label heatingLabel = new Label("Heating facilities: " + house.getHeating());
		Label swimmingPoolLabel = new Label("Swimming pool: " + house.getSwimmingPool());
		Label pointsRequireLabel = new Label("Points need for a week: " + Points);
		Label discountLabel = new Label("Discounts for long stays(%): " + dicount);
		Button btBack = new Button("Back to home");
		btBack.setOnAction(e -> {

			index start = new index();
			start.start(primaryStage);
		});

		detail.getChildren().addAll(cityLabel, distanceLabel, pTransportLabel, roomNumLabel, heatingLabel,
				swimmingPoolLabel, pointsRequireLabel, discountLabel, btBack);

		root.setSpacing(50);
		root.getChildren().addAll(imageBox, detail);
		Scene scene = new Scene(root, 1366, 768);
		primaryStage.setTitle("house detail");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public Detail(House house, Member member, VHEC vhec, LocalDate date) // member see detail
	{
		Stage primaryStage = new Stage();
		VBox root = new VBox();

		HBox imageBox = new HBox();
		imageBox.setSpacing(50);
		Image image = new Image("file:" + System.getProperty("user.dir") + "/images/" + house.getImage() + "");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setFitWidth(480);
		imageView.setFitHeight(320);

		Image map = new Image("file:" + System.getProperty("user.dir") + "/images/" + house.getMap() + "");
		ImageView mapView = new ImageView();
		mapView.setImage(map);
		mapView.setFitWidth(480);
		mapView.setFitHeight(320);
		imageBox.getChildren().addAll(imageView, mapView);

		VBox detail = new VBox();
		detail.setSpacing(20);

		double dicount, Points, distance;

		dicount = new BigDecimal(house.getDiscount()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		Points = new BigDecimal(house.getPointsRequire()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		distance = new BigDecimal(house.getDistance()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

		Label cityLabel = new Label("City: " + house.getCity());		
		Label distanceLabel = new Label("Distance to city centre (km):" + distance);
		Label pTransportLabel = new Label("Availability of public transport: " + house.getpTransport());
		Label roomNumLabel = new Label("Number of rooms: " + house.getRoomNum());
		Label heatingLabel = new Label("Heating facilities: " + house.getHeating());
		Label swimmingPoolLabel = new Label("Swimming pool: " + house.getSwimmingPool());
		Label pointsRequireLabel = new Label("Points need for a week: " + Points);
		Label discountLabel = new Label("Discounts for long stays(%): " + dicount);

		HBox buttonHbox = new HBox();

		Button btRequest = new Button("Request Occupy");
		btRequest.setOnAction(e -> {

			boolean check = true;

			for (int i = 0; i < vhec.getOR().size(); i++) {// not allow owner occupy its house
				OccupancyRequest or = vhec.getOR().get(i);

				if (or.getOccupier().getAccountName().compareTo(house.getOwner().getAccountName()) == 0) {
					check = false;
					break;
				}
			}

			if (!vhec.checkWeek(house, date))
				check = false;

			if (check) {
				OccupancyRequest newOR = new OccupancyRequest(house.getOwner(), member, house, date);

				InsertDB.RequestOccupancy(newOR);

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Message");
				alert.setContentText("Request successfully!,Please wait for owner accept ");
				alert.showAndWait();
				new MyRequest(member);
				primaryStage.close();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Message");
				alert.setContentText("Request Failure!, A request is being considered ");
				alert.showAndWait();

			}

		});

		Button btBack = new Button("Back to house list");
		btBack.setOnAction(e -> {

			new ViewHouse(member);
			primaryStage.close();
		});

		Button btRating = new Button("House Utility Rating");
		btRating.setOnAction(e -> {

			utilityRating(house);

		});

		buttonHbox.getChildren().addAll(btRating, btRequest, btBack);
		buttonHbox.setSpacing(50);
		detail.getChildren().addAll(cityLabel, distanceLabel, pTransportLabel, roomNumLabel, heatingLabel,
				swimmingPoolLabel, pointsRequireLabel, discountLabel, buttonHbox);

		root.setSpacing(50);
		root.getChildren().addAll(imageBox, detail);
		Scene scene = new Scene(root, 1366, 768);
		primaryStage.setTitle("house detail");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void utilityRating(House house) {

		Stage primaryStage = new Stage();
		FlowPane pane = new FlowPane(Orientation.VERTICAL, 5, 15);
		pane.setPadding(new Insets(11, 12, 13, 14));

		
		Label scoresLab = new Label("Utility Rating: " +"\t" + house.getAvgUntilityRating());		
		pane.getChildren().add(scoresLab);
		
		Label fairValueLab = new Label("Fair Value: " + "\t" + house.getFairValue());		
		pane.getChildren().add( fairValueLab);

		HBox reviewBox = new HBox();
		Label reviewLab = new Label("Review: ");
		TextArea reviewTextArea = new TextArea(house.getReview());
		reviewTextArea.setEditable(true);
		reviewTextArea.setPrefWidth(500);
		reviewTextArea.setWrapText(true);
		reviewBox.getChildren().addAll(reviewLab, reviewTextArea);
		pane.getChildren().add(reviewBox);

		Button btOK = new Button("OK");
		btOK.setOnAction(e -> {

	
			primaryStage.close();

		});

		pane.getChildren().add(btOK);

		Scene scene = new Scene(pane, 600, 350);
		primaryStage.setTitle("Utiltity Rating");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
