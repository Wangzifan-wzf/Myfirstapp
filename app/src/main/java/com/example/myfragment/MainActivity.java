package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonOne,buttonTwo;  //三个按钮
    private FragmentManager fragmentManager;  //Fragment 管理器
    private FragmentTransaction fragmentTransaction;  //Fragment 事务处理

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        buttonOne = (Button) findViewById(R.id.bt_one);
        buttonTwo = (Button) findViewById(R.id.bt_two);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);

        fragmentManager = getSupportFragmentManager(); //得到Fragment 管理器对象

        fragmentTransaction = fragmentManager.beginTransaction(); //开始fragmnet 的事务处理
        //初始化一个 fragment
        fragment_one fragment = new fragment_one(); //实例化 fragment
        fragmentTransaction.add(R.id.fragment_id, fragment); //fragment_id 是布局中给fragment 占位置的控
        fragmentTransaction.commit(); //提交事务
    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = fragmentManager.beginTransaction(); //开始fragmnet 的事务处理
        switch(v.getId()) {
            case R.id.bt_one:
                fragmentTransaction.replace(R.id.fragment_id,new fragment_one());  //加载第一个 fragment
                fragmentTransaction.addToBackStack(null);  //把 fragment one放到 栈队里  跳转后 返回键可返回
                break;
            case R.id.bt_two:
                fragmentTransaction.replace(R.id.fragment_id,new fragment_two());  //加载第二个 fragment
                fragmentTransaction.addToBackStack(null);  //把 fragment two放到 栈队里 跳转后返回键 可返回
                break;
            default:
                break;
        }

        fragmentTransaction.commit();//提交事务
    }
}