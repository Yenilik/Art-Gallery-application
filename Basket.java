package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Basket {
	private Connection con;
	private Statement state;
	private ResultSet rs;
	static ArrayList <String >author = null;
	static ArrayList <String> image = null;
	static ArrayList <String> title = null;
	static ArrayList <String> price=null;
	public VBox getGrid (String userid) {
		VBox gr = new VBox();
		
		
		try {
			
			  Class.forName("com.mysql.jdbc.Driver"); 
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/artgallery","root","");
			  state=(Statement) con.createStatement();
			  	 
			  
		 }
		  catch (Exception ex) {
			 
			  System.out.println("error" );
		  }
		try  {
			 ResultSet rs1=(ResultSet) state.executeQuery("select * from basket");
			 while(rs1.next()) {
				 
				 String uid=rs1.getString("userid");
				 String aut = rs1.getString("author");
				 String im = rs1.getString("image");
				 String tit=rs1.getString("title");
				 String pr=rs1.getString("price");
				
				 if(userid.equalsIgnoreCase(uid)) {
					 System.out.println("ll"+aut);
					gr.getChildren().addAll(getV(aut,im,tit,pr,userid));
				 }
	    			 }}
		 
		catch (Exception e ) {
			System.out.println(e);
		}
		  
		
  gr.setSpacing(10);
  gr.setPadding(new Insets(7,205,20,205));
		return gr;
	}
	public VBox getV(String aut,String im,String tit,String pr,String userid) {
		VBox vb = new VBox();
		Label a = new Label(aut);
		Image i = new Image(im,120,120,false,false);
		ImageView iv = new ImageView(i);
		Image i2 = new Image(im,120,120,false,false);
		ImageView iv2 = new ImageView(i);
		Label t = new Label(tit);
		Label p = new Label(pr);
		Button b = new Button("buy");
		b.setStyle("-fx-background-radius:25;-fx-background-color:#F7BE51;-fx-text-fill:white;-fx-alignment:center");
		p.setStyle("-fx-text-fill:#805CE1;-fx-font-size:9pt");
		p.setStyle("-fx-padding:5,0,0,0;-fx-text-fill:#F7BE51");
		HBox hb = new HBox(p,b);
		hb.setSpacing(47);
		vb.getChildren().addAll(iv,a,t,hb);
		b.setOnAction((event6) -> {
			String n="";
			String id="";
			String e="";
			 try  {
				 ResultSet rs1=(ResultSet) state.executeQuery("select name , userid from user");
				 while(rs1.next()) {
					String name = rs1.getString("name");
					String uid = rs1.getString("userid");
					String email = rs1.getString("email");
					if (userid.equalsIgnoreCase(uid)) {  
					n+=name;
					id+=uid;
			        e+=email; 
		} }}
		catch (Exception ex ) {
			System.out.println();
		}
						 Label pri = new Label("Picture price: " + pr);
			 Label tt = new Label("Picture title:" + tit);
			 Label ph = new Label("Your phone: ");
			 Label ad = new Label("Your address: ");
			 TextField phone= new TextField();
			TextField address=new TextField();
			VBox vborder = new VBox(tt,pri);
			GridPane grorder = new GridPane();
			Button bt = new Button("Order");
			grorder.add(ph, 0, 0);
			grorder.add(phone, 1, 0);
			grorder.add(ad, 0, 1);
			grorder.add(address, 1, 1);
			grorder.add(bt, 1, 2);
			vb.getChildren().clear();
			vb.getChildren().addAll(vborder,grorder);
			bt.setOnAction((event7) -> {
				vb.getChildren().clear();
				vb.getChildren().addAll(iv2,a,t,hb);
			});
	 			});
		
		return vb;
	}
}


