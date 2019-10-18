package house;


import java.time.LocalDate;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import member.*;
import occupancy.MyRequest;
import occupancy.ResponseRequest;
import rating.PreformRating;
import teamPublic.VHEC;
import teamPublic.index;

public class ViewHouse {
	
	
	public ViewHouse(Member member,LocalDate date,String city) {
		
		
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
			new ViewHouse(member);
			primaryStage.close();

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
	

		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		Text prompte = new Text("Please select a Check-in Day and City ");
		prompte.setFont(new Font(20));		
		VBox weekVbox = new VBox(20);
		weekVbox.setStyle("-fx-padding: 10;");
		DatePicker weekDatePicker = new DatePicker();
		weekDatePicker.setShowWeekNumbers(true);
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		Label checkInlabel = new Label("Check-In Date:");		
		Label cityLabel = new Label("City :");
		ComboBox<String> cityCbo = new ComboBox<>();
		cityCbo.getItems().add("All");		
		VHEC vhecCity = new VHEC();		
		
		for(String selectCity : vhecCity.getCity() )
		{
			cityCbo.getItems().add(selectCity);		
		}		
		cityCbo.setValue("All");
		
		Button btOK = new Button("OK");
		btOK.setOnAction(e -> {
			
		LocalDate selectedDay = weekDatePicker.getValue();		
		new ViewHouse(member,selectedDay, cityCbo.getValue());
		primaryStage.close();

		});
		
		
		gridPane.add(checkInlabel, 0, 0);	
		GridPane.setHalignment(checkInlabel, HPos.LEFT);
		gridPane.add(weekDatePicker, 1, 0);
		gridPane.add(cityLabel, 2, 0);
		gridPane.add(cityCbo, 3, 0);
		gridPane.add(btOK, 4, 0);

		weekVbox.getChildren().addAll(prompte,gridPane);

	
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		
			Pane titlePane = new Pane();
			Text text1 = new Text(90, 0, "House image");
			text1.setFont(new Font(18));
			text1.setStyle("-fx-font-weight: bold");
			Text text2 = new Text(430, 0, "City");
			text2.setFont(new Font(18));
			text2.setStyle("-fx-font-weight: bold");
			Text text3 = new Text(585, 0, "Rooms");
			text3.setFont(new Font(18));
			text3.setStyle("-fx-font-weight: bold");
			Text text4 = new Text(710, 0, " Poins Require ");
			text4.setFont(new Font(18));
			text4.setStyle("-fx-font-weight: bold");

			titlePane.getChildren().addAll(text1, text2, text3, text4);
	

			/*
			 * --------------------------------------------------------------------
			 */

			VHEC vhec = new VHEC(member);
			for (int i = 0; i < vhec.getHouse().size(); i++) {

				HBox item = new HBox();

				House tempHouse = vhec.getHouse().get(i);

				if(!vhec.checkWeek(tempHouse,date))
					continue;
				
				if(city.compareTo("All")!=0 && city.compareTo(tempHouse.getCity())!=0 )// filter city
					continue;
				
				Image image = new Image("file:" + System.getProperty("user.dir") + "/images/" + tempHouse.getImage() + "");
				ImageView imageView = new ImageView();
				imageView.setImage(image);
				imageView.setFitWidth(320);
				imageView.setFitHeight(200);

				BorderPane bp = new BorderPane();
				Label citylabel = new Label(tempHouse.getCity());
				bp.setCenter(citylabel);

				BorderPane bp2 = new BorderPane();
				Label RoomNumlabel = new Label(String.valueOf(tempHouse.getRoomNum()));
				bp2.setCenter(RoomNumlabel);

				BorderPane bp3 = new BorderPane();
				Label pointslabel = new Label(Double.toString(tempHouse.getPointsRequire()));
				bp3.setCenter(pointslabel);

				BorderPane bp4 = new BorderPane();
				Button btDetail = new Button("Details");
				btDetail.setOnAction(e -> {
					new Detail(tempHouse, member, vhec,date);
					primaryStage.close();

				});
				bp4.setCenter(btDetail);
				item.getChildren().addAll(imageView, bp, bp2, bp3, bp4);
				item.setSpacing(100);
				vBox.getChildren().add(item);
			}
				
		ScrollPane sp = new ScrollPane(vBox);
		HBox.setHgrow(sp, Priority.ALWAYS);
		HBox hbox = new HBox();
		VBox fp = new VBox();
		hbox.getChildren().addAll(vBox, sp);
		fp.setSpacing(50);
		fp.getChildren().addAll(tophBox,weekVbox,titlePane, hbox);	
		sp.getStyleClass().add("edge-to-edge");
		
		vBox.setSpacing(50);
		Scene scene = new Scene(fp, 1366, 768);
		primaryStage.setTitle("Welcome");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}

	public ViewHouse(Member member) {
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

			new ViewHouse(member);
			primaryStage.close();
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
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		Text prompte = new Text("Please select a Check-in Day and City ");
		prompte.setFont(new Font(20));		
		VBox weekVbox = new VBox(20);
		weekVbox.setStyle("-fx-padding: 10;");
		DatePicker weekDatePicker = new DatePicker();
		weekDatePicker.setShowWeekNumbers(true);
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		Label checkInlabel = new Label("Check-In Date:");		
		Label cityLabel = new Label("City :");
		ComboBox<String> cityCbo = new ComboBox<>();
		cityCbo.getItems().add("All");		
		VHEC vhecCity = new VHEC();			
		for(String city : vhecCity.getCity() )
		{
			cityCbo.getItems().add(city);		
		}
		cityCbo.setValue("All");
		
		Button btOK = new Button("OK");
		btOK.setOnAction(e -> {
			
		LocalDate selectedDay = weekDatePicker.getValue();		
		new ViewHouse(member,selectedDay, cityCbo.getValue());
		primaryStage.close();

		});
				
		gridPane.add(checkInlabel, 0, 0);	
		GridPane.setHalignment(checkInlabel, HPos.LEFT);
		gridPane.add(weekDatePicker, 1, 0);
		gridPane.add(cityLabel, 2, 0);
		gridPane.add(cityCbo, 3, 0);
		gridPane.add(btOK, 4, 0);


		weekVbox.getChildren().addAll(prompte,gridPane);

		vBox.getChildren().add(weekVbox);
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		

		
		
		
		
		vBox.setSpacing(50);
		Scene scene = new Scene(vBox, 1366, 768);
		primaryStage.setTitle("Choose a week and city");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
