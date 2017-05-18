package mx.com.bit01.numerologiaappux.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.com.bit01.numerologiaappux.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PitagoricaFragment extends Fragment {


    public PitagoricaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pitagorica, container, false);
    }

}
