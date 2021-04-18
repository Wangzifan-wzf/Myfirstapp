package com.example.myfragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class fragment_one extends Fragment implements View.OnClickListener{
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);

        textView = (TextView) view.findViewById(R.id.text_one_id);
        textView.setOnClickListener(this);

        //这里就是把view返回给MainActivity里的方法
        return view;
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick (View v){
        System.out.println("lum_1 点击 fragme_1");
        switch (v.getId()) {
            case R.id.text_one_id:
                break;
            default:
                break;
        }

    }
}