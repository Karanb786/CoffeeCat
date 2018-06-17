package com.coffee.coffeecat;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int noofcoffee=2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField = findViewById(R.id.userName);
        String name = nameField.getText().toString();

        CheckBox cramBox =findViewById(R.id.cream);
        boolean hascheamBox= cramBox.isChecked();

        CheckBox chocoBox=findViewById(R.id.chocolate);
        boolean haschoco=chocoBox.isChecked();

        int price = calculatePrice();
        String priceMessage =createOrderSummery(name, price, hascheamBox,haschoco);
        displayMessage(priceMessage);


    }

    private int calculatePrice(){return noofcoffee*5; }

    private String createOrderSummery(String name, int price, boolean hascheamBox,boolean haschoco){
        String priceMessage = "Name : "+name;
        priceMessage +="\nAdd wwhipped cream? " +hascheamBox;
        priceMessage +="\nAdd Chocolate? " +haschoco;
        priceMessage += "\nQuintity :"+noofcoffee;
        priceMessage +="\nPrice: $" +price;
        priceMessage+= "\nThank You!";
        return priceMessage;

    }
public void increment(View view){
        noofcoffee = noofcoffee+1;
        displayquintity(noofcoffee);

}


public void decrement(View view){

    noofcoffee = noofcoffee-1;

    displayquintity(noofcoffee);

}
    /**
     * This method displays the given quantity value on the screen.
     */




    /**
     * This method displays the given price on the screen.
     */



    /**
     * This method displays the given text on the screen.
     *
     */


    private void displayquintity(int numberOFCoffee){
    TextView quintityText= findViewById(R.id.quantity_text_view);
    quintityText.setText(""+numberOFCoffee);

    }
    private void displayMessage(String message) {
        TextView orderSummeryTextViw = (TextView) findViewById(R.id.order_summery_text_view);

        orderSummeryTextViw.setText(message);
    }
}