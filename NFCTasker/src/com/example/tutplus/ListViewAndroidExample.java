package com.example.tutplus;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;




public class ListViewAndroidExample extends Activity {
	 ListView listView ;
	 
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_android_example);
        listView = (ListView) findViewById(R.id.list);
        
        // Defined Array values to show in ListView
        String[] values = new String[] { "Wifi Off", 
                                         "Wifi On",
                                         "Silent",
                                         "General", 
                                         "Home mode (wifi on+ ringer)", 
                                         "Work mode (wifi off+ silent)", 
                                         "Bluetooth Off", 
                                         "Bluetooth On"
                                        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter); 
        
        // ListView Item Click Listener
        listView.setOnItemClickListener(new OnItemClickListener() {

              public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
                
               // ListView Clicked item index
               int itemPosition     = position;
               
               // ListView Clicked item value
               //String  itemValue    = (String) listView.getItemAtPosition(position);
                  
                // Show Alert 
                //Toast.makeText(getApplicationContext(),
                 // "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                  //.show();
               
               String t = String.valueOf(itemPosition);
            	   Intent myintent=new Intent(ListViewAndroidExample.this, Write.class).putExtra("Value", t);
            	   startActivity(myintent);
               
             
              }

         }); 
    }

    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
