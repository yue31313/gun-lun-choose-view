package com.ycf.blog_06_chinesepickerdemo.Chinese;

import com.ycf.blog_06_chinesepickerdemo.R;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

public class ChinesePicker extends FrameLayout
{
	private final NumberPicker mWeekSpinner;
	private final NumberPicker mBeginSpinner;
	private final NumberPicker mEndSpinner;
    private String mWeek,mBegin,mEnd; 
    private OnChooseChangedListener mOnChooseChangedListener;

    private String[] week = { "��һ", "�ܶ�","����", "����", "����", "����", "����"};
    private String[] begin = { "��һ��", "�ڶ���","������", "���Ľ�", "�����", "������", "���߽�", "�ڰ˽�", "�ھŽ�", "��ʮ��"};
    private String[] end = { "��һ��", "�ڶ���","������", "���Ľ�", "�����", "������", "���߽�", "�ڰ˽�", "�ھŽ�", "��ʮ��"};
    
    public ChinesePicker(Context context)
	{
    	super(context);
    	 inflate(context, R.layout.chinesedialog, this);
    	 
    	 mWeekSpinner=(NumberPicker)this.findViewById(R.id.week);
    	 mWeekSpinner.setMaxValue(6);
    	 mWeekSpinner.setMinValue(0);
    	 mWeekSpinner.setDisplayedValues(week);
	     mWeekSpinner.invalidate();
    	 mWeekSpinner.setOnValueChangedListener(mOnWeekChangedListener);
    	 
    	 mBeginSpinner=(NumberPicker)this.findViewById(R.id.begin);
    	 mBeginSpinner.setMaxValue(9);
    	 mBeginSpinner.setMinValue(0);
    	 mBeginSpinner.setDisplayedValues(begin);
    	 mBeginSpinner.invalidate();
    	 mBeginSpinner.setOnValueChangedListener(mOnBeginChangedListener);
    	 
    	 mEndSpinner=(NumberPicker)this.findViewById(R.id.end);
    	 mEndSpinner.setMaxValue(9);
    	 mEndSpinner.setMinValue(0);
    	 mEndSpinner.setDisplayedValues(end);
    	 mEndSpinner.invalidate();
    	 mEndSpinner.setOnValueChangedListener(mOnEndChangedListener);
	}
    
    private NumberPicker.OnValueChangeListener mOnWeekChangedListener=new OnValueChangeListener()
	{
		@Override
		public void onValueChange(NumberPicker picker, int oldVal, int newVal)
		{
			setContent();
		}
	};
    
    private NumberPicker.OnValueChangeListener mOnBeginChangedListener=new OnValueChangeListener()
	{
		@Override
		public void onValueChange(NumberPicker picker, int oldVal, int newVal)
		{
			setContent();
		}
	};
	
	  private NumberPicker.OnValueChangeListener mOnEndChangedListener=new OnValueChangeListener()
		{
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal)
			{
				setContent();
			}
		};
	
		
	public void setContent()
	{
		mWeek=week[mWeekSpinner.getValue()];
		mBegin=begin[mBeginSpinner.getValue()];
		mEnd=end[mEndSpinner.getValue()];
		onChooseChanged();
	}
		
	  public interface OnChooseChangedListener 
	  {
	     void onChooseChanged(ChinesePicker view, String week, String begin, String end);
	  }
	
	  public void setOnChooseChangedListener(OnChooseChangedListener callback) 
	  {
	        mOnChooseChangedListener = callback;
	  }
	  
	  private void onChooseChanged() 
	  {
        if (mOnChooseChangedListener != null)
        {
            mOnChooseChangedListener.onChooseChanged(this, mWeek,mBegin, mEnd);
        }
	  }
}
