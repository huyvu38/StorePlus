package com.example.shop2;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductArrayAdapter extends ArrayAdapter<Product> {
    private Activity context;
    private int textViewResourceId;
    private ArrayList<Product> listProduct;
    static HashMap<Integer, Integer> quantities; // Store quantities

    public ProductArrayAdapter(Activity context, int textViewResourceId, ArrayList<Product> listProduct) {
        super(context, textViewResourceId, listProduct);
        this.context = context;
        this.textViewResourceId = textViewResourceId;
        this.listProduct = listProduct;
        this.quantities = new HashMap<>();
    }
    //Get view
    @Override
    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView = layoutInflater.inflate(textViewResourceId, parent, false);
        }

        // Get product
        Product product = listProduct.get(position);

        // Anh xa
        ImageView image = convertView.findViewById(R.id.image_item);
        image.setImageResource(product.getImage());

        TextView quantity = convertView.findViewById(R.id.textViewQuantity);
        int currentQuantity = quantities.getOrDefault(position, 0);
        quantity.setText(String.valueOf(currentQuantity));


        ImageView addItem = convertView.findViewById(R.id.imageView5);

        ImageView deleteItem = convertView.findViewById(R.id.imageView6);

        addItem.setOnClickListener(v -> {
            int number = quantities.getOrDefault(position, 0);
            number++;
            quantities.put(position, number);
            quantity.setText(String.valueOf(number));
        });

        deleteItem.setOnClickListener(v -> {
            int number = quantities.getOrDefault(position, 0);
            if (number > 0) {
                number--;
                quantities.put(position, number);
                quantity.setText(String.valueOf(number));
            }
        });

        TextView textViewName = convertView.findViewById(R.id.txtName);
        textViewName.setText(product.getName());

        TextView textViewInformation = convertView.findViewById(R.id.txtInformation);
        textViewInformation.setText("USD" + product.getPrice() + "   Sell : " + product.getNumSell());

        return convertView;
    }

}