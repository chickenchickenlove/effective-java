package com.example.effectivejava1.chapter20.typeframework;

public interface SingSongWriter extends Singer, SongWriter{
    @Override
    AudioClip sing(Song song);

    @Override
    Song compose(int shartPosition);
}
