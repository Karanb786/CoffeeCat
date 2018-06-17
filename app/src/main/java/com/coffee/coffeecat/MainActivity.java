package com.coffee.coffeecat;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int noofcoffee=2;
    String email = "karanbagle420@gmail.com";


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

        int price = calculatePrice(hascheamBox,haschoco);
        String priceMessage =createOrderSummery(name, price, hascheamBox,haschoco);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order for "+name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        displayMessage(priceMessage);





    }

    private int calculatePrice(boolean addCream , boolean addChoo) {
        int basePrice = 5;
         if(addCream){
             basePrice = basePrice+1;
         }
         if(addChoo){
             basePrice=basePrice+2;
         }
        return noofcoffee* basePrice;
    }

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
        if(noofcoffee==10){
            Toast.makeText(this,"You canot order more then 10 coffee",Toast.LENGTH_SHORT).show();
            return;
        }

        noofcoffee = noofcoffee+1;
        displayquintity(noofcoffee);

}


public void decrement(View view){
        if(noofcoffee==1){
            Toast.makeText(this,"You must order more then 1 coffee",Toast.LENGTH_SHORT).show();
            return;

        }

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