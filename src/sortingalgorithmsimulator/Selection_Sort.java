package sortingalgorithmsimulator;

import static java.lang.System.exit;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Selection_Sort{

    Scene scene;
    Rectangle r=new Rectangle(600, 450, 390, 240);
    Rectangle[] rect = new Rectangle[12];
    Text []text=new Text[12];
    Text []statement=new Text[5];
    Text t;
    int[] posX = new int[12];
    int[] posY = new int[12];
    int[] height = {10, 80, 120, 40, 90, 70, 115, 10, 50, 60,34,23};
    int[] position = new int[12];
    int[] position_new = new int[12];
    int iterator1 = 0;
    int iterator2 = 0, count = 1;
    boolean change = false;
    boolean colorEffect = false;
    boolean ret = false;
    boolean firstelement=true;
    int cycle1 = 0, cycle2 = 0, c = 0, dx = 0, dy = 0;
    int point=0,tr=0;
    boolean start_sort=false;
    boolean end_sort=false;
    Rectangle rectangle = new Rectangle(50, 650, 300, 10);
    Rectangle r_move = new Rectangle(50, 645, 20, 20);
    long limit = 168000000;

    public void updaterectangle(long time) {
        if ((change == false)&&(start_sort)&&(end_sort==false)) {
            System.out.println("c=1");
            if ((iterator1+1) == (count)&&(point==iterator1)) {
                firstelement = false;
                rect[position[iterator1]].setFill(Color.RED);
                statement[1].setText("set "+height[iterator1]+" as new minimum value");
                statement[1].setFill(Color.WHITE);
                statement[4].setFill(Color.WHITE);
                cycle1++;
                if (cycle1 == 50) {
                    statement[4].setFill(Color.BLUE);
                    System.out.println("c=5");
                    cycle1 = 0;
                    firstelement=true;
                    statement[1].setFill(Color.BLUE);
                    point++;
                    System.out.println("iterator2=" + iterator2);
                }
            }
            rect[position[iterator2]].setFill(Color.RED);
            statement[0].setText("current minimum value "+height[position[iterator2]]);
            if(iterator1==11){
                rect[position[iterator2]].setFill(Color.GREENYELLOW);
                end_sort=true;
            }
            if(end_sort==false){
                statement[2].setText("check if "+height[count]+" is smaller than "+height[iterator2]);
                statement[2].setFill(Color.WHITE);
            }
            if ((firstelement)&&(height[position[iterator2]] > height[position[count]])&&(end_sort==false)) {
                statement[1].setText("set "+height[count]+" as new minimum value");
                statement[1].setFill(Color.WHITE);
                rect[position[iterator2]].setFill(Color.PLUM);
                
                iterator2 = count;
                rect[position[count]].setFill(Color.RED);
                statement[0].setText("current minimum value "+height[position[count]]);
                colorEffect = true;
                tr=1;
                System.out.println("c=2");
            } else if((firstelement)&&(end_sort==false)){
                statement[2].setText("check if "+height[count]+" is smaller than "+height[iterator2]);
                statement[2].setFill(Color.WHITE);
                colorEffect = true;
                tr=0;
                System.out.println("c=3");
            }
        }
        if ((colorEffect)&&(firstelement)&&(start_sort)&&(end_sort==false)) {
            rect[position[count]].setFill(Color.BLUE);
            cycle1++;
            
            System.out.println("c=4");
            if (cycle1 == 50) {
                if(tr==1){
                    statement[1].setFill(Color.BLUE);
                }
                tr = 0;
                System.out.println("c=5");
                colorEffect = false;
                cycle1 = 0;
                rect[position[count]].setFill(Color.PLUM);
                System.out.println("iterator2=" + iterator2);
                count++;
                if (count == 12) {
                    if ((iterator2 == (count - 1))) {
                        rect[position[count - 1]].setFill(Color.RED);
                    }
                    System.out.println("c=6");
                    change = true;
                    dy = 5;
                    dx = 0;
                }
            }
        }
        if ((change)&&(iterator1!=iterator2)&&(firstelement)&&(start_sort)&&(end_sort==false)) {
            System.out.println("c=21");
            statement[3].setText("swap minimum with first unsorted position");
            statement[3].setFill(Color.WHITE);
            statement[2].setFill(Color.BLUE);
            statement[1].setFill(Color.BLUE);
            
            double cx = rect[position[iterator1]].getX();
            double cy = rect[position[iterator1]].getY();
            double cx1 = rect[position[iterator2]].getX();
            double cy1 = rect[position[iterator2]].getY();
            
            double cxt = text[position[iterator1]].getTranslateX();
            double cyt = text[position[iterator1]].getTranslateY();
            double cxt1 = text[position[iterator2]].getTranslateX();
            double cyt1 = text[position[iterator2]].getTranslateY();
            
            if ((ret == false) && ((rect[position[iterator1]].getY()+height[position[iterator1]] )!= 400)) {
                rect[position[iterator1]].setX(cx + dx);
                rect[position[iterator1]].setY(cy + dy);
                rect[position[iterator2]].setX(cx1 + dx);
                rect[position[iterator2]].setY(cy1 + dy);
                
                text[position[iterator1]].setTranslateX(cxt + dx);
                text[position[iterator1]].setTranslateY(cyt + dy);
                text[position[iterator2]].setTranslateX(cxt1 + dx);
                text[position[iterator2]].setTranslateY(cyt1 + dy);
                
                System.out.println("c=21");
            } else if (((rect[position[iterator1]].getY()+height[position[iterator1]]) == 400)) {
                dx = 5;
                dy = 0;
                System.out.println("c=10");
                if ((ret == false) && (rect[position[iterator1]].getX() != posX[iterator2])) {
                    rect[position[iterator1]].setX(cx + dx);
                    rect[position[iterator1]].setY(cy + dy);
                    rect[position[iterator2]].setX(cx1 - dx);
                    rect[position[iterator2]].setY(cy1 + dy);
                    
                    text[position[iterator1]].setTranslateX(cxt + dx);
                    text[position[iterator1]].setTranslateY(cyt + dy);
                    text[position[iterator2]].setTranslateX(cxt1 - dx);
                    text[position[iterator2]].setTranslateY(cyt1 + dy);
                    
                    System.out.println("c=11");
                }
                if ((rect[position[iterator1]].getX() == posX[iterator2])) {
                    dx = 0;
                    dy = -5;
                    ret = true;
                    System.out.println("c=12");
                }

            }
            if (ret) {
                System.out.println("c=13");
                cx = rect[position[iterator1]].getX();
                cy = rect[position[iterator1]].getY();
                cx1 = rect[position[iterator2]].getX();
                cy1 = rect[position[iterator2]].getY();
                
                cxt = text[position[iterator1]].getTranslateX();
                cyt = text[position[iterator1]].getTranslateY();
                cxt1 = text[position[iterator2]].getTranslateX();
                cyt1 = text[position[iterator2]].getTranslateY();
                
                if ((rect[position[iterator1]].getY() != (300-height[position[iterator1]]))) {
                    System.out.println("c=14");
                    rect[position[iterator1]].setX(cx + dx);
                    rect[position[iterator1]].setY(cy + dy);
                    rect[position[iterator2]].setX(cx1 + dx);
                    rect[position[iterator2]].setY(cy1 + dy);
                    
                    text[position[iterator1]].setTranslateX(cxt + dx);
                    text[position[iterator1]].setTranslateY(cyt + dy);
                    text[position[iterator2]].setTranslateX(cxt1 + dx);
                    text[position[iterator2]].setTranslateY(cyt1 + dy);
                    
                } else if ((rect[position[iterator1]].getY() == (300-height[position[iterator1]]))) {
                    System.out.println("c=15");
                    rect[position[iterator2]].setFill(Color.GREENYELLOW);
                    int temp;
                    temp = position[iterator1];
                    position[iterator1] = position[iterator2];
                    position[iterator2] = temp;
                    iterator1++;
                    iterator2 = iterator1;
                    count = iterator2 + 1;
                    change = false;
                    statement[3].setFill(Color.BLUE);
                    ret=false;
                    for(int i=0;i<10;i++){
                        posX[i]=(int)rect[position[i]].getX();
                    }
                }
            }
        }
        else if ((change) && (iterator1 == iterator2)&&(firstelement)&&(start_sort)&&(end_sort==false)) {
            rect[position[iterator2]].setFill(Color.GREENYELLOW);
            iterator1++;
            iterator2 = iterator1;
            count = iterator2 + 1;
            change = false;
        }
    }

    public void start() {
        Stage primaryStage=new Stage();
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: cadetblue;");
        
        Button button=new Button("Start");
        button.setLayoutX(50);
        button.setLayoutY(450);
        button.setPrefSize(200, 20);
        button.setStyle("-fx-font: 22 arial; -fx-base:  #a6b5c9;");
        
        Button buttonpause=new Button("Pause");
        buttonpause.setLayoutX(50);
        buttonpause.setLayoutY(500);
        buttonpause.setPrefSize(200, 20);
        buttonpause.setStyle("-fx-font: 22 arial; -fx-base: #a6b5c9;");
        
        Button buttonclose=new Button("Close");
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

        for (int i = 0; i < 12; i++) {
            posX[i] = 200 + i * 50;
            position_new[i] = position[i] = i;
        }
        Random random=new Random();
        int n;
        int s;
        for(int i=0;i<12;i++){
            n=random.nextInt();
            s=(n>=0?(n%150):-(n%150));
            s=(s==0?10:s);
            height[i]=s;
            posY[i]=(300-height[i]);
            text[i]=new Text(posX[i], 320,Integer.toString(s));
            text[i].setFill(Color.BLUE);
            text[i].setFont(Font.font("Verdana", 15));
        }
        

//        rect[0] = new Rectangle(100, 220, 30, 80);
//        rect[1] = new Rectangle(150, 270, 30, 30);
//        rect[2] = new Rectangle(200, 180, 30, 120);
//        rect[3] = new Rectangle(250, 260, 30, 40);
//        rect[4] = new Rectangle(300, 220, 30, 80);
//        rect[5] = new Rectangle(350, 230, 30, 70);
//        rect[6] = new Rectangle(400, 185, 30, 115);
//        rect[7] = new Rectangle(450, 245, 30, 55);
//        rect[8] = new Rectangle(500, 250, 30, 50);
//        rect[9] = new Rectangle(550, 240, 30, 60);
//        rect[10] = new Rectangle(500, 245, 30, 55);
//        rect[11] = new Rectangle(550, 235, 30, 66);
        for (int i = 0; i < 12; i++) {
            rect[i]=new Rectangle(posX[i],posY[i],30,height[i]);
            rect[i].setFill(Color.PLUM);
        }
        
        statement[0]=new Text(610,480,"current minimum value "+height[0]);
        statement[0].setFill(Color.WHITE);
        statement[0].setFont(Font.font("Verdana", 15));
        statement[1]=new Text(610,530,"set "+height[1]+" as new minimum value");
        statement[1].setFill(Color.BLUE);
        statement[1].setFont(Font.font("Verdana", 15));
        statement[2]=new Text(610,580,"check if "+height[0]+" is smaller than  "+height[1]);
        statement[2].setFill(Color.BLUE);
        statement[2].setFont(Font.font("Verdana", 15));
        statement[3]=new Text(610,620,"swap minimum with first unsorted position");
        statement[3].setFill(Color.BLUE);
        statement[3].setFont(Font.font("Verdana", 15));
        statement[4]=new Text(610,670,"repeat the process noOfElements-1 times");
        statement[4].setFill(Color.BLUE);
        statement[4].setFont(Font.font("Verdana", 15));
//        t=new Text(610,460,"swap minimum with first unsorted position");
        
        AnimationTimer timer;
        timer = new AnimationTimer() {
            private long lastUpdate = 0;
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= limit) {
                    button.setOnAction((ActionEvent ae) -> {
                        start_sort = true;
                    });

                    buttonpause.setOnAction((ActionEvent ae) -> {
                        start_sort = false;
                    });
                    lastUpdate = now;
                    updaterectangle(now);
                }
            }
        };
        System.out.println("start");
        timer.start();
        
        r.setFill(Color.BLUE);
        r_move.setFill(Color.WHITE);
        rectangle.setFill(Color.WHITE);
        root.getChildren().addAll(text);
        root.getChildren().addAll(button,buttonpause,buttonclose);
        root.getChildren().addAll(r,r_move,rectangle);
        root.getChildren().addAll(rect);
        root.getChildren().addAll(statement);
        scene = new Scene(root, 1000, 700);

        primaryStage.setTitle("Selecton Sort");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
