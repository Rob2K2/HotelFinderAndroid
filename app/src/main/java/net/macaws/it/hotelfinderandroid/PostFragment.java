package net.macaws.it.hotelfinderandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import net.macaws.it.hotelfinderandroid.adapter.PostAdapter;
import net.macaws.it.hotelfinderandroid.model.Post;
import net.macaws.it.hotelfinderandroid.network.RetrievePostsAsyncTask;

/**
 * Created by Rob on 10/07/2016.
 */
public class PostFragment extends Fragment {
    private ListView listView;
    private PostAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        // Inflate the layout for this fragment
        listView = (ListView)view.findViewById(R.id.posts_list_view);
        adapter = new PostAdapter(getActivity());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Post p = adapter.getItem(position);

                Toast.makeText(getActivity(), p.getTitle(), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("title",p.getTitle());
                intent.putExtra("content",p.getContent());
                intent.putExtra("image",p.getUser().getPicture_url());
                startActivity(intent);
            }
        });

        RetrievePostsAsyncTask task = new RetrievePostsAsyncTask(this);
        task.execute();

        return view;
    }

    public PostAdapter getAdapter() {
        return adapter;
    }
}
