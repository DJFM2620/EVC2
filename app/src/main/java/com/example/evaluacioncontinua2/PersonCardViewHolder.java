package com.example.evaluacioncontinua2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class PersonCardViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView PersonImage;
    public TextView PersonName;
    public TextView PersonAge;
    public TextView PersonCountry;

    public PersonCardViewHolder(@NonNull View itemView) {

        super(itemView);

        PersonImage = itemView.findViewById(R.id.person_image);
        PersonName = itemView.findViewById(R.id.person_name);
        PersonAge = itemView.findViewById(R.id.person_age);
        PersonCountry = itemView.findViewById(R.id.person_country);
    }
}
