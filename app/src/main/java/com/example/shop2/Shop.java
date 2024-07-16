package com.example.shop2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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
    static ArrayList<Product> listProduct;
    ProductArrayAdapter arrayAdapter;

    ImageView cartImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        //Gan bien
        listProduct = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Product product = new Product(name[i], image[i], price[i], information[i]);
            listProduct.add(product);
            mDatabase.child("Product" + (i + 1)).setValue(product);
        }
        arrayAdapter = new ProductArrayAdapter(Shop.this, R.layout.activity_layout_item, listProduct);
        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Shop.this, DetailActivity.class);
                intent.putExtra("image", image[position]);
                intent.putExtra("price", price[position]);
                intent.putExtra("information", information[position]);
                intent.putExtra("name", name[position]);
                startActivity(intent); // Launch the DetailActivity
            }
        });
        cartImage = findViewById(R.id.cartImage);
        cartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shop.this, CartActivity.class);
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