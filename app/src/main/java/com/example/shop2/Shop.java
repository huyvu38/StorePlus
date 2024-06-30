package com.example.shop2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Shop extends AppCompatActivity {
    //Khai bao cac product
    private DatabaseReference mDatabase;
    int [] image = {R.drawable.product1, R.drawable.product2,
            R.drawable.product3, R.drawable.product4,
            R.drawable.product5, R.drawable.product6,
            R.drawable.product7, R.drawable.product8};

    String [] name = {"T-shirt", "Sunscreen", "Laptop", "Phone",
            "Teddy bear", "Glasses", "Headphone", "Backpack"};
    Double [] price = {20.4, 10.0, 999.99, 550.0, 10.0, 30.0, 20.0, 25.0};

    String [] information = {"T-shirt for male with an affordable price",
                             "Sunscreen from shop brand skin1004 to protect you from sun",
                             "Macbook 128GB",
                             "Iphone 16 Pro Max 256GB",
                             "Capybara for children",
                             "Glasses",
                             "Listen to music with headphone from Lucky shop",
                             "Sale 20% for students when buying backpack during B2S day"};

    GridView gridView;
    ArrayList<Product> listProduct;
    ProductArrayAdapter arrayAdapter;

    EditText quantity;
    ImageView addView;
    ImageView removeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        //Gan bien
        listProduct = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Product product = new Product(name[i],image[i], price[i], information[i]);
            listProduct.add(product);
            //mDatabase.child("")
            mDatabase.child("Product" + String.valueOf(i+1)).setValue(product);
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