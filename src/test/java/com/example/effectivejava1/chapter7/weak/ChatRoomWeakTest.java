package com.example.effectivejava1.chapter7.weak;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChatRoomWeakTest {


    @Test
    void test1() throws InterruptedException {

        ChatRoomWeak chatRoomWeak = new ChatRoomWeak();
        UserWeak user1 = new UserWeak();
        UserWeak user2 = new UserWeak();

        chatRoomWeak.addUser(user1);
        chatRoomWeak.addUser(user2);

        chatRoomWeak.sendMessage("hello");

        user1 = null;

        System.gc();

        Thread.sleep(5000L);

        List<WeakReference<UserWeak>> users = chatRoomWeak.getUsers();
        Assertions.assertThat(users.size()).isEqualTo(1);
    }

}