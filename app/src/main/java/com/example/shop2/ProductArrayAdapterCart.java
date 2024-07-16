package com.example.shop2;
import static com.example.shop2.ProductArrayAdapter.quantities;
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

public class ProductArrayAdapterCart extends ArrayAdapter<Product> {
    private Activity context;
    private int textViewResourceId;
    private ArrayList<Product> listProduct;
    private double total;


    public ProductArrayAdapterCart(Activity context, int textViewResourceId, ArrayList<Product> listProduct) {
        super(context, textViewResourceId, listProduct);
        this.context = context;
        this.textViewResourceId = textViewResourceId;
        this.listProduct = listProduct;
        this.total = 0.0;
        calculateTotal();
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
        //Only display product in the cart with at least 1 item
        int quantity = quantities.getOrDefault(position, 0);
        ImageView image = convertView.findViewById(R.id.imageViewCart);
        image.setImageResource(product.getImage());

        TextView quantityCart = convertView.findViewById(R.id.textView14);
        quantityCart.setText(String.valueOf(quantity));

        TextView nameCart = convertView.findViewById(R.id.textView16);
        nameCart.setText(product.getName());

        TextView priceCart = convertView.findViewById(R.id.textView15);
        priceCart.setText(String.valueOf(product.getPrice()));
        return convertView;
    }
    /*
    public double total(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        // Get product
        Product product = listProduct.get(position);
        //Only display product in the cart with at least 1 item
        int quantity = quantities.getOrDefault(position, 0);
    }

     */

    public double getTotal() {
        return total;
    }
    // Calculate the total price for all items in the cart
    private void calculateTotal() {
        total = 0.0;
        for (int i = 0; i < listProduct.size(); i++) {
            Product product = listProduct.get(i);
            int quantity = quantities.getOrDefault(i, 0);
            total += product.getPrice() * quantity;
        }
    }
}