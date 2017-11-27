package judoevents.htl.at.judoeventsandroid.activity;

import android.app.Activity;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import judoevents.htl.at.judoeventsandroid.R;

import judoevents.htl.at.judoeventsandroid.entity.Event;
import judoevents.htl.at.judoeventsandroid.fragment.EventDetailFragment;
import judoevents.htl.at.judoeventsandroid.fragment.HomeScreenFragment;
import judoevents.htl.at.judoeventsandroid.fragment.SwipeFragment;

public class MainActivity extends AppCompatActivity implements SwipeFragment.OnSwipeFragmentInteractionListener,HomeScreenFragment.OnHomeScreenFragmentInteractionListener,EventDetailFragment.OnFragmentInteractionListener /*,EventDetailFragment.OnEventDetailFragmentInteractionListener*/ {


    public static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    public static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    Event e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMainActivity(this);

        FragmentManager fm = getSupportFragmentManager();
        SwipeFragment sf = (SwipeFragment) fm.findFragmentById(R.id.fragmentContainer);
        if(sf == null)
        {
            sf = SwipeFragment.newInstance("Test","test");
            fm.beginTransaction().add(R.id.fragmentContainer,sf).commit();
        }
        /*HomeScreenFragment hcf = (HomeScreenFragment) fm.findFragmentById(R.id.fragmentContainer);
        if(hcf == null){

            hcf = HomeScreenFragment.newInstance();
            fm.beginTransaction().add(R.id.fragmentContainer,hcf)
            .commit();
        }*/
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @Override
    public void onHomeScreenFragmentInteraction(Uri uri)
    {

    }

    @Override
    public void onDetailFragmentInteraction()
    {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fragmentContainer,EventDetailFragment.newInstance("TT","tt")).commit();
    }

    @Override
    public void onSwipeFragmentInteraction(Uri uri) {

    }

    /*@Override
    public void onEventDetailInteraction(Event e)
    {
        EventDetailFragment edf = EventDetailFragment.newInstance(e);
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,edf).commit();
    }*/


}
