package com.celerysoft.demo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import com.celerysoft.demo.adapters.SampleTableAdapter;
import com.celerysoft.tablefixheaders.TableFixHeaders;

public class StyleTable extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);

		TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
		tableFixHeaders.setRowSelectable(true);
		tableFixHeaders.setAdapter(new MyAdapter(this));
	}

	public class MyAdapter extends SampleTableAdapter
	{

		private final int width;
		private final int height;

		private final int VIEW_TYPE_HEADER = 0;
		private final int VIEW_TYPE_ITEM = 1;
		private final int VIEW_TYPE_COUNT = 2;

		public MyAdapter(Context context)
		{
			super(context);

			Resources resources = context.getResources();

			width = resources.getDimensionPixelSize(R.dimen.table_width);
			height = resources.getDimensionPixelSize(R.dimen.table_height);
		}

		@Override
		public int getRowCount()
		{
			return 20;
		}

		@Override
		public int getColumnCount()
		{
			return 10;
		}

		@Override
		public int getWidth(int column)
		{
			return width;
		}

		@Override
		public int getHeight(int row)
		{
			return height;
		}

		@Override
		public String getCellString(int row, int column)
		{
			return "Lorem (" + row + ", " + column + ")";
		}

		@Override
		public int getLayoutResource(int row, int column)
		{
			final int layoutResource;
			switch (getItemViewType(row, column)) {
			case VIEW_TYPE_HEADER:
				layoutResource = R.layout.item_style_table_header;
				break;
			case VIEW_TYPE_ITEM:
				layoutResource = R.layout.item_style_table;
				break;
			default:
				throw new RuntimeException("wtf?");
			}
			return layoutResource;
		}

		@Override
		public int getItemViewType(int row, int column)
		{
			if (row < 0) {
				return VIEW_TYPE_HEADER;
			} else {
				return VIEW_TYPE_ITEM;
			}
		}

		@Override
		public int getViewTypeCount()
		{
			return VIEW_TYPE_COUNT;
		}

		@Override
		public int getBackgroundResId(int row, int column)
		{
			final int backgroundResource;
			switch (getItemViewType(row, column)) {
			case VIEW_TYPE_HEADER:
				backgroundResource = R.drawable.item_style_table_header;
				break;
			case VIEW_TYPE_ITEM:
				backgroundResource = R.drawable.item_style_table;
				break;
			default:
				throw new RuntimeException("wtf?");
			}
			return backgroundResource;
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
			return null;
		}
	}
}
