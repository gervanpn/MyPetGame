package com.mypet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter {
	
	//to reference the Activity
	private final Activity context;
	
	//to store the animal images
	private final Integer[] imageIDarray;
	
	//to store the list of countries
	//private final String[] nameArray;
	private ArrayList<String> nameArray = new ArrayList<String>();
	
	
	public CustomListAdapter(Activity context, ArrayList<String> nameArrayParam, Integer[] imageIDArrayParam){
		
		super(context,R.layout.listview_row , nameArrayParam);
		this.context=context;
		this.imageIDarray = imageIDArrayParam;
		this.nameArray = nameArrayParam;
	}
	
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater=context.getLayoutInflater();
		View rowView=inflater.inflate(R.layout.listview_row, null,true);
		
		//this code gets references to objects in the listview_row.xml file
		TextView nameTextField = (TextView) rowView.findViewById(R.id.textViewPetName);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewIcon);
		
		//this code sets the values of the objects to values from the arrays
		nameTextField.setText( nameArray.get( position ) );
		imageView.setImageResource(imageIDarray[position]);
		
		return rowView;
		
	};
}
