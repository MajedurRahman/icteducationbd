package com.design.capstone.icteducationbd;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;


/**
 * Created by Majedur Rahman on 8/10/2017.
 */

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.ViewHolder> {


    private final Context context;
    private final LayoutInflater layoutInflater;
    ArrayList<Model> modelArrayList = new ArrayList<>();


    public CategoryRecyclerAdapter(Context mcontext, ArrayList<Model> foodItems) {
        this.context = mcontext;
      layoutInflater = LayoutInflater.from(context);
        modelArrayList = foodItems;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View foodItemView = layoutInflater.inflate(R.layout.food_item, parent, false);
        return new ViewHolder(foodItemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Model foodItem = modelArrayList.get(position);

        holder.itemPosition = position;
        holder.foodNameTV.setText(foodItem.getName().toString());
        holder.foodImage.setBackgroundResource(foodItem.getImage());

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        public final TextView foodNameTV;
        public final ImageView foodImage;
        int itemPosition;

        public ViewHolder(View itemView) {
            super(itemView);

            foodNameTV = (TextView) itemView.findViewById(R.id.foodNameTV);
            foodImage = (ImageView) itemView.findViewById(R.id.foodImage);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    switch (itemPosition) {


                        case 0:

                            context.startActivity(new Intent(context, MainActivity.class));
                            break;
                        case 1:

                            context.startActivity(new Intent(context, RegisterActivity.class));
                            break;
                        case 2:

                            context.startActivity(new Intent(context, LoginActivity.class));
                            break;
                        case 3:



                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                            // set title

                            alertDialogBuilder.setTitle("Exit Warning");
                            alertDialogBuilder.setIcon(android.R.drawable.stat_sys_warning);

                            // set dialog message
                            alertDialogBuilder
                                    .setMessage("Do You Want To Exit App")
                                    .setCancelable(false)
                                    .setPositiveButton("EXIT",new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {

                                            ///Dailog
                                            android.os.Process.killProcess(android.os.Process.myPid());
                                            System.exit(1);
                                        }
                                    })
                                    .setNegativeButton("NO",new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            // if this button is clicked, just close
                                            // the dialog box and do nothing
                                            dialog.cancel();
                                        }
                                    });

                            // create alert dialog
                            AlertDialog alertDialog = alertDialogBuilder.create();



                            // show it
                            alertDialog.show();

                            break;


                    }

                }
            });


        }
    }
}
