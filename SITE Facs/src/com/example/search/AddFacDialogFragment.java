package com.example.search;

import com.example.sitefacs.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddFacDialogFragment extends DialogFragment{

	TextView facName;
	TextView facLoc;
	TextView facDesig;
	TextView facEmail;
	Button facAdd;
	
	MainActivity activity;
	Context context;
	
	//int index;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		getDialog().setTitle("FACULTY DETAILS");
		View view = inflater.inflate(R.layout.dialog_viewfac, container, false);
		
		activity = (MainActivity) getActivity();
		context = activity.getBaseContext();
		//index = activity.getIndex();
		
		facName = (TextView) view.findViewById(R.id.tvName);
		facDesig = (TextView) view.findViewById(R.id.tvDesig);
		facLoc = (TextView) view.findViewById(R.id.tvLoc);
		facEmail = (TextView) view.findViewById(R.id.tvEmail);
		facAdd = (Button) view.findViewById(R.id.bAdd);
	    
		facName.setText(CountriesList.gen[activity.index] + " " + CountriesList.countries[activity.index]);
		facDesig.setText(CountriesList.designation[activity.index]);
		facLoc.setText(CountriesList.abbreviations[activity.index]);
		facEmail.setText(CountriesList.email[activity.index]);
		
		
		if(MyFacsList.name.contains(CountriesList.countries[activity.index]))
		{
			facAdd.setText("CLICK TO REMOVE");
		}
		else
		{
			facAdd.setText("CLICK TO ADD");
		}
		
	    
		facAdd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (facAdd.getText().equals("CLICK TO ADD"))
				{	
				MyFacsList.name.add(CountriesList.countries[activity.index]);
				MyFacsList.loc.add(CountriesList.abbreviations[activity.index]);
				MyFacsList.email.add(CountriesList.email[activity.index]);
				MyFacsList.desig.add(CountriesList.designation[activity.index]);
				MyFacsList.gen.add(CountriesList.gen[activity.index]);
				MyFacsList.notes.add("");
				Toast.makeText(context,"Prof. "+CountriesList.countries[activity.index]+" has been added to your list successfully.", Toast.LENGTH_LONG).show();
				}
				else if (facAdd.getText().equals("CLICK TO REMOVE"))
				{
					Toast.makeText(context,"Prof. "+CountriesList.countries[activity.index]+" has been removed from your list successfully.", Toast.LENGTH_LONG).show();
					MyFacsList.notes.remove(MyFacsList.email.indexOf(CountriesList.email[activity.index]));
					MyFacsList.name.remove(CountriesList.countries[activity.index]);
					MyFacsList.loc.remove(CountriesList.abbreviations[activity.index]);
					MyFacsList.email.remove(CountriesList.email[activity.index]);
					MyFacsList.desig.remove(CountriesList.designation[activity.index]);
					MyFacsList.gen.remove(CountriesList.gen[activity.index]);
				}
				activity.saveToShaPref();
				dismiss();
			}
		});
		
		return view;
	}



	/*@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    // Get the layout inflater
	    LayoutInflater inflater = getActivity().getLayoutInflater();

	    // Inflate and set the layout for the dialog
	    // Pass null as the parent view because its going in the dialog layout
	    builder.setView(inflater.inflate(R.layout.dialog_viewfac, null));
	    //facName = (TextView) getView().findViewById(R.id.tvName);
	    //facName.setText("Hello");
	    // Add action buttons
	           builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	                   // add fac to my facs ...
	               }
	           })
	           .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	                   AddFacDialogFragment.this.getDialog().cancel();
	               }
	           });      
	    return builder.create();
	}*/

}
