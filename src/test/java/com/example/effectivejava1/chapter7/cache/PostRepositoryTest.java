package com.example.effectivejava1.chapter7.cache;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {

    @Test
    void cache() throws InterruptedException {
        PostRepository postRepository = new PostRepository();
        Integer p1 = 1;
//        postRepository.getPostById(p1);

        CacheKey key = new CacheKey(p1);
        postRepository.getPostById(key);

        assertFalse(postRepository.getCache().isEmpty());

        key = null;
        System.out.println("run gc");
        System.gc();
        System.out.println("wait");
        Thread.sleep(3000L);

        assertTrue(postRepository.getCache().isEmpty());
    }

    @Test
    void backgroundThread() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        PostRepository postRepository = new PostRepository();
        CacheKey key1 = new CacheKey(1);
        postRepository.getPostById(key1);

        Runnable removeOldCache = () -> {
            System.out.println("running removeOldCache Task");
            Map<CacheKey, Post> cache = postRepository.getCache();
            Set<CacheKey> cacheKeys = cache.keySet();
            Optional<CacheKey> key = cacheKeys.stream().min(Comparator.comparing(CacheKey::getCreated));
            key.ifPresent(cacheKey ->{
                System.out.println("remove " + cacheKey);
                cache.remove(cacheKey);
            });
        };

        System.out.println("The time is : " + new Date());

        executor.scheduleAtFixedRate(removeOldCache, 1, 3, TimeUnit.SECONDS);
        Thread.sleep(20000L);

        executor.shutdown();
    }




}