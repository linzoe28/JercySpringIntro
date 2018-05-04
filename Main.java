//EliotCodeHub 2018

package App;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

class Snake
        {
          public  Rectangle body = new Rectangle(10,10,Color.WHITE);
          private int Xpos;
          private int Ypos;
          private int oldXpos;
          private int oldYpos;

          Snake(int X, int Y)
          {
              oldXpos = Xpos = X;
              oldYpos = Ypos = Y;
          }

          public void setPos(int X, int Y)
          {
              oldXpos =Xpos;
              oldYpos =Ypos;

              Xpos =X;
              Ypos =Y;

          }

          public int getOldXpos()
            { return oldXpos; }

          public int getOldYpos()
            {return oldYpos;}
        }




public class Main extends Application
{

    public static void main(String[] args)
    { launch(args); }
    GridPane GameGrid = new GridPane();

    ArrayList<Snake> SnakeP = new ArrayList<>(0);



    int mX = 1, mY = 0;
    int posX =1, posY = 1;

    double speed = 1/15.0;
    //Thread thread;

    int GridSizeSquared = 15;

    Rectangle Food = new Rectangle(10,10,Color.ORANGE);
    int foodN = 0;
    int FoodPosX = new Random().nextInt(GridSizeSquared);
    int FoodPosY = new Random().nextInt(GridSizeSquared);

    public void start(Stage PrimaryStage)
    {
        FillGrid(GameGrid);
        SnakeP.add(new Snake(posX, posY));

        //GameGrid.setGridLinesVisible(true);
        GameGrid.setVgap(1.5);
        GameGrid.setHgap(1.5);

        GameGrid.add(Food, FoodPosX,FoodPosY);
        GameGrid.add(SnakeP.get(0).body, posX,posY);





        Scene Game = new Scene(GameGrid);
        Game.setFill(Color.MEDIUMAQUAMARINE);





        PrimaryStage.setTitle("Grid Game");

        Game.setOnKeyPressed(this::KeyPressedProcess);
        PrimaryStage.setScene(Game);

        PrimaryStage.show();

 /* thread = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException exc) {
                throw new Error("Unexpected interruption", exc);
            }
            Platform.runLater(()->MoveChar());
        });*/
        //thread.setDaemon(true);
        //thread.start();

        Timeline Loop = new Timeline(new KeyFrame(Duration.seconds(speed), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                MoveChar();
               // System.out.println("this is called every half second on UI thread");
              //  speed*=(1/2);
            }
        }));
        Loop.setCycleCount(Timeline.INDEFINITE);
        Loop.play();


    }

    public void MoveChar()
    {
        if(mX == -1 && (posX == 0))
        { }
        else if(mY == -1 && (posY == 0))
        { }
        else if(mX == 1 && (posX == GridSizeSquared-1))
        { }
        else if(mY == 1 && (posY == GridSizeSquared-1))
        { }

        else
            {

               //head
                GameGrid.getChildren().remove(SnakeP.get(0).body);
                posX+=mX;
                posY+=mY;
                GameGrid.add(SnakeP.get(0).body, posX,posY);
                SnakeP.get(0).setPos(posX,posY);

               //Rest of body
               if(SnakeP.size() > 1)
               {
                   for(int x = 1; x<SnakeP.size();x++)
                   {
                       GameGrid.getChildren().remove(SnakeP.get(x).body);
                       GameGrid.add(SnakeP.get(x).body, SnakeP.get(x-1).getOldXpos(),SnakeP.get(x-1).getOldYpos());
                       SnakeP.get(x).setPos(SnakeP.get(x-1).getOldXpos(),SnakeP.get(x-1).getOldYpos());
                   }

               }

               if(posX == FoodPosX && posY == FoodPosY)
               {
                Grow();
               }

            }



    }


    public void KeyPressedProcess(KeyEvent event)
    {
        if(mY ==0 && (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP))
        {
            mX = 0;
            mY = -1;
        }
        else if(mY == 0 && (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN))
        {
            mX = 0;
            mY = 1;
        }
        else if(mX ==0 && (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT))
        {
            mX = -1;
            mY = 0;
        }
        else if(mX == 0 && (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT))
        {
            mX = 1;
            mY = 0;
        }

        if(event.getCode() == KeyCode.ESCAPE)
            System.exit(0);
          //  MoveChar();

    }

    public void FillGrid(GridPane Grid)
    {
        for(int x =0;x<GridSizeSquared;x++)
        {
            GameGrid.addColumn(x,new Rectangle(10,10, Color.GRAY));

           for(int y = 1; y < GridSizeSquared;y++)
            GameGrid.addRow(y,new Rectangle(10,10, Color.GRAY));

        }

    }

    public void PlaceFood()
    {
        Random rPos = new Random();

        int newPosX =  rPos.nextInt(GridSizeSquared);
        int newPosY =  rPos.nextInt(GridSizeSquared);

        FoodPosX = newPosX;
        FoodPosY = newPosY;

        GameGrid.getChildren().remove(Food);
        GameGrid.add(Food, newPosX,newPosY);

    }

    public void Grow()
    {
        SnakeP.add(new Snake(SnakeP.get(SnakeP.size()-1).getOldXpos(),
                SnakeP.get(SnakeP.size()-1).getOldXpos()));

        GameGrid.add(SnakeP.get(SnakeP.size()-1).body,
                SnakeP.get(SnakeP.size()-1).getOldXpos(),
                SnakeP.get(SnakeP.size()-1).getOldXpos());

        PlaceFood();

    }


}
