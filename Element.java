package project;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.Random;

import java.sql.*;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Element {
	public String author;
	public Image im;
	public String title;
	String price;
	String style;
	public String imm;
	private Connection con;
	private Statement state;
	private ResultSet rs;
	 	public Element (String author,String title, String price,Image im,String style,String imm) {
			this.author=author;
			this.title=title;
			this.im=im;
			this.price=price;
			this.style=style;
			this.imm=imm;
		}
	public VBox getv (String userid) {
		VBox vb = new VBox ();
		Button l = new Button("favorite");
		Button b = new Button("basket");
		ImageView img = new ImageView (im);
		HBox hb = new HBox ();
		HBox hb2 = new HBox();
		Label pr = new Label(this.price);
		pr.setStyle("-fx-text-fill:#805CE1;-fx-font-size:9pt");
		hb2.getChildren().addAll(b,l);
		pr.setStyle("-fx-padding:5,0,0,0;-fx-text-fill:#F7BE51");
		hb.getChildren().addAll(pr,hb2);
		hb.setSpacing(2);
		Text aut = new Text (this.author);
		Label tit = new Label(this.title);
		tit.setStyle("-fx-text-fill:#555555");
		vb.getChildren().addAll(img,aut,tit,hb);
		vb.setStyle("-fx-background-color:white");
		l.setStyle("-fx-background-radius:25;-fx-background-color:#F7BE51;-fx-text-fill:white;-fx-alignment:center");
		b.setStyle("-fx-background-radius:25;-fx-background-color:#F7BE51;-fx-text-fill:white;-fx-alignment:center");
		int uit=Integer.parseInt(userid);
		Random rand = new Random();
		int elid=rand.nextInt(101);
		try {
			
			  Class.forName("com.mysql.jdbc.Driver"); 
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/artgallery","root","");
			  state=(Statement) con.createStatement();
			  	 
			  
		 }
		  catch (Exception ex) {
			 
			  System.out.println("error" );
		  }
		

		 l.setOnAction((event5) -> {
			 try  {
				 ResultSet rs1=(ResultSet) state.executeQuery("select *  from Elected");
				 state.executeUpdate("INSERT INTO elected VALUES ( " + uit + ", " + elid + ",'" +author+ "','" + imm+ "', '"+title+"', '"+price+"', '" + style +"' )");	
			 }
							 catch (Exception e ) {
				 System.out.println(e);
			 }
	 			});
		 b.setOnAction((event5) -> {
			 try  {
				 ResultSet rs1=(ResultSet) state.executeQuery("select *  from basket");
				 state.executeUpdate("INSERT INTO basket VALUES ( " + uit + ", " + elid + ",'" +author+ "','" + imm+ "', '"+title+"', '"+price+"', '" + style +"' )");	
			 }
							 catch (Exception e ) {
				 System.out.println(e);
			 }
	 			});

		return vb;
	}
	public VBox getV(int compid) {
		VBox vb = new VBox();
		Button l = new Button("fv");
		Button b = new Button("buy");
		 try {
			// Statement state = this.conn.createStatement();
			 ResultSet rs1=(ResultSet) state.executeQuery("select * from element"); 
			while(rs1.next()) {
				int cid = rs1.getInt("compid");
				
				if(compid==cid) {
					ImageView img = new ImageView (im);
					HBox hb = new HBox ();
					HBox hb2 = new HBox();
					Label pr = new Label(this.price);
				}
			}
		 }
		 
		 catch (Exception e ) {
			 System.out.println(e);
		 }
		 System.out.println(im);
		return vb;
	}
	public String getStyle () {
		return this.style;
	}
	
	
}

