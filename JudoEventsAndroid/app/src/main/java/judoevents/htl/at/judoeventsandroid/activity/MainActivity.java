package judoevents.htl.at.judoeventsandroid.activity;

import android.app.Activity;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import judoevents.htl.at.judoeventsandroid.R;
import judoevents.htl.at.judoeventsandroid.entity.Event;
import judoevents.htl.at.judoeventsandroid.fragment.EventDetailFragment;
import judoevents.htl.at.judoeventsandroid.fragment.HomeScreenFragment;

public class MainActivity extends AppCompatActivity implements HomeScreenFragment.OnHomeScreenFragmentInteractionListener,EventDetailFragment.OnFragmentInteractionListener /*,EventDetailFragment.OnEventDetailFragmentInteractionListener*/ {


    public static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    public static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMainActivity(this);

        FragmentManager fm = getSupportFragmentManager();
        HomeScreenFragment hcf = (HomeScreenFragment) fm.findFragmentById(R.id.fragmentContainer);


        if(hcf == null){

            hcf = HomeScreenFragment.newInstance();
            fm.beginTransaction().add(R.id.fragmentContainer,hcf)
            .commit();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @Override
    public void onHomeScreenFragmentInteraction(Uri uri)
    {

    }

    @Override
    public void onDetailFragmentInteraction() {
        EventDetailFragment edf = EventDetailFragment.newInstance("Test1","Test2");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,edf).addToBackStack("Home").commit();
    }

    /*@Override
    public void onEventDetailInteraction(Event e)
    {
        EventDetailFragment edf = EventDetailFragment.newInstance(e);
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,edf).commit();
    }*/
}
