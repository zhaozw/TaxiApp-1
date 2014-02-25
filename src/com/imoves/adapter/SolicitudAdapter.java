package com.imoves.adapter;

 
import com.imoves.taxitools.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SolicitudAdapter extends BaseAdapter{

	private LayoutInflater inflater;
	private final Context context;
	String[] name;
	public SolicitudAdapter(Context context, String[] name) {
		this.inflater = LayoutInflater.from(context);
		this.context = context;		
		this.name = name;		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return name.length;
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
			view = inflater.inflate(R.layout.item_list_productos_personal, null);
			holder = new ViewHolder();
			holder.text = (TextView) view.findViewById(R.id.textTituloCategoria);		
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		
		holder.text.setText(name[position]);
		
		return view;
	}
	
	private class ViewHolder {
		public TextView text;

	}

}
