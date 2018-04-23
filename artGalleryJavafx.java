package project;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;

public class artGalleryJavafx extends Application {
public static int log =0;
public static int sign =0;
public static AnchorPane login = new AnchorPane();
public static AnchorPane signup = new AnchorPane();	
Stage stage;
Scene scene1,scene2,scene3,scene4;
private Connection con;
private Statement state;
private ResultSet rs;

	@Override
	public void start(Stage window) throws Exception {
		// TODO Auto-generated method stub
		stage=window;
		 try {
		
			  Class.forName("com.mysql.jdbc.Driver"); 
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/artgallery","root","");
			  state=(Statement) con.createStatement();
			  
			  
		 }
		  catch (Exception ex) {
			 
			  System.out.println("error" );
		  }
		Image im = new Image ("http://www.souslatonnelle.com/images/claude-monet-nympheas-bleues-saules.jpg");
		Circle circle = new Circle ();
		circle.setFill(new ImagePattern(im));
		Circle circle2 = new Circle ();
		circle2.setFill(new ImagePattern(im));

		Image img = new Image("http://www.keyano.ca/portals/0/Images/Theatre/Art%20Gallery%20header.jpg",130,50,false,false);
	    ImageView imv = new ImageView(img);
		
		circle.setCenterX(150f);
		circle.setCenterY(300.5f);
		circle.setRadius(220.7f);
		
		circle2.setCenterX(150f);
		circle2.setCenterY(300.5f);
		circle2.setRadius(220.7f);

		Image img2 = new Image ("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKKPGskZxKJJXW3I-zk0VKRVDbrBuGTVeE8dNHiGjwxVID7klI_g",120,120,false,false);
		ImageView imv2 = new ImageView(img2);
	    imv2.setStyle("-fx-padding-right:30px");
		VBox v1 = new VBox ();
		TextField t1 = new TextField ();
		t1.setPromptText("Username");
		t1.setStyle("-fx-background-radius:35;-fx-background-insets: 0 0 0 0, 0, 0, 0");
		t1.setMaxWidth(190);
		t1.setPrefHeight(30);
		PasswordField t2 = new PasswordField();
		t2.setStyle("-fx-background-radius:35;-fx-background-insets: 0 0 0 0, 0, 0, 0;");
		t2.setPrefWidth(190);
		t2.setPrefHeight(30);
		t2.setPromptText("Password");
		v1.getChildren().addAll(t1,t2);
		v1.setSpacing(10);
		Button b1 = new Button ("Login");
		b1.setPrefWidth(190);
		b1.setStyle("-fx-background-radius:35;-fx-background-color:#805CE1;-fx-text-fill:white;");
		b1.setId("b1");
		b1.setPrefHeight(30);
		Button b2 = new Button ("First time here? Sign up");
		b2.setStyle("-fx-background-color:transparent;-fx-text-fill:#805CE1;");
		b2.setId("b2");
		b2.setPrefWidth(190);
		VBox v2 = new VBox();
		v2.setSpacing(6);
		v2.getChildren().addAll(b1,b2);
		GridPane gr = new GridPane ();
		gr.add(imv, 0, 0);
		gr.add(imv2, 1, 2);
		gr.add(v1, 1, 3);
		gr.add(v2, 1, 4);
	    gr.setHgap(340);
		gr.setVgap(25);
		

		TextField tn = new TextField ();
		tn.setPromptText("Name");
		TextField te = new TextField ();
		te.setPromptText("Email");
		PasswordField tp = new PasswordField();
		tp.setPromptText("Password");
        tn.setStyle("-fx-border-color:transparent;-fx-background-radius:35;;-fx-background-insets: 0 0 0 0, 0, 0, 0");
		te.setStyle("-fx-border-color:transparent;-fx-background-radius:35;-fx-background-insets: 0 0 0 0, 0, 0, 0;");
		tp.setStyle("-fx-border-color:transparent;-fx-background-radius:35;-fx-background-insets: 0 0 0 0, 0, 0, 0");
		tn.setPrefWidth(190);
		tn.setPrefHeight(30);
		te.setMaxWidth(190);
		te.setPrefHeight(30);
		tp.setMaxWidth(190);
		tp.setPrefHeight(30);
		ImageView imv5 = new ImageView(img2);
		ImageView imv4 = new ImageView(img);
	    imv4.setStyle("-fx-padding-right:30px");
		GridPane gr2 = new GridPane ();
		VBox v3 = new VBox();
		v3.getChildren().addAll(tn,te,tp);
		v3.setSpacing(7);
		VBox v4 = new VBox ();
		Button b3 = new Button ("Sign up");
		b3.setStyle("-fx-background-radius:35;-fx-background-color:#805CE1;-fx-text-fill:white;");
		b3.setPrefWidth(190);
		b3.setPrefHeight(30);
		v4.getChildren().add(b3);
		gr2.add(imv4, 0, 0);
		gr2.add(imv5, 1, 2);
		gr2.add(v3, 1, 3);
		gr2.add(v4, 1, 4);
		
		gr2.setHgap(340);
	    gr2.setVgap(25);
	   
		b2.setOnAction((event5) -> {
        window.setScene(scene1);
		});
		b1.setOnAction((event5) -> {
			if(check(t1.getText(),t2.getText())) {
	        window.setScene(scene2); }
			else {
				Stage stage2 = new Stage ();
				Label label = new Label ("Username or password is incorrect");
				label.setStyle("-fx-text-fill:white");
				VBox gr3 = new VBox(label);
				gr3.setStyle("-fx-background-color:red");
				gr3.setAlignment(Pos.CENTER);
				Scene scene4 = new Scene(gr3,250,70);
			    stage2.setScene(scene4);
			    stage2.show();
			}
			});
		b3.setOnAction((event5) -> {
			if (create(tn.getText(),te.getText(),tp.getText())) {
	        window.setScene(scene2); }
			else {
				Stage stage5 = new Stage ();
				Label label = new Label ("This username or email is already exist");
				label.setStyle("-fx-text-fill:white");
				VBox vbb = new VBox(label);
				vbb.setStyle("-fx-background-color:red");
				vbb.setAlignment(Pos.CENTER);
				Scene scene5 = new Scene(vbb,250,70);
				stage5.setScene(scene5);
				stage5.show();
			}
			});

		ScrollPane sp = new ScrollPane();
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		sp.setStyle("-fx-background-color:white");
		FileInputStream inputstream = new FileInputStream("C:\\Users\\Admin\\Desktop\\star2.png"); 
		FileInputStream inputstream2 = new FileInputStream("C:\\Users\\Admin\\Desktop\\book2.png"); 
		FileInputStream inputstream3= new FileInputStream("C:\\Users\\Admin\\Desktop\\heart2.png"); 
		FileInputStream inputstream4 = new FileInputStream("C:\\Users\\Admin\\Desktop\\acc4.png"); 
		FileInputStream inputstream5 = new FileInputStream("C:\\Users\\Admin\\Desktop\\basket2.png"); 
		Image ima = new Image (inputstream,20,20,false,false);
		Image ima2 = new Image (inputstream2,20,20,false,false);
		Image ima3 = new Image (inputstream3,20,20,false,false);
		Image ima4 = new Image (inputstream4,20,20,false,false);
		Image ima5 = new Image(inputstream5,20,20,false,false);
		ImageView iv1 = new ImageView (ima);
		ImageView iv2 = new ImageView (ima2);
		ImageView iv3 = new ImageView (ima3);
		ImageView iv4 = new ImageView (ima4);
		ImageView iv5 = new ImageView (ima5);
		Button st = new Button("Compilation",iv1);
		Button sr = new Button("Catalog",iv2);
		Button fv = new Button("Elected",iv3);
		Button pr = new Button ("Profile",iv4);
		Button kr = new Button ("Basket",iv5);
		VBox vb = new VBox ();
		st.setStyle("-fx-background-color:transparent;-fx-text-fill:white;-fx-background-radius:0;-fx-background-insets: 0 0 0 0, 0, 0, 0;-fx-font-size:9pt;");
		sr.setStyle("-fx-background-color:transparent;-fx-text-fill:white;-fx-background-radius:0;-fx-background-insets: 0 0 0 0, 0, 0, 0;-fx-font-size:9pt;");
		fv.setStyle("-fx-background-color:transparent;-fx-text-fill:white;-fx-background-radius:0;-fx-background-insets: 0 0 0 0, 0, 0, 0;-fx-font-size:9pt;");
		pr.setStyle("-fx-background-color:transparent;-fx-text-fill:white;-fx-background-radius:0;-fx-background-insets: 0 0 0 0, 0, 0, 0;-fx-font-size:9pt;");
		kr.setStyle("-fx-background-color:transparent;-fx-text-fill:white;-fx-background-radius:0;-fx-background-insets: 0 0 0 0, 0, 0, 0;-fx-font-size:9pt;");
		st.setId("b");
		sr.setId("b");
		vb.getChildren().addAll(st,sr,fv,pr,kr);
		vb.setSpacing(7);
		vb.setPadding(new Insets(5,5,5,5));
		vb.setStyle("-fx-background-color:#805CE1");
		HBox hb = new HBox();
		Image pabb = new Image ("https://inshe.tv/wp-content/uploads/2016/05/pikasso.jpg",470,320,false,false);
		Image pab= new Image ("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2GtJCW9g9ZtWck2SniehA58Yw9SP0a9s1dh2x5FQf_h1OlibS",170,120,false,false);
		Image pab2 = new Image ("http://www.pablo-ruiz-picasso.net/images/works/1834.jpg",170,120,false,false);
		Image pab3 = new Image ("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2D1j5jV7b4y0Ryx5VYVMzIm9-myJmX8M-1h8TH-E2SGv3vGzT",170,120,false,false);
		Image pab4 = new Image ("https://i.pinimg.com/originals/bb/c8/30/bbc8301a6658183280aa30f6eb08a42a.jpg",170,120,false,false);
		Element el= new Element("Pablo Picasso","Dora Maar","$100 000",pab,"Cubism","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2GtJCW9g9ZtWck2SniehA58Yw9SP0a9s1dh2x5FQf_h1OlibS");
		Element el2 = new Element ("Pablo Picasso","Female acrobat","$10 000 000",pab2,"Cubism","http://www.pablo-ruiz-picasso.net/images/works/1834.jpg");
		Element el3 = new Element ("Pablo Picasso","Guernica","$100 000",pab3,"Cubism","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2D1j5jV7b4y0Ryx5VYVMzIm9-myJmX8M-1h8TH-E2SGv3vGzT");
		Element el4 = new Element ("Pablo Picasso","Girl Reading","$1 000 000",pab4,"Cubism","https://i.pinimg.com/originals/bb/c8/30/bbc8301a6658183280aa30f6eb08a42a.jpg");
		ArrayList <Element> ellist = new ArrayList <> ();
		ellist.add(el);
		ellist.add(el2);
		ellist.add(el3);
		ellist.add(el4);
		Compilation picas = new Compilation ("Pablo Picasso","The most famous paintings of Pablo Picasso",pabb,ellist);
		ArrayList <Compilation> plist = new ArrayList <>();
		plist.add(picas);
		CompilationMain comMain = new CompilationMain(plist);
		sp.setStyle("-fx-background-color:transparent;-fx-background-radius:2em");
		FileInputStream inputstream8 = new FileInputStream("C:\\Users\\Admin\\Desktop\\lll.jpg"); 
        Image image = new Image (inputstream8,570,450,false,false);
        ImageView iv = new ImageView(image);
        HBox hbb= new HBox();
        hbb.getChildren().add(iv);
        sp.setContent(hbb);
		hb.getChildren().addAll(vb,sp);
		scene2 = new Scene (hb,700,450);
		login.getChildren().addAll(circle,gr);
		Group broof = new Group(login);
        signup.getChildren().addAll(circle2,gr2);
		Group roof = new Group(signup);
		scene1 = new Scene (roof,700,450);
		Scene scene = new Scene (broof,700,450);
		Catalog cat = new Catalog();
		sr.setOnAction((event5) -> {
			VBox vbb = new VBox();
			Button r = new Button("Renaissance");
			Button c = new Button ("Cubism");
			Button i = new Button ("Impressionism");
			Button m = new Button ("Modern");
			Button a = new Button ("Abstract Expressionism");
			Button g = new Button ("Gothic");
			Button re = new Button ("Realism");
			Button co = new Button ("Concretism");
			Button su = new Button ("Surrealism");
			Button mi = new Button ("Minimalism");
			Button p = new Button ("Purism");
			Button reg = new Button ("Regionalism");
			Button t = new Button ("Transautomatism");
			Separator sep = new Separator ();
			sep.setOrientation(Orientation.HORIZONTAL);
			r.setPrefSize(500, 20);
			i.setStyle("-fx-background-color:white");
			i.setPrefSize(500, 20);
			r.setStyle("-fx-background-color:white");
			c.setPrefSize(500, 20);
			c.setStyle("-fx-background-color:white");
			m.setPrefSize(500, 20);
			m.setStyle("-fx-background-color:white");
			a.setPrefSize(500, 20);
			a.setStyle("-fx-background-color:white");
			re.setPrefSize(500, 20);
			re.setStyle("-fx-background-color:white");
			g.setPrefSize(500, 20);
			g.setStyle("-fx-background-color:white");
			co.setPrefSize(500, 20);
			co.setStyle("-fx-background-color:white");
			su.setPrefSize(500, 20);
			su.setStyle("-fx-background-color:white");
			mi.setPrefSize(500, 20);
			mi.setStyle("-fx-background-color:white");
			p.setPrefSize(500, 20);
			p.setStyle("-fx-background-color:white");
			reg.setPrefSize(500, 20);
			reg.setStyle("-fx-background-color:white");
			t.setPrefSize(500, 20);
			t.setStyle("-fx-background-color:white");
			vbb.getChildren().addAll(sep,r,i,c,m,a,re,g,co,su,mi,p,reg,t);
			vbb.setPadding(new Insets(5,30,30,30));
			vbb.setSpacing(5);
			vbb.setStyle("-fx-background-color:white");
			ArrayList <Button> b = new ArrayList <> ();
			b.add(g);
			b.add(r);
			b.add(c);
			b.add(i);
			b.add(m);
			b.add(a);
			b.add(re);
			b.add(co);
			b.add(su);
			b.add(mi);
			b.add(p);
			b.add(t);
			b.add(reg);
			c.setOnAction((event8) -> {
	 			vbb.getChildren().clear();
	 			vbb.setPadding(new Insets(0,0,0,0));
	 	        vbb.setSpacing(0);
	 	        vbb.getChildren().addAll(picas.getGrid(idGet(t1.getText(),tn.getText())));
	 			});
				sp.setContent(vbb);
			
			});
         st.setOnAction((event5) -> {
        	 
			sp.setContent(comMain.getCom(idGet(t1.getText(),tn.getText())));
 });
        
         pr.setOnAction((event5) -> {
        	 String emm="Email: ";
        	 try  {
    			 ResultSet rs1=(ResultSet) state.executeQuery("select name , email from user");
    			 

    	    			 while(rs1.next()) {
    				 String name=rs1.getString("name");
    				 String email=rs1.getString("email");
    				    if( t1.getText().equalsIgnoreCase(name)||tn.getText().equalsIgnoreCase(name)) {
    	    	         emm+=email;
    	    	            	    	       
    				 }
    			 }
    	      	    			 FileInputStream inputstream7 = new FileInputStream("C:\\Users\\Admin\\Desktop\\account.png"); 
    	    			 Label l3 = new Label( t1.getText()+tn.getText()) ;
    	      	    	        Label em = new Label(emm); 
     	    	        Image im7 = new Image (inputstream7,110,110,false,false);
     	           	 ImageView iv7 = new ImageView(im7);
     	    	        	 VBox vbb=new VBox(iv7);
     	    	        	 vbb.setAlignment(Pos.CENTER);
     					 VBox vb7 = new VBox(l3,em);
     					 vb7.setSpacing(7);
     					 HBox hb7= new HBox(vb7,iv7);
     					 hb7.setPadding(new Insets(7,320,297,10));
     					 hb7.setSpacing(30);
     					 hb7.setStyle("-fx-background-color:white");
          	 			sp.setContent(hb7);		 
        	 }
        
        	 catch(Exception e ) {
        		 System.out.println(e);
        	 }
        
 	       
 			});
         Label label = new Label ("There are no products in the selected category");
         Button bt= new Button("Go to catalog");
          bt.setStyle("-fx-background-radius:35;-fx-background-color:#F7BE51;-fx-prompt-text-fill:white;-fx-alignment:center");
		VBox vbb = new VBox ();
		vbb.setPadding(new Insets(150,162,250,162));
		vbb.setStyle("-fx-background-color:white");
		vbb.setSpacing(7);
		vbb.getChildren().addAll(label,bt);
		
		Label labelb = new Label ("There are no products in the basket");
        Button btb = new Button("Go to catalog");
         btb.setStyle("-fx-background-radius:35;-fx-background-color:#F7BE51;-fx-prompt-text-fill:white;-fx-alignment:center");
		VBox vbbb = new VBox ();
		vbbb.setPadding(new Insets(150,190,250,190));
		vbbb.setStyle("-fx-background-color:white");
		vbbb.setSpacing(7);
		vbbb.getChildren().addAll(labelb,btb);
          Elected elect = new Elected();
          Basket basket = new Basket ();
        kr.setOnAction((event5) -> {
        	if(checkB(idGet(t1.getText(),tn.getText()))==false) {
        	 vbbb.setAlignment(Pos.CENTER);
 			sp.setContent(vbbb);
 			btb.setOnAction((event6) -> {
 	        	sp.setContent(comMain.getCom(idGet(t1.getText(),tn.getText())));
 	 	       
 	 			}); } else {
        	sp.setContent(basket.getGrid(idGet(t1.getText(),t2.getText()))); }
 			});
        		fv.setOnAction((event5) -> {
        			if(checkB(idGet(t1.getText(),tn.getText()))==false) {
			vbb.setAlignment(Pos.CENTER);
 			sp.setContent(vbb);
 			bt.setOnAction((event6) -> {
 	        	sp.setContent(comMain.getCom(idGet(t1.getText(),t2.getText())));
 	 	       
 	 			});
        			}
        			else {
 	       sp.setContent(elect.getGrid(idGet(t1.getText(),tn.getText()))); }
 			});

         		//scene.getStylesheets().add(getClass().getResource("style.css").toString());
         window.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTghD2We9c1isP97nARwgkxe3c5J8EA7x1Z9jHlaiaYnsBpnXs7"));
         stage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTghD2We9c1isP97nARwgkxe3c5J8EA7x1Z9jHlaiaYnsBpnXs7"));
         window.setTitle("Art Gallery");
         window.setScene (scene);
		window.show();	
		
	}
	 public boolean check(String uname, String upass) {
		 boolean bool=false;
		 try  {
			 ResultSet rs1=(ResultSet) state.executeQuery("select name , password from user");
			 while(rs1.next()) {
				String name = rs1.getString("name");
				String password = rs1.getString("password");
				if (uname.equalsIgnoreCase(name)& upass.equalsIgnoreCase(password)) {
					bool=true;
				}
					
			 }
		 }
		 catch(Exception e) {
			System.out.println(e); 
		 }
		 return bool;
	        }
	 public boolean create (String uname,String uemail,String upass) {
		 boolean bool=false;
		 try  {
			 ResultSet rs1=(ResultSet) state.executeQuery("select userid, name , email, password,fvid,basketid from user");
			 while(rs1.next()) {
				String name = rs1.getString("name");
				String email = rs1.getString("email");
				int userid=rs1.getInt("userid");
				int fvid=rs1.getInt("fvid");
				int basketid = rs1.getInt("basketid");
				Random rand = new Random();
				int usid=rand.nextInt(101);
				int fid = rand.nextInt(101);
				int bid=rand.nextInt(101);
		
				if (!uname.equalsIgnoreCase(name)|| uemail.equalsIgnoreCase(email)||usid==userid||fid==fvid||bid==basketid) {
					try {
					 state.executeUpdate("INSERT INTO user VALUES ( " + usid + ", '" + uname + "','" + uemail + "', '"+upass+"', "+fid+", " + bid +" )");	
					bool=true; }
					catch(Exception e1) {
						System.out.println(e1);
					}
				}
					
			 }
		 }
		 catch(Exception e) {
			System.out.println( e); 
		 }
		return bool;
	 }
	 public void addPicture (String aut,String im,String tit,String pr,String st) {
		 try {
			 ResultSet rs1=(ResultSet) state.executeQuery("select elid from element"); 
			while(rs1.next()) {
				int elid=rs1.getInt("elid");
				Random rand = new Random();
				int ellid=rand.nextInt(101);
			  if (ellid!=elid) {
			 state.executeUpdate("INSERT INTO element VALUES ( " + ellid + ", '" + aut + "','" + im + "', '"+tit+"', '"+pr+"', '" + st +"' )");	 
			  }
			  }
			
			}
		 catch (Exception e1 ) {
			 System.out.println(e1);
		 }
		 
	 }
	 public String idGet(String name1,String name2) {
		 String uid="";
		 try  {
			 ResultSet rs1=(ResultSet) state.executeQuery("select name , userid from user");
			 while(rs1.next()) {
				String name = rs1.getString("name");
				String userid = rs1.getString("userid");
				if (name1.equalsIgnoreCase(name)|| name2.equalsIgnoreCase(name)) {
					uid+=userid;
				}
					
			 }
		 }
		 catch(Exception e) {
			System.out.println(e); 
		 }
		 return uid;
	        }
           public boolean checkB (String userid) {
        	  Boolean bool = false;
        	  try  {
     			 ResultSet rs1=(ResultSet) state.executeQuery("select * from elected");
     			 while(rs1.next()) {
     				 
     				 String uid=rs1.getString("userid");
     				 if (userid.equalsIgnoreCase(uid)) {
     					 bool=true;
     				 } } }
        	  catch (Exception e ) {
        		  System.out.println(e);
        	  }

        	  return bool;
           }
		public static void main(String [] args) {
		launch(args);
	}
		
	

}


