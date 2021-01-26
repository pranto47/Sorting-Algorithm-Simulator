package sortingalgorithmsimulator;

//import java.awt.Color;
import java.util.Random;
import javafx.scene.paint.*;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Bubble_Sort {

    Scene scene;
    Rectangle[] rect = new Rectangle[12];
    Rectangle r = new Rectangle(600, 450, 390, 240);
    double[] x = new double[12];
    Rectangle rectangle = new Rectangle(50, 650, 300, 10);
    Rectangle r_move = new Rectangle(50, 645, 20, 20);
    int[] position_new = new int[12];
    Text[] text = new Text[12];
    Text[] statement = new Text[5];
    int[] height = new int[12];
    int[] posY = new int[12];
    int length;
    int pos = 0;
    boolean back = true;
    int decrease = 0;
    int con = 0;
    int cycle = 0;
    int change = 0;
    double dx = 0;
    double dy = 5;
    double dxc = 0;
    boolean ok = true;
    boolean start_sort = false;
    boolean end_sort = false;
    long limit = 168000000;

    public void updaterectangle(long time) {
        double cx = rect[position_new[pos]].getX();
        double cy = rect[position_new[pos]].getY();
        double cx1 = rect[position_new[pos + 1]].getX();
        double cy1 = rect[position_new[pos + 1]].getY();

        double cxt = text[position_new[pos]].getTranslateX();
        double cyt = text[position_new[pos]].getTranslateY();
        double cxt1 = text[position_new[pos + 1]].getTranslateX();
        double cyt1 = text[position_new[pos + 1]].getTranslateY();

        double height1 = rect[position_new[pos]].getY() + rect[position_new[pos]].getHeight();
        if ((end_sort == false) && (start_sort) && (ok) && (height1 == 400) && (rect[position_new[pos]].getHeight() > rect[position_new[pos + 1]].getHeight()) && (rect[position_new[pos]].getX() != x[cycle + 1])) {
            statement[2].setText(height[position_new[pos]] + " > " + height[position_new[pos + 1]] + " is true");
            statement[2].setFill(Color.WHITE);
            statement[3].setText("swap " + height[position_new[pos]] + " and " + height[position_new[pos + 1]]);
            statement[3].setFill(Color.WHITE);
            rect[position_new[pos]].setX(cx - dx);
            rect[position_new[pos]].setY(cy + dy);
            rect[position_new[pos + 1]].setX(cx1 + dx);
            rect[position_new[pos + 1]].setY(cy1 + dy);

            text[position_new[pos]].setTranslateX(cxt - dx);
            text[position_new[pos]].setTranslateY(cyt + dy);
            text[position_new[pos + 1]].setTranslateX(cxt1 + dx);
            text[position_new[pos + 1]].setTranslateY(cyt1 + dy);
        } else if ((start_sort) && (end_sort == false)) {
            if (pos == 0) {
                statement[4].setFill(Color.WHITE);
            } else {
                statement[4].setFill(Color.BLUE);
            }
            statement[2].setFill(Color.BLUE);
            statement[3].setFill(Color.BLUE);
            if ((rect[position_new[pos]].getHeight() > rect[position_new[pos + 1]].getHeight())) {
                statement[2].setText(height[position_new[pos]] + " > " + height[position_new[pos + 1]] + " is true");
                statement[2].setFill(Color.WHITE);
            } else {
                statement[2].setText(height[position_new[pos]] + " > " + height[position_new[pos + 1]] + " is false");
                statement[2].setFill(Color.WHITE);
            }
            rect[position_new[pos]].setX(cx + dx);
            rect[position_new[pos]].setY(cy + dy);
            rect[position_new[pos + 1]].setX(cx1 + dx);
            rect[position_new[pos + 1]].setY(cy1 + dy);

            text[position_new[pos]].setTranslateX(cxt + dx);
            text[position_new[pos]].setTranslateY(cyt + dy);
            text[position_new[pos + 1]].setTranslateX(cxt1 + dx);
            text[position_new[pos + 1]].setTranslateY(cyt1 + dy);
        }

    }

    public void start() {
        Stage primaryStage=new Stage();
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: cadetblue;");
        Button button = new Button("Start");
        button.setLayoutX(50);
        button.setLayoutY(450);
        button.setPrefSize(200, 20);
        button.setStyle("-fx-font: 22 arial; -fx-base:  #a6b5c9;");

        Button buttonpause = new Button("Pause");
        buttonpause.setLayoutX(50);
        buttonpause.setLayoutY(500);
        buttonpause.setPrefSize(200, 20);
        buttonpause.setStyle("-fx-font: 22 arial; -fx-base: #a6b5c9;");

        Button buttonclose = new Button("Close");
        buttonclose.setLayoutX(50);
        buttonclose.setLayoutY(550);
        buttonclose.setPrefSize(200, 20);
        buttonclose.setStyle("-fx-font: 22 arial; -fx-base: #a6b5c9;");

        buttonclose.setOnAction((ActionEvent ae) -> {
            primaryStage.close();
        });

        rectangle.setOnMousePressed((MouseEvent e) -> {
            double differ = (int) (e.getX() - 50);
            r_move.setX(e.getX() - 10);
            if (differ <= 30) {
                limit = 168000000;
            } else if (differ <= 60) {
                limit = 140000000;
            } else if (differ <= 90) {
                limit = 112000000;
            } else if (differ <= 120) {
                limit = 84000000;
            } else if (differ <= 150) {
                limit = 70000000;
            } else if (differ <= 180) {
                limit = 56000000;
            } else if (differ <= 210) {
                limit = 42000000;
            } else if (differ <= 240) {
                limit = 28000000;
            } else if (differ <= 270) {
                limit = 14000000;
            } else {
                limit = 0;
            }
        });


        length = rect.length;
        Random random = new Random();
        int n;
        int s;
        for (int i = 0; i < 12; i++) {
            position_new[i] = i;
            x[i] = 200 + i * 50;
        }
        for (int i = 0; i < length; i++) {
            n = random.nextInt();
            s = (n >= 0 ? (n % 150) : -(n % 150));
            s = (s == 0 ? 10 : s);
            height[i] = s;
            posY[i] = (300 - height[i]);
            text[i] = new Text(x[i], 320, Integer.toString(s));
            text[i].setFill(Color.BLUE);
            text[i].setFont(Font.font("Verdana", 15));
        }
        for (int i = 0; i < 12; i++) {
            position_new[i] = i;
            x[i] = 200 + i * 50;
        }
        for (int i = 0; i < length; i++) {
            rect[i] = new Rectangle(x[i], posY[i], 30, height[i]);
            rect[i].setFill(Color.CYAN);
        }

        AnimationTimer timer;
        timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= limit) {
                    double height1 = 0;
                    button.setOnAction((ActionEvent ae) -> {
                        start_sort = true;
                    });

                    buttonpause.setOnAction((ActionEvent ae) -> {
                        start_sort = false;
                    });

                    height1 = rect[position_new[pos]].getY() + rect[position_new[pos]].getHeight();

                    if ((start_sort) && (ok) && (height1 == 300) && (change == 1)) {
                        if (rect[position_new[pos]].getHeight() <= rect[position_new[pos + 1]].getHeight()) {
                            back = true;
                        } else {
                            con = position_new[pos];
                            position_new[pos] = position_new[pos + 1];
                            position_new[pos + 1] = con;
                        }

                        if (cycle == ((length - 2) - decrease)) {
                            rect[position_new[pos + 1]].setFill(Color.BLUE);
                            back = true;
                            cycle = 0;
                            pos = 0;
                            change = 0;
                            decrease++;
                        } else {
                            pos++;
                            dy = 5;
                            dx = 0;
                            change = 0;
                            cycle++;
                        }
                        if (decrease == (length - 1)) {
                            rect[position_new[pos]].setFill(Color.BLUE);
                            rect[position_new[pos + 1]].setFill(Color.BLUE);
                            back = false;
                            change = 0;
                            dx = 0;
                            dy = 0;
                            pos = 0;
                            decrease = 0;
                            ok = false;
                            end_sort = true;
                        }

                    }

                    if ((start_sort) && (ok) && (height1 < 400) && (rect[position_new[pos]].getX() == x[cycle]) && (back)) {
                        dy = 5;
                        dx = 0;
                        change = 1;
                    } else if ((start_sort) && (ok) && (height1 == 400) && (rect[position_new[pos]].getHeight() > rect[position_new[pos + 1]].getHeight()) && (rect[position_new[pos]].getX() != x[cycle + 1])) {
                        dx = -5;
                        dy = 0;
                        change = 1;
                        statement[2].setFill(Color.BLUE);
                        back = false;
                    } else if ((start_sort) && (ok) && (height1 == 400) && (rect[position_new[pos]].getHeight() <= rect[position_new[pos + 1]].getHeight())) {
                        dy = -5;
                        dx = 0;
                        statement[2].setFill(Color.BLUE);
                        back = false;
                        change = 1;
                    } else if ((start_sort) && (ok) && (rect[position_new[pos]].getHeight() <= rect[position_new[pos + 1]].getHeight()) && (height1 > 300) && (rect[position_new[pos]].getX() == x[cycle + 1])) {
                        dy = -5;
                        dx = 0;
                        change = 1;
                    } else if ((start_sort) && (ok) && (rect[position_new[pos]].getX() == x[cycle + 1])) {
                        dy = -5;
                        dx = 0;
                        change = 1;
                    }
                    lastUpdate = now;
                    updaterectangle(now);
                }
            }
        };
        System.out.println("start");
        timer.start();

        statement[0] = new Text(610, 480, "if leftElement > rightElement");
        statement[0].setFill(Color.WHITE);
        statement[0].setFont(Font.font("Verdana", 15));
        statement[1] = new Text(610, 530, "swap (leftElement , rightElement)");
        statement[1].setFill(Color.WHITE);
        statement[1].setFont(Font.font("Verdana", 15));
        statement[2] = new Text(610, 580, height[0] + " > " + height[1] + " is true");
        statement[2].setFill(Color.BLUE);
        statement[2].setFont(Font.font("Verdana", 15));
        statement[3] = new Text(610, 620, "swap " + height[0] + " and " + height[1]);
        statement[3].setFill(Color.BLUE);
        statement[3].setFont(Font.font("Verdana", 15));
        statement[4] = new Text(610, 670, "loop from 0 to noOfUnsortedElements-1 ");
        statement[4].setFill(Color.BLUE);
        statement[4].setFont(Font.font("Verdana", 15));

        r.setFill(Color.BLUE);
        r_move.setFill(Color.WHITE);
        rectangle.setFill(Color.WHITE);
        root.getChildren().addAll(text);
        root.getChildren().addAll(button);
        root.getChildren().addAll(buttonpause);
        root.getChildren().addAll(buttonclose);
        root.getChildren().addAll(rect);
        root.getChildren().addAll(r, rectangle, r_move);
        root.getChildren().addAll(statement);
        scene = new Scene(root, 1000, 700);

        primaryStage.setTitle("Bubble Sort");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
