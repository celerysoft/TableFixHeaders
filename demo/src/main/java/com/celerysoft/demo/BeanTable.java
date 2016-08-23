package com.celerysoft.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.celerysoft.demo.adapters.MatrixTableAdapter2;
import com.celerysoft.demo.bean.Human;
import com.celerysoft.tablefixheaders.TableFixHeaders;

import java.util.ArrayList;

public class BeanTable extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);

		TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);

		final MatrixTableAdapter2<Human> adapter = new MatrixTableAdapter2<>(this);

		ArrayList<Human> list = new ArrayList<>();

		Human human = new Human("Name", "Age", "Gender", "Height", "Weight", "ID", "VIP");
		Human human0 = new Human("Allen", "18", "Male", "1.81m", "85kg", "0001", "NO");
		Human human1 = new Human("Billy", "19", "Male", "1.92m", "95kg", "0002", "YES");
		Human human2 = new Human("Cindy", "20", "Female", "1.70m", "55kg", "0003", "YES");
		Human human3 = new Human("Dark", "21", "Male", "2.01m", "99kg", "0004", "NO");
		Human human4 = new Human("Elly", "22", "Female", "1.61m", "45kg", "0005", "YES");
		Human human5 = new Human("Forest", "23", "Male", "1.76m", "75kg", "0006", "NO");
		Human human6 = new Human("Gard", "24", "Female", "1.77m", "60kg", "0007", "YES");
		Human human7 = new Human("Holo", "25", "Male", "1.85m", "88kg", "0008", "NO");

		list.add(human);
		list.add(human0);
		list.add(human1);
		list.add(human2);
		list.add(human3);
		list.add(human4);
		list.add(human5);
		list.add(human6);
		list.add(human7);

		adapter.setData(list);

		tableFixHeaders.setRowSelectable(true);
		tableFixHeaders.setAdapter(adapter);
		tableFixHeaders.setOnItemClickListener(new TableFixHeaders.OnItemClickListener() {
			@Override
			public void onItemClick(TableFixHeaders parent, View view, int row, int column, long id) {
				//Toast.makeText(BeanTable.this, adapter.getItem(row).getAttribute(column).toString(), Toast.LENGTH_SHORT).show();
				Toast.makeText(BeanTable.this, adapter.getItem(row, column).toString(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}
