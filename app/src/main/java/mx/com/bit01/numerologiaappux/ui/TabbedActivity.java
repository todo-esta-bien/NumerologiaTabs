package mx.com.bit01.numerologiaappux.ui;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;
import mx.com.bit01.numerologiaappux.R;
import mx.com.bit01.numerologiaappux.models.Person;
import mx.com.bit01.numerologiaappux.utils.Constants;

public class TabbedActivity extends AppCompatActivity implements MaterialTabListener {

    private ViewPager pager;
    private ViewPagerAdapter pagerAdapter;
    MaterialTabHost tabHost;
    String[] tabNames;

    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        tabNames = new String[]{this.getResources().getString(R.string.numPit), this.getResources().getString(R.string.numTant)}; //Todas las tabs de la actividad

        //Inicia Traer los datos del usuario

        Person extras = (Person) getIntent().getParcelableExtra(Constants.TAG_PERSON);
        if(extras!=null){

            person = (Person) getIntent().getParcelableExtra(Constants.TAG_PERSON);
            person.setTantricNum(person.getmDay(),person.getmMonth(),person.getmYear());
            Toast.makeText(this, person.toString(), Toast.LENGTH_LONG).show();

        }

        //Termina traer datos del usuario

        //Inicias config de la toolbar
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.tabbedActivityTitle));
        toolbar.setTitleTextColor(Color.WHITE);
        this.setSupportActionBar(toolbar);
        //Terminas config de la toolbar

        //Inicas config del tabhost
        tabHost = (MaterialTabHost) this.findViewById(R.id.tabHost);
        pager = (ViewPager) this.findViewById(R.id.pager);
        // init view pager
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                tabHost.setSelectedNavigationItem(position);
            }
        });

        for (int i = 0; i < pagerAdapter.getCount(); i++) {
            tabHost.addTab(
                    tabHost.newTab()
                            .setText(tabNames[i])
                            .setTabListener(this)
            );
        }
        //TErminas config del tabhost

    }

    @Override
    public void onTabSelected(MaterialTab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab tab) {

    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public Fragment getItem(int num) {

            switch (num){

                case 0:
                    return new PitagoricaFragment();
                case 1:
                    return TantricaFragment.newInstance(person.getmTantricNum());
                default:
                    return new PitagoricaFragment();

            }


        }
        @Override
        public int getCount() {
            return tabNames.length;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return tabNames[position];
        }
    }

}
