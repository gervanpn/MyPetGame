package com.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mypet.Enums.AnimalType;
import com.mypet.Helpers.DBHelper;

import java.util.ArrayList;

public class PetListActivity extends AppCompatActivity {

	Button addPet;
	
	//String[] nameArray;// = {"Cat","Dog","Hamster" };
	ArrayList<String> nameArray = new ArrayList<String>();
	ArrayList<Integer> imagesArray = new ArrayList<Integer>();
	
	ArrayList<Integer> imageArray = new ArrayList<Integer>();
	
	//ArrayList< AnimalType> animalTypes = new ArrayList<AnimalType>();
	
//	Integer[] imageArray = {R.drawable.cat_button,
//				R.drawable.dog_button,
//				R.drawable.hamster_btn,
//
//			R.drawable.cat_button,
//				R.drawable.dog_button,
//				R.drawable.hamster_btn,
//
//			R.drawable.cat_button,
//				R.drawable.dog_button,
//				R.drawable.hamster_btn,
//				};

	ListView listView;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_pet_list );
		
		
		listView = findViewById(R.id.petListView);
		addPet = findViewById(R.id.btn_addPet);
		
		
		DBHelper myDb = new DBHelper( this );
		
		Cursor data = myDb.getAllData();
		
			//for (int row = 0; row < data.getCount(); row++) {
			//for ( int index = 0 ; index < data.getColumnCount() ; index++ ) {
		data.moveToFirst();
		
		//System.out.println("Count -> " + data.getCount());
		//System.out.println("Column Count -> " + data.getColumnCount());
		//System.out.println("");
		if (data.getCount() > 0 ) {
			//do {
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
								imagesArray.add(R.drawable.hamster_btn);
								break;
						}
						
						//imagesArray.add (tmp);
					}
						//nameArray.add( tmp );
					//System.out.println( "Column Name -> " + data.getColumnName( i ) + " -> " + tmp );
				}
			}
			data.moveToNext();
			//if (data.isLast()) break;
			//} while ( ! data.moveToNext() );
		}
			data.close();
		}
		CustomListAdapter whatever = new CustomListAdapter(this,nameArray , imagesArray);//, animalTypes);
		listView.setAdapter(whatever);
				//data.moveToNext();
			//}
		//}
		//System.out.println("Data -> " + data.toString());
		
		addPet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(PetListActivity.this, SelectPet.class);
				startActivity(intent);
			}
		});
	}

}