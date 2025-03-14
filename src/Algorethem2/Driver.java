package Algorethem2;

import java.awt.TextArea;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.swing.JFileChooser;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Driver extends Application {

	static Scene scene;
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		Pane p1 = new Pane();
		Button compres = new Button("  File Compression  ");
		compres.setFont(new Font(25));
		Button Decompres = new Button("File Decompression");
		Decompres.setFont(new Font(25));
		VBox h1 = new VBox();
		h1.getChildren().addAll(compres, Decompres);

		h1.setSpacing(20);

		ImageView imageView = new ImageView("comp.png");
		imageView.setFitWidth(800);
		imageView.setFitHeight(600);

		h1.setLayoutX(270);
		h1.setLayoutY(300);
		p1.getChildren().addAll(imageView, h1);

		compres.setOnAction(e -> {


			FileChooser f1 = new FileChooser();
			f1.setTitle("Choose File");
			File file = f1.showOpenDialog(primaryStage);			
			if(file != null)
			{
			 Main main=new Main();

				main.namefile=file.getName();	
				main.file=file;
			    FileChooser fileChooser = new FileChooser();
			    
				if( fileChooser==null) {
					Alert al=new Alert(AlertType.ERROR);
					al.setContentText("Please choose file");
					al.show();
					return;
				}
			  
			  System.out.println(main.file.getName());
			  System.out.println("-----------------------------");
		  
			    
		        fileChooser.setTitle("Enter where do you need save the file");
		        
			    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All Files", "*.*");

			    fileChooser.getExtensionFilters().add(extFilter);
		        
			    fileChooser.setInitialFileName(main.namefile+".hfmn");

		        File file1 = fileChooser.showSaveDialog(primaryStage);
                main.filehfmn=file1;
                
                
                
                
                Button header = new Button("Show header");
				Button Table = new Button("Show Table");
			
				header.setFont(new Font(22));
				Table.setFont(new Font(22));
				//statc.setFont(new Font(22));
				header.setVisible(false);
				Table.setVisible(false);
			//	statc.setVisible(false);
				
				
				
				HBox h2 = new HBox();
				
				h2.getChildren().addAll(header, Table);
				
				h2.setSpacing(410);
	            
				h2.setLayoutX(40);
	            
				h2.setLayoutY(500);
				
				Pane p2 = new Pane();
				
				Label l1=new Label("Befor compression :"+(double)file.length()/1000+" Kbyte");
				
				Label l2=new Label("After compression :");
				
				Label l3=new Label("Compression ratio :");
				l1.setPrefWidth(450);
				l2.setPrefWidth(450);
				l3.setPrefWidth(450);
				l1.setFont(new Font(20));
				l1.setStyle("-fx-background-color: #F0F0F0;" + 
				            "-fx-text-fill: #000000;" +  
			            		"-fx-border-color: #F0F0F0;" +
			                    "-fx-border-width: 2;" +         
			                    "-fx-padding: 10;");
				l2.setStyle(
			            "-fx-background-color: #F0F0F0;" + 
				                "-fx-text-fill: #000000;" +  
			            		"-fx-border-color: #F0F0F0;" +
			                    "-fx-border-width: 2;" +         
			                    "-fx-padding: 10;" 
			                    );
				l3.setStyle("-fx-background-color: #F0F0F0;" + 
				                "-fx-text-fill: #000000;" +  
			            		"-fx-border-color: #F0F0F0;" +
			                    "-fx-border-width: 2;" +         
			                    "-fx-padding: 10;" 
			                    );
				l2.setFont(new Font(20));
				l3.setFont(new Font(20));
				
				VBox v1=new VBox();
				v1.getChildren().addAll(l1,l2,l3);
				v1.setSpacing(20);
				v1.setLayoutX(20);
				v1.setLayoutY(20);
				v1.setSpacing(30);
				
				
				Button back=new Button(" Back ");
				back.setFont(new Font(15));
				back.setLayoutX(730);
				back.setLayoutY(20);
				back.setVisible(false);
				back.setOnAction(er->
				{
					primaryStage.setScene(scene);
					
				});
				p2.getChildren().addAll(h2,v1,back);
				p2.setStyle("-fx-background-color: #0C142C;");
				Scene s1=new Scene(p2,800,600);
				primaryStage.setScene(s1);
                  
		        main.filecompress();

		    	 l2.setText("After compression :"+(double)file1.length()/1000+" Kbyte");
		    	 double ratio=(double)(((double)file.length()-file1.length())/file.length())*100;
		    
				 l3.setText( String.format("Compression ratio: %.2f", ratio));
			
				 header.setVisible(true);
					Table.setVisible(true);
					//statc.setVisible(true);
					back.setVisible(true);
		        Alert al=new Alert(AlertType.INFORMATION);
			       
				al.setContentText("The compress is succ");
				al.show();
				
		
	

    Table.setOnAction(er->
    {
    	ArrayList<TableHufman> newn=(ArrayList<TableHufman>) main.tableHufman.clone();
    	
    	
    	
    	
    	
    	
    	 TableView<TableHufman> tableView = new TableView<>();

    	 
    	 
    	 
         for(int i=0;i<newn.size();i++)
         {
        	 if(newn.get(i).getData()>127)
        	 {
        		newn.get(i).setData(newn.get(i).getData());
        	 }
         }
    	 TableColumn<TableHufman, Integer> dataColumn = new TableColumn<>("Data");
         dataColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getData()).asObject());

         TableColumn<TableHufman, Integer> frequencyColumn = new TableColumn<>("Frequency");
         frequencyColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getFrequncy()).asObject());

         TableColumn<TableHufman, String> codeColumn = new TableColumn<>("Code");
         codeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCode()));

         TableColumn<TableHufman, Integer> lengthColumn = new TableColumn<>("length");
         lengthColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getLength()).asObject());

         dataColumn.setPrefWidth(200);
         frequencyColumn.setPrefWidth(200);
         codeColumn.setPrefWidth(200);
         lengthColumn.setPrefWidth(200);
         tableView.getColumns().add(dataColumn);
         tableView.getColumns().add(frequencyColumn);
         tableView.getColumns().add(codeColumn);
         tableView.getColumns().add(lengthColumn);
         ObservableList<TableHufman> huffmanData = FXCollections.observableArrayList(newn);
         tableView.setItems(huffmanData);
         VBox vbox = new VBox(tableView);
         Scene scene = new Scene(vbox, 800, 500);
         
         Stage ss=new Stage();
         ss.setTitle("Huffman Table View");
         ss.setScene(scene);
         ss.show();
    	
    	
    	
    	
    });
	header.setOnAction(er->
	{	
		Stage ss=new Stage();
		Pane pp=new Pane();
		javafx.scene.control.TextArea heade=new javafx.scene.control.TextArea();
		heade.setPrefHeight(600);
		heade.setPrefWidth(800);
		heade.setText(main.heead);
		pp.getChildren().addAll(heade);
		Scene scane=new Scene(pp,heade.getPrefWidth(),heade.getPrefHeight());
		ss.setScene(scane);
		ss.show();	
	});
   			       
	     		
				
				
				
				
				
			}
			else {
				
				Alert al=new Alert(AlertType.ERROR);
				al.setContentText("Please choose file");
				al.show();
				return;
				
			}
			
			
			
	
		});
		
		Decompres.setOnAction(rt->
		{
			
			Decompres dec=new Decompres();

			FileChooser f1 = new FileChooser();
			f1.setTitle("Choose File");
			File file = f1.showOpenDialog(primaryStage);

			   
			    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All Files", "*.hfmn*");

			    f1.getExtensionFilters().add(extFilter);
		    if(!file.getName().contains(".hfmn"))
		    {
		    	Alert al=new Alert(AlertType.ERROR);
				al.setContentText("Please choose coreect file file");
				al.show();
				return;
		    }
			    
			    
			if(file != null)
			{
				dec.filePath=file;	
				
				DirectoryChooser  der=new DirectoryChooser();
			    
				   
				   der.setTitle("Select Folder");

			       File selected = der.showDialog(primaryStage);
				
				if( selected==null) {
					Alert al=new Alert(AlertType.ERROR);
					al.setContentText("Please choose file");
					al.show();
					return;
				}
			
				dec.decpath=selected.getPath();
				try {
					dec.decompress();
					Alert al=new Alert(AlertType.INFORMATION);
					al.setContentText("Succeccfly");
					al.show();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 
			
               
			}
			else {
				
				Alert al=new Alert(AlertType.ERROR);
				al.setContentText("Please choose file");
				al.show();
				return;
				
			}
			
			
			
	
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		});

		 scene = new Scene(p1, 800, 600);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
