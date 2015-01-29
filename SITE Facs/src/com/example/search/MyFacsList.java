package com.example.search;

import java.util.ArrayList;
import java.util.Arrays;

//import android.app.Activity;
//import android.content.SharedPreferences;
//import android.content.SharedPreferences.Editor;
//import android.content.Context;
//import android.preference.PreferenceManager;

public class MyFacsList{
	public static ArrayList<String> name = new ArrayList<String>();
	public static ArrayList<String> loc = new ArrayList<String>();
	public static ArrayList<String> email = new ArrayList<String>();
	public static ArrayList<String> desig = new ArrayList<String>();
	public static ArrayList<String> gen = new ArrayList<String>();
	public static ArrayList<String> notes = new ArrayList<String>();
	//public static Context context;
	public static String fileName = "SiteFacs";
	/*SharedPreferences pref = getSharedPreferences(fileName, 0); // 0 - for private mode
	SharedPreferences.Editor editor = pref.edit();
	
	void saveToShaPref(){
		for(int i=0;i<name.size();i++)
		{
		         editor.putString("val"+i,name.get(i));
		}
		 editor.putInt("size",name.size());
		 editor.commit();
	}
	
	void getFromShaPref(){
		int size=pref.getInt("size",1);
		String s = new String();
		for(int j=0;j<size;j++)
		{
		          s = pref.getString("val"+j, "hai");
		          name.add(s);
		}
	}*/
}
