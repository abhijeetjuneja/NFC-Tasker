package com.example.tutplus;




import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.widget.CompoundButton;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.Switch;
import android.widget.Toast;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;

public class wifi extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wifi);
		 moveTaskToBack(true);
		final String s= getIntent().getStringExtra("value");
		Integer x = Integer.valueOf(s);
		if(x==0)
		toggleWiFi(false);
		if(x==1)
			toggleWiFi(true);
		if(x==2)
			silent();
		if(x==3)
			general();
		if(x==4)
			homemode();
		if(x==5)
			workmode();
		if(x==6)
			setBluetooth(false);
		if(x==7)
			setBluetooth(true);
	}

	public void toggleWiFi(boolean status) {
		WifiManager wifiManager = (WifiManager) this
				.getSystemService(Context.WIFI_SERVICE);
		if (status == true && !wifiManager.isWifiEnabled()) {
			wifiManager.setWifiEnabled(true);
		} else if (status == false && wifiManager.isWifiEnabled()) {
			wifiManager.setWifiEnabled(false);
		}
	}
	public void silent()
	{
		AudioManager audiomanage = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		audiomanage.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	}
	public void general()
	{
		AudioManager audiomanage = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		audiomanage.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	}
	public void homemode()
	{
		AudioManager audiomanage = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		audiomanage.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		toggleWiFi(true);
	}
	public void workmode()
	{
		AudioManager audiomanage = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		audiomanage.setRingerMode(AudioManager.RINGER_MODE_SILENT);
		toggleWiFi(false);
		
	}
	public static boolean setBluetooth(boolean enable) 
	{
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean isEnabled = bluetoothAdapter.isEnabled();
        if (enable && !isEnabled) {
            return bluetoothAdapter.enable(); 
        }
        else if(!enable && isEnabled) {
            return bluetoothAdapter.disable();
        }
        // No need to change bluetooth state
        return true;
    }
	
}

