package com.example.shop2;
import static com.example.shop2.Shop.listProduct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class CartActivity extends AppCompatActivity {

    GridView gridView;
    ProductArrayAdapterCart arrayAdapterCart;
    TextView totalPriceTextView;
    TextView taxTextView;
    TextView priceAfter;
    Button checkOut;
    EditText addressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        arrayAdapterCart = new ProductArrayAdapterCart(CartActivity.this, R.layout.activity_layout_item_cart, listProduct);
        gridView = findViewById(R.id.gridCart);
        gridView.setAdapter(arrayAdapterCart);
        double total = arrayAdapterCart.getTotal();
        totalPriceTextView = findViewById(R.id.textView9);
        totalPriceTextView.setText(String.format("%.2f USD", total));
        taxTextView = findViewById(R.id.textView11);
        double tax = total * 0.1;
        taxTextView.setText(String.format("%.2f USD", tax));
        priceAfter = findViewById(R.id.textView13);
        double totalPriceWithTax = total + tax + 5;
        priceAfter.setText(String.format("%.2f USD", totalPriceWithTax));
        checkOut = findViewById(R.id.checkOutButton);

        addressText = findViewById(R.id.editTextTextPostalAddress);
        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalPriceWithTax > 5 && (addressText.getText().toString().isEmpty() == false)) {
                    Toast.makeText(CartActivity.this, "Order success",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CartActivity.this, "Order unsuccess",
                            Toast.LENGTH_SHORT).show();
                }
                //come back
                Intent intent = new Intent(CartActivity.this, Shop.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}