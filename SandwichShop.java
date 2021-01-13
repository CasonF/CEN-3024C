import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class SandwichShop extends Application
{

    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5, scene6;
    String meat = "", bread = "";
    int i = 0;
    String sandwich;
    static ArrayList<Label> sandwichList = new ArrayList<Label>();
    int width = 700;
    int height = 700;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ArrayList<String> extras = new ArrayList<>();

        window = primaryStage;
        window.setTitle("Sandwich Shop");

        /// Window 1 ///
        
        // Start Button
        Button button1 = new Button();
        button1.setText("Start");
        Label label1 = new Label("Welcome to the Sandwich Shop! Please come in and place an order!");
        
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, width, height);
        
        /// Window 2 ///

        // Select Meat
        Button button2 = new Button();
        button2.setText("Chicken");
        
        Button button3 = new Button();
        button3.setText("Ham");
        
        Button button4 = new Button();
        button4.setText("Turkey");

        Label label2 = new Label("What kind of meat would you like on this sandwich?");

        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(label2, button2, button3, button4);
        scene2 = new Scene(layout2, width, height);

        /// Window 3 ///
        
        // Select Bread
        Button button5 = new Button();
        button5.setText("Wheat");
        
        Button button6 = new Button();
        button6.setText("White");
       
        Button button7 = new Button();
        button7.setText("Rye");

        Label label3 = new Label("What kind of bread would you like that on?");

        VBox layout3 = new VBox(20);
        layout3.getChildren().addAll(label3, button5, button6, button7);
        scene3 = new Scene(layout3, width, height);

        /// Window 4 ///
        
        // Check-boxes for extras
        CheckBox mayo = new CheckBox("Mayo");
        mayo.setIndeterminate(false);

        CheckBox mustard = new CheckBox("Mustard");
        mustard.setIndeterminate(false);

        CheckBox oil = new CheckBox("Oil");
        oil.setIndeterminate(false);

        CheckBox spinach = new CheckBox("Spinach");
        spinach.setIndeterminate(false);

        CheckBox olives = new CheckBox("Olives");
        olives.setIndeterminate(false);

        CheckBox onions = new CheckBox("Onions");
        onions.setIndeterminate(false);

        CheckBox tomatoes = new CheckBox("Tomatoes");
        tomatoes.setIndeterminate(false);

        CheckBox salt = new CheckBox("Salt");
        salt.setIndeterminate(false);

        CheckBox pepper = new CheckBox("Pepper");
        pepper.setIndeterminate(false);

        Button button8 = new Button();
        button8.setText("Done!");

        Label label4 = new Label("Finally, what extra toppings would you like?");

        VBox layout4 = new VBox(20);
        layout4.getChildren().addAll(label4, mayo, mustard, oil, spinach, olives, onions, tomatoes, salt, pepper, button8);
        scene4 = new Scene(layout4, width, height);

        /// Window 5 ///
        
        // Check-out or add another sandwich
        Button button9 = new Button();
        button9.setText("Add another sandwich");
        Button button10 = new Button();
        button10.setText("Check out");
        VBox layout5 = new VBox(10);
        Label label5 = new Label("Your current order: ");
        layout5.getChildren().addAll(button9, button10);
        layout5.getChildren().add(label5);
        scene5 = new Scene(layout5, width, height);

        /// Window 6 ///
        
        // Receipt page
        Label lastPage = new Label("Your final receipt: \n");
        VBox checkOut = new VBox(10);
        checkOut.getChildren().add(lastPage);
        scene6 = new Scene(checkOut, width, height);

        //Set starting scene and show
        window.setScene(scene1);
        window.show();
        
        ////// Button Actions ///////
        
        // Start Button Goes to next page
        button1.setOnAction(e -> window.setScene(scene2));
        
        button2.setOnAction(e ->
        {
            meat = "chicken";
            window.setScene(scene3);
        });
        
        button3.setOnAction(e ->
        {
            meat = "ham";
            window.setScene(scene3);
        });
        
        button4.setOnAction(e ->
        {
            meat = "turkey";
            window.setScene(scene3);
        });
        
        button5.setOnAction(e ->
        {
            bread = "wheat";
            window.setScene(scene4);
        });
        
        button6.setOnAction(e ->
        {
            bread = "white";
            window.setScene(scene4);
        });
        
        button7.setOnAction(e ->
        {
            bread = "rye";
            window.setScene(scene4);
        });
        
        // Selection done on the toppings/extras page
        button8.setOnAction(e ->
        {
            if (mayo.isSelected())
            {
                extras.add("mayo");
            }
            if (mustard.isSelected())
            {
                extras.add("mustard");
            }
            if (oil.isSelected())
            {
                extras.add("oil");
            }
            if (spinach.isSelected())
            {
                extras.add("spinach");
            }
            if (olives.isSelected())
            {
                extras.add("olives");
            }
            if (onions.isSelected())
            {
                extras.add("onions");
            }
            if (tomatoes.isSelected())
            {
                extras.add("tomatoes");
            }
            if (salt.isSelected())
            {
                extras.add("salt");
            }
            if (pepper.isSelected())
            {
                extras.add("pepper");
            }
            
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (String stuff : extras)
            {
                sb.append(stuff);
                if (i < extras.size() - 2)
                {
                    sb.append(", ");
                }
                else if (i < extras.size() - 1)
                {
                    sb.append(" and ");
                }
                else
                {
                    sb.append(".");
                }
                i++;
            }
            
            //System.out.println(extras); //to test that strings are being added to extras
            String toppings = sb.toString();
            Label thisSandwich = new Label("You want a " + meat + " sandwich on " + bread + " bread with " + toppings);
            //System.out.println(thisSandwich); //to test that the label is set
            sandwichList.add(thisSandwich);
            extras.clear();
            //System.out.println(sandwichList.size());
            //System.out.println(sandwichList); //to test that label was written to arraylist
            System.out.println(sandwichList.size());
            System.out.println(sandwichList.get(sandwichList.size()-1));
            System.out.println("About to add the sandwich to layout 5 and checkout");
            layout5.getChildren().add(sandwichList.get(sandwichList.size()-1));
            //checkOut.getChildren().add(sandwichList.get(sandwichList.size()-1));
            
            // Clear all the previously checked toppings
            mayo.setSelected(false);
            mustard.setSelected(false);
            oil.setSelected(false);
            spinach.setSelected(false);
            olives.setSelected(false);
            onions.setSelected(false);
            tomatoes.setSelected(false);
            salt.setSelected(false);
            pepper.setSelected(false);
            
            
            window.setScene(scene5);
        });
        
        // Add another sandwich
        button9.setOnAction(e ->
        {
            window.setScene(scene2);
        });
        
        // Go to checkout
        button10.setOnAction(e ->
        {
            for (int j = 0; j < sandwichList.size(); j++)
            {
                checkOut.getChildren().add(sandwichList.get(j));
            }
            
            window.setScene(scene6);
        });

    }
}
