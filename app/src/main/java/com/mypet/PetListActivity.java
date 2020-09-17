package com.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class PetListActivity extends AppCompatActivity {
	
	String[] nameArray = {"Cat","Dog","Hamster" };
	
	Integer[] imageArray = {R.drawable.cat_button,
				R.drawable.dog_button,
				R.drawable.hamster_btn,
				};
	
	ListView listView;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_pet_list );
		
		CustomListAdapter whatever = new CustomListAdapter(this, nameArray, imageArray);
		listView = (ListView) findViewById(R.id.petListView);
		listView.setAdapter(whatever);
	}
}