package com.imoves.adapter;

 
import com.imoves.taxitools.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PersonasAdapter extends BaseAdapter{

	private LayoutInflater inflater;
	private final Context context;
	public PersonasAdapter(Context context) {
		this.inflater = LayoutInflater.from(context);
		this.context = context;		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		
		if (convertView == null) {
			view = inflater.inflate(R.layout.grid_item, null);
			holder = new ViewHolder();
			holder.text = (TextView) view.findViewById(R.id.txtItem);		
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		
		holder.text.setText("Persona "+position);
		
		return view;
	}
	
	private class ViewHolder {
		public TextView text;

	}

}
