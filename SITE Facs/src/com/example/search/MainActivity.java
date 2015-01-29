package com.example.search;

import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.sitefacs.R;

public class MainActivity extends Activity implements TextWatcher{

	AutoCompleteTextView myAutoComplete;

	ListView listView;
	static int index;
	String itemSelected;
	
	SharedPreferences pref;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        myAutoComplete = (AutoCompleteTextView)findViewById(R.id.myautocomplete);
        
        myAutoComplete.addTextChangedListener(this);
        myAutoComplete.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, CountriesList.countries));
        myAutoComplete.setOnItemClickListener(
        		new OnItemClickListener()
        		{

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int position, long arg3) {
						// TODO Auto-generated method stub
						itemSelected = (String) arg0.getItemAtPosition(position);
						index = Arrays.asList(CountriesList.countries).indexOf(itemSelected);
						getFromShaPref();
                        DialogFragment newFragment = new AddFacDialogFragment();
                        newFragment.show(getFragmentManager(), "myfrag");
						/*try {
						Class ourClass = Class.forName("com.example.search.ViewFac");
						Intent ourIntent = new Intent(MainActivity.this, ourClass);
						ourIntent.putExtra("facIndex", index);
						ourIntent.putExtra("sourceActivity", "MainActivity");
						startActivity(ourIntent);
						}
						catch(ClassNotFoundException e){
							e.printStackTrace();
						}*/
					}
        			
        });
        
        pref = getSharedPreferences(MyFacsList.fileName, MODE_PRIVATE);
        
        listView = (ListView) findViewById(R.id.lv_country);
        
        listView.setAdapter(new EfficientAdapter(this));
        
        listView.setOnItemClickListener(        
                new OnItemClickListener()
                {
                    @Override
                    
                    public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3) {
                        // TODO Auto-generated method stub
                        //Toast.makeText(getApplicationContext(),"You Selected "+CountriesList.countries[position], Toast.LENGTH_LONG).show();
                        index = position;
                        getFromShaPref();
                        DialogFragment newFragment = new AddFacDialogFragment();
                        newFragment.show(getFragmentManager(), "myfrag");
                    	/*try {
    						Class ourClass = Class.forName("com.example.search.ViewFac");
    						Intent ourIntent = new Intent(MainActivity.this, ourClass);
    						ourIntent.putExtra("facIndex", position);
    						ourIntent.putExtra("sourceActivity", "MainActivity");
    						startActivity(ourIntent);
    						}
    						catch(ClassNotFoundException e){
    							e.printStackTrace();
    						}*/
                    }
      
                }
                );
    }
	
	
	@Override
	public void afterTextChanged(Editable arg0) {
	 // TODO Auto-generated method stub

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
	  int after) {
	 // TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
	 // TODO Auto-generated method stub

	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nofacs, menu);
        return true;
    }
    
    /**
     * On selecting action bar icons
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
        case R.id.action_view:
            // search action
        	finish();
            return true;
        case android.R.id.home:
        	NavUtils.navigateUpFromSameTask(this);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    void saveToShaPref() {
    	SharedPreferences.Editor editor = pref.edit();
		for(int i=0;i<MyFacsList.name.size();i++)
		{
		         editor.putString("nameval"+i,MyFacsList.name.get(i));
		         editor.putString("locval"+i,MyFacsList.loc.get(i));
		         editor.putString("emailval"+i,MyFacsList.email.get(i));
		         editor.putString("desigval"+i,MyFacsList.desig.get(i));
		         editor.putString("genval"+i,MyFacsList.gen.get(i));
		         editor.putString("notesval"+i,MyFacsList.notes.get(i));
		}
		 editor.putInt("size",MyFacsList.name.size());
		 editor.commit();
	}
	
	void getFromShaPref(){
		MyFacsList.name.clear();
		MyFacsList.loc.clear();
		MyFacsList.email.clear();
		MyFacsList.desig.clear();
		MyFacsList.gen.clear();
		MyFacsList.notes.clear();
		
		int size = pref.getInt("size",0);
		String s = new String();
		for(int j=0;j<size;j++)
		{
		          s = pref.getString("nameval"+j, "hai");
		          MyFacsList.name.add(s);
		          s = pref.getString("locval"+j, "hello");
		          MyFacsList.loc.add(s);
		          s = pref.getString("emailval"+j, "hello");
		          MyFacsList.email.add(s);
		          s = pref.getString("desigval"+j, "hello");
		          MyFacsList.desig.add(s);
		          s = pref.getString("genval"+j, "hello");
		          MyFacsList.gen.add(s);
		          s = pref.getString("notesval"+j, "hello");
		          MyFacsList.notes.add(s);
		}
	}

}
