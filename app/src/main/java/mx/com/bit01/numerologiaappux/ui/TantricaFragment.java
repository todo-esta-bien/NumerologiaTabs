package mx.com.bit01.numerologiaappux.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.com.bit01.numerologiaappux.R;
import mx.com.bit01.numerologiaappux.models.TantricNum;
import mx.com.bit01.numerologiaappux.utils.Constants;


/**
 * A simple {@link Fragment} subclass.
 */
public class TantricaFragment extends Fragment {

    private int mSoul, mKarma, mTalent, mDestinty, mPath, mCosmicAge;

    @BindView(R.id.tvValSoulFragment)
    TextView tvSoul;

    @BindView(R.id.tvValKarmaFragment)
    TextView tvKarma;

    @BindView(R.id.tvValTalentFragment)
    TextView tvTalent;

    @BindView(R.id.tvValDestinyFragment)
    TextView tvDestiny;

    @BindView(R.id.tvValPathFragment)
    TextView tvPath;

    @BindView(R.id.tvValCosmicAgeFragment)
    TextView tvCosmicAge;

    public TantricaFragment() {
        // Required empty public constructor
    }

    public static TantricaFragment newInstance(TantricNum tantricNum){

        TantricaFragment tantricaFragment = new TantricaFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.TAG_FRAGMENT_TANTRIC,tantricNum);
        tantricaFragment.setArguments(args);
        return tantricaFragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){

            Bundle args = getArguments();
            TantricNum tantricNum = (TantricNum)args.getParcelable(Constants.TAG_FRAGMENT_TANTRIC);
            mSoul = tantricNum.getSoul();
            mKarma = tantricNum.getKarma();
            mTalent = tantricNum.getTalent();
            mDestinty = tantricNum.getDestinty();
            mPath = tantricNum.getPath();
            mCosmicAge = tantricNum.getCosmicAge();

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tantrica, container, false);
        ButterKnife.bind(this,view);
        tvSoul.setText(mSoul+"");
        tvKarma.setText(mKarma+"");
        tvTalent.setText(mTalent+"");
        tvDestiny.setText(mDestinty+"");
        tvPath.setText(mPath+"");
        tvCosmicAge.setText(mCosmicAge+"");
        return view;
    }

}
