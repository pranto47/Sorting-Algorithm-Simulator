/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithmsimulator;

import static java.lang.System.exit;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Lotus Computer
 */
public class Heap_Sort {

    GraphicsContext gc;
    Canvas canvas = new Canvas(1200, 1200);
    Label label = new Label();
    Text[] text = new Text[15];
    Text[] text_unsorted=new Text[15];
    Rectangle r=new Rectangle(800, 560, 540, 180);
    Text []statement=new Text[5];
    Text [] statement1 =new Text[2];
    Line[] line = new Line[14];
    double[] middlePointX = new double[15];
    int[] arr = {6, 2, 26, 10, 23, 15, 29, 7, 9, 13, 20, 18, 1, 24, 25};
    double m=0,m1=0;
    double [][]center=new double [15][2];
    int [][] sorted_Array_Pos=new int [15][2];
    int []current_pos=new int [15];
    double [] circleX = new double [15];
    double [] circleY = new double [15];
    boolean isRearranged=false;
    boolean onMovement=false;
    boolean exchange=false;
    boolean placeMove=false;
    boolean sorted=false;
    int startElement,currentValue,left,right,greater;  
    double x=0,y=0,x1=0,y1=0;
    int scale=0,lastValue=14;
    int c=0,difference=300,blur=0,cycle=0;
    double diff=1;
    
    boolean previous=false;
    boolean arranged=false;
    boolean correct_pos=false;
    int previousValue=0;
    int width=3;
    int final_pos=0;
    boolean start_sort=false;
    boolean end_sort=false;
    
    Rectangle rectangle = new Rectangle(50, 660, 300, 10);
    Rectangle r_move = new Rectangle(50, 655, 20, 20);
    long limit = 168000000;

    public void updaterectangle(long now) {
        if((isRearranged==false)&&(onMovement==false)&&(placeMove==false)&&(correct_pos==false)&&(start_sort)&&(end_sort==false)){
            left=(2*currentValue)+1;
            right=(2*currentValue)+2;
            if((left<=lastValue)&&(right<=lastValue)){
                greater = (arr[left]>arr[right])?left:right;
                exchange = arr[greater]>arr[currentValue];
            }
            else if((left<=lastValue)){
                greater=left;
                exchange = arr[greater]>arr[currentValue];
            }
            if(exchange){
                m=(center[greater][1]-center[currentValue][1])/(center[greater][0]-center[currentValue][0]);
                m=(1/m);
            }
            onMovement=true;
        }
        
        if((isRearranged)&&(onMovement==false)&&(placeMove==false)&&(correct_pos==false)&&(start_sort)&&(end_sort==false)){
            left=(2*currentValue)+1;
            right=(2*currentValue)+2;
            if((left<=lastValue)&&(right<=lastValue)){
                greater = (arr[left]>arr[right])?left:right;
                exchange = arr[greater]>arr[currentValue];
            }
            else if((left<=lastValue)){
                greater=left;
                exchange = arr[greater]>arr[currentValue];
            }
            if(exchange){
                m=(center[greater][1]-center[currentValue][1])/(center[greater][0]-center[currentValue][0]);
                m=(1/m);
            }
            else{
                arranged=true;
            }
            onMovement=true;
        }        
        
        if((isRearranged)&&(onMovement)&&(exchange)&&(placeMove==false)&&(arranged==false)&&(correct_pos==false)&&(start_sort)&&(end_sort==false)){
            x = text[current_pos[currentValue]].getTranslateX();
            y = text[current_pos[currentValue]].getTranslateY();
            x1 = text[current_pos[greater]].getTranslateX();
            y1 = text[current_pos[greater]].getTranslateY();
            statement[0].setText("check if root "+arr[currentValue]+" > child element "+arr[greater]);
            statement[0].setFill(Color.WHITE);
            statement[1].setText("swap root "+arr[currentValue]+" and child element "+arr[greater]);
            statement[1].setFill(Color.WHITE);
            if (scale != 100) {
                switch (scale%5) {
                    case 0:
                        gc.setStroke(Color.INDIGO.brighter());
                        break;
                    case 1:
                        gc.setStroke(Color.YELLOW.brighter());
                        break;
                    case 2:
                        gc.setStroke(Color.RED.brighter());
                        break;
                    case 3:
                        gc.setStroke(Color.BLUE.brighter());
                        break;
                    case 4:
                        gc.setStroke(Color.BLACK.brighter());
                        break;
                }
                gc.strokeOval(circleX[greater], circleY[greater], 50, 50);
                gc.strokeOval(circleX[currentValue], circleY[currentValue], 50, 50);
                text[current_pos[currentValue]].setTranslateX(x + m);
                text[current_pos[currentValue]].setTranslateY(y + 1);
                text[current_pos[greater]].setTranslateX(x1 - m);
                text[current_pos[greater]].setTranslateY(y1 - 1);
                scale++;
            }
            else{
                statement[0].setFill(Color.BLUE);
                statement[1].setFill(Color.BLUE);
                gc.setStroke(Color.INDIGO.brighter());
                gc.setLineWidth(width);
                gc.strokeOval(circleX[greater], circleY[greater], 50, 50);
                gc.strokeOval(circleX[currentValue], circleY[currentValue], 50, 50);
                
                int temp=current_pos[greater];
                current_pos[greater]=current_pos[currentValue];
                current_pos[currentValue]=temp;
                scale=0;

                int temp1 = arr[greater];
                arr[greater] = arr[currentValue];
                arr[currentValue] = temp1;
                onMovement = false;
                if((2*(greater)+1)<=lastValue){
                    System.out.println("c="+10);
                    currentValue=greater;
                }
                else{
                    System.out.println("c="+10);
                    placeMove=true;
                    onMovement=false;
                    currentValue=0;
                    scale=0;
                }
            }
        }
        
        if((arranged)&&(correct_pos==false)&&(start_sort)&&(end_sort==false)){
            statement[0].setText("root element is greater than child elements");
            statement[0].setFill(Color.WHITE);
            int n1=2*(currentValue)+1;
            int n2=2*(currentValue)+2;
            diff=1;
            switch (blur) {
                    case 0:
                        gc.setStroke(Color.INDIGO.brighter());
                        break;
                    case 1:
                        gc.setStroke(Color.YELLOW.brighter());
                        break;
                    case 2:
                        gc.setStroke(Color.RED.brighter());
                        break;
                    case 3:
                        gc.setStroke(Color.BLUE.brighter());
                        break;
                    case 4:
                        gc.setStroke(Color.BLACK.brighter());
                        break;
                }
                
            if(blur!=5){
                if(n2<=lastValue){
                    gc.strokeOval(circleX[n2], circleY[n2], 50, 50);
                }
                gc.strokeOval(circleX[n1], circleY[n1], 50, 50);
                blur+=diff;
                if(blur==5){
                    cycle++;
                }
            } 
            else if((blur==5)&&(cycle!=10)){
                blur=0;
            }
            else{
                statement[0].setFill(Color.BLUE);
                gc.setStroke(Color.INDIGO.brighter());
                if(n2<=lastValue){
                    gc.strokeOval(circleX[n2], circleY[n2], 50, 50);
                }
                gc.strokeOval(circleX[n1], circleY[n1], 50, 50);
                blur = 0;
                cycle=0;
                currentValue=0;
                placeMove=true;
                arranged=false;
            }
        }
        
        if((isRearranged==false)&&(onMovement)&&(exchange)&&(correct_pos==false)&&(start_sort)&&(end_sort==false)){
            x = text[current_pos[currentValue]].getTranslateX();
            y = text[current_pos[currentValue]].getTranslateY();
            x1 = text[current_pos[greater]].getTranslateX();
            y1 = text[current_pos[greater]].getTranslateY();
            
            statement[0].setText("check if root "+arr[currentValue]+" > chiild element "+arr[greater]);
            statement[0].setFill(Color.WHITE);
            statement[1].setText("swap root "+arr[currentValue]+" and child element "+arr[greater]);
            statement[1].setFill(Color.WHITE);
            if (scale != 100) {
                switch (scale%5) {
                    case 0:
                        gc.setStroke(Color.INDIGO.brighter());
                        break;
                    case 1:
                        gc.setStroke(Color.YELLOW.brighter());
                        break;
                    case 2:
                        gc.setStroke(Color.RED.brighter());
                        break;
                    case 3:
                        gc.setStroke(Color.BLUE.brighter());
                        break;
                    case 4:
                        gc.setStroke(Color.BLACK.brighter());
                        break;
                }
                gc.strokeOval(circleX[greater], circleY[greater], 50, 50);
                gc.strokeOval(circleX[currentValue], circleY[currentValue], 50, 50);
                text[current_pos[currentValue]].setTranslateX(x + m);
                text[current_pos[currentValue]].setTranslateY(y + 1);
                text[current_pos[greater]].setTranslateX(x1 - m);
                text[current_pos[greater]].setTranslateY(y1 - 1);
                scale++;
            } else {
                
                statement[0].setFill(Color.BLUE);
                statement[1].setFill(Color.BLUE);
                gc.setStroke(Color.INDIGO.brighter());
                gc.setLineWidth(width);
                gc.strokeOval(circleX[greater], circleY[greater], 50, 50);
                gc.strokeOval(circleX[currentValue], circleY[currentValue], 50, 50);
                int temp=current_pos[greater];
                current_pos[greater]=current_pos[currentValue];
                current_pos[currentValue]=temp;
                scale=0;

                int temp1 = arr[greater];
                arr[greater] = arr[currentValue];
                arr[currentValue] = temp1;
                onMovement = false;
                if ((2*(greater)+2)<=lastValue){  
                    if(previous==false){
                        previous=true;
                        previousValue=currentValue;
                        currentValue=greater;
                    }
                    currentValue=greater;
                }
                else{
                    if(previous==false){
                        currentValue--;
                    }
                    else{
                        previous=false;
                        currentValue=previousValue-1;
                    }
                    if(currentValue==-1){
                        placeMove=true;
                        isRearranged=true;
                        onMovement=false;
                        currentValue=0;
                        scale=0;
                    }
                }
            }
        }
        else if((placeMove==false)&&(isRearranged==false)&&(correct_pos==false)&&(start_sort)&&(end_sort==false)){
            sorted=true;
        }
        if((placeMove==false)&&(isRearranged==false)&&(sorted)&&(correct_pos==false)&&(start_sort)&&(end_sort==false)){
            int n1=2*(currentValue)+1;
            int n2=2*(currentValue)+2;
            statement[0].setText("root element is greater than child elements");
            statement[0].setFill(Color.WHITE);
            diff=1;
            switch (blur) {
                    case 0:
                        gc.setStroke(Color.INDIGO.brighter());
                        break;
                    case 1:
                        gc.setStroke(Color.YELLOW.brighter());
                        break;
                    case 2:
                        gc.setStroke(Color.RED.brighter());
                        break;
                    case 3:
                        gc.setStroke(Color.BLUE.brighter());
                        break;
                    case 4:
                        gc.setStroke(Color.BLACK.brighter());
                        break;
                }
                
                
            if(blur!=5){
                if(n2<=lastValue){
                    gc.strokeOval(circleX[n2], circleY[n2], 50, 50);
                }
                gc.strokeOval(circleX[n1], circleY[n1], 50, 50);
                blur+=diff;
                if(blur==5){
                    cycle++;
                }
            } 
            else if((blur==5)&&(cycle!=10)){
                blur=0;
            }
            else {
                statement[0].setFill(Color.BLUE);
                gc.setStroke(Color.INDIGO.brighter());
                if(n2<=lastValue){
                    gc.strokeOval(circleX[n2], circleY[n2], 50, 50);
                }
                gc.strokeOval(circleX[n1], circleY[n1], 50, 50);
                blur = 0;
                cycle=0;
                sorted=false;
                onMovement = false;
                if(previous==false){
                    currentValue--;
                }
                else{
                    currentValue=(previousValue-1);
                    previous=false;
                }
                if (currentValue == -1) {
                    placeMove = true;
                    isRearranged = true;
                    onMovement = false;
                    currentValue = 0;
                    scale = 0;
                }
            }
        }

        if((placeMove)&&(correct_pos==false)&&(start_sort)&&(end_sort==false)){
            m=(center[lastValue][1]-center[currentValue][1])/(center[lastValue][0]-center[currentValue][0]);
            m=(1/m);
            statement[4].setText("swap root "+arr[currentValue]+" with last child element "+arr[lastValue]);
            statement[4].setFill(Color.WHITE);
            x = text[current_pos[currentValue]].getTranslateX();
            y = text[current_pos[currentValue]].getTranslateY();
            x1 = text[current_pos[lastValue]].getTranslateX();
            y1 = text[current_pos[lastValue]].getTranslateY();
            if(scale!=difference){
                text[current_pos[currentValue]].setTranslateX(x + m);
                text[current_pos[currentValue]].setTranslateY(y + 1);
                text[current_pos[lastValue]].setTranslateX(x1 - m);
                text[current_pos[lastValue]].setTranslateY(y1 - 1);
                switch (scale%5) {
                    case 0:
                        gc.setStroke(Color.INDIGO.brighter());
                        break;
                    case 1:
                        gc.setStroke(Color.YELLOW.brighter());
                        break;
                    case 2:
                        gc.setStroke(Color.RED.brighter());
                        break;
                    case 3:
                        gc.setStroke(Color.BLUE.brighter());
                        break;
                    case 4:
                        gc.setStroke(Color.BLACK.brighter());
                        break;
                }
                gc.strokeOval(circleX[lastValue], circleY[lastValue], 50, 50);
                gc.strokeOval(circleX[currentValue], circleY[currentValue], 50, 50);
                scale++;
            }
            if(scale==difference){
                gc.setStroke(Color.INDIGO.brighter());
                statement[4].setFill(Color.BLUE);
                gc.setLineWidth(width);
                gc.strokeOval(circleX[lastValue], circleY[lastValue], 50, 50);
                gc.strokeOval(circleX[currentValue], circleY[currentValue], 50, 50);
                int temp=current_pos[lastValue];
                current_pos[lastValue]=current_pos[currentValue];
                current_pos[currentValue]=temp;
                scale=0;
                int temp1 = arr[lastValue];
                arr[lastValue] = arr[currentValue];
                arr[currentValue] = temp1;
                onMovement = false;
                placeMove=false;
                currentValue=0;
                if((lastValue==7)){
                    difference=200;
                }
                if((lastValue==3)){
                    difference=100;
                }
                if((lastValue==1)){
                    correct_pos=true;
                    currentValue=0;
                    difference=0;
                    exchange=true;
                }
                lastValue--;
            }
        }
        
        if((correct_pos)&&(start_sort)&&(end_sort==false)){
            x = text[current_pos[final_pos]].getTranslateX();
            y = text[current_pos[final_pos]].getTranslateY();
            if (exchange) {
                m = (center[final_pos][1] - sorted_Array_Pos[final_pos][1]) / (center[final_pos][0] - sorted_Array_Pos[final_pos][0]);
                m = (1 / m);
                exchange = false;
                scale=0;
            }
            if ((final_pos >= 7)) {
                difference = 390;
            }
            else if ((final_pos >= 3)) {
                difference = 290;
            }
            else if ((final_pos>= 1)) {
                difference = 190;
            }
            else{
                difference = 90;
            }
            if(scale!=difference){
                System.out.println("text="+text[current_pos[final_pos]].getText());
                text[current_pos[final_pos]].setTranslateX(x - m);
                text[current_pos[final_pos]].setTranslateY(y - 1);
                scale++;
            }
            else{
                final_pos++;
                exchange=true;
                scale=0;
                if(final_pos==15){
                    end_sort=true;
                }
            }
        }

    }
    
    public void start() {
        Stage primaryStage=new Stage();
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: cadetblue;");
        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(3);
        int length;
        double st = 200;
        double end = 1000;
        double mid;
        double constMid;
        constMid = (end - st) * 2;
        double value;
        
        Button button=new Button("Start");
        button.setLayoutX(50);
        button.setLayoutY(500);
        button.setPrefSize(200, 20);
        button.setStyle("-fx-font: 22 arial; -fx-base:  #a6b5c9;");
        
        Button buttonpause=new Button("Pause");
        buttonpause.setLayoutX(50);
        buttonpause.setLayoutY(550);
        buttonpause.setPrefSize(200, 20);
        buttonpause.setStyle("-fx-font: 22 arial; -fx-base: #a6b5c9;");
        
        Button buttonclose=new Button("Close");
        buttonclose.setLayoutX(50);
        buttonclose.setLayoutY(600);
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
        for(int i=0;i<15;i++){
            arr[i]=random.nextInt()%100;
        }

        
        for (int i = 0; i < 4; i++) {
            length = (int) Math.pow(2, i);
            mid = (st + end) / 2;
            end = mid;
            constMid /= 2;
            value = constMid;
            for (int j = 0; j < length; j++) {
                if (j == 0) {
                    middlePointX[length + j - 1] = mid;
                } else {
                    middlePointX[length + j - 1] = mid + value;
                    mid = (mid + value);
                }
            }
        }

        int l;
        for (int i = 0; i < 4; i++) {
            l = (int) Math.pow(2, i);
            for (int j = 0; j < l; j++) {
                gc.setStroke(Color.SADDLEBROWN.brighter());
                gc.strokeOval(middlePointX[j + l - 1] + 10, 200 + i * 100, 50, 50);
                center[j + l - 1][0]=middlePointX[j + l - 1] + 20;
                center[j + l - 1][1]= 200 + i * 100+30;
                
                circleX[j+l-1]=middlePointX[j + l - 1] + 10;
                circleY[j+l-1]=200 + i * 100;
                
                text[j + l - 1] = new Text(middlePointX[j + l - 1] + 20, 200 + i * 100 + 30, Integer.toString(arr[j + l - 1]));
                text[j + l - 1].setFill(Color.BLUE);
                text[j + l - 1].setFont(Font.font("Verdana", 20));
                current_pos[j+l-1]=j+l-1;
            }
        }
        gc.setStroke(Color.RED.brighter());
        gc.strokeLine(middlePointX[0] + 10, 230, middlePointX[1] + 55, 310);
        gc.strokeLine(middlePointX[0] + 60, 230, middlePointX[2] + 15, 310);
        gc.strokeLine(middlePointX[1] + 15, 338, middlePointX[3] + 55, 410);
        gc.strokeLine(middlePointX[1] + 55, 338, middlePointX[4] + 15, 410);
        gc.strokeLine(middlePointX[2] + 15, 338, middlePointX[5] + 55, 410);
        gc.strokeLine(middlePointX[2] + 55, 338, middlePointX[6] + 15, 410);
        gc.strokeLine(middlePointX[3] + 25, 448, middlePointX[7] + 40, 500);
        gc.strokeLine(middlePointX[3] + 45, 448, middlePointX[8] + 30, 500);
        gc.strokeLine(middlePointX[4] + 25, 448, middlePointX[9] + 40, 500);
        gc.strokeLine(middlePointX[4] + 45, 448, middlePointX[10] + 30, 500);
        gc.strokeLine(middlePointX[5] + 25, 448, middlePointX[11] + 40, 500);
        gc.strokeLine(middlePointX[5] + 45, 448, middlePointX[12] + 30, 500);
        gc.strokeLine(middlePointX[6] + 25, 448, middlePointX[13] + 40, 500);
        gc.strokeLine(middlePointX[6] + 45, 448, middlePointX[14] + 30, 500);
        
        gc.setStroke(Color.RED.brighter());
        gc.setLineWidth(1);
        gc.strokeRect(300, 50, 750, 30);
        gc.strokeRect(300, 120, 750, 30);
        statement1[0]=new Text(200, 70, "Unsorted  :");
        statement1[0].setFill(Color.BLUE);
        statement1[0].setFont(Font.font("Verdana", 15));
        statement1[1]=new Text(200, 140, "Sorted  :");
        statement1[1].setFill(Color.BLUE);
        statement1[1].setFont(Font.font("Verdana", 15));
        for(int i=0;i<15;i++){
            gc.strokeLine(350+i*50, 50, 350+i*50, 80);
            gc.strokeLine(350+i*50, 120, 350+i*50, 150);
            sorted_Array_Pos[i][0]=305+i*50;
            sorted_Array_Pos[i][1]=140;
        }
        
        for(int i=0;i<15;i++){
            text_unsorted[i] = new Text(305+i*50, 70, Integer.toString(arr[i]));
            text_unsorted[i].setFill(Color.BLUE);
            text_unsorted[i].setFont(Font.font("Verdana", 20));
        }
        
        currentValue=startElement = (arr.length/2)-1;
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
        
        statement[0]=new Text(810,580,"check if < ");
        statement[0].setFill(Color.BLUE);
        statement[0].setFont(Font.font("Verdana", 15));
        statement[1]=new Text(810,610,"check if < ");
        statement[1].setFill(Color.BLUE);
        statement[1].setFont(Font.font("Verdana", 15));
        statement[2]=new Text(810,640,"if root element < child element");
        statement[2].setFill(Color.WHITE);
        statement[2].setFont(Font.font("Verdana", 15));
        statement[3]=new Text(810,670,"swap (root , child element)");
        statement[3].setFill(Color.WHITE);
        statement[3].setFont(Font.font("Verdana", 15));
        statement[4]=new Text(810,700,"");
        statement[4].setFill(Color.BLUE);
        statement[4].setFont(Font.font("Verdana", 15));
        
        r.setFill(Color.BLUE);
        r_move.setFill(Color.WHITE);
        rectangle.setFill(Color.WHITE);
        root.getChildren().addAll(text);
        root.getChildren().addAll(text_unsorted);
        root.getChildren().addAll(canvas);
        root.getChildren().addAll(button,buttonpause,buttonclose);
        root.getChildren().addAll(r,r_move,rectangle);
        root.getChildren().addAll(statement);
        root.getChildren().addAll(statement1);
        Scene scene = new Scene(root, 1350, 750);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
