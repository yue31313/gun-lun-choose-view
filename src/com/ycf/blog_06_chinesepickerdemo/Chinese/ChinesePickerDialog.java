package com.ycf.blog_06_chinesepickerdemo.Chinese;
import com.ycf.blog_06_chinesepickerdemo.Chinese.ChinesePicker.OnChooseChangedListener;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class ChinesePickerDialog extends AlertDialog implements OnClickListener
{
    private ChinesePicker mChoosePicker;
    private String mWeek="周一";
    private String mBegin="第一节";
    private String mEnd="第一节";
    
    private OnChooseSetListener mOnChooseSetListener;
    
	@SuppressWarnings("deprecation")
	public ChinesePickerDialog(Context context) 
	{
		super(context);
		mChoosePicker = new ChinesePicker(context);
	    setView(mChoosePicker);
	    
	    mChoosePicker.setOnChooseChangedListener(new OnChooseChangedListener()
		{
			@Override
			public void onChooseChanged(ChinesePicker view, String week, String begin, String end)
			{
				mWeek=week;
				mBegin=begin;
				mEnd=end;
				updateTitle(mWeek,mBegin,mEnd); 		
			}
		});
	    
	    setButton("设置", this);
        setButton2("取消", (OnClickListener)null);
        updateTitle(mWeek,mBegin,mEnd); 
	}
	
	public interface OnChooseSetListener 
    {
        void OnChooseSet(AlertDialog dialog, String week,String begin, String end);
    }
	
	private void updateTitle(String week,String begin,String end) 
    {
        setTitle("您选择的是："+week+" "+begin+"到"+end);
    }
	
	public void setOnChooseSetListener(OnChooseSetListener callBack)
    {
        mOnChooseSetListener = callBack;
    }
	 
	public void onClick(DialogInterface arg0, int arg1)
    {
        if (mOnChooseSetListener != null) 
        {
            mOnChooseSetListener.OnChooseSet(this, mWeek,mBegin,mEnd);
        }
    }
}
