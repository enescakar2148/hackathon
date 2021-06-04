package com.hackathon.hackathon_app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hackathon.hackathon_app.R;

import org.jetbrains.annotations.NotNull;

public class SssFragment extends Fragment {
    private EditText soruedittext;
    private Context mContext;

    public SssFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sss_fragment,container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    public void sorugonder(View view){
        String soru = soruedittext.getText().toString();
        Toast.makeText(mContext, soru+ " bize ulaştı.", Toast.LENGTH_SHORT).show();
    }
}
