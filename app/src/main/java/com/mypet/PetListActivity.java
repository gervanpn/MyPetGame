package com.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mypet.Helpers.DBHelper;

import java.util.ArrayList;

public class PetListActivity extends AppCompatActivity {

	Button addPet;
	
	ArrayList<String> nameArray = new ArrayList<String>();
	ArrayList<Integer> imagesArray = new ArrayList<Integer>();
	ArrayList<Integer> imageArray = new ArrayList<Integer>();
	
	ListView listView;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_pet_list );
		
		listView = findViewById(R.id.petListView);
		addPet = findViewById(R.id.btn_addPet);
		
		DBHelper myDb = new DBHelper( this );
		
		Cursor data = myDb.getAllData();
		data.moveToFirst();
		
		if (data.getCount() > 0 ) {
			for (int rows = 0; rows < data.getCount(); rows++) {
				for ( int i = 0 ; i < data.getColumnNames().length ; i++ ) {
				
					String tmp = data.getString( i );
					if ( data.getColumnName( i ).equals( "ID" ) ) {
					} else {
						if ( data.getColumnName( i ).equals( "NAME" ) ) nameArray.add( tmp );
						if ( data.getColumnName( i ).equals( "TYPE" ) ) {
							switch (tmp){
								case "Cat":
									imagesArray.add(R.drawable.cat_button);
									break;
								case "Dog":
									imagesArray.add(R.drawable.dog_button);
									break;
								case "Hamster":
									imagesArray.add(R.drawable.hamster_button );
									break;
							}
						}
					}
				}
				data.moveToNext();
			}
			data.close();
		}
		
		CustomListAdapter whatever = new CustomListAdapter(this,nameArray , imagesArray);
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