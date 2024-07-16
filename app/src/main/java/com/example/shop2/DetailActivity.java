package com.example.shop2;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    TextView textName;
    TextView textPrice;
    TextView textInformation;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        textName = findViewById(R.id.textName2);
        textPrice = findViewById(R.id.textPrice2);
        textInformation = findViewById(R.id.textDetail);
        image = findViewById(R.id.image2);

        Intent intent = getIntent();
        int img = intent.getIntExtra("image", 0);
        image.setImageResource(img);
        double price = intent.getDoubleExtra("price", 1);
        textPrice.setText(String.valueOf(price));
        String information = intent.getStringExtra("information");
        textInformation.setText(information);
        String name = intent.getStringExtra("name");
        textName.setText(name);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}