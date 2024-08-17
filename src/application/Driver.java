package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



public class Driver extends Application {
 static QuadraticHash<Date_Record> Date_Table = new QuadraticHash(11);

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		
		ArrayList<Distict> newn=new ArrayList<>();
		
		Button start = new Button();
		
		start.setShape(new javafx.scene.shape.Rectangle(30, 80));
		start.setMinSize(220, 100);
		start.setMaxSize(220, 100);
		start.setLayoutX(300);
		start.setLayoutY(350);
		Image image = new Image("file:/C:/Users/HP/Pictures/Screenshots/nemer4.png");
		start.setGraphic(new ImageView(image));
		start.setPrefSize(100, 50);
		Pane stackpane = new Pane();
		stackpane.getChildren().addAll(start);
		String imagePath = "file:/C:/Users/HP/Pictures/Screenshots/nemer3.png";
		Scene choose = new Scene(stackpane, 800, 800);
		primaryStage.setScene(choose);
		primaryStage.show();
		start.setOnAction(e -> {
			try {
				Scanner s1 = write(primaryStage);
				if (s1 == null) {
					return;
				}
				s1.nextLine();
				int sum = 0;
				int j=0;
				while (s1.hasNext()) {
					
					String[] part = s1.nextLine().split(",");
					
					if (part.length != 6)// to cheak the data is valid
						continue;
					
			
					
					
					
					try {
						Integer.parseInt(part[2]);
					} catch (Exception x) {
						part[2] = "0";
					}
					Martyr m1 = new Martyr(part[0].trim(), Integer.parseInt(part[2].trim()),part[5].toLowerCase().trim().charAt(0));
					boolean m=false;
					
					for(int i=0;i<newn.size();i++)
					{
						
						if(newn.get(i).name.toLowerCase().trim().compareTo(part[4].toLowerCase().trim())==0)
						{	
							if(newn.get(i).find(part[3])==null)
							{
								
								
								newn.get(i).locaion.add(part[3]);
							
							}
							m=true;
							break;
						}
						
					}
					
					if(m==false)
					{
					
						
						Distict d1=new Distict();
						d1.name=part[4];
						d1.locaion.add(part[3]);
						newn.add(d1);
					
					}

					
					
					m1.setDistrict(part[4]);
					m1.setLocation(part[3]);
					int year = Integer.parseInt(part[1].split("/")[2]);
					int moanth = Integer.parseInt(part[1].split("/")[0]);
					int day = Integer.parseInt(part[1].split("/")[1]);
					
					Date_Record date = new Date_Record(year, moanth, day);
					Date_Record find ;
					try{
				find = Date_Table.find(date).getData();
					}catch (Exception e1) {
						find=null;
					}
					if (find == null) {
					
						Date_Table.insert(date);
		
					}
					Date_Table.find(date).getData().getMartyr().insert(m1);
			
					
				}
				
				System.out.println(Date_Table.getNewn().length);
				
				
				FX_Scene scene = new FX_Scene();
				scene.setDis(newn);
				scene.setDate(Date_Table);
				scene.getpane(primaryStage);

			} catch (Exception e2) {
				// TODO: handle exception
			}

		});

	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Scanner write(Stage pri) throws FileNotFoundException {
		FileChooser filechoser = new FileChooser();
		File file = filechoser.showOpenDialog(pri);
		if (file == null) {
			Alert alert1 = new Alert(AlertType.ERROR);
			alert1.setHeaderText("please enter valid data");
			alert1.show();
			return null;
		}
		Scanner s1 = new Scanner(file);
		return s1;
	}

}
