package com.dvision.cardapp;

import android.content.Intent;
import android.os.Bundle;

import com.dvision.cardapp.interfaces.OnRecyclerViewItemClickListener;
import com.dvision.cardapp.pojo.ContactEntity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsActivity extends AppCompatActivity implements OnRecyclerViewItemClickListener {

    ContactEntity contact1 = new ContactEntity("John", "doe");
    ContactEntity contact2 = new ContactEntity("John", "doe");
    ContactEntity contact3 = new ContactEntity("John", "doe");

    public ContactEntity[] dataset = {contact1, contact2, contact3};

    private RecyclerView recyclerView;
    private ContactListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_layout);
        recyclerView = (RecyclerView) findViewById(R.id.contact_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter = new ContactListAdapter(dataset);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(ContactEntity contact) {
        Intent intent = new Intent(this, DossierActivity.class);
        //intent.putExtra("contact", contact);
        startActivityForResult(intent, 1);
    }
}
