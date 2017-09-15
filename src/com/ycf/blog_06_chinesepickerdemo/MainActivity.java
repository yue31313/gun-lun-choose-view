package com.ycf.blog_06_chinesepickerdemo;

import com.ycf.blog_06_chinesepickerdemo.Chinese.ChinesePickerDialog;
import com.ycf.blog_06_chinesepickerdemo.Chinese.ChinesePickerDialog.OnChooseSetListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private Button btn_choose;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_choose=(Button)this.findViewById(R.id.btn_choose);
		btn_choose.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog();
			}
		});
	}
	public void showDialog()
	{
		ChinesePickerDialog dialog  = new ChinesePickerDialog(this);
		dialog.setOnChooseSetListener(new OnChooseSetListener()
		{
			public void OnChooseSet(AlertDialog dialog, String week, String begin, String end)
			{
				Toast.makeText(MainActivity.this, "ÄúÑ¡ÔñµÄÊÇ£º"+week+" "+begin+"-"+end, Toast.LENGTH_LONG).show();
			}
		});
		dialog.show();
	}
}
