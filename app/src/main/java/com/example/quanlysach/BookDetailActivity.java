package com.example.quanlysach;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class BookDetailActivity extends Activity {
    private Book book;
    private int index;
    private TextView tvStatus;
    private Button btnMarkRead;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        index = getIntent().getIntExtra("BOOK_INDEX", -1);
        if (index < 0 || index >= BookRepository.getBooks().size()) { finish(); return; }
        book = BookRepository.getBooks().get(index);
        ((TextView) findViewById(R.id.tvDetailTitle)).setText(book.getTitle());
        ((TextView) findViewById(R.id.tvDetailAuthorCategory)).setText("Tác giả: " + book.getAuthor() + "\nThể loại: " + book.getCategory());
        tvStatus = findViewById(R.id.tvDetailStatus);
        ((TextView) findViewById(R.id.tvDetailNote)).setText(book.getNote().isEmpty() ? "Chưa có ghi chú" : book.getNote());
        RatingBar rating = findViewById(R.id.ratingDetail);
        rating.setRating(book.getRating());
        rating.setOnRatingBarChangeListener((bar, value, fromUser) -> { if (fromUser) book.setRating(value); });
        btnMarkRead = findViewById(R.id.btnMarkRead);
        btnMarkRead.setOnClickListener(v -> { book.setReadingStatus("Đã đọc"); bindStatus(); Toast.makeText(this, "Đã đánh dấu đã đọc", Toast.LENGTH_SHORT).show(); });
        findViewById(R.id.btnDeleteBook).setOnClickListener(v -> { BookRepository.getBooks().remove(index); Toast.makeText(this, "Đã xóa sách", Toast.LENGTH_SHORT).show(); finish(); });
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
        bindStatus();
    }
    private void bindStatus() {
        tvStatus.setText("Tình trạng: " + book.getReadingStatus());
        btnMarkRead.setEnabled(!"Đã đọc".equals(book.getReadingStatus()));
    }
}
