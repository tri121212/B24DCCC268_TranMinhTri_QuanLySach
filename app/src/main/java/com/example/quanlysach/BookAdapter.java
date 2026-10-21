package com.example.quanlysach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    public BookAdapter(Context context, List<Book> books) { super(context, 0, books); }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        if (item == null) item = LayoutInflater.from(getContext()).inflate(R.layout.item_book, parent, false);
        Book book = getItem(position);
        ((TextView) item.findViewById(R.id.tvItemTitle)).setText(book.getTitle());
        ((TextView) item.findViewById(R.id.tvItemInfo)).setText(book.getAuthor() + " • " + book.getCategory());
        ((TextView) item.findViewById(R.id.tvItemStatus)).setText(book.getReadingStatus());
        ((RatingBar) item.findViewById(R.id.ratingItem)).setRating(book.getRating());
        return item;
    }
}
