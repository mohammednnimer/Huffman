module Project3 {
	
	
	requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    opens application to javafx.base;

    exports application;
}
