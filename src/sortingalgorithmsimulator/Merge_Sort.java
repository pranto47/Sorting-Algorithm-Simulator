package sortingalgorithmsimulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.animation.AnimationTimer;
import static javafx.application.Application.launch;
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

public class Merge_Sort {

    Scene scene;
    Rectangle[] rect = new Rectangle[12];
    double[] posX = new double[12];
    Text []text=new Text[12];
    double[] posY = {270, 270, 180, 270, 210, 230, 185, 245,240,200,190,250};
    double[] new_posY = {270, 270, 180, 270, 210, 230, 185, 245,240,200,190,250};
    int[] height = {60, 60, 150, 60, 120, 100, 145, 85,90,130,140,80};
    int[] new_height = {60, 60, 150, 60, 120, 100, 145, 85,90,130,140,80};
    int[] new_height1 = {60, 60, 150, 60, 120, 100, 145, 85,90,130,140,80};
    double[] new_posX = new double[12];
    Rectangle r=new Rectangle(550, 450, 440, 240);
    int[] sequence=new int [22];
    Text []statement=new Text[5];
    
    int []middles=new int[4];;
    int[] current_pos = new int[12];
    int[] new_pos = new int[12];
    int[] cur_pos_height = new int[12];
    int [][] partition_sequence=new int [22][2];

    double dx, dy, d;
    double m = 0;
    int pos=0,p=0;
    int st = 0, end = 2;
    int half = 4;
    boolean sech = false, full = false;
    boolean ret = false;
    boolean start = true;
    boolean ism = true;
    boolean move = false;
    int lor = 1;
    int compos = 0;
    int compare = 0;
    int mul = 2, con;
    int c = 0, count = 1,arrayList_Count=0;
    ArrayList <Integer> element = new ArrayList <> ();
    ArrayList <Integer> pos_sequence = new ArrayList <> ();
    int arraylist_List=0;
    boolean yes=true;
    boolean partition=false;
    int cyl=0;
    int cylcount=0;
    boolean start_sort=false,end_sort=false;
    Rectangle rectangle = new Rectangle(50, 650, 300, 10);
    Rectangle r_move = new Rectangle(50, 645, 20, 20);
    long limit = 168000000;
    
    Color [] colors={Color.SIENNA,Color.BROWN,Color.BURLYWOOD,Color.MAROON,Color.CHARTREUSE,Color.CHOCOLATE,Color.CHOCOLATE,Color.CORNFLOWERBLUE,
    Color.CRIMSON,Color.DARKGOLDENROD,Color.DARKBLUE,Color.DARKGREEN,Color.DARKORANGE,Color.DARKORCHID,Color.DARKRED,Color.DARKSALMON,Color.DEEPPINK,
    Color.DODGERBLUE,Color.GOLD,Color.INDIANRED,Color.ORANGERED,Color.MEDIUMPURPLE};

    public void updaterectangle(long time) {
        
        if((partition==false)&&(start_sort)&&(end_sort==false)){
            statement[0].setFill(Color.WHITE);
            if(cyl!=50){
                for(int i=partition_sequence[cylcount][0];i<=partition_sequence[cylcount][1];i++){
                    rect[i].setFill(colors[cylcount]);
                }
                for(int i=partition_sequence[cylcount+1][0];i<=partition_sequence[cylcount+1][1];i++){
                    rect[i].setFill(colors[cylcount+1]);
                }
                cyl++;
            }
            if(cyl==50){
                cyl=0;
                cylcount+=2;
                if(cylcount==22){
                    statement[0].setFill(Color.BLUE);
                    rect[0].setFill(Color.BLUE);
                    rect[1].setFill(Color.BLUE);
                    partition=true;
                }
            }
        }
        
        if ((ism)&&(partition)&&(start_sort)&&(end_sort==false)) {
            compare = 0;
            statement[1].setFill(Color.WHITE);
            int j;
            for (int i = st; i <= (end); i++) {
                for(j=0;j<(pos_sequence.size());j++){
                    yes = pos_sequence.get(j) != i;
                    if(yes==false){
                        break;
                    }
                }
                System.out.println("j="+j);
                if((pos_sequence.size())==0){
                    yes=true;
                }
                if((element.get(arrayList_Count)==(height[cur_pos_height[i]]))&&(yes)){
                    compare=i;
                    pos_sequence.add(i);
                    break;
                }
            }
            arrayList_Count++;
            compos =compare;
            new_pos[pos] = current_pos[compos];
            new_posX[pos] = posX[compos];
            new_posY[pos] = posY[compos];
            new_height[pos] = new_height1[compos];
            
            if ((pos == compos)) {
                m = 0;
                dx = 0;
                dy = 5;
                move = false;
                System.out.println("yahh");
            } else{
                if ((ret == false) && (compos < pos)) {
                    dy = 5;
                    dx = 0;
                    lor = 1;
                    move = true;
                } else if ((ret == false)) {
                    dy = 5;
                    dx = 0;
                    lor = -1;
                    move = true;
                }
            }
            ism = false;
        }
        if (((rect[current_pos[compos]].getY()) != (400 - height[cur_pos_height[compos]])) && (ret == false)&&(partition)&&((start_sort)&&(end_sort==false))) {
            double cx = rect[current_pos[compos]].getX();
            double cy = rect[current_pos[compos]].getY();
            
            double cxt = text[current_pos[compos]].getTranslateX();
            double cyt = text[current_pos[compos]].getTranslateY();
            
            rect[current_pos[compos]].setX(cx + dx);
            rect[current_pos[compos]].setY(cy + dy);
            
            text[current_pos[compos]].setTranslateX(cxt+dx);
            text[current_pos[compos]].setTranslateY(cyt+dy);
            
            if ((rect[current_pos[compos]].getY()) == (400 - height[cur_pos_height[compos]]) && (ret == false)) {
                if ((move) && (rect[current_pos[compos]].getX() != posX[current_pos[pos]])) {
                    if (lor == 1) {
                        dx = 5;
                        dy = 0;
                    } else if (lor == -1) {
                        dx = -5;
                        dy = 0;
                    }
                }
            }
        } else if (((rect[current_pos[compos]].getY()) == (400 - height[cur_pos_height[compos]])) && (ret == false)&&(partition)&&(start_sort)&&(end_sort==false)) {
            
            if(move){
                double cx1 = rect[current_pos[compos]].getX();
                double cy1 = rect[current_pos[compos]].getY();
                
                double cxt1 = text[current_pos[compos]].getTranslateX();
                double cyt1 = text[current_pos[compos]].getTranslateY();
                
                rect[current_pos[compos]].setX(cx1 + dx);
                rect[current_pos[compos]].setY(cy1 + dy);
                
                text[current_pos[compos]].setTranslateX(cxt1+dx);
                text[current_pos[compos]].setTranslateY(cyt1+dy);
            }

            if ((rect[current_pos[compos]].getY()) == (400 - height[cur_pos_height[compos]]) && (ret == false)) {
                if ((move) && (rect[current_pos[compos]].getX() != posX[cur_pos_height[pos]])) {
                    if (lor == 1) {
                        dx = 5;
                        dy = 0;
                    } else if (lor == -1) {
                        dx = -5;
                        dy = 0;
                    }
                } else if ((move) && (rect[current_pos[compos]].getX() == posX[current_pos[pos]])) {
                    move = false;
                } else {
                    if ((pos) != end) {
                        pos++;
                        ism = true;
                        compare = 0;
                    } else {
                        ret = true;
                        posX = new_posX.clone();
                        current_pos = new_pos.clone();
                        cur_pos_height = new_pos.clone();

                        posY = new_posY.clone();
                        new_height1 = new_height.clone();
                        dx = 0;
                        dy = -5;
                        pos = st; 
                    }
                }
            }

        } else if ((start_sort)&&(end_sort==false)&&(partition)&&(ret) && (rect[current_pos[pos]].getY()!= (300 - rect[current_pos[pos]].getHeight()))) {
            statement[1].setFill(Color.BLUE);
            double cx = rect[current_pos[pos]].getX();
            double cy = rect[current_pos[pos]].getY();
            
            double cxt = text[current_pos[pos]].getTranslateX();
            double cyt = text[current_pos[pos]].getTranslateY();
            
            rect[current_pos[pos]].setX(cx + dx);
            rect[current_pos[pos]].setY(cy + dy);
            
            text[current_pos[pos]].setTranslateX(cxt+dx);
            text[current_pos[pos]].setTranslateY(cyt+dy);
            if ((rect[current_pos[pos]].getY() == (300 - rect[current_pos[pos]].getHeight()))) {
                if ((pos) != end) {
                    pos++;
                } else  {
                    if(p==20){
                        end_sort=true;
                        p=0;
                        for (int i = st; i <= end; i++) {
                            rect[i].setFill(Color.GREENYELLOW);
                        }
                    }
                    ret = false;
                    if ((end > 6)&&(end_sort==false)) {
                        for (int i = st; i <= end; i++) {
                            rect[i].setFill(Color.GREENYELLOW);
                        }
                    } else if(end_sort==false){
                        for (int i = st; i <= end; i++) {
                            rect[i].setFill(Color.RED);
                        }
                    }
                    ism = true;
                    p = p + 2;
                    st = sequence[p];
                    end = sequence[p + 1];
                    arrayList_Count=0;
                    
                    element.clear();
                    for(int i=st;i<=end;i++){
                        element.add(height[i]);
                    }
                    Collections.sort(element);
                    pos_sequence.clear();
                    if (end_sort == false) {
                        for (int i = st; i <= end; i++) {
                            rect[i].setFill(Color.BLUE);
                        }
                    }
                    pos = st;
                    current_pos = new_pos.clone();
                    cur_pos_height = new_pos.clone();
                    posX = new_posX.clone();
                    posY = new_posY.clone();
                    new_height1 = new_height.clone();
                    
                    for(int i=0;i<12;i++){
                        posX[i]=rect[i].getX();
                    }
                } 

            }
        }

    }

    public void start() {
        Stage primaryStage=new Stage();
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: cadetblue;");
        int length=12;
        
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

        
        MergeSort ob=new MergeSort(sequence,partition_sequence);
        
        ob.start();
        for(int i:sequence){
            System.out.println("value :"+i);
        }
        
        st=sequence[p];
        end=sequence[p+1];
        
        Random random=new Random();
        int n;
        int s=0;
        
        for (int i = 0; i < 12; i++) {
            posX[i] = 250 + i * 50;
            new_posX[i] = 250 + i * 50;
            current_pos[i] = i;
            cur_pos_height[i] = i;
            new_pos[i] = i;
        }
        
        for(int i=0;i<12;i++){
            n=random.nextInt();
            s=(n>=0?(n%150):-(n%150));
            s=(s==0?10:s);
            height[i]=s;
            new_height[i]=s;
            new_height1[i]=s;
            posY[i]=(300-height[i]);
            text[i]=new Text(posX[i], 320,Integer.toString(s));
            text[i].setFill(Color.BLUE);
            text[i].setFont(Font.font("Verdana", 15));
        }
        
        
        for (int i = 0; i < 12; i++) {
            rect[i] = new Rectangle(posX[i], posY[i], 30, height[i]);
            //rect[i].setFill(Color.DARKSLATEGREY);
        }
//        rect[0].setFill(Color.BLUE);
//        rect[1].setFill(Color.BLUE);
        
        for(int i=st;i<=end;i++){
            element.add(height[i]);
        }
        Collections.sort(element);
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
        statement[0]=new Text(560,480,"split the array into partition of 1");
        statement[0].setFill(Color.BLUE);
        statement[0].setFont(Font.font("Verdana", 15));
        statement[1]=new Text(560,530,"recursively merge two adjacent partitions");
        statement[1].setFill(Color.BLUE);
        statement[1].setFont(Font.font("Verdana", 15));
        statement[2]=new Text(560,580,"if leftPartitionHeadValue <= rightPartitionHeadValue");
        statement[2].setFill(Color.WHITE);
        statement[2].setFont(Font.font("Verdana", 15));
        statement[3]=new Text(560,620,"copy leftPartitionHeadValue");
        statement[3].setFill(Color.WHITE);
        statement[3].setFont(Font.font("Verdana", 15));
        statement[4]=new Text(560,670,"else copy rightPartitionHeadValue");
        statement[4].setFill(Color.WHITE);
        statement[4].setFont(Font.font("Verdana", 15));
        
        timer.start();
        r.setFill(Color.BLUE);
        r_move.setFill(Color.WHITE);
        rectangle.setFill(Color.WHITE);
        root.getChildren().addAll(r,r_move,rectangle);
        root.getChildren().addAll(rect);
        scene = new Scene(root, 1000, 700);
        root.getChildren().addAll(text);
        root.getChildren().addAll(statement);
        root.getChildren().addAll(button,buttonpause,buttonclose);
        primaryStage.setTitle("Merge Sort");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
