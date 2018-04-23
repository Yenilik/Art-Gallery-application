package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Catalog  {
public ArrayList <Element> ellist;
public String style;
public Element el;
     public Catalog () {
    	 
     }
     public Catalog ( Element el) {
    	this.el=el;
     }
	public VBox getV ()  {
		VBox vb = new VBox();
		//FileInputStream inputstream = new FileInputStream("C:\\Users\\Admin\\Desktop\\search2.png");
		//Image im = new Image ("https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Search_ballonicon2.svg/2000px-Search_ballonicon2.svg.png",20,20,false,false);
		//ImageView img = new ImageView (im);
		TextField s = new TextField ();
		s.setPrefSize(510, 25);
		s.setPromptText("Search");
		s.setStyle("-fx-background-radius:35;-fx-background-color:#F7BE51;-fx-prompt-text-fill:white;-fx-alignment:center");
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
		vb.getChildren().addAll(s,sep,r,i,c,m,a,re,g,co,su,mi,p,reg,t);
		vb.setPadding(new Insets(5,30,30,30));
		vb.setSpacing(5);
		vb.setStyle("-fx-background-color:white");
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
		c.setOnAction((event5) -> {
 			vb.getChildren().clear();
 			
 	        
 			});

			
				return vb;
	}
}
