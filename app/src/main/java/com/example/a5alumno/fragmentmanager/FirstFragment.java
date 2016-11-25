package com.example.a5alumno.fragmentmanager;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class FirstFragment extends Fragment implements View.OnClickListener {

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragView = inflater.inflate(R.layout.fragment_first, container, false);
        final Button upd1 = (Button) fragView.findViewById(R.id.firstFragmentButton);
        upd1.setOnClickListener(this);
        return fragView;

//        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.firstFragmentButton){
            //Enviar datos al otro Fragment.
            this.mFirstFragCallback.onCommFromFragmentOne(new Random().nextInt(100));
        }
    }

    public interface OnFirstFragmentInterface {
        void onCommFromFragmentOne(long rNumber);
    }

    private OnFirstFragmentInterface mFirstFragCallback;

//    @Override
//    public void onAttach(Activity hostActivity){
//        super.onAttach(hostActivity);
//    try{
//        this.mFirstFragCallback = (OnFirstFragmentInterface) hostActivity;
//    } catch(ClassCastException e){
//        throw new ClassCastException(this.getActivity().toString()
//                + " must implement OnFirstFragmentInferface");}
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.mFirstFragCallback = (OnFirstFragmentInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(this.getActivity().toString()
                    + " must implement OnFirstFragmentInferface");
        }
    }

}
