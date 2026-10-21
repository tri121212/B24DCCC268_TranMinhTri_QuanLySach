package com.example.quanlysach;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class AddBookActivity extends Activity {
    private EditText edtTitle, edtAuthor, edtNote;
    private Spinner spinnerCategory;
    private RadioGroup groupStatus;
    private RatingBar ratingBook;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        edtTitle = findViewById(R.id.edtTitle); edtAuthor = findViewById(R.id.edtAuthor); edtNote = findViewById(R.id.edtNote);
        spinnerCategory = findViewById(R.id.spinnerCategory); groupStatus = findViewById(R.id.groupStatus); ratingBook = findViewById(R.id.ratingBook);
        findViewById(R.id.btnSaveBook).setOnClickListener(v -> saveBook());
    }

    private void saveBook() {
        String title = edtTitle.getText().toString().trim();
        String author = edtAuthor.getText().toString().trim();
        if (TextUtils.isEmpty(title)) { edtTitle.setError("Tên sách không được để trống"); edtTitle.requestFocus(); return; }
        if (TextUtils.isEmpty(author)) { edtAuthor.setError("Tác giả không được để trống"); edtAuthor.requestFocus(); return; }
        String status = "Chưa đọc";
        int selected = groupStatus.getCheckedRadioButtonId();
        if (selected == R.id.rbReading) status = "Đang đọc";
        else if (selected == R.id.rbRead) status = "Đã đọc";
        BookRepository.getBooks().add(new Book(title, author, spinnerCategory.getSelectedItem().toString(), status, ratingBook.getRating(), edtNote.getText().toString().trim()));
        Toast.makeText(this, "Đã thêm sách", Toast.LENGTH_SHORT).show();
        finish();
    }
}
