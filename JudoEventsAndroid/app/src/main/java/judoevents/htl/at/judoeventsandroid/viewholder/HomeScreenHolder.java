package judoevents.htl.at.judoeventsandroid.viewholder;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.sql.SQLException;

import judoevents.htl.at.judoeventsandroid.R;
import judoevents.htl.at.judoeventsandroid.entity.Event;

/**
 * Created by User on 20.11.2017.
 */

public class HomeScreenHolder extends RecyclerView.ViewHolder
{
    TextView eventNameTextView;
    TextView eventNameTextView2;
    ImageView eventIV;

    public HomeScreenHolder(View itemView) {
        super(itemView);
        this.eventNameTextView = (TextView) itemView.findViewById(R.id.evenetNameTV);
        this.eventNameTextView2 = (TextView) itemView.findViewById(R.id.evenetNameTV2);
        this.eventIV = (ImageView) itemView.findViewById(R.id.eventImageView);
    }

    public void setViews(Event e) throws SQLException {
        eventNameTextView.setText(e.getEventName());
        eventNameTextView2.setText("21.00.19");
        //InputStream imageStream = e.getPicture().getBinaryStream();
        //Bitmap bmp = BitmapFactory.decodeStream(imageStream);
        //eventIV.setImageBitmap(e.getPicture());
    }
}
