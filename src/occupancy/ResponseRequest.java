package occupancy;

import java.util.ArrayList;

import db.InsertDB;
import db.UpdateDB;
import house.AddHouse;
import house.House;
import house.ViewHouse;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import member.Member;
import member.Points;
import rating.PreformRating;
import teamPublic.VHEC;
import teamPublic.index;

public class ResponseRequest {
	public ResponseRequest(Member member) {
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

		
		
		
		
		
		Pane titlePane = new Pane();
		
		Text text1 =new Text(90,0,"House image");	
		text1.setFont(new Font(18));
		text1.setStyle("-fx-font-weight: bold");
		Text text2 =new Text(400,0,"Occupier");
		text2.setFont(new Font(18));
		text2.setStyle("-fx-font-weight: bold");
		Text text3 =new Text(500,0,"Occupier Rating");
		text3.setFont(new Font(18));
		text3.setStyle("-fx-font-weight: bold");
		Text text4 =new Text(650,0," Checkin Day ");
		text4.setFont(new Font(18));
		text4.setStyle("-fx-font-weight: bold");
		Text text5 =new Text(820,0," Result ");
		text5.setFont(new Font(18));
		text5.setStyle("-fx-font-weight: bold");	

		titlePane.getChildren().addAll(text1,text2,text3,text4,text5);
		
		
		/*
		 *--------------------------------------------------------
		 */
		
		
		VHEC vhec=new VHEC(member);
		ArrayList<OccupancyRequest> allOR=vhec.getOR();
		ArrayList<OccupancyRequest> myOR =new ArrayList<>();
		
		for(int i=0;i<allOR.size();i++)
		{
			if(allOR.get(i).getOwner().getAccountName().compareTo(member.getAccountName())==0 )
				myOR.add(allOR.get(i));
		}
		
		for(int i=0;i<myOR.size();i++)
		{					
			HBox item = new HBox();		
		
			
			OccupancyRequest tempOR =  myOR.get(i);
			House tempHouse = tempOR.getHouse() ;
			Image image = new Image("file:" + System.getProperty("user.dir") + "/images/"+ tempHouse.getImage() +"");
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			imageView.setFitWidth(320);
			imageView.setFitHeight(200);
			
			BorderPane bp2 =new BorderPane();
			Label IDlabel =new Label(tempOR.getOccupier().getName());
			bp2.setCenter(IDlabel);
			
			BorderPane bp =new BorderPane();
			Label citylabel = new Label(String.valueOf(tempOR.getOccupier().getOccupierRating()));
			bp.setCenter(citylabel);		
			
			BorderPane bp3 =new BorderPane();
			Label checkinDatelabel =new Label(String.valueOf(tempOR.getCheckinDay()));
			 bp3.setCenter(checkinDatelabel);
			 
			BorderPane bp6 =new BorderPane();
			Label resultlabel =new Label(tempOR.getResult());
			bp6.setCenter(resultlabel);
				 
			 
			BorderPane bp4 =new BorderPane();
			 Button btAccept = new Button("Accept");
			 btAccept.setOnAction(e -> {
				 
				   UpdateDB.AcceptRequest(tempOR);
				   tempOR.getOwner().earnPoints(tempHouse.getPointsRequire());
				   tempOR.getOccupier().deductPoints(tempHouse.getPointsRequire());
				 
				   InsertDB.CreateRating(tempOR);
				   
				   
				   Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Message");
					alert.setContentText("Accept successfully! ");
					alert.showAndWait();
				   
				   new ResponseRequest(member);
				   primaryStage.close();
			 });
			bp4.setCenter(btAccept);
		    
			 BorderPane bp5 =new BorderPane();
			 Button btReject = new Button("Reject");
			 btReject.setOnAction(e -> {
				   UpdateDB.RejectRequest(tempOR);
				  
				   Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Message");
					alert.setContentText("Reject successfully! ");
					alert.showAndWait();
					new ResponseRequest(member);
					primaryStage.close();
				 
			 });
				 bp5.setCenter(btReject);
				 
				 if(tempOR.getResult().compareTo("Pending")!=0) 
				 {
					 btAccept.setVisible(false);
					 btReject.setVisible(false);
				 }
			
			item.getChildren().addAll(imageView,bp2,bp,bp3,bp6,bp4,bp5);
			
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
		fp.getChildren().addAll(tophBox,titlePane, hbox);	
		sp.getStyleClass().add("edge-to-edge");
		
		Scene scene = new Scene(fp,1366,768);
		primaryStage.setTitle("My Request");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}
