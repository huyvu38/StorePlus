package com.example.shop2;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Shop extends AppCompatActivity {
    //Khai bao cac product
    int [] image = {R.drawable.product1, R.drawable.product2,
            R.drawable.product3, R.drawable.product4,
            R.drawable.product5, R.drawable.product6,
            R.drawable.product7, R.drawable.product8};

    String [] name = {"T-shirt", "Sunscreen", "Laptop", "Phone",
            "Teddy bear", "Glasses", "Headphone", "Backpack"};
    Double [] price = {20.4, 10.0, 999.99, 550.0, 10.0, 30.0, 20.0, 25.0};

    GridView gridView;
    ArrayList<Product> listProduct;
    ProductArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop);

        //Gan bien
        listProduct = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Product product = new Product(name[i],image[i], price[i]);
            listProduct.add(product);
        }
        arrayAdapter = new ProductArrayAdapter(Shop.this, R.layout.activity_layout_item, listProduct);
        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(arrayAdapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}