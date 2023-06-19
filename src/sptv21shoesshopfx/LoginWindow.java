package sptv21shoesshopfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// Импорт класса MenuWindow
import sptv21shoesshopfx.MenuWindow;

public class LoginWindow extends Application {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    private Stage primaryStage;
    private Stage welcomeStage;
    private MenuWindow menuWindow;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Вход");

        // Создание компонентов
        Label usernameLabel = new Label("Логин:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Пароль:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Вход");
        Label errorLabel = new Label();
        errorLabel.setFont(Font.font(18));
        errorLabel.setTextFill(Color.RED);

        // Увеличение размера текста
        usernameLabel.setFont(Font.font(18));
        usernameField.setFont(Font.font(18));
        passwordLabel.setFont(Font.font(18));
        passwordField.setFont(Font.font(18));
        loginButton.setFont(Font.font(18));

        // Создание сетки и настройка размещения компонентов
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 1, 2);
        gridPane.add(errorLabel, 0, 3, 2, 1);

        // Создание контейнера для центрирования сетки
        VBox container = new VBox(gridPane);
        container.setAlignment(Pos.CENTER);

        // Настройка размеров окна
        double windowWidth = 330;
        double windowHeight = 260;

        // Создание сцены
        Scene scene = new Scene(container, windowWidth, windowHeight);

        // Настройка действия при нажатии кнопки Вход
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Проверка логина и пароля
            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                System.out.println("Успешный вход!");

                // Закрываем окно входа
                primaryStage.close();

                // Открываем новое окно меню
                openMenuWindow();
            } else {
                System.out.println("Неправильный логин или пароль!");
                errorLabel.setText("Неправильный логин или пароль!");
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Метод для открытия окна меню
    private void openMenuWindow() {
        menuWindow = new MenuWindow();
        menuWindow.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
