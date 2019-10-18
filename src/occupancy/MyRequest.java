package occupancy;

import java.util.ArrayList;

import house.AddHouse;
import house.Detail;
import house.House;
import house.ViewHouse;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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

public class MyRequest {
	
	public MyRequest(Member member) {
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
		Text text2 =new Text(450,0,"HouseID");
		text2.setFont(new Font(18));
		text2.setStyle("-fx-font-weight: bold");
		Text text3 =new Text(690,0,"City");
		text3.setFont(new Font(18));
		text3.setStyle("-fx-font-weight: bold");
		Text text4 =new Text(820,0," Checkin Day ");
		text4.setFont(new Font(18));
		text4.setStyle("-fx-font-weight: bold");
		Text text5 =new Text(1000,0," Result ");
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
			if(allOR.get(i).getOccupier().getAccountName().compareTo(member.getAccountName())==0 )
				myOR.add(allOR.get(i));
		}
		
		
		for(int i=0;i<myOR.size();i++)
		{
			VBox itemc=new VBox();
		
			HBox item = new HBox();		
		
			
			OccupancyRequest tempOR =  myOR.get(i);
			
			if(tempOR.getResult().compareTo("Pending")==0)
			tempOR.timecheck();//check if out of 24 hours
			
			House tempHouse = tempOR.getHouse() ;
			Image image = new Image("file:" + System.getProperty("user.dir") + "/images/"+ tempHouse.getImage() +"");
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			imageView.setFitWidth(320);
			imageView.setFitHeight(200);
			
			BorderPane bp2 =new BorderPane();
			Label IDlabel =new Label(tempHouse.getHouseID());
			bp2.setCenter(IDlabel);
			
			BorderPane bp =new BorderPane();
			Label citylabel = new Label(tempHouse.getCity());
			bp.setCenter(citylabel);		
			
			BorderPane bp3 =new BorderPane();
			Label checkinDatelabel =new Label(String.valueOf(tempOR.getCheckinDay()));
			 bp3.setCenter(checkinDatelabel);
			
			 
			 
			 
			BorderPane bp4 =new BorderPane();
			Label resultlabel =new Label(myOR.get(i).getResult());
			bp4.setCenter(resultlabel);
		    
			 BorderPane bp5 =new BorderPane();
			 Button btDetail = new Button("House Details");
			 btDetail.setOnAction(e -> {
				    new Detail(tempHouse,member,vhec,tempOR.getCheckinDay());
					primaryStage.close();
				 
			 });
				 bp5.setCenter(btDetail);
			
			item.getChildren().addAll(imageView,bp2,bp,bp3,bp4,bp5);
			
			item.setSpacing(100);
			
			Label contectDetail =new Label("Contect detail: ( waiting for owner accept ) ");
			
			if(myOR.get(i).getResult().compareTo("Accept")==0)
			{
				contectDetail.setText("Contect detail: "+ myOR.get(i).getOwner().getName() + ", " + myOR.get(i).getOwner().getAddress()+", "+ myOR.get(i).getOwner().getPhoneNum());
			}
			
			itemc.getChildren().addAll(item,contectDetail);
			itemc.setSpacing(10);
			vBox.getChildren().add(itemc);			
			
			
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
