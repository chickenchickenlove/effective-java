package com.example.effectivejava1.chapter7.listener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatRoom {

    // 잘못된 사용법
    private List<WeakReference<User>> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(new WeakReference<>(user));
    }

    public void sendMessage(String message) {
        users.forEach(userWeakReference ->
                Objects.requireNonNull(userWeakReference.get())
                        .receive(message));
    }

    public List<WeakReference<User>> getUsers() {
        return users;
    }
}
