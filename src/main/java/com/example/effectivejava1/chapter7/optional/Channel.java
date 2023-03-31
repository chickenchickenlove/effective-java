package com.example.effectivejava1.chapter7.optional;

import java.util.Optional;

public class Channel {

    private int numOfSubscribers;

    public MemberShip defaultMemberShip() {
        if (this.numOfSubscribers < 2000) {
            return null;
        } else {
            return new MemberShip();
        }
    }

    public Optional<MemberShip> defaultMemberShipWithOptional() {
        if (this.numOfSubscribers < 2000) {
            return Optional.empty();
        } else {
            return Optional.of(new MemberShip());
        }
    }
}
