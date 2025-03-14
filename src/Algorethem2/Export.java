package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import Algorethem2.Main;
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
import javafx.scene.control.TextArea;
import javafx.scene.effect.Shadow;
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

public class Encr extends Application {

	int width;
	int height;
	int count=0;
	String bits="";
	int x;
	int y;
	String total;
	
	File file;
	String Path;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		Pane p1 = new Pane();

		p1.setStyle("-fx-Background-color:rgb(187, 192, 209);");

		ImageView imageView = new ImageView("comp.png");
		imageView.setFitWidth(800);
		imageView.setFitHeight(600);

		Label l1 = new Label("Please Enter Any Text:");
		l1.setStyle("-fx-font-size:25; -fx-text-fill:rgb(187, 192, 209);");

		l1.setLayoutX(10);
		l1.setLayoutY(320);

		TextArea tt = new TextArea();
		tt.setLayoutX(10);
		tt.setLayoutY(360);
		tt.setPrefHeight(120);
		tt.setPrefWidth(770);
		tt.setStyle("-fx-control-inner-background:rgb(208, 215, 238);");

		tt.setFont(new Font(20));

		Button b1 = new Button("Run");
		b1.setStyle("-fx-background-radius: 50px; -fx-font-size: 20px;");

		b1.setPrefWidth(100);
		b1.setPrefHeight(30);
		b1.setLayoutX(350);
		b1.setLayoutY(500);
//C:\\Users\\HP\\Pictures\\Screenshots\\Screenshot 2024-07-17 214218.png
		
		FileChooser f1 = new FileChooser();
		f1.setTitle("Choose File");
		 file = f1.showOpenDialog(primaryStage);			
		if(file == null)
		{
			Alert al=new Alert(AlertType.ERROR);
			al.setContentText("Please enter file");
			al.show();
			return;
			
		 	}
		
		Path=file.getPath();
		System.out.println(Path);
		
	
		
		
		BufferedImage image = ImageIO.read(file);
		 width = image.getWidth();
		 height = image.getHeight();

		b1.setOnAction(er -> {
			if (tt.getText().trim() == "") {
				Alert al = new Alert(AlertType.ERROR);
				al.setContentText("Please Enter Text");
				al.show();
				return;

			}

			String n = tt.getText();
			 total = "";

			 
			 
			for (int i = 0; i < n.length(); i++) {
				int j = (int) n.charAt(i);
				int count = 0;
				String sum = "";
				while (count < 8) {
					if (j == 0) {
						sum += "0";
					} else if (j % 2 == 0) {
						sum += "0";

					} else {
						sum += "1";
					}
					j /= 2;
					count++;
				}
				String reversed = new StringBuilder(sum).reverse().toString();
				total += reversed;

			}

			 bits = "";
			 count = 0;
			int newPixel = 0;
			for (int i = 0; count < total.length(); i++) {
				int revTohight = total.length() - 1 - i;
				 x = generateRandomNumber(i, width);
				 y = generateRandomNumber(revTohight, height);
				int pixel = image.getRGB(x, y);
				int alpha = (pixel >> 24) & 0xff;
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = pixel & 0xff;

				bits += total.charAt(count) + "";

				if (red % 2 == 0 && count < total.length()) {
					if (Integer.parseInt(total.charAt(count) + "") == 1) {
						red++;
					}

					count++;
				} else if (red % 2 != 0 && count < total.length()) {
					if (Integer.parseInt(total.charAt(count) + "") == 0) {
						red--;
					}

					count++;
				}

				if (count > total.length() - 1) {

					newPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
					image.setRGB(x, y, newPixel);
					break;
				}
				bits += total.charAt(count) + "";
				if (green % 2 == 0 && count < total.length()) {
					if (Integer.parseInt(total.charAt(count) + "") == 1) {
						green++;
					}

					count++;
				} else if (green % 2 != 0 && count < total.length()) {
					if (Integer.parseInt(total.charAt(count) + "") == 0) {
						green--;
					}

					count++;
				}

				if (count > total.length() - 1) {
					newPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
					image.setRGB(x, y, newPixel);
					break;
				}
				bits += total.charAt(count) + "";
				if (blue % 2 == 0 && count < total.length()) {
					if (Integer.parseInt(total.charAt(count) + "") == 1) {
						blue++;
					}

					count++;
				} else if (blue % 2 != 0 && count < total.length()) {
					if (Integer.parseInt(total.charAt(count) + "") == 0) {
						blue--;
					}
					count++;
				}
				newPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
				image.setRGB(x, y, newPixel);

			}

			int x = 0, y = 0;

			File outputFile = new File("C:/Users/HP/Pictures/Screenshots/Screenshot 2024-07-17 21490822.png");
			try {
				ImageIO.write(image, "png", outputFile);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			System.out.println("enter number");
//			int n1 = next.nextInt();
//			if (n1 == 1) {
//

//
//			
//			
//			
//			
//			

			Pane p2 = new Pane();
			p2.setStyle("-fx-Background-color:rgb(187, 192, 209);");

			Label org = new Label("Original image:");

			org.setStyle("-fx-font-size:25; -fx-text-fill:Black;");

			org.setLayoutX(10);
			org.setLayoutY(20);

			Label copy = new Label("Copy image:");

			copy.setStyle("-fx-font-size:25; -fx-text-fill:Black;");

			copy.setLayoutX(410);
			copy.setLayoutY(20);
			
			
			HBox h1=new HBox();
			
			ImageView image1=new ImageView(Path);
			ImageView image2=new ImageView("file:C:/Users/HP/Pictures/Screenshots/Screenshot 2024-07-17 21490822.png");
			
			image1.setFitWidth(400);
			image2.setFitWidth(400);
			image1.setFitHeight(400);
			image2.setFitHeight(400);
		
			h1.getChildren().addAll(image1,image2);
			h1.setLayoutY(70);
			
			Button Decryption=new Button("Decryption");
			Decryption.setPrefWidth(200);
			Decryption.setPrefHeight(30);
			Decryption.setLayoutX(300);
			Decryption.setLayoutY(500);	
			Decryption.setStyle("-fx-background-radius: 50px; -fx-font-size: 20px;");

			Decryption.setOnAction(etr->
			{
				
				
				File filecopy = new File("C:/Users/HP/Pictures/Screenshots/Screenshot 2024-07-17 21490822.png");

				BufferedImage imagecopy;
				try {
					imagecopy = ImageIO.read(filecopy);
					width = imagecopy.getWidth();
					 height = imagecopy.getHeight();

			
					  
					 count = 0;
					bits = "";
					for (int i = 0; count < total.length(); i++) {
						int revTohight = total.length() - 1 - i;
					  int x1 = generateRandomNumber(i, width);
					  int y1 = generateRandomNumber(revTohight, height);

						int pixel = imagecopy.getRGB(x1, y1);
						int red = (pixel >> 16) & 0xff;
						count++;
						bits += red % 2 + "";
						if (count > total.length() - 1)
							{
							break;
							}
						int green = (pixel >> 8) & 0xff;
						count++;
						bits += green % 2 + "";
						if (count > total.length() - 1)
							break;
						int blue = pixel & 0xff;
						count++;
						bits += blue % 2 + "";
					}

					int sum = 0;
					String secret = "";
					for (int i = 0; i < bits.length();) {
						sum = 0;

						for (int j = 0; j < 8 && i < bits.length(); j++) {
							if (bits.charAt(i) != '0')
								sum += Math.pow(2, 8 - j - 1);
							i++;
						}
						secret += (char) sum + "";

					}

				
				Stage s1=new Stage();
				Label lab=new Label(secret);
				lab.setFont(new Font(15));
				
				Pane pp=new Pane();
				pp.getChildren().add(lab);
				pp.setStyle("-fx-Background-color:rgb(187, 192, 209);");

				
				
				Scene sd=new Scene(pp,800,300);
				
				s1.setScene(sd);
				s1.show();
				
			
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			  
				
				
				
				
				
			});
			
			
			
			
			
			
			
			
			p2.getChildren().addAll(org,copy,h1,Decryption);

			Scene s2 = new Scene(p2, 800, 600);
			primaryStage.setScene(s2);

		});

		p1.getChildren().addAll(imageView, tt, l1, b1);

		Scene scene = new Scene(p1, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public static int generateRandomNumber(int n, int length) {
		int a = 37;
		int b = 42;

		return (a * n + b) % length;

	}
}
