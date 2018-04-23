package project;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Compilation {
public String text;
public Image im;
public String text2;
public ArrayList <Image> listim = new ArrayList <Image> ();
public   ArrayList<String> listst = new ArrayList <String>();
public  ArrayList <String> listst2 = new ArrayList <String> ();
public ArrayList <Element> ellist = new ArrayList <Element>();


	public Compilation (String text,String text2, Image im,ArrayList <Element> ellist) {
		this.text=text;
		this.text2=text2;
		this.im=im;
		this.listst.add(text);
		this.listst2.add(text2);
		this.ellist=ellist;
		
	}
	
	public VBox getVb (String userid) {
		VBox vb = new VBox ();
		ImageView img = new ImageView (im);
		Text tx = new Text(this.text);
		Text tx2 = new Text (this.text2);
		Button  bt  = new Button ("See all pictures");
		 bt.setPrefSize(470,20);
		 bt.setStyle("-fx-background-color:#F7BE51;-fx-text-fill:white;-fx-background-radius:35");
		vb.getChildren().addAll(img,tx,tx2,bt);
		vb.setSpacing(7);
		vb.setStyle("-fx-background-color:white");
		vb.setPadding(new Insets(5,50,20,50));
		bt.setOnAction((event5) -> {
			vb.setPadding(new Insets(0,0,0,0));
			vb.getChildren().clear();
			vb.setSpacing(0);
			vb.getChildren().addAll(getGrid(userid));
	       
			});
		
		return vb;
	}
	public GridPane getGrid (String userid) {
        GridPane gr = new GridPane ();
        int x =ellist.size()/3;
        int y=ellist.size()%3;
        int x1=ellist.size()-1;
        if (y!=0) {
        	x=x+1;
        }
     
        for (int i=0; i<x;i++) {
        	for (int j=0; j<3; j++) {
        		if (x1>=0) {
        		gr.add(ellist.get(x1).getv(userid), j, i);
        		x1--;
        		}
        	}
        }
        gr.setVgap(7);
        gr.setHgap(12);
        gr.setStyle("-fx-background-color:white");
        gr.setPadding(new Insets(5,6,6,6));
        
		return gr;
	}
	
}

