package com.example.sihua.bookviewer;


import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sihua.bookcontent.BookContent;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookListFragment extends ListFragment {

    public CallBacks mCallBack;
    public interface CallBacks{
        public void onItemSelected(Integer id);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(),android.R.layout
                .simple_list_item_activated_1,android.R.id.text1,BookContent.ITEMS));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(!(context instanceof CallBacks)){
            throw new IllegalStateException("This activity must implement Callback interface!");
        }
        mCallBack=(CallBacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack=null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallBack.onItemSelected(BookContent.ITEMS.get(position).id);
    }

    public void setActivateOnItemClick(boolean activateOnItemClick)
    {
        getListView().setChoiceMode(
                activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
                        : ListView.CHOICE_MODE_NONE);
    }
}
