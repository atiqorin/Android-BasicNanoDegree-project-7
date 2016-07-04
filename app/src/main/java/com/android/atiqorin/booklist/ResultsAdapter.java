package com.android.atiqorin.booklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by atiqorin on 7/4/16.
 */
public class ResultsAdapter extends BaseAdapter {

    private static final String TITLE = "title";
    private static final String INFO = "volumeInfo";
    private static final String ITEMS = "items";
    private static final String AUTHORS = "authors";
    String title;
    JSONArray details = null;
    ArrayList<Result> detailedData = new ArrayList<>();
    String result;
    Context context;

    public ResultsAdapter(String result, Context context) {
        this.result = result;
        this.context = context;
        if (result != null) {
            try {
                JSONObject jsonObj = new JSONObject(result);
                details = jsonObj.getJSONArray(ITEMS);
                for (int i = 0; i < details.length(); i++) {
                    JSONObject c = details.getJSONObject(i);
                    JSONObject deta = c.getJSONObject(INFO);
                    JSONArray Authors = deta.getJSONArray(AUTHORS);
                    title = deta.getString(TITLE);
                    detailedData.add(new Result(Authors.toString(), title));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getCount() {
        return detailedData.size()-1;
    }

    @Override
    public Object getItem(int position) {
        return detailedData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView title = (TextView) row.findViewById(R.id.Title);
        TextView Authors = (TextView) row.findViewById(R.id.author);

        Result temp = detailedData.get(position);

        title.setText("Title: " + temp.Title);
        Authors.setText("Authors: " + temp.getAuthors());


        return row;
    }
}
