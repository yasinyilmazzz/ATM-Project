module com.example.atmproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atmproject to javafx.fxml;
    exports com.example.atmproject;
}