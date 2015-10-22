package appbaac.tawan.baacrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by BAAC on 21/10/2015.
 */
public class MyAdapter extends BaseAdapter {    //2. add extend BaseAdapter then alt+enter choose 1 OK

    //Explicit
    private Context objContext;
    private  String[] sourceStrings, foodStrings, priceStrings;

    public MyAdapter(Context objContext, String[] sourceStrings, String[] foodStrings, String[] priceStrings) {

        //1.constructor Alt+Insert then ( all choose )

        this.objContext = objContext;
        this.sourceStrings = sourceStrings;
        this.foodStrings = foodStrings;
        this.priceStrings = priceStrings;
    }

    @Override
    public int getCount() {
        return foodStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //3.
        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView1 = objLayoutInflater.inflate(R.layout.food_listview, viewGroup, false);

        //For Show Food
        TextView foodTextView = (TextView) objView1.findViewById(R.id.txtShowFood);
        foodTextView.setText(foodStrings[i]);


        //For Show Price
        TextView priceTextView = (TextView) objView1.findViewById(R.id.txtShowPrice);
        priceTextView.setText(priceStrings[i]);

        //For Icon
        ImageView iconImageView = (ImageView) objView1.findViewById(R.id.imvicon); //alt+enter cast to show(ImageView auto)
        Picasso.with(objContext).
                load(sourceStrings[i]).
                resize(120, 120).
                into(iconImageView);


        return objView1;
    }
}   // Main Class
