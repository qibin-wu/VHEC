package teamPublic;



import house.Detail;
import house.House;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;
import member.BecomeMember;
import member.login;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;


public class index extends Application {
	
	@Override 
	public void start(Stage primaryStage) {
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));
		
		HBox tophBox=new HBox();
		HBox buttonhBox= new HBox();
		Button btSign = new Button("Log in");
		btSign.setOnAction(e -> {
			
			new login();
			primaryStage.close();
		});
		btSign.setPrefWidth(150);
		Button btJoin = new Button("Become Member");
		btJoin.setOnAction(e -> {
			
			new BecomeMember();
			primaryStage.close();
			
		});
		btJoin.setPrefWidth(150);
		Label vhecLeabel =new Label("Vacation House Exchange Club");
		vhecLeabel.setFont(new Font(36));
		vhecLeabel.setTextFill(Color.GREEN);
		vhecLeabel.setStyle("-fx-font-weight: bold");
	
	
		buttonhBox.getChildren().add(btSign);
		buttonhBox.getChildren().add(btJoin);		
		buttonhBox.setSpacing(30);		
		buttonhBox.setAlignment(Pos.CENTER);
		tophBox.getChildren().addAll(vhecLeabel,buttonhBox);
		tophBox.setSpacing(400);
		

		
		
		
		Pane titlePane = new Pane();
		
		Text text1 =new Text(90,0,"House image");	
		text1.setFont(new Font(18));
		text1.setStyle("-fx-font-weight: bold");
		Text text2 =new Text(430,0,"City");
		text2.setFont(new Font(18));
		text2.setStyle("-fx-font-weight: bold");
		Text text3 =new Text(585,0,"Rooms");
		text3.setFont(new Font(18));
		text3.setStyle("-fx-font-weight: bold");
		Text text4 =new Text(710,0," Poins Require ");
		text4.setFont(new Font(18));
		text4.setStyle("-fx-font-weight: bold");

		titlePane.getChildren().addAll(text1,text2,text3,text4);
	
		/*
		 -----------------------------------------------------------------------------------
		 */
		
			
		VHEC vhec=new VHEC();
		
		
		for(int i=0;i<vhec.getHouse().size();i++)
		{
			
		
			HBox item = new HBox();		
		
			House tempHouse = vhec.getHouse().get(i) ;
			
			Image image = new Image("file:" + System.getProperty("user.dir") + "/images/"+ tempHouse.getImage() +"");
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			imageView.setFitWidth(320);
			imageView.setFitHeight(200);
			
			BorderPane bp =new BorderPane();
			Label citylabel = new Label(tempHouse.getCity());
			bp.setCenter(citylabel);
			
			BorderPane bp2 =new BorderPane();
			Label RoomNumlabel =new Label(String.valueOf(tempHouse.getRoomNum()));
			bp2.setCenter(RoomNumlabel);
			
			BorderPane bp3 =new BorderPane();
			Label pointslabel =new Label( Double.toString(tempHouse.getPointsRequire()));
			 bp3.setCenter(pointslabel);
		    
			 BorderPane bp4 =new BorderPane();
			 Button btDetail = new Button("Details");
			 btDetail.setOnAction(e -> {
				    new Detail(tempHouse);
					primaryStage.close();
				 
			 });
				 bp4.setCenter(btDetail);
			
			item.getChildren().addAll(imageView,bp,bp2,bp3,bp4);
			
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
		primaryStage.setTitle("Vacation House Exchange Club");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	* The main method is only needed for the IDE with limited JavaFX support. Not
	* needed for running from the command line.
	*/
	public static void main(String[] args) {
		launch(args);
	}

}
