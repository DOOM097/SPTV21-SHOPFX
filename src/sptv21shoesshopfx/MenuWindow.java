package sptv21shoesshopfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuWindow extends Stage {

    public MenuWindow() {
        setTitle("Меню");
        double buttonWidth = 300;
        double buttonHeight = 50;
        double smallerButtonWidth = buttonWidth / 1.5;
        double smallerButtonHeight = buttonHeight / 1.5;
        
        // Создание кнопок в стиле Button dropdown
        SplitMenuButton menuButton1 = createSplitMenuButton("Роли", "Добавить роль", "Изменить роль");
        SplitMenuButton menuButton2 = createSplitMenuButton("Добавть обувь");
        SplitMenuButton menuButton3 = createSplitMenuButton("Купить обувь");
        SplitMenuButton menuButton4 = createSplitMenuButton("Прибыль");
        SplitMenuButton menuButton5 = createSplitMenuButton("Users", "Добавить user", "Изменить user");
        SplitMenuButton menuButton6 = createSplitMenuButton("Регистрация", "регистрация нового user");
        Button exitButton = new Button("Выход");
        exitButton.setPrefSize(smallerButtonWidth, smallerButtonHeight);
        exitButton.setFont(Font.font(18));
        exitButton.setOnAction(event -> {
            close(); // Закрываем окно меню при нажатии на кнопку "Выход"
        });
        
        // Создание метки с сообщением "Добро пожаловать в магазин!"
        Label welcomeLabel = new Label("Добро пожаловать в магазин!");
        welcomeLabel.setFont(Font.font(18));

        // Настройка размеров и стилей кнопок
        menuButton1.setPrefSize(buttonWidth, buttonHeight);
        menuButton2.setPrefSize(buttonWidth, buttonHeight);
        menuButton3.setPrefSize(buttonWidth, buttonHeight);
        menuButton4.setPrefSize(buttonWidth, buttonHeight);
        menuButton5.setPrefSize(buttonWidth, buttonHeight);
        menuButton6.setPrefSize(buttonWidth, buttonHeight);

        menuButton1.setFont(Font.font(18));
        menuButton2.setFont(Font.font(18));
        menuButton3.setFont(Font.font(18));
        menuButton4.setFont(Font.font(18));
        menuButton5.setFont(Font.font(18));
        menuButton6.setFont(Font.font(18));

        // Создание контейнера VBox
        VBox container = new VBox(10); // Расстояние между строками: 10
        container.setPadding(new Insets(10));
        container.setAlignment(Pos.TOP_RIGHT);
        container.getChildren().addAll(createWelcomeBox(welcomeLabel), createButtonsRow(menuButton1, menuButton2, menuButton3, menuButton4, menuButton5, menuButton6), exitButton);

        // Настройка размеров окна меню
        double windowWidth = 1710;
        double windowHeight = 900;

        // Создание сцены меню
        Scene scene = new Scene(container, windowWidth, windowHeight);

        setScene(scene);
    }

    private HBox createButtonsRow(SplitMenuButton... buttons) {
        HBox buttonsRow = new HBox(10); // Расстояние между кнопками: 10
        buttonsRow.setAlignment(Pos.TOP_LEFT);
        buttonsRow.getChildren().addAll(buttons);
        return buttonsRow;
    }

    private VBox createWelcomeBox(Label welcomeLabel) {
        VBox welcomeBox = new VBox(10); // Расстояние между элементами: 10
        welcomeBox.setAlignment(Pos.TOP_CENTER);
        welcomeBox.getChildren().add(welcomeLabel);
        return welcomeBox;
    }

    private SplitMenuButton createSplitMenuButton(String text, String... items) {
        SplitMenuButton splitMenuButton = new SplitMenuButton();
        splitMenuButton.setText(text);

        for (String item : items) {
            MenuItem menuItem = new MenuItem(item);
            splitMenuButton.getItems().add(menuItem);
        }

        return splitMenuButton;
    }
}
