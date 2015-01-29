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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyFacDialogFragment extends DialogFragment{

	TextView facName;
	TextView facLoc;
	TextView facDesig;
	TextView facEmail;
	Button facAdd;
	
	Button bedit;
	EditText editnotes;
	InputMethodManager imm;
	Context context;
	
	MyFacs activity;
	
	//int index;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		getDialog().setTitle("FACULTY DETAILS");
		View view = inflater.inflate(R.layout.dialog_myfac, container, false);
		
		activity = (MyFacs) getActivity();
		//index = activity.getIndex();
		
		facName = (TextView) view.findViewById(R.id.tvName);
		facDesig = (TextView) view.findViewById(R.id.tvDesig);
		facLoc = (TextView) view.findViewById(R.id.tvLoc);
		facEmail = (TextView) view.findViewById(R.id.tvEmail);
		facAdd = (Button) view.findViewById(R.id.bAdd);
	    
		facName.setText(MyFacsList.gen.get(activity.index)+" "+MyFacsList.name.get(activity.index));
		facLoc.setText(MyFacsList.loc.get(activity.index));
		facEmail.setText(MyFacsList.email.get(activity.index));
		facDesig.setText(MyFacsList.desig.get(activity.index));
		facAdd.setText("CLICK TO REMOVE");
		
		bedit = (Button) view.findViewById(R.id.bEdit);
		editnotes = (EditText) view.findViewById(R.id.etNotes);
		editnotes.setText(MyFacsList.notes.get(activity.index));
		//editnotes.clearFocus();
		context = activity.getBaseContext();
		imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		
	    
		facAdd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Toast.makeText(context,"Prof. "+MyFacsList.name.get(activity.index)+" has been removed from your list successfully.", Toast.LENGTH_LONG).show();
				MyFacsList.notes.remove(MyFacsList.email.indexOf(MyFacsList.email.get(activity.index)));
				MyFacsList.name.remove(MyFacsList.name.get(activity.index));
				MyFacsList.loc.remove(MyFacsList.loc.get(activity.index));
				MyFacsList.email.remove(MyFacsList.email.get(activity.index));
				MyFacsList.desig.remove(MyFacsList.desig.get(activity.index));
				MyFacsList.gen.remove(MyFacsList.gen.get(activity.index));
				activity.saveToShaPref();
				dismiss();
			}
		});
		
			bedit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(bedit.getText().equals("EDIT"))
				{
					editnotes.setFocusableInTouchMode(true);
					imm.showSoftInput(editnotes, InputMethodManager.SHOW_IMPLICIT);
					
					bedit.setText("SAVE");
				}
				else
				{
					editnotes.setFocusable(false);
					imm.hideSoftInputFromWindow(editnotes.getWindowToken(), 0);
					//editnotes.setBackgroundColor(0); 
					MyFacsList.notes.set(MyFacsList.email.indexOf(MyFacsList.email.get(activity.index)), editnotes.getText().toString());
					activity.saveToShaPref();
					Toast.makeText(context,"Saved", Toast.LENGTH_LONG).show();
					bedit.setText("EDIT");
				}
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
