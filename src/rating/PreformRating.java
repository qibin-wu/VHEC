package rating;



import db.UpdateDB;
import house.AddHouse;
import house.ViewHouse;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
import occupancy.*;
import teamPublic.*;


public class PreformRating {
	
	
	public PreformRating(Member member) {
		
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
		
		Text prompte = new Text("Please select a Rating type ");
		prompte.setFont(new Font(20));		
		VBox typeVbox = new VBox(20);

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);		
		Button btOR = new Button("Occupier Rating");
		btOR.setOnAction(e -> {
		this.OccupierRating(member);		
		primaryStage.close();

		});
		
		Button btUR = new Button("Utility Rating");
		btUR.setOnAction(e -> {
			this.UtilityRating(member);		
			primaryStage.close();

		});		
		
		gridPane.add(btOR, 0, 0);	
		gridPane.add(btUR, 1, 0);	


		typeVbox.getChildren().addAll(prompte,gridPane);
		vBox.getChildren().add(typeVbox);	
		
		vBox.setSpacing(50);
		Scene scene = new Scene(vBox, 1366, 768);
		primaryStage.setTitle("Rating");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	private void UtilityRating(Member member) {//user as occupier give the OccupierRating
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
		
		
		
		
		Text prompte = new Text("Please select a Rating type ");
		prompte.setFont(new Font(20));		
		VBox typeVbox = new VBox(20);

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);		
		Button btOR = new Button("Occupier Rating");
		btOR.setOnAction(e -> {
		this.OccupierRating(member);		
		primaryStage.close();

		});
		
		Button btUR = new Button("Utility Rating");
		btUR.setOnAction(e -> {
			this.UtilityRating(member);		
			primaryStage.close();

		});		
		
		gridPane.add(btOR, 0, 0);	
		gridPane.add(btUR, 1, 0);	


		typeVbox.getChildren().addAll(prompte,gridPane);
		

		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */

		
		Pane titlePane = new Pane();		
		Text text1 =new Text(90,0,"House image");	
		text1.setFont(new Font(18));
		text1.setStyle("-fx-font-weight: bold");
		Text text2 =new Text(408,0,"Owner");
		text2.setFont(new Font(18));
		text2.setStyle("-fx-font-weight: bold");
		Text text3 =new Text(540,0,"Checkin Day");
		text3.setFont(new Font(18));
		text3.setStyle("-fx-font-weight: bold");		
		Text text4 =new Text(709,0,"Rating Score");
		text4.setFont(new Font(18));
		text4.setStyle("-fx-font-weight: bold");
		Text text5 =new Text(890,0,"Fair Value");
		text5.setFont(new Font(18));
		text5.setStyle("-fx-font-weight: bold");
		titlePane.getChildren().addAll(text1,text2,text3,text4,text5);

		
		
		
		
		/*
		 * 
		 * 
		 * */
		
		
		VHEC vhec=new VHEC(member);
		
		
		
		for(int i=0;i<vhec.getUtilityRating().size();i++)
		{
		
			UtilityRating utiRate = vhec.getUtilityRating().get(i);
		
			
		if(utiRate.getOwner().getAccountName().compareTo(member.getAccountName())==0)//owner cannot rate itself
				continue;
		String RatingResult;
		if(utiRate.getRatingScore()==-11)
			RatingResult="Waiting for rate";
		else
			RatingResult=String.valueOf(utiRate.getRatingScore());
		String fairValue;
		if(utiRate.getFairValue()==-1)
			fairValue="Waiting for rate";
		else
			fairValue=String.valueOf(utiRate.getFairValue());
		
		
		
		HBox item = new HBox();		
					
		Image image = new Image("file:" + System.getProperty("user.dir") + "/images/"+ utiRate.getHouse().getImage() +"");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setFitWidth(320);
		imageView.setFitHeight(200);
		
		BorderPane bp2 =new BorderPane();
		Label namelabel =new Label(utiRate.getOwner().getName());
		bp2.setCenter(namelabel);
		
		BorderPane bp =new BorderPane();
		Label datelabel = new Label(String.valueOf(utiRate.getOr().getCheckinDay()));
		bp.setCenter(datelabel);		
		
		BorderPane bp3 =new BorderPane();
		Label resultlabel = new Label(RatingResult);
		bp3.setCenter(resultlabel);
		
		BorderPane bp5 =new BorderPane();
		Label fairValuelabel = new Label(fairValue);
		bp5.setCenter(fairValuelabel);

			 
		 
		BorderPane bp4 =new BorderPane();
		 Button btRated = new Button("Rate");
		 btRated.setOnAction(e -> {			 
			   startRate(utiRate);
			   primaryStage.close();
		 });
		bp4.setCenter(btRated);
		btRated.setVisible(false);
		 if(RatingResult.compareTo("Waiting for rate")==0 || fairValue.compareTo("Waiting for rate")==0) 
			 {
				 btRated.setVisible(true);
				
			 }
		
		item.getChildren().addAll(imageView,bp2,bp,bp3,bp5,bp4);		
		item.setSpacing(100);
		vBox.getChildren().add(item);			
		}
		
	
		
		vBox.setSpacing(50);
		ScrollPane sp = new ScrollPane(vBox);
		HBox.setHgrow(sp, Priority.ALWAYS);
		HBox hbox = new HBox();
		VBox fp = new VBox();
		hbox.getChildren().addAll(vBox, sp);
		fp.setSpacing(50);
		fp.getChildren().addAll(tophBox,typeVbox,titlePane, hbox);	
		sp.getStyleClass().add("edge-to-edge");
		Scene scene = new Scene(fp, 1366, 768);
		primaryStage.setTitle("Rating");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	private void startRate(UtilityRating utiRate) {
		Stage primaryStage = new Stage();
		
		
		FlowPane pane = new FlowPane(Orientation.VERTICAL, 5, 15);		
		pane.setPadding(new Insets(11, 12, 13, 14));	
		
		HBox rateBox=new HBox();		
		Label scoresLab =new Label("Rating Score(-10 ~ 10): " +"\t");
		TextField scoresTF = new TextField();		
		rateBox.getChildren().addAll(scoresLab, scoresTF );
		pane.getChildren().add(rateBox );
		
		HBox fairValueBox=new HBox();
		Label fairValueLab =new Label("Fair Value: " +"\t");
		TextField fairValueTF = new TextField();		
		fairValueBox.getChildren().addAll(fairValueLab, fairValueTF );
		pane.getChildren().add(fairValueBox );
		
		HBox reviewBox=new HBox();
		Label reviewLab =new Label("Review: " +"\t");
		TextArea reviewTextArea = new TextArea();
		reviewTextArea.setPrefWidth(300);
		reviewTextArea.setWrapText(true);	
		reviewBox.getChildren().addAll(reviewLab,  reviewTextArea );
		pane.getChildren().add(reviewBox );
		
		
		Button btOK = new Button("OK");
		btOK.setOnAction(e -> {	

			UpdateDB.performUtilityRating(utiRate, Double.parseDouble(scoresTF.getText()) , Double.parseDouble(fairValueTF.getText()), reviewTextArea.getText());
			
			utiRate.setRatingScore(Double.parseDouble(scoresTF.getText()));
			utiRate.setFairValue(Double.parseDouble(fairValueTF.getText()));
			utiRate.setReview(reviewTextArea.getText());
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setContentText("Rated Successfully ");
			alert.showAndWait();
			
			VHEC vhec =new VHEC (utiRate.getOwner());
			
			new PreformRating(vhec.getMember() );
			primaryStage.close();
			
		});
		
		Button btBack = new Button("Back");
		btBack.setOnAction(e -> {	

			VHEC vhec =new VHEC(utiRate.getOwner());			
			new PreformRating(vhec.getMember());
			primaryStage.close();
			
		});
		HBox buttonbox=new HBox();
		
		buttonbox.getChildren().addAll(btOK,btBack);
		buttonbox.setSpacing(20);
		pane.getChildren().add(buttonbox);
		
		Scene scene = new Scene(pane, 600, 350);
		primaryStage.setTitle("Utiltity Rating"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
		
	}

	private void OccupierRating(Member member)//user as owner give the OccupierRating
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
		
		
		
		Text prompte = new Text("Please select a Rating type ");
		prompte.setFont(new Font(20));		
		VBox typeVbox = new VBox(20);

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);		
		Button btOR = new Button("Occupier Rating");
		btOR.setOnAction(e -> {
		this.OccupierRating(member);		
		primaryStage.close();

		});
		
		Button btUR = new Button("Utility Rating");
		btUR.setOnAction(e -> {
			this.UtilityRating(member);		
			primaryStage.close();

		});		
		
		gridPane.add(btOR, 0, 0);	
		gridPane.add(btUR, 1, 0);	


		typeVbox.getChildren().addAll(prompte,gridPane);
		

		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */

		
		Pane titlePane = new Pane();		
		Text text1 =new Text(90,0,"House image");	
		text1.setFont(new Font(18));
		text1.setStyle("-fx-font-weight: bold");
		Text text2 =new Text(400,0,"Occupier");
		text2.setFont(new Font(18));
		text2.setStyle("-fx-font-weight: bold");
		Text text3 =new Text(540,0,"Checkin Day");
		text3.setFont(new Font(18));
		text3.setStyle("-fx-font-weight: bold");		
		Text text4 =new Text(700,0,"Rating Score");
		text4.setFont(new Font(18));
		text4.setStyle("-fx-font-weight: bold");
		titlePane.getChildren().addAll(text1,text2,text3,text4);

		
		
		
		
		/*
		 * 
		 * 
		 * */
		
		
		VHEC vhec=new VHEC(member);
		
		
		
		for(int i=0;i<vhec.getOccupierRating().size();i++)
		{
		
		OccupierRating occRate = vhec.getOccupierRating().get(i);
		String RatingResult;
		if(occRate.getRatingScore()==-11)
			RatingResult="Waiting for rate";
		else
			RatingResult=String.valueOf(occRate.getRatingScore());
		
		if(occRate.getOccupier().getAccountName().compareTo(member.getAccountName())==0)//occupier cannot rated itself
			continue;
		
		
		HBox item = new HBox();		
					
		Image image = new Image("file:" + System.getProperty("user.dir") + "/images/"+ occRate.getHouse().getImage() +"");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setFitWidth(320);
		imageView.setFitHeight(200);
		
		BorderPane bp2 =new BorderPane();
		Label namelabel =new Label(occRate.getOccupier().getName());
		bp2.setCenter(namelabel);		
		
		BorderPane bp =new BorderPane();
		Label datelabel = new Label(String.valueOf(occRate.getOr().getCheckinDay()));
		bp.setCenter(datelabel);		
		
		BorderPane bp3 =new BorderPane();
		Label resultlabel = new Label(RatingResult);
		bp3.setCenter(resultlabel);

			 
		 
		BorderPane bp4 =new BorderPane();
		 Button btRated = new Button("Rate");
		 btRated.setOnAction(e -> {			 
			   startRate(occRate);
			   primaryStage.close();
		 });
		bp4.setCenter(btRated);
		btRated.setVisible(false);
		 if(RatingResult.compareTo("Waiting for rate")==0) 
			 {
				 btRated.setVisible(true);
				
			 }
		
		item.getChildren().addAll(imageView,bp2,bp,bp3,bp4);		
		item.setSpacing(100);
		vBox.getChildren().add(item);			
		}
		
	
		
		vBox.setSpacing(50);
		
		ScrollPane sp = new ScrollPane(vBox);
		HBox.setHgrow(sp, Priority.ALWAYS);
		HBox hbox = new HBox();
		VBox fp = new VBox();
		hbox.getChildren().addAll(vBox, sp);
		fp.setSpacing(50);
		fp.getChildren().addAll(tophBox,typeVbox,titlePane, hbox);	
		sp.getStyleClass().add("edge-to-edge");
		Scene scene = new Scene(fp, 1366, 768);
		primaryStage.setTitle("Rating");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private static void startRate(OccupierRating occRate) {
		
		Stage primaryStage = new Stage();
		
		
		FlowPane pane = new FlowPane(Orientation.VERTICAL, 5, 15);		
		pane.setPadding(new Insets(11, 12, 13, 14));	
		
		HBox rateBox=new HBox();		
		
		Label scoresLab =new Label("Rating Score(-10 ~ 10): ");
		TextField scoresTF = new TextField();		
		rateBox.getChildren().addAll(scoresLab, scoresTF );
		pane.getChildren().add(rateBox);
		
		Button btOK = new Button("OK");
		btOK.setOnAction(e -> {	

			UpdateDB.performOccupierRating(occRate, Double.parseDouble(scoresTF.getText()));
			occRate.setRatingScore(Double.parseDouble(scoresTF.getText()));
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setContentText("Rated Successfully ");
			alert.showAndWait();
			
			VHEC vhec =new VHEC(occRate.getOwner());
			
			new PreformRating(vhec.getMember());
			primaryStage.close();
			
		});
		
		Button btBack = new Button("Back");
		btBack.setOnAction(e -> {	

			VHEC vhec =new VHEC(occRate.getOwner());			
			new PreformRating(vhec.getMember());
			primaryStage.close();
			
		});
		HBox buttonbox=new HBox();
		buttonbox.setSpacing(20);
		buttonbox.getChildren().addAll(btOK,btBack);
		
		pane.getChildren().add(buttonbox);
		
		Scene scene = new Scene(pane, 600, 350);
		primaryStage.setTitle("Occupier Rating"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 

	}
}
