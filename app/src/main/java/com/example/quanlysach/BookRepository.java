package com.example.quanlysach;

import java.util.ArrayList;

/** Danh sách chỉ sống trong bộ nhớ trong lúc ứng dụng đang chạy theo yêu cầu đề bài. */
public final class BookRepository {
    private static final ArrayList<Book> books = new ArrayList<>();
    private static boolean initialized = false;

    private BookRepository() { }

    public static ArrayList<Book> getBooks() {
        if (!initialized) {
            books.add(new Book("Lập trình Android cơ bản", "Nguyễn Văn A", "Công nghệ", "Đang đọc", 4, "Đọc các chương về Activity và Intent."));
            books.add(new Book("Đắc nhân tâm", "Dale Carnegie", "Kỹ năng sống", "Đã đọc", 5, "Sách về nghệ thuật giao tiếp."));
            books.add(new Book("Dế Mèn phiêu lưu ký", "Tô Hoài", "Văn học", "Chưa đọc", 0, ""));
            initialized = true;
        }
        return books;
    }
}
