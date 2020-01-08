package com.dvision.cardapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dvision.cardapp.interfaces.OnRecyclerViewItemClickListener;
import com.dvision.cardapp.pojo.ContactEntity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactViewHolder> {
    private ContactEntity[] dataSet;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ContactViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView firstName;
        public TextView lastName;

        public ContactViewHolder(View view) {
            super(view);
            this.firstName = view.findViewById(R.id.firstName);
            this.lastName = view.findViewById(R.id.lastName);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ContactListAdapter(ContactEntity[] myDataset) {
        dataSet = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_item, parent, false);
        ContactViewHolder vh = new ContactViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.firstName.setText(dataSet[position].getFirsName());
        holder.lastName.setText(dataSet[position].getLastName());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    public void setListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}
