package com.example.quanlysach;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private ArrayList<Book> books;
    private BookAdapter adapter;
    private TextView tvStatistics;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        books = BookRepository.getBooks();
        tvStatistics = findViewById(R.id.tvStatistics);
        adapter = new BookAdapter(this, books);
        ListView listBooks = findViewById(R.id.listBooks);
        listBooks.setAdapter(adapter);
        listBooks.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, BookDetailActivity.class);
            intent.putExtra("BOOK_INDEX", position);
            startActivity(intent);
        });
        findViewById(R.id.btnAddBook).setOnClickListener(v -> startActivity(new Intent(this, AddBookActivity.class)));
    }

    @Override protected void onResume() {
        super.onResume();
        if (adapter != null) adapter.notifyDataSetChanged();
        updateStatistics();
    }

    private void updateStatistics() {
        int read = 0;
        for (Book book : books) if ("Đã đọc".equals(book.getReadingStatus())) read++;
        tvStatistics.setText("Tổng số sách: " + books.size() + "    |    Đã đọc: " + read + "    |    Chưa đọc xong: " + (books.size() - read));
    }
}
