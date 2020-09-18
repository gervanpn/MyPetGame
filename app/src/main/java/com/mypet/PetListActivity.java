package com.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.mypet.Enums.AnimalType;
import com.mypet.Helpers.DBHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PetListActivity extends AppCompatActivity {

	Button addPet;
	
	ArrayList<String> nameArray = new ArrayList<String>();
	ArrayList<Integer> imagesArray = new ArrayList<Integer>();
	ArrayList<String> animalArray = new ArrayList<String>();
	
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
									animalArray.add( AnimalType.Cat.toString());
									break;
								case "Dog":
									imagesArray.add(R.drawable.dog_button);
									animalArray.add( AnimalType.Dog.toString());
									break;
								case "Hamster":
									imagesArray.add(R.drawable.hamster_button );
									animalArray.add( AnimalType.Hamster.toString());
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
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
									long id) {
				Intent intent = new Intent(PetListActivity.this, PetData.class);
				intent.putExtra( "Name", nameArray.get(position) );
				intent.putExtra( "Type", animalArray.get(position) );
				System.out.println("name set -> " + nameArray.get(position));
				System.out.println("type set -> " + animalArray.get(position));
				System.out.println("image set -> " + String.format("%d", imagesArray.get(position)));
				//intent.putExtra( "Img", imagesArray.get(position) );
				startActivity(intent);
			}
		});
		addPet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(PetListActivity.this, SelectPet.class);
				startActivity(intent);
			}
		});
	}

}