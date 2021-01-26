package sortingalgorithmsimulator;

import static java.lang.System.exit;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Quick_Sort{

    Scene scene;
    Rectangle[] rect = new Rectangle[12];
    Rectangle r=new Rectangle(550, 450, 440, 240);
    Text []text=new Text[12];
    Text []statement=new Text[5];
    double[] posX = new double[12];
    double[] posY = {220, 220, 220, 260, 250, 230, 185, 245, 240, 200, 190, 210};
    int[] height = {110, 110, 110, 70, 80, 100, 145, 85, 90, 130, 140, 120};
    int[] sequence = new int[22];
    int[] current_pos = new int[12];
    int[] new_pos = new int[12];

    int pos, st, end;
    int iterator;
    double dx = 5;
    double dy = 5;
    boolean greater_pivot = false;
    boolean same_pos = false;
    boolean ret = false;
    boolean isstart = true;
    int c = 0,count=2;
    int fiterator;
    boolean start_sort=false;
    boolean end_sort=false;
    Rectangle rectangle = new Rectangle(50, 650, 300, 10);
    Rectangle r_move = new Rectangle(50, 645, 20, 20);
    long limit = 168000000;
    
    public void updaterectangle(long time) {
        if ((isstart)&&(start_sort)&&(end_sort==false)) {
            
            rect[current_pos[end]].setFill(Color.YELLOW);
            statement[1].setText("set "+height[current_pos[end]]+" as pivot");
            statement[1].setFill(Color.WHITE);
            statement[2].setText("working on Index "+st+" to "+end);
            statement[2].setFill(Color.WHITE);
            isstart=false;
            if (pos != end) {
                if (rect[current_pos[pos]].getHeight() <= rect[current_pos[end]].getHeight()) {
                    c = 2;
                    iterator=fiterator;
                    greater_pivot = true;
                    if (pos == iterator) {
                        same_pos = true;
                        dx = 0;
                        dy = 5;
                    } else {
                        same_pos = false;
                        dx = 0;
                        dy = 5;
                    }
                } else {
                    iterator=pos;
                    dx = 0;
                    dy = 5;
                    greater_pivot = false;
                    same_pos = true;
                }
            } 
            else if((st!=end)&&(pos==end)&&(fiterator==st)){
                same_pos = false;
                iterator=st;
                dx = 0;
                dy = 5;
            }
            else if ((fiterator == st)&&(pos==end)) {
                same_pos = true;
                iterator=st;
                dx = 0;
                dy = 5;
            } else if((pos==end)&&(fiterator==end)){
                same_pos = true;
                iterator=fiterator;
                dx = 0;
                dy = 5;
            }
            else{
                same_pos = false;
                iterator=fiterator;
                dx = 0;
                dy = 5;
            }
        }
        if ((pos != end) && (same_pos == false)&&(start_sort)&&(end_sort==false)) {
            double cx1 = rect[current_pos[iterator]].getX();
            double cy1 = rect[current_pos[iterator]].getY();
            double cx2 = rect[current_pos[pos]].getX();
            double cy2 = rect[current_pos[pos]].getY();
            
            double cxt = text[current_pos[iterator]].getTranslateX();
            double cyt = text[current_pos[iterator]].getTranslateY();
            double cxt1 = text[current_pos[pos]].getTranslateX();
            double cyt1 = text[current_pos[pos]].getTranslateY();
            
            statement[3].setText("checking if "+height[current_pos[pos]]+" < "+height[current_pos[end]]+"(pivot) is true");
            statement[3].setFill(Color.WHITE);
            
            statement[4].setText("swaping element "+height[current_pos[pos]]+" and "+height[current_pos[iterator]]);
            statement[4].setFill(Color.WHITE);
            
            if ((ret == false) && ((rect[current_pos[iterator]].getY()) != (400 - height[current_pos[iterator]])) && (rect[current_pos[iterator]].getX() != posX[pos])) {
                dx = 0;
                dy = 5;
                rect[current_pos[iterator]].setX(cx1 + dx);
                rect[current_pos[iterator]].setY(cy1 + dy);
                rect[current_pos[pos]].setX(cx2 + dx);
                rect[current_pos[pos]].setY(cy2 + dy);
                
                text[current_pos[iterator]].setTranslateX(cxt + dx);
                text[current_pos[iterator]].setTranslateY(cyt + dy);
                text[current_pos[pos]].setTranslateX(cxt1 + dx);
                text[current_pos[pos]].setTranslateY(cyt1 + dy);
            } else if ((ret == false) && ((rect[current_pos[iterator]].getY()) == (400 - height[current_pos[iterator]])) && (rect[current_pos[iterator]].getX() != posX[pos])) {
                dx = 5;
                dy = 0;
                statement[3].setFill(Color.BLUE);
                statement[4].setText("swaping element "+height[current_pos[pos]]+" and "+height[current_pos[iterator]]);
                statement[4].setFill(Color.WHITE);
                rect[current_pos[iterator]].setX(cx1 + dx);
                rect[current_pos[iterator]].setY(cy1 + dy);
                rect[current_pos[pos]].setX(cx2 - dx);
                rect[current_pos[pos]].setY(cy2 + dy);
                
                text[current_pos[iterator]].setTranslateX(cxt + dx);
                text[current_pos[iterator]].setTranslateY(cyt + dy);
                text[current_pos[pos]].setTranslateX(cxt1 - dx);
                text[current_pos[pos]].setTranslateY(cyt1 + dy);
                if ((rect[current_pos[iterator]].getX() == posX[pos])) {
                    ret = true;
                }
            } else if ((ret) && (rect[current_pos[iterator]].getX() == posX[pos]) && (rect[current_pos[iterator]].getY() != (330 - rect[current_pos[iterator]].getHeight()))) {
                dx = 0;
                dy = -5;
                rect[current_pos[iterator]].setX(cx1 + dx);
                rect[current_pos[iterator]].setY(cy1 + dy);
                rect[current_pos[pos]].setX(cx2 + dx);
                rect[current_pos[pos]].setY(cy2 + dy);
                
                text[current_pos[iterator]].setTranslateX(cxt + dx);
                text[current_pos[iterator]].setTranslateY(cyt + dy);
                text[current_pos[pos]].setTranslateX(cxt1 + dx);
                text[current_pos[pos]].setTranslateY(cyt1 + dy);
                
            } else {
                statement[4].setFill(Color.BLUE);
                dx = 0;
                int temp=current_pos[iterator];
                current_pos[iterator]=current_pos[pos];
                current_pos[pos]=temp;
                isstart=true;
                dy = 0;
                pos++;
                ret=false;
                if (greater_pivot) {
                    fiterator++;
                }
                greater_pivot=false;
                for (int i = 0; i < 12; i++) {
                    posX[i] = 250+50*i;
                }
            }

        } else if ((pos != end) && (same_pos)&&(start_sort)&&(end_sort==false)) {
            double cx2 = rect[current_pos[pos]].getX();
            double cy2 = rect[current_pos[pos]].getY();
            
            statement[3].setText("checking if "+height[current_pos[pos]]+" < "+height[current_pos[end]]+"(pivot)");
            statement[3].setFill(Color.WHITE);
            //statement1[2].setFill(Color.WHITE);
            
            double cxt1 = text[current_pos[pos]].getTranslateX();
            double cyt1 = text[current_pos[pos]].getTranslateY();
            if ((ret == false) && (rect[current_pos[iterator]].getY()) != (400 - height[current_pos[iterator]])) {
                dx = 0;
                dy = 5;
                rect[current_pos[pos]].setX(cx2 + dx);
                rect[current_pos[pos]].setY(cy2 + dy);
                
                text[current_pos[pos]].setTranslateX(cxt1 + dx);
                text[current_pos[pos]].setTranslateY(cyt1 + dy);
                if ((rect[current_pos[iterator]].getY()) == (400 - height[current_pos[iterator]])) {
                    statement[3].setFill(Color.BLUE);
                    ret = true;
                }
            } else if ((ret) && (rect[current_pos[pos]].getY() != (330 - rect[current_pos[pos]].getHeight()))) {
                dx = 0;
                dy = -5;
                rect[current_pos[pos]].setX(cx2 + dx);
                rect[current_pos[pos]].setY(cy2 + dy);
                
                text[current_pos[pos]].setTranslateX(cxt1 + dx);
                text[current_pos[pos]].setTranslateY(cyt1 + dy);
                if ((rect[current_pos[iterator]].getY() == (330 - rect[current_pos[iterator]].getHeight()))) {
                    same_pos = false;
                for (int i = 0; i < 12; i++) {
                    posX[i] = 250+50*i;
                }
                    if(greater_pivot){
                        fiterator++;
                    }
                    pos++;
                    isstart=true;
                    dx = 0;
                    dy = 0;
                    ret = false;
                    greater_pivot=false;
                }
            }
        } else if ((pos == end) && (same_pos == false)&&(start_sort)&&(end_sort==false)) {
            double cx1 = rect[current_pos[iterator]].getX();
            double cy1 = rect[current_pos[iterator]].getY();
            double cx2 = rect[current_pos[pos]].getX();
            double cy2 = rect[current_pos[pos]].getY();
            
            statement[4].setText("swaping element "+height[current_pos[iterator]]+" and "+height[current_pos[pos]]+" (pivot)");
            statement[4].setFill(Color.WHITE);
            statement[3].setFill(Color.BLUE);
            
            double cxt = text[current_pos[iterator]].getTranslateX();
            double cyt = text[current_pos[iterator]].getTranslateY();
            double cxt1 = text[current_pos[pos]].getTranslateX();
            double cyt1 = text[current_pos[pos]].getTranslateY();
            if ((ret == false) && ((rect[current_pos[iterator]].getY()) != (400 - height[current_pos[iterator]])) && (rect[current_pos[iterator]].getX() != posX[pos])) {
                dx = 0;
                dy = 5;
                rect[current_pos[iterator]].setX(cx1 + dx);
                rect[current_pos[iterator]].setY(cy1 + dy);
                rect[current_pos[pos]].setX(cx2 + dx);
                rect[current_pos[pos]].setY(cy2 + dy);
                
                text[current_pos[iterator]].setTranslateX(cxt + dx);
                text[current_pos[iterator]].setTranslateY(cyt + dy);
                text[current_pos[pos]].setTranslateX(cxt1 + dx);
                text[current_pos[pos]].setTranslateY(cyt1 + dy);
            } else if ((ret == false) && ((rect[current_pos[iterator]].getY()) == (400 - height[current_pos[iterator]])) && (rect[current_pos[iterator]].getX() != posX[pos])) {
                dx = 5;
                dy = 0;
                rect[current_pos[iterator]].setX(cx1 + dx);
                rect[current_pos[iterator]].setY(cy1 + dy);
                rect[current_pos[pos]].setX(cx2 - dx);
                rect[current_pos[pos]].setY(cy2 + dy);
                
                text[current_pos[iterator]].setTranslateX(cxt + dx);
                text[current_pos[iterator]].setTranslateY(cyt + dy);
                text[current_pos[pos]].setTranslateX(cxt1 - dx);
                text[current_pos[pos]].setTranslateY(cyt1 + dy);
                if ((rect[current_pos[iterator]].getX() == posX[pos])) {
                    ret = true;
                }
            } else if ((ret) && (rect[current_pos[iterator]].getX() == posX[pos]) && (rect[current_pos[iterator]].getY() != (330 - rect[current_pos[iterator]].getHeight()))) {
                dx = 0;
                dy = -5;
                rect[current_pos[iterator]].setX(cx1 + dx);
                rect[current_pos[iterator]].setY(cy1 + dy);
                rect[current_pos[pos]].setX(cx2 + dx);
                rect[current_pos[pos]].setY(cy2 + dy);
                
                text[current_pos[iterator]].setTranslateX(cxt + dx);
                text[current_pos[iterator]].setTranslateY(cyt + dy);
                text[current_pos[pos]].setTranslateX(cxt1 + dx);
                text[current_pos[pos]].setTranslateY(cyt1 + dy);
            } else {
                
                 if(count==24){
                    rect[current_pos[pos]].setFill(Color.RED);
                        end_sort=true;
                }
                 statement[4].setFill(Color.BLUE);
                rect[current_pos[pos]].setFill(Color.RED);
                dx = 0;
                dy = 0;
                ret=false;
                isstart=true;
                greater_pivot=false;
                
               
                
                int temp=current_pos[iterator];
                current_pos[iterator]=current_pos[pos];
                current_pos[pos]=temp;
                st=sequence[count];
                end=sequence[count+1];
                count+=2;
                pos=st;
                fiterator=st;
                for (int i = 0; i < 12; i++) {
                    posX[i] = 250+50*i;
                }
            }

        } else if ((pos == end) && (same_pos)&&(start_sort)&&(end_sort==false)) {
            double cx2 = rect[current_pos[pos]].getX();
            double cy2 = rect[current_pos[pos]].getY();
            
            double cxt = text[current_pos[pos]].getTranslateX();
            double cyt = text[current_pos[pos]].getTranslateY();
            if ((ret == false) && (rect[current_pos[iterator]].getY()) != (400 - height[current_pos[iterator]])) {
                dx = 0;
                dy = 5;
                rect[current_pos[pos]].setX(cx2 + dx);
                rect[current_pos[pos]].setY(cy2 + dy);
                
                text[current_pos[pos]].setTranslateX(cxt + dx);
                text[current_pos[pos]].setTranslateY(cyt + dy);
                if ((rect[current_pos[iterator]].getY()) == (400 - height[current_pos[iterator]])) {
                    ret = true;
                }
            } else if ((ret) && (rect[current_pos[pos]].getY() != (330 - rect[current_pos[pos]].getHeight()))) {
                dx = 0;
                dy = -5;
                rect[current_pos[pos]].setX(cx2 + dx);
                rect[current_pos[pos]].setY(cy2 + dy);
                
                text[current_pos[pos]].setTranslateX(cxt + dx);
                text[current_pos[pos]].setTranslateY(cyt + dy);
                if ((rect[current_pos[iterator]].getY() == (330 - rect[current_pos[iterator]].getHeight()))) {
                    
                    if(count==24){
                        rect[current_pos[pos]].setFill(Color.RED);
                        end_sort=true;
                    } else {
                        rect[current_pos[pos]].setFill(Color.RED);
                        same_pos = false;
                        st = sequence[count];
                        end = sequence[count + 1];
                        count += 2;

                        pos = st;
                        fiterator = st;
                        ret = false;
                        greater_pivot = false;
                        dx = 0;
                        isstart = true;
                        dy = 0;
                        for (int i = 0; i < 12; i++) {
                            posX[i] = 250 + 50 * i;
                        }
                    }
                }
            }

        }

    }

    public void start() {
        Stage primaryStage=new Stage();
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: cadetblue;");
        int length;
        
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
        for (int i = 0; i < 12; i++) {
            posX[i] = 250 + i * 50;
            current_pos[i] = i;
            new_pos[i] = i;
        }
        
        for(int i=0;i<12;i++){
            n=random.nextInt();
            s=(n>=0?(n%150):-(n%150));
            s=(s==0?10:s);
            height[i]=s;
            posY[i]=(330-height[i]);
            text[i]=new Text(posX[i], 350,Integer.toString(s));
            text[i].setFill(Color.BLUE);
            text[i].setFont(Font.font("Verdana", 15));
        }
        
        int [] height_new = height.clone();
        QuickSortLength ob = new QuickSortLength(height_new);
        length = ob.start();

        System.out.println("length=" + length);

        int[] sequence1 = new int[length];
        int [] height_new_2=height.clone();
        QuickSort obj = new QuickSort(sequence1,height_new_2);
        obj.start();
        sequence = sequence1;
        
        for(int i:sequence){
            System.out.println("element="+i);
        }
        
        st = sequence[0];
        pos = sequence[0];
        fiterator = sequence[0];
        end = sequence[1];


        for (int i = 0; i < 12; i++) {
            rect[i] = new Rectangle(posX[i], posY[i], 30, height[i]);
            rect[i].setFill(Color.DARKGOLDENROD);
        }
        
        statement[0]=new Text(560,480,"for each (unsorted) partition set last element as pivot");
        statement[0].setFill(Color.WHITE);
        statement[0].setFont(Font.font("Verdana", 15));
        statement[1]=new Text(560,530,"set "+height[11]+" as pivot");
        statement[1].setFill(Color.BLUE);
        statement[1].setFont(Font.font("Verdana", 15));
        statement[2]=new Text(560,580,"working on Index 0 to 11");
        statement[2].setFill(Color.BLUE);
        statement[2].setFont(Font.font("Verdana", 15));
        statement[3]=new Text(560,620,"checking if "+height[0]+" > "+height[11]+"(pivot)");
        statement[3].setFill(Color.BLUE);
        statement[3].setFont(Font.font("Verdana", 15));
        statement[4]=new Text(560,670,"swap Index to Index");
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
        timer.start();
        
        r.setFill(Color.BLUE);
        r_move.setFill(Color.WHITE);
        rectangle.setFill(Color.WHITE);
        root.getChildren().addAll(button,buttonpause,buttonclose);
        root.getChildren().addAll(r,r_move,rectangle);
        root.getChildren().addAll(rect);
        root.getChildren().addAll(text);
        root.getChildren().addAll(statement);
        scene = new Scene(root, 1000, 700);

        primaryStage.setTitle("Merge Sort");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
}
