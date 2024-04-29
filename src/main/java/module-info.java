module com.example.project4lists {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project4lists to javafx.fxml;
    exports com.example.project4lists;
}