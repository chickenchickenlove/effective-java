package com.example.effectivejava1.chapter7.cache;

import java.util.Map;
import java.util.WeakHashMap;

public class PostRepositoryWithReference {

    private Map<Integer, Post> cache;

    public PostRepositoryWithReference() {
        this.cache = new WeakHashMap<>();
    }

    public Post getPostById(Integer key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            // TODO : DB에서 읽어오거나 REST API를 통해서 읽어올 수 있습니다.
            Post post = new Post();
            cache.put(key, post);
            return post;
        }
    }

    public Map<Integer, Post> getCache() {
        return cache;
    }

}
