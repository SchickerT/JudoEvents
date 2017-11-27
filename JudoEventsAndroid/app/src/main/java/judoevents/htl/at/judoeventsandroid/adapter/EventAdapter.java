package judoevents.htl.at.judoeventsandroid.adapter;

import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.io.Console;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import judoevents.htl.at.judoeventsandroid.R;
import judoevents.htl.at.judoeventsandroid.activity.MainActivity;
import judoevents.htl.at.judoeventsandroid.entity.Event;
import judoevents.htl.at.judoeventsandroid.viewholder.HomeScreenHolder;


public class EventAdapter extends RecyclerView.Adapter<HomeScreenHolder>
{
    List<Event> events;

    public EventAdapter(List<Event> eventList)
    {
        this.events = eventList;
    }


    @Override
    public HomeScreenHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_screen_layout,parent,false);
        return new HomeScreenHolder(v);
    }

    @Override
    public void onBindViewHolder(HomeScreenHolder holder, int position)
    {
        final Event e = events.get(position);
        try
        {
            holder.setViews(e);
        }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(
                        MainActivity.getMainActivity()).create();
                alertDialog.setTitle("Test");
                MainActivity.getMainActivity().onDetailFragmentInteraction();
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
