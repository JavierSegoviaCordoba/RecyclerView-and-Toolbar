package com.example.javier.recyclerviewandtoolbar;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RecyclerViewFragment extends Fragment {

    View view;
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    ArrayList<MyItemClass> myItemClasses = new ArrayList<>();
    String[] titles, content;
    RecyclerView.Adapter adapter;
    TypedValue typedValueToolbarHeight = new TypedValue();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        ButterKnife.inject(this, view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        titles = getActivity().getResources().getStringArray(R.array.array_titles_recyclerview);
        content = getActivity().getResources().getStringArray(R.array.array_content_recyclerview);
        for (int i = 0; i < titles.length; i++){
            myItemClasses.add(new MyItemClass(titles[i], content[i]));
        }
        adapter = new RecyclerViewAdapter(getActivity(), myItemClasses);
        recyclerView.setAdapter(adapter);

        getActivity().getTheme().resolveAttribute(android.R.attr.actionBarSize, typedValueToolbarHeight, true);

        int toolbarHeight = TypedValue
                .complexToDimensionPixelSize(typedValueToolbarHeight.data, getResources()
                        .getDisplayMetrics());
        int statusBarHeight = new ConvertToPx().convertToPx(25, getActivity());

        int paddingTop = toolbarHeight + statusBarHeight;

        recyclerView.setPadding(0, paddingTop, 0, 0);

        return view;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
