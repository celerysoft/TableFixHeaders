package com.celerysoft.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.celerysoft.demo.adapters.MatrixTableAdapter;
import com.celerysoft.demo.adapters.MatrixTableAdapter2;
import com.celerysoft.demo.bean.Human;
import com.celerysoft.tablefixheaders.TableFixHeaders;

import java.util.ArrayList;

public class SimpleTable extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);

		TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
		final MatrixTableAdapter<String> matrixTableAdapter = new MatrixTableAdapter<String>(
				this, new String[][] {
						{ "Row&Column -1", "Column 0", "Column 1", "Column 2",
								"Column 3", "Column 4" },
						{ "Row 0", "sed", "do", "eiusmod", "tempor",
								"incididunt" },
						{ "Row 1", "irure", "occaecat", "enim", "laborum",
								"reprehenderit" },
						{ "Row 2", "fugiat", "nulla", "reprehenderit",
								"laborum", "consequat" },
						{ "Row 3", "consequat", "laborum", "fugiat", "eiusmod",
								"enim" },
						{ "Row 4", "nulla", "Excepteur", "voluptate",
								"occaecat", "et" },
						{ "Row 5", "occaecat", "fugiat", "dolore",
								"consequat", "eiusmod" },
						{ "Row 6", "fugiat", "Excepteur", "occaecat",
								"fugiat", "laborum" },
						{ "Row 7", "voluptate", "reprehenderit", "Excepteur",
								"fugiat", "nulla" }, });
		tableFixHeaders.setRowSelectable(true);
		tableFixHeaders.setAdapter(matrixTableAdapter);

		tableFixHeaders.setOnItemClickListener(new TableFixHeaders.OnItemClickListener() {
			@Override
			public void onItemClick(TableFixHeaders parent, View view, int row, int column, long id) {
				Toast.makeText(SimpleTable.this, matrixTableAdapter.getInformation(row, column), Toast.LENGTH_SHORT).show();
			}
		});
	}
}
