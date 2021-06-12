package com.melvinson.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	LinearLayout mainMenuButtons; // 主菜单

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mainMenuButtons = findViewById(R.id.main_menu_buttons);

		// 点击事件 3. 实例化（创建对象）一个OnClick对象。
		OnClick onClick = new OnClick();

		// 遍历主菜单控件
		for (int i = 0; i < mainMenuButtons.getChildCount(); i++) {
			// 点击事件 4. 找到需要设置点击事件的控件
			// 点击事件 5. 把，刚才创建好的 onClick 对象传递给 setOnClickListener 方法。
			// OnClick < View.OnClickListener 的儿子。
			mainMenuButtons.getChildAt(i).setOnClickListener(onClick);
		}
	}

	// 点击事件 1. 创建一个内部类 OnClick （类名字随意），实现 View.OnClickListener 接口
	private class OnClick implements View.OnClickListener {
		// 点击事件 2. 重写 OnClickListener 的方法 onClick
		@Override
		public void onClick(View v) {
			// 页面跳转 1. 声明一个 Intent 变量
			Intent intent = null;
			switch (v.getTag().toString()) {
				case "main_menu_linear_layout_demo":
					// 页面跳转 2. 设置目的地
					// 把当前 Activity 上下文 (Context) 也就是 this 传递进第一个参数。然后目的地 Activity 的 class 传递给第二个参数
					intent = new Intent(MainActivity.this, LinearLayoutDemoActivity.class); // 创建一个 Intent 对象
					break;
				default:
					break;
			}
			// 页面跳转 3. 跳转到该页面
			// 当点击的按钮有效
			if (intent != null) {
				startActivity(intent);
			} else {
				Toast.makeText(MainActivity.this, "当前按钮是无效的", Toast.LENGTH_SHORT).show();
			}
		}
	}
}