package com.example.effectivejava1.chapter7.weak;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatRoomWeak {

    // 잘못된 사용법
    private List<WeakReference<UserWeak>> users;

    public ChatRoomWeak() {
        this.users = new ArrayList<>();
    }

    public void addUser(UserWeak user) {
        this.users.add(new WeakReference<>(user));
    }

    public void sendMessage(String message) {
        users.forEach(userWeakReference ->
                Objects.requireNonNull(userWeakReference.get())
                        .receive(message));
    }

    public List<WeakReference<UserWeak>> getUsers() {
        return users;
    }
}
