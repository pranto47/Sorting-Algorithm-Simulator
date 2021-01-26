

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

public class Insertion_Sort{
    
    Scene scene;
    Rectangle[] rect = new Rectangle[12];
    double []x=new double [12];
    Text []text=new Text[12];
    int []position_new=new int[12];
    int[] posX = new int[12];
    int[] posY = new int[12];
    Text []statement=new Text[5];
    Rectangle r=new Rectangle(600, 450, 390, 240);
    int [] height=new int [12];
    int[] position = new int[12];
    double dx = 0;
    double dy = 5;
    double cx,cy,cx1,cy1;
    int cycle=0;
    int x_change=0;
    Rectangle rectangle = new Rectangle(50, 650, 300, 10);
    Rectangle r_move = new Rectangle(50, 645, 20, 20);
    long limit = 168000000;
    
    boolean ret=false;
    boolean compare=false;
    boolean back=false;
    boolean color_effect=false;
    boolean first_move=true;
    boolean end_sort =false;///
    boolean start_sort=false;
    double cxt,cyt,cxt1,cyt1;
    
    int iterator=1,current_pos=1;
    int check_element=iterator-1;
    int c;

    public void updaterectangle(long time) {
        if((ret==false)&&(compare==false)&&(first_move)&&(end_sort==false)&&(start_sort)){
            System.out.println("c=0");
            statement[0].setFill(Color.WHITE);
            statement[4].setFill(Color.WHITE);
            rect[position[iterator]].setFill(Color.RED);
            cx = rect[position[iterator]].getX();
            cy = rect[position[iterator]].getY();
            cxt = text[position[iterator]].getTranslateX();
            cyt = text[position[iterator]].getTranslateY();
            dx=0;
            dy=5;
            if((rect[position[iterator]].getY()!=(400-height[position[iterator]]))){
                rect[position[iterator]].setX(cx+dx);
                rect[position[iterator]].setY(cy+dy);
                text[position[iterator]].setTranslateX(cxt+dx);
                text[position[iterator]].setTranslateY(cyt+dy);
                System.out.println("c=1");
            }
            if((rect[position[iterator]].getY()==(400-height[position[iterator]]))){
                System.out.println("c=2");
                statement[0].setFill(Color.BLUE);
                statement[4].setFill(Color.BLUE);
                compare=true;
                ret=true;
                check_element=iterator-1;
                color_effect=true;
                cycle=0;
                first_move=false;
            }
            current_pos=iterator;
            
        }
        if((ret) && (compare)&&(end_sort==false)&&(start_sort)) {
            System.out.println("c=3");
            if ((back == false) && (height[position[current_pos]] >= height[position[check_element]])) {
                statement[1].setText(height[position[check_element]]+">"+height[position[current_pos]]+" is false");
                statement[1].setFill(Color.WHITE);
                System.out.println("c=4");
                if (color_effect) {
                    rect[position[check_element]].setFill(Color.BLUE);
                    System.out.println("c=5");
                    cycle++;
                    System.out.println("c=4");
                    if (cycle == 50) {
                        System.out.println("c=5");
                        color_effect = false;
                        cycle = 0;
                        rect[position[check_element]].setFill(Color.PLUM);
                        System.out.println("iterator2=" + iterator);
                        back=true;
                        statement[1].setFill(Color.BLUE);
                        System.out.println("c=6");
                    }
                }
                dx=0;
                dy=-5;
            }
            else if((back==false)&&(height[position[current_pos]] < height[position[check_element]])){
                System.out.println("c=7");
                statement[1].setText(height[position[check_element]]+">"+height[position[current_pos]]+" is true");
                statement[1].setFill(Color.WHITE);
                if (color_effect) {
                    System.out.println("c=8");
                    rect[position[check_element]].setFill(Color.BLUE);
                    cycle++;
                    System.out.println("c=4");
                    if (cycle == 50) {
                        statement[1].setFill(Color.BLUE);
                        System.out.println("c=5");
                        color_effect = false;
                        cycle = 0;
                        rect[position[check_element]].setFill(Color.PLUM);
                        System.out.println("iterator2=" + iterator);
                        color_effect=false;
                        dx=2;
                        dy=0;
                        System.out.println("c=9");
                    }
                }
                if((color_effect==false)){
                    System.out.println("c=10");
                    statement[3].setFill(Color.WHITE);
                    cx = rect[position[current_pos]].getX();
                    cy = rect[position[current_pos]].getY();
                    cx1 = rect[position[check_element]].getX();
                    cy1 = rect[position[check_element]].getY();
                    
                    cxt = text[position[current_pos]].getTranslateX();
                    cyt = text[position[current_pos]].getTranslateY();
                    cxt1 = text[position[check_element]].getTranslateX();
                    cyt1 = text[position[check_element]].getTranslateY();

                    if ((x_change != 50)) {
                        System.out.println("c=11");
                        rect[position[current_pos]].setX(cx - dx);
                        rect[position[current_pos]].setY(cy + dy);
                        rect[position[check_element]].setX(cx1 + dx);
                        rect[position[check_element]].setY(cy1 + dy);

                        text[position[current_pos]].setTranslateX(cxt - dx);
                        text[position[current_pos]].setTranslateY(cyt + dy);
                        text[position[check_element]].setTranslateX(cxt1 + dx);
                        text[position[check_element]].setTranslateY(cyt1 + dy);

                        x_change+=dx;
                    }
                    if((x_change == 50)){
                        System.out.println("c=12");
                        statement[3].setFill(Color.BLUE);
                        int temp=position[current_pos];
                        position[current_pos]=position[check_element];
                        position[check_element]=temp;
                        current_pos--;
                        x_change=0;
                        for(int i:position){
                            System.out.println(i);
                        }
                        check_element=current_pos-1;
                        if(current_pos==0){
                            ret=true;
                            compare=true;
                            back=true;
                            color_effect=false;
                            dx=0;
                            dy=-5;
                            System.out.println("current_pos"+current_pos);
                        }
                        else {
                            ret = true;
                            compare = true;
                            color_effect = true;
                            System.out.println("current_pos else"+current_pos);
                            
                        }
                    }
                }
            }
            if((ret)&&(compare)&&(back)){
                System.out.println("c=13");
                cx = rect[position[current_pos]].getX();
                cy = rect[position[current_pos]].getY();
                
                cxt = text[position[current_pos]].getTranslateX();
                cyt = text[position[current_pos]].getTranslateY();
                statement[2].setFill(Color.WHITE);
                if ((rect[position[current_pos]].getY() != (300-height[position[current_pos]]))) {
                    System.out.println("c=14");
                    rect[position[current_pos]].setX(cx + dx);
                    rect[position[current_pos]].setY(cy + dy);
                    text[position[current_pos]].setTranslateX(cxt + dx);
                    text[position[current_pos]].setTranslateY(cyt + dy);
                    
                    System.out.println("c=14");
                }
                if((rect[position[current_pos]].getY() == (300-height[position[current_pos]]))){
                    ret=false;
                    rect[position[current_pos]].setFill(Color.PLUM);
                    System.out.println("c=15");
                    compare=false;
                    statement[2].setFill(Color.BLUE);
                    back=false;
                    iterator++;
                    if(iterator==12){
                        end_sort=true;
                    }
                    first_move=true;
                    check_element=iterator-1;
                }
            }
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
        

        Random random=new Random();
        int n;
        int s;
         for(int i=0;i<12;i++)
        {
            position[i]=i;
            posX[i]=200+i*50;
        }
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
       
        for (int i = 0; i < 12; i++) {
            rect[i]=new Rectangle(posX[i],posY[i],30,height[i]);
            rect[i].setFill(Color.CHARTREUSE);
        }
        
        statement[0]=new Text(610,480,"Extract the first unsorted element");
        statement[0].setFill(Color.WHITE);
        statement[0].setFont(Font.font("Verdana", 15));
        statement[1]=new Text(610,530,height[0]+">"+height[1]+" is false");
        statement[1].setFill(Color.BLUE);
        statement[1].setFont(Font.font("Verdana", 15));
        statement[2]=new Text(610,580,"insert element at current position");
        statement[2].setFill(Color.BLUE);
        statement[2].setFont(Font.font("Verdana", 15));
        statement[3]=new Text(610,620,"move sorted element to the right by 1");
        statement[3].setFill(Color.BLUE);
        statement[3].setFont(Font.font("Verdana", 15));
        statement[4]=new Text(610,670,"repeat the process from first unsorted element to noOfElement-1");
        statement[4].setFill(Color.BLUE);
        statement[4].setFont(Font.font("Verdana", 15));

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
        root.getChildren().addAll(button,buttonpause,buttonclose);
        root.getChildren().addAll(r,r_move,rectangle);
        root.getChildren().addAll(text);
        root.getChildren().addAll(rect);
        root.getChildren().addAll(statement);
        scene = new Scene(root, 1000, 700);
        
        primaryStage.setTitle("Insertion Sort");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
