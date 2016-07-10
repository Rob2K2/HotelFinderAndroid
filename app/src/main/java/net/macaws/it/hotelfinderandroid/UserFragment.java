package net.macaws.it.hotelfinderandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import net.macaws.it.hotelfinderandroid.adapter.UserAdapter;
import net.macaws.it.hotelfinderandroid.network.RetrieveUsersAsyncTask;

/**
 * Created by Rob on 10/07/2016.
 */
public class UserFragment extends Fragment {

    private ListView listView;
    private UserAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user, container, false);
        // Inflate the layout for this fragment
        listView = (ListView)view.findViewById(R.id.users_list_view);
        adapter = new UserAdapter(getActivity());
        listView.setAdapter(adapter);

        RetrieveUsersAsyncTask task = new RetrieveUsersAsyncTask(this);
        task.execute();

        return view;
    }

    public UserAdapter getAdapter() {
        return adapter;
    }
}