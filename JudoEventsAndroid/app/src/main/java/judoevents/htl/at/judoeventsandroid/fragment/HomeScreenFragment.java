package judoevents.htl.at.judoeventsandroid.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.InputStream;
import java.sql.Blob;
import java.util.LinkedList;
import java.util.List;

import judoevents.htl.at.judoeventsandroid.R;
import judoevents.htl.at.judoeventsandroid.adapter.EventAdapter;
import judoevents.htl.at.judoeventsandroid.entity.Event;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnHomeScreenFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeScreenFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private OnHomeScreenFragmentInteractionListener mListener;
    private EventAdapter adapter;
    private RecyclerView rv;

    public HomeScreenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeScreenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeScreenFragment newInstance() {
        HomeScreenFragment fragment = new HomeScreenFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        List<Event> events = loadEvents();
        adapter = new EventAdapter(loadEvents());
        rv = (RecyclerView) v.findViewById(R.id.eventRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
        return v;
    }

    private List<Event> loadEvents()
    {
        List<Event> ev = new LinkedList<>();


        // BitmapFactory.decodeByteArray(BLOB von DB) voresrt mit testdaten
        ev.add(new Event("TestName1" , BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("TestName2", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("TestName3", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("TestName4", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("BspName2", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("BspName123", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("TestName442", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("TestName4432", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("U12-U13 Regionalrunde", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("U14 Regionalrunde", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("U16 Regionalrunde", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("U12 Regionalrunde", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("U16 Landesrunde", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("TestName434", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("TestName4", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("TestName5", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("TestName6", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        ev.add(new Event("TestName7", BitmapFactory.decodeResource(getContext().getResources(),android.R.drawable.btn_star)));
        return ev;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onHomeScreenFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnHomeScreenFragmentInteractionListener) {
            mListener = (OnHomeScreenFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnHomeScreenFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnHomeScreenFragmentInteractionListener {
        // TODO: Update argument type and name
        void onHomeScreenFragmentInteraction(Uri uri);
    }
}
