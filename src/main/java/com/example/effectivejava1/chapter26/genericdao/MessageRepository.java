package com.example.effectivejava1.chapter26.genericdao;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MessageRepository {

    private Set<Message> messages;

    public MessageRepository() {
        this.messages = new HashSet<>();
    }

    public Optional<Message> findById(Long id) {
        return messages.stream().filter(a -> a.getId().equals(id)).findAny();
    }

    public void add(Message message) {
        this.messages.add(message);
    }

}
