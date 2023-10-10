module com.example.memoryproject {
    requires javafx.graphics;


    opens com.example.memoryproject to javafx.fxml;
    exports com.example.memoryproject;
}