module com.example.memoryproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.memoryproject to javafx.fxml;
    exports com.example.memoryproject;
}