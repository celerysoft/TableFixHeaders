package com.celerysoft.demo.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.celerysoft.demo.R;
import com.celerysoft.tablefixheaders.adapter.BaseTableAdapter;

public class MatrixTableAdapter<T> extends BaseTableAdapter
{

	private final static int WIDTH_DIP = 110;
	private final static int HEIGHT_DIP = 32;

	private final Context context;

	private T[][] table;

	private final int width;
	private final int height;

	public MatrixTableAdapter(Context context)
	{
		this(context, null);
	}

	public MatrixTableAdapter(Context context, T[][] table)
	{
		this.context = context;
		Resources r = context.getResources();

		width = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, WIDTH_DIP, r.getDisplayMetrics()));
		height = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, HEIGHT_DIP, r.getDisplayMetrics()));

		setInformation(table);
	}

	public void setInformation(T[][] table)
	{
		this.table = table;
	}

	@Override
	public int getRowCount()
	{
		return table.length - 1;
	}

	@Override
	public int getColumnCount()
	{
		return table[0].length - 1;
	}

	@Override
	public View getView(int row, int column, View convertView, ViewGroup parent)
	{
		if (convertView == null) {
			convertView = new TextView(context);
			((TextView) convertView).setGravity(Gravity.CENTER_VERTICAL);
		}
		((TextView) convertView).setText(table[row + 1][column + 1].toString());
		return convertView;
	}

	@Override
	public int getHeight(int row)
	{
		return height;
	}

	@Override
	public int getWidth(int column)
	{
		return width;
	}

	@Override
	public int getItemViewType(int row, int column)
	{
		return 0;
	}

	@Override
	public int getViewTypeCount()
	{
		return 1;
	}

	@Override
	public int getBackgroundResId(int row, int column)
	{
		return 0;
	}

	@Override
	public int getBackgroundHighlightResId(int row, int column) {
		return R.drawable.item_highlight_rect;
	}

	@Override
	public boolean isRowSelectable(int row) {
		return true;
	}

	@Override
	public long getItemId(int row, int column) {
		return 0;
	}

	@Override
	public Object getItem(int row, int column) {
		if (row <= getRowCount() && column <= getColumnCount()) {
			return this.table[row][column];
		} else {
			return null;
		}
	}
}
