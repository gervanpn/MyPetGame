package com.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class PetListActivity extends AppCompatActivity {

	Button addPet;
	
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
		listView = findViewById(R.id.petListView);
		addPet = findViewById(R.id.btn_addPet);
		listView.setAdapter(whatever);

		addPet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(PetListActivity.this, SelectPet.class);
				startActivity(intent);
			}
		});
	}

}