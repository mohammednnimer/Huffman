package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FX_Scene extends Application {
	QuadraticHash<Date_Record> Date;

	TableView<String> table1 = new TableView<>();

	private ArrayList<Distict> dis = new ArrayList<>();

	public ArrayList<Distict> getDis() {
		return dis;
	}

	public void setDis(ArrayList<Distict> dis) {
		this.dis = dis;
	}

	public void setDate(QuadraticHash<Date_Record> date) {
		Date = date;
	}

	ImageView imag = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\plus.png");
	ImageView ubd = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\ubp.png");
	ImageView neg = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\neg.png");
	ImageView imag1 = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\nemer.jpeg");
	ImageView left = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\left.png");
	ImageView left1 = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\left.png");
	Scene choose;

	AVL_Tree<Martyr> avl;

	@Override
	public void start(Stage arg0) throws Exception {

	}

	public Pane getpane(Stage primaryStage) {
		avl = Date.traverce().getfront().getMartyr();

		Button b1 = new Button("Choose to Date screen");
		b1.setShape(new javafx.scene.shape.Ellipse(85, 40)); // Creating an oval shape
		b1.setMinSize(170, 80);
		b1.setMaxSize(170, 80);
		b1.setLayoutX(100);
		b1.setLayoutY(20);

		b1.setStyle(
				"-fx-background-color: #B0BEC5; -fx-text-fill: black; -fx-border-color: black; -fx-border-radius: 50; -fx-background-radius: 50; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");

		Button b2 = new Button("Choose to Martyr screne");
		b2.setShape(new javafx.scene.shape.Ellipse(85, 40)); // Creating an oval shape
		b2.setMinSize(170, 80);
		b2.setMaxSize(170, 80);
		b2.setLayoutX(100);
		b2.setLayoutY(120);

		b2.setStyle(
				"-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-border-color: black; -fx-border-radius: 50; -fx-background-radius: 50; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");

		Button b3 = new Button("Load to file");
		b3.setShape(new javafx.scene.shape.Ellipse(85, 40)); // Creating an oval shape
		b3.setMinSize(170, 80);
		b3.setMaxSize(170, 80);
		b3.setLayoutX(100);
		b3.setLayoutY(220);

		b3.setStyle(
				"-fx-background-color: #E0E0E0; -fx-text-fill: black; -fx-border-color: black; -fx-border-radius: 50; -fx-background-radius: 50; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");

		imag1.setFitWidth(800);
		imag1.setFitHeight(450);
		Pane v2 = new Pane();

		v2.getChildren().addAll(b1, b2, b3);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("please enter valid data ");
		alert.setContentText("Hello, World!");
		String imagePath = "file:/C:/Users/HP/Pictures/Screenshots/nemer.jpeg";
		Image image = new Image(imagePath);

		BackgroundSize backgroundSize = new BackgroundSize(800, 800, false, false, false, false);
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);

		Background background = new Background(backgroundImage);
		v2.setBackground(background);
		b1.setOnAction(e -> {

			Date_Scene date = new Date_Scene();
			date.setDate(Date);
			date.abload();
			date.setNegative(date.getQueue().getfront());
			Label l1 = new Label("please Enter Date");

			DatePicker d1 = new DatePicker();

			HBox h1 = new HBox();
			h1.setSpacing(10);
			VBox v1 = new VBox();
			v1.setSpacing(10);
			HBox root = new HBox();

			Label ll = new Label("Please Enter Date:");
			ll.setFont(new Font(22));
			root.getChildren().addAll(ll, d1);
			root.setSpacing(10);

			imag.setFitHeight(20);
			imag.setFitWidth(20);
			Button insert = new Button("insert a new Date", imag);
			insert.setPrefWidth(180);
			insert.setPrefHeight(40);
			insert.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");
			Button print = new Button("print the Hash Table ");
			print.setPrefWidth(180);
			print.setPrefHeight(40);
			print.setStyle("-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");

			VBox pane = new VBox();
			pane.setSpacing(20);
			root.setAlignment(Pos.CENTER);
			pane.setAlignment(Pos.CENTER);

			neg.setFitHeight(20);
			neg.setFitWidth(20);
			Button delet = new Button("Delet Date    ", neg);
			delet.setPrefWidth(180);
			delet.setPrefHeight(40);
			delet.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");

			ubd.setFitHeight(20);
			ubd.setFitWidth(20);
			Button ubdat = new Button("Ubdate the Date", ubd);
			ubdat.setPrefWidth(180);
			ubdat.setPrefHeight(40);
			ubdat.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");

			ImageView ent = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\enter.jpeg");
			ent.setFitHeight(20);
			ent.setFitWidth(20);
			Button enter = new Button("load", ent);
			enter.setPrefWidth(180);
			enter.setPrefHeight(40);
			enter.setStyle("-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");

			
			
			Button Printwhith = new Button("Print with the Empty");
			Printwhith.setPrefWidth(180);
			Printwhith.setPrefHeight(40);
			Printwhith.setStyle("-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");

			
			
			Label displ1 = new Label("Avrege the age =" + date.avg());

			Label displ2 = new Label("Total number of martyr =" + date.total());
			Label displ3 = new Label("Name of Daistict =" + date.district());
			Label displ4 = new Label("Name of location =" + date.Location());
			displ1.setFont(new Font(15));
			displ2.setFont(new Font(15));
			displ3.setFont(new Font(15));
			displ4.setFont(new Font(15));
			Label nameof = new Label("Date :" + date.getNegative().getDate());
			nameof.setFont(new Font(20));
			HBox h2 = new HBox();
			Label nameofdistrict = new Label("      ");
			h2.setAlignment(Pos.CENTER);
			h2.getChildren().addAll(nameof, nameofdistrict);
			pane.getChildren().addAll(h2, root, insert, delet, ubdat, print, enter,Printwhith ,displ1, displ2, displ3, displ4);
			BorderPane porderPane = new BorderPane();
			porderPane.setCenter(pane);

			Button back = new Button("Back");
			porderPane.setTop(back);
			porderPane.setAlignment(back, Pos.CENTER);
			back.setOnAction(t -> {

				primaryStage.setScene(choose);

			});

			left.setFitHeight(30);
			left.setFitWidth(30);
			Button button = new Button("", left);
			porderPane.setLeft(button);
			porderPane.setAlignment(button, Pos.CENTER);
			Button button1 = new Button("", left1);
			left1.setFitHeight(30);
			left1.setFitWidth(30);
			button.setRotate(180);
			porderPane.setRight(button1);
			porderPane.setAlignment(button1, Pos.CENTER);
			porderPane.setStyle(
					"-fx-background-color: #B0BEC5; -fx-text-fill: black; -fx-border-color: black; -fx-border-radius: 50; -fx-background-radius: 50; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
			Scene s1 = new Scene(porderPane, 800, 800);
			primaryStage.setScene(s1);
			insert.setOnAction(e1 -> {

				if (d1 == null) {
					Alert alert1 = new Alert(AlertType.ERROR);
					alert1.setTitle("Wrong password");
					alert1.setHeaderText(null);
					alert1.setContentText("Please enter date");
					alert1.showAndWait();
					return;
				} else {
					LocalDate loc = d1.getValue();
					if(loc==null)
					{
						Alert alert1 = new Alert(AlertType.ERROR);
						alert1.setTitle("");
						alert1.setHeaderText(null);
						alert1.setContentText("The date is not exist");
						alert1.showAndWait();
						return;
					}
					
					Date_Record dd = new Date_Record(loc);
					if (Date.find(dd) != null) {
						Alert alert1 = new Alert(AlertType.ERROR);
						alert1.setTitle("Wrong password");
						alert1.setHeaderText("the Date is alredy axist");
						alert1.setContentText("the Date is alredy axist");
						alert1.showAndWait();
						d1.setValue(null);
						return;
					} else {
						Date.insert(dd);
						if(!table1.getItems().isEmpty())
						{
							table1.getItems().clear();
							date.print(table1);
						}
						date.fromto();
						l1.setText("Date :" + date.getNegative().getDate());
						table1.getItems().clear();
					
						Alert alert1 = new Alert(AlertType.INFORMATION);
						alert1.setTitle("");
						alert1.setHeaderText("");
						alert1.setContentText("The operation succeeded");
						alert1.showAndWait();
						d1.setValue(null);
						date.setDate(Date);
						date.setQueue(new Queue<>());
						date.setStack(new Stack_Linked_list<>());
						date.abload();
						date.fromto();
					}
					d1.setValue(null);
				}

			});

			button1.setOnAction(e2 -> {
				Date_Record dd = date.next();
				if (dd != null) {
					if(!table1.getItems().isEmpty())
					{
						table1.getItems().clear();
						date.print(table1);
						
					}
					date.setNegative(dd);
					
					try {
						nameof.setText("Date :" + date.getNegative().getDate());
						displ2.setText("Total number of martyr =" + date.total());
						displ1.setText("Avrege the age =" + date.avg());
						displ3.setText("Name of Daistict =" + date.district());
						displ4.setText("Name of location =" + date.Location());
					}catch (Exception e1) {
						
						
						displ2.setText("Total number of martyr =" + "");
						displ1.setText("Avrege the age =" + 0);
						displ3.setText("Name of Daistict =" + "");
						displ4.setText("Name of location =" + "");
						
					}
					
					
					

					
				}
			});
			button.setOnAction(e2 -> {
				Date_Record dd = date.prev();
				if (dd != null) {
					if(!table1.getItems().isEmpty())
					{
						table1.getItems().clear();
						date.print(table1);
					}
					date.setNegative(dd);
					try {
						nameof.setText("Date :" + date.getNegative().getDate());
						displ2.setText("Total number of martyr =" + date.total());
						displ1.setText("Avrege the age =" + date.avg());
						displ3.setText("Name of Daistict =" + date.district());
						displ4.setText("Name of location =" + date.Location());
					}catch (Exception e1) {
						displ2.setText("Total number of martyr =" + "");
						displ1.setText("Avrege the age =" + 0);
						displ3.setText("Name of Daistict =" + "");
						displ4.setText("Name of location =" + "");	
					}
				}
			});

			delet.setOnAction(e1 -> {
				if (d1 == null) {
					Alert alert1 = new Alert(AlertType.ERROR);
					alert1.setTitle("Wrong password");
					alert1.setHeaderText(null);
					alert1.setContentText("Please enter date");
					alert1.showAndWait();
					return;
				}

				else {
					LocalDate loc = d1.getValue();
					if(loc==null)
					{
						Alert alert1 = new Alert(AlertType.ERROR);
						alert1.setTitle("");
						alert1.setHeaderText(null);
						alert1.setContentText("The date is not exist");
						alert1.showAndWait();
						return;
					}
					Date_Record dd = new Date_Record(loc);
					
					
					Date_Record d = date.delet(dd);
					if (d == null) {
						Alert alert1 = new Alert(AlertType.ERROR);
						alert1.setHeaderText(null);
						alert1.setContentText("The date is not exist");
						alert1.showAndWait();
						return;

					}
					
					if(!table1.getItems().isEmpty())
					{
						table1.getItems().clear();
						date.print(table1);
					}
					d1.setValue(null);
					if (d.getDate().equals(date.getNegative().getDate())) {
						Date_Record d2 = date.getQueue().dequeue();

						if (date.getQueue().getfront() == null) {
							date.prev();
						}
						date.setNegative(date.getQueue().getfront());
						
						
						try {
							nameof.setText("Date :" + date.getNegative().getDate());
							displ2.setText("Total number of martyr =" + date.total());
							displ1.setText("Avrege the age =" + date.avg());
							displ3.setText("Name of Daistict =" + date.district());
							displ4.setText("Name of location =" + date.Location());
						}catch (Exception e2) {
							displ2.setText("Total number of martyr =" + "");
							displ1.setText("Avrege the age =" + 0);
							displ3.setText("Name of Daistict =" + "");
							displ4.setText("Name of location =" + "");	
						}
						Alert alert1 = new Alert(AlertType.INFORMATION);
						alert1.setTitle("");
						alert1.setHeaderText("the Date is alredy axist");
						alert1.setContentText("The operation succeeded");
						alert1.showAndWait();
						return;
					}
					date.setQueue(new Queue<>());
					date.setStack(new Stack_Linked_list<>());
					date.abload();
					date.fromto();
					try {
						nameof.setText("Date :" + date.getNegative().getDate());
						displ2.setText("Total number of martyr =" + date.total());
						displ1.setText("Avrege the age =" + date.avg());
						displ3.setText("Name of Daistict =" + date.district());
						displ4.setText("Name of location =" + date.Location());
					}catch (Exception e2) {
						displ2.setText("Total number of martyr =" + "");
						displ1.setText("Avrege the age =" + 0);
						displ3.setText("Name of Daistict =" + "");
						displ4.setText("Name of location =" + "");	
					}
					Alert alert1 = new Alert(AlertType.INFORMATION);
					alert1.setTitle("");
					alert1.setHeaderText("the Date is alredy axist");
					alert1.setContentText("The operation succeeded");
					alert1.showAndWait();
				}
			});
			enter.setOnAction(r -> {
				   avl = date.getNegative().getMartyr();
			});

			ubdat.setOnAction(r -> {

				DatePicker dd = new DatePicker();

				Label lable = new Label("insert the new Date");
				HBox hh = new HBox();

				hh.getChildren().addAll(lable, dd);
				hh.setSpacing(20);
				hh.setAlignment(Pos.CENTER);

				Button done = new Button("done");
				VBox vv = new VBox();
				vv.getChildren().addAll(hh, done);
				vv.setSpacing(20);
				vv.setAlignment(Pos.CENTER);
				done.setOnAction(t -> {

					LocalDate loc = dd.getValue();
					
					if(loc==null)
					{
						alert.setHeaderText("choose any date");
						alert.show();
						return;
						
					}
					
                      if(loc.compareTo(date.getNegative().getDate())==0)
                      {
                    	  primaryStage.setScene(s1);
                    	  return;
                    	  
                    	  
                      }
					
					
					if (dd.getValue() == null) {
						Alert alert1 = new Alert(AlertType.ERROR);
					
						alert1.setHeaderText(null);
						alert1.setContentText("Please enter date");
						alert1.showAndWait();
						return;

					}
					Date_Record dat = new Date_Record(loc);

					if (Date.find(dat) != null) {
						Alert alert1 = new Alert(AlertType.ERROR);
						alert1.setTitle("Wrong password");
						alert1.setHeaderText(null);
						alert1.setContentText("the Date is alredy axist");
						alert1.showAndWait();
						d1.setValue(null);
						return;
					}
					dat.setMartyr(date.getNegative().getMartyr());
				Date_Record t1=	date.delet(date.getNegative());
				date.date.insert(dat);
				if(t1==date.getNegative())
				{
					
					Date_Record d2 = date.getQueue().dequeue();
					if (date.getQueue().getfront() == null) {
						date.prev();
					}
					
					
					
					
					date.setNegative(date.getQueue().getfront());
					date.setQueue(new Queue<>());
					date.setStack(new Stack_Linked_list<>());
					date.abload();
					date.fromto();
					
					
					
					
					
					try {
						nameof.setText("Date :" + date.getNegative().getDate());
						displ2.setText("Total number of martyr =" + date.total());
						displ1.setText("Avrege the age =" + date.avg());
						displ3.setText("Name of Daistict =" + date.district());
						displ4.setText("Name of location =" + date.Location());
					}catch (Exception e1) {
						displ2.setText("Total number of martyr =" + "");
						displ1.setText("Avrege the age =" + 0);
						displ3.setText("Name of Daistict =" + "");
						displ4.setText("Name of location =" + "");	
					}
					
					Alert alert1 = new Alert(AlertType.INFORMATION);
					alert1.setTitle("");
					alert1.setHeaderText("the Date is alredy axist");
					alert1.setContentText("The operation succeeded");
					alert1.showAndWait();
					primaryStage.setScene(s1);
					date.setDate(Date);
					
					return;
				}
	
				

				});

				Scene fed = new Scene(vv, 800, 800);
				primaryStage.setScene(fed);

			});
			TableColumn<String, String> nameColumn = new TableColumn<>("date");

			TableColumn<String, String> column = new TableColumn<>("Date");
			column.setCellValueFactory(data -> javafx.beans.binding.Bindings.concat(data.getValue()));

			table1.setMaxWidth(300);
			column.setPrefWidth(300);
			porderPane.setBottom(table1);
			table1.getColumns().add(column);
			porderPane.setAlignment(table1, Pos.CENTER);
			print.setOnAction(e1 -> {

				

				date.print(table1);

			});
Printwhith.setOnAction(e1 -> {
				

				date.print_Empty(table1);

			});
		});
		b2.setOnAction(e -> {

			Martyr_Scene mar = new Martyr_Scene();
			mar.setM1(avl);

			GridPane grid = new GridPane();
			grid.setPadding(new Insets(20));
			grid.setHgap(10);
			grid.setVgap(10);

			Label nameLabel = new Label("Name:");
			TextField nameField = new TextField();
			nameField.setPromptText("Enter name");

			Label ageLabel = new Label("Age:");
			ComboBox<Integer> ageComboBox = new ComboBox<>();
			for (int i = 0; i < 120; i++) {
				ageComboBox.getItems().add(i);
			}
			ageComboBox.setPromptText("Select age");
			ageComboBox.setValue(10);
			Label dis = new Label("Choose any District");
			ComboBox<String> DistrictComoBox = new ComboBox<>();
			DistrictComoBox.setPromptText("Select District");

			Label loc = new Label("Choose any Location");
			ComboBox<String> testloc = new ComboBox<>();
			testloc.setPromptText("Select location");

			DistrictComoBox.setOnAction(e2 -> {

				loc(testloc, DistrictComoBox.getValue());
				testloc.setValue(DistrictComoBox.getValue());
			});

			Label genderLabel = new Label("Gender:");
			ToggleGroup genderToggleGroup = new ToggleGroup();
			RadioButton maleRadioButton = new RadioButton("Male");
			maleRadioButton.setToggleGroup(genderToggleGroup);
			RadioButton femaleRadioButton = new RadioButton("Female");
			femaleRadioButton.setToggleGroup(genderToggleGroup);
			HBox genderBox = new HBox(10, maleRadioButton, femaleRadioButton);
			maleRadioButton.setSelected(true);
			Label districtLabel = new Label("District:");
			grid.addColumn(0, nameLabel, ageLabel, dis, loc, genderLabel);
			grid.addColumn(1, nameField, ageComboBox, DistrictComoBox, testloc, genderBox);
			dist(DistrictComoBox);
			VBox v1 = new VBox();
			v1.setSpacing(10);
			
			
			HBox root = new HBox();
			imag.setFitHeight(20);
			imag.setFitWidth(20);
			Button insert = new Button("insert a new Martyr", imag);
			insert.setPrefWidth(180);
			insert.setPrefHeight(40);
			insert.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");
			VBox pane = new VBox();
			pane.setSpacing(20);
			Label l1 = new Label("The size :" + mar.size());
			l1.setFont(new Font(20));
			Label l2 = new Label("The Haigth :" + mar.heigth());
			l2.setFont(new Font(20));

			root.setAlignment(Pos.CENTER);
			pane.setAlignment(Pos.CENTER);
			ImageView neg = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\neg.png");
			neg.setFitHeight(20);
			neg.setFitWidth(20);
			
			
			
			Button delet = new Button("Delet Martyr", neg);
			delet.setPrefWidth(180);
			delet.setPrefHeight(40);
			delet.setStyle("-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");
            ComboBox<String> nenw=new ComboBox<>();
			mar.abload_name(nenw);
			HBox h1=new HBox();
			h1.getChildren().addAll(new Label("                    "),delet,nenw);
			h1.setSpacing(10);
			h1.setAlignment(Pos.CENTER);
			
			ImageView ubd = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\ubp.png");
			ubd.setFitHeight(20);
			ubd.setFitWidth(20);
			Button ubdat = new Button("Ubdate the Martyr", ubd);
			ubdat.setPrefWidth(180);
			ubdat.setPrefHeight(40);
			ubdat.setStyle("-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");

			ImageView ent = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\enter.jpeg");
			ent.setFitHeight(20);
			ent.setFitWidth(20);
			Button enter = new Button("Ptint level-by-level ", ent);
			enter.setPrefWidth(180);
			enter.setPrefHeight(40);
			enter.setStyle("-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");
			grid.setAlignment(Pos.CENTER);
			Button sort=new Button("Sort by name");
			sort.setPrefWidth(180);
			sort.setPrefHeight(40);
			sort.setStyle("-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");
			TableView<Martyr> table1 = new TableView<>();
			TableColumn<Martyr, String> name = new TableColumn<>("name");
			name.setCellValueFactory(new PropertyValueFactory<>("name"));
			name.setPrefWidth(200);
			TableColumn<Martyr, Integer> age = new TableColumn<>("age");
			age.setCellValueFactory(new PropertyValueFactory<>("age"));
			age.setPrefWidth(70);
			TableColumn<Martyr, Character> Gender = new TableColumn<>("Gender");
			Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
			Gender.setPrefWidth(70);
			TableColumn<Martyr, String> District = new TableColumn<>("District");
			District.setCellValueFactory(new PropertyValueFactory<>("District"));
			District.setPrefWidth(100);
			TableColumn<Martyr, String> Location = new TableColumn<>("Location");
			Location.setCellValueFactory(new PropertyValueFactory<>("Location"));
			Location.setPrefWidth(100);
			table1.getColumns().addAll(name, age, Gender, District, Location);
			table1.setMaxWidth(540);
			
			
			
			pane.getChildren().addAll(l1, l2, grid, insert, h1, enter,sort);
			BorderPane porderPane = new BorderPane();
			porderPane.setCenter(pane);

			Button back = new Button("Back");
			porderPane.setTop(back);
			porderPane.setAlignment(back, Pos.CENTER);
			back.setOnAction(e1 -> {
				primaryStage.setScene(choose);
			});

			porderPane.setStyle(
					"-fx-background-color: #E0E0E0; -fx-text-fill: black; -fx-border-color: transparent; -fx-border-radius: 50; -fx-background-radius: 50; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");

			Scene d1 = new Scene(porderPane, 800, 800);
			primaryStage.setScene(d1);

			
			pane.getChildren().add(table1);
			enter.setOnAction(er->
			{
				
				
				
			mar.name(table1);

				
			});
			insert.setOnAction(e1 -> {

				if (nameField.getText() == "" || ageComboBox.getValue() == null || DistrictComoBox.getValue() == null|| testloc.getValue() == null) {
					Alert alert1 = new Alert(AlertType.ERROR);
					alert1.setTitle("Wrong password");
					alert1.setHeaderText(null);
					alert1.setContentText("Please enter data valid");
					alert1.showAndWait();
					return;

				}

				Martyr m1 = new Martyr();
				m1.setName(nameField.getText());
				m1.setAge(ageComboBox.getValue());
				m1.setDistrict(DistrictComoBox.getValue());
				m1.setLocation(testloc.getValue());
				if (maleRadioButton.isSelected()) {
					m1.setGender('m');
				} else {
					m1.setGender('f');
				}
			
				
				mar.getM1().insert(m1);
				l1.setText("The size :" + mar.size());
				l2.setText("The Haigth :" + mar.heigth());
				nameField.setText("");
				ageComboBox.setValue(10);
				DistrictComoBox.setValue(null);
				testloc.setValue(null);
				mar.name(table1);
				mar.abload_name(nenw);
				
			});
			delet.setOnAction(e1 -> {
				if (nenw.getValue() == null|| mar.delet(	nenw.getValue().trim()) == null) {
					Alert alert1 = new Alert(AlertType.ERROR);
					alert1.setTitle("Wrong password");
					alert1.setHeaderText(null);
					alert1.setContentText("Please enter data valid");
					alert1.showAndWait();
					return;

				}
				l1.setText("The size :" + mar.size());
				l2.setText("The Haigth :" + mar.heigth());
				nameField.setText("");
				ageComboBox.setValue(10);
				DistrictComoBox.setValue(null);
				testloc.setValue(null);
				mar.name(table1);
				mar.abload_name(nenw);
				
			});
			
			 sort.setOnAction(M->
			 {
				mar.marter(table1);
				 
			 });

			
			
			table1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
				if (newValue != null) {
					TextField t1 = new TextField(newValue.getName());
					ComboBox<Integer> age1 = new ComboBox<>();
					for (int i = 0; i < 120; i++) {
						age1.getItems().add(i);
					}
					age1.setValue(newValue.getAge());
					RadioButton r1 = new RadioButton("M");
					RadioButton r2 = new RadioButton("F");
					ToggleGroup tog = new ToggleGroup();
					r1.setToggleGroup(tog);
					r2.setToggleGroup(tog);
					if (newValue.getGender() == 'm')
						r1.setSelected(true);
					else {
						r2.setSelected(true);
					}
					Button done = new Button("Ubdate");
					ComboBox<String> DistrictComoBox1 = new ComboBox<>();
					DistrictComoBox1.setPromptText("Select District");
					DistrictComoBox1.setValue(newValue.getDistrict());

					dist(DistrictComoBox1);
					ComboBox<String> location = new ComboBox<>();

					location.setPromptText("Select Location");
					location.setValue(newValue.getLocation());

					loc(location, DistrictComoBox1.getValue());
					GridPane gg = new GridPane();
					gg.add(new Label("the name"), 0, 0);
					gg.add(t1, 1, 0);
					gg.add(new Label("The Gender"), 0, 4);
					gg.add(r1, 1, 4);
					gg.add(r2, 2, 4);
					gg.add(new Label("The age"), 0, 1);
					gg.add(age1, 1, 1);
					gg.add(new Label("Distroct"), 0, 2);
					gg.add(DistrictComoBox1, 1, 2);

					gg.add(new Label("Location"), 0, 3);
					gg.add(location, 1, 3);
					gg.setAlignment(Pos.CENTER);
					gg.setHgap(20);
					gg.setVgap(20);
					VBox vv = new VBox();
					vv.getChildren().addAll(gg, done);
					vv.setSpacing(20);
					vv.setAlignment(Pos.CENTER);
					Scene ss = new Scene(vv, 800, 800);
					primaryStage.setScene(ss);

					DistrictComoBox1.setOnAction(M -> {
						loc(location, DistrictComoBox1.getValue());
						location.setValue(DistrictComoBox1.getValue());
					});
					done.setOnAction(r -> {
						if (t1.getText() == "") {
							Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
							alert2.setTitle("Information Dialog");
							alert2.setHeaderText("please enter valid data ");

							alert2.show();
							return;
						}

						newValue.setAge(age1.getValue());
						newValue.setLocation(location.getValue());
						if (r1.isSelected()) {
							newValue.setGender(r1.getText().charAt(0));
						} else {
							newValue.setGender(r2.getText().charAt(0));
						}



						if (DistrictComoBox1.getValue() != null) {
							if (newValue.getDistrict().toLowerCase()
									.compareTo(DistrictComoBox1.getValue().toLowerCase().trim()) != 0
									|| newValue.getName().toLowerCase()
											.compareTo(t1.getText().toLowerCase().trim()) != 0) {


								Martyr m1 = new Martyr();

								m1.setName(t1.getText().trim());

								m1.setAge(age1.getValue());
								m1.setName(t1.getText().trim());
								m1.setDistrict(DistrictComoBox1.getValue());
								m1.setLocation(location.getValue());
								if (r1.isSelected()) {
									m1.setGender(r1.getText().toLowerCase().charAt(0));
								} else {
									System.out.println(r2.getText().toLowerCase().charAt(0));
									m1.setGender(r2.getText().toLowerCase().charAt(0));
								}

								mar.delet(newValue.getName());

								avl.insert(m1);

							}
							
//							Martyr m1 = new Martyr();
//							m1.setAge(age1.getValue());
//							m1.setName(t1.getText().trim());
//							if (r1.isSelected()) {
//								m1.setGender(r1.getText().toLowerCase().charAt(0));
//							} else {
//								System.out.println(r2.getText().toLowerCase().charAt(0));
//								m1.setGender(r2.getText().toLowerCase().charAt(0));
//							}
//							mar.delet(newValue.getName());
//							avl.insert(m1);
						} else {
							newValue.setName(t1.getText().trim());
						}

						table1.getItems().clear();
						mar.name(table1);
						mar.abload_name(nenw);
						primaryStage.setScene(d1);
					});

				}
			});

		});
		b3.setOnAction(e -> {

			try {
				File f1 = new File("copyfile");
				PrintWriter p1 = new PrintWriter(f1);

				p1.write("Name,Date,Age,location,District,Gender");
				print(p1);
				p1.close();

				Alert alert1 = new Alert(AlertType.INFORMATION);
				alert1.setTitle("");
				alert1.setHeaderText("the Date is alredy axist");
				alert1.setContentText("The operation succeeded");
				alert1.showAndWait();
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		});
		choose = new Scene(v2, 800, 800);
		primaryStage.setScene(choose);
		return v2;

	}

	public void dist(ComboBox<String> n1) {
		n1.getItems().clear();
		for (int i = 0; i < dis.size(); i++) {
			n1.getItems().add(dis.get(i).name);

		}

	}

	public void loc(ComboBox<String> n1, String name) {
//	if(name==null)
//	{
//		
//		Alert al=new Alert(AlertType.ERROR);
//		al.setHeaderText("insert District");
//				al.show();
//		return;
//	}
try {
	
	
	n1.getItems().clear();
	for (int i = 0; i < dis.size(); i++) {
		if (dis.get(i).name.toLowerCase().trim().compareTo(name.toLowerCase().trim()) == 0) {

			for (int j = 0; j < dis.get(i).locaion.size(); j++) {
				n1.getItems().add(dis.get(i).locaion.get(j));
			}
			return;

		}

	}

	
	
	
	
	
	
}catch (Exception e) {
	
	}
		
	}

	public void print(PrintWriter p1) {
		Queue<Date_Record> d1 = Date.traverce();

		while (d1.getfront() != null) {	
			String date = d1.getfront().getDate().toString();
			try {
				
				Queue<Martyr> m1 = d1.getfront().getMartyr().levelOrderTraversal();	
				while (!m1.isEmpty()) {
					String name = m1.getfront().getName();
					int age = m1.getfront().getAge();
					String Distric = m1.getfront().getDistrict();
					String location = m1.getfront().getLocation();
					char gender = m1.getfront().getGender();

					p1.write("\n" + name + "," + date + "," + age + "," + location + "," + Distric + "," + gender);

					m1.dequeue();

				}


			}catch (Exception e) {
				// TODO: handle exception
			}
			d1.dequeue();
			
		}

	}
	
	
	
	
	

	
	

	public static void main(String[] args) {
		launch(args);
	}

}
