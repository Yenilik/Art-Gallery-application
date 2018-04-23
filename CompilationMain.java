package project;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class CompilationMain {
public ArrayList <Compilation> list;

	public CompilationMain (ArrayList <Compilation> list) {
		this.list=list;
			}
	 public VBox getCom (String userid) {
		 VBox vb = new VBox ();
		 int i=this.list.size()-1;
		 while (i>=0) {
			
			 vb.getChildren().addAll(this.list.get(i).getVb(userid));
			 i--;
		 }
		
		 
		 vb.setSpacing(7);
		 vb.setStyle("-fx-background-color:white");
		 return vb;
	 }
	 public ArrayList <Compilation>getCL () {
		 return this.list;
	 }
		 

}
