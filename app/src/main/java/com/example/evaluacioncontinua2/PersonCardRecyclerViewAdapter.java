package com.example.evaluacioncontinua2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacioncontinua2.network.ImageRequest;
import com.example.evaluacioncontinua2.network.PersonEntry;

import java.util.List;

public class PersonCardRecyclerViewAdapter extends RecyclerView.Adapter<PersonCardViewHolder> {

    private List<PersonEntry> personList;
    private ImageRequest imageRequest;

    PersonCardRecyclerViewAdapter(List<PersonEntry> personList){

        this.personList = personList;
        imageRequest = ImageRequest.getInstance();
    }

    @NonNull
    @Override
    public PersonCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_card, parent, false);

        return new PersonCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonCardViewHolder holder, int position) {

        if(personList != null && position < personList.size()){

            PersonEntry person = personList.get(position);

            holder.PersonName.setText(person.Name);
            holder.PersonAge.setText(person.Age);
            holder.PersonCountry.setText(person.Country);
            imageRequest.setImageFromUrl(holder.PersonImage, person.Url);
        }
    }

    @Override
    public int getItemCount() {

        return personList.size();
    }
}
