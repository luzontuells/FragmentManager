package com.example.a5alumno.fragmentmanager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondFragment extends Fragment{

    private TextView mFragmentTextView;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragView = inflater.inflate(R.layout.fragment_second, container, false);
        return fragView;

//        return inflater.inflate(R.layout.fragment_second, container, false);

    }



    //TODO: en algún sitio va this.myTextView.setText(INFO DEL OTRO FRAGMENT);
    public void updateTextInfo(String string){
        this.mFragmentTextView = (TextView) this.getView().findViewById(R.id.txtViewFragment2);
        this.mFragmentTextView.setText(string);
    }




//    public interface OnSecondFragmentInterface {
//        void onCommFromFragmentTwo(long rNumber);
//    }
//    private FirstFragment.OnFirstFragmentInterface mSecondFragCallback;
//
//    @Override
//    public void onAttach(Activity hostActivity){
//        super.onAttach(hostActivity);
//        try{
//            this.mSecondFragCallback = (FirstFragment.OnFirstFragmentInterface) hostActivity;
//        } catch(ClassCastException e){
//            throw new ClassCastException(this.getActivity().toString()
//                    + " must implement OnSecondFragmentInferface");}
//    }
}
