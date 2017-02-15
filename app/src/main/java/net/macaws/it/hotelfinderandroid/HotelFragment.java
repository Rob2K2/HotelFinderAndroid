package net.macaws.it.hotelfinderandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import net.macaws.it.hotelfinderandroid.adapter.HotelAdapter;
import net.macaws.it.hotelfinderandroid.network.RetrieveHotelsAsyncTask;

/**
 * Created by Rob on 19/10/2016.
 */

public class HotelFragment extends Fragment {

    private ListView listView;
    private HotelAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hotel, container, false);
        // Inflate the layout for this fragment
        listView = (ListView)view.findViewById(R.id.hotels_list_view);
        adapter = new HotelAdapter(getActivity());
        listView.setAdapter(adapter);

        RetrieveHotelsAsyncTask task = new RetrieveHotelsAsyncTask(this);
        task.execute();

        return view;
    }

    public HotelAdapter getAdapter() {
        return adapter;
    }
}
