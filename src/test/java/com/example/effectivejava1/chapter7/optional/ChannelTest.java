package com.example.effectivejava1.chapter7.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ChannelTest {

    @Test
    void npeTest() {
        Channel channel = new Channel();
        MemberShip memberShip = channel.defaultMemberShip();
        if (memberShip != null) {
            memberShip.equals(new MemberShip());
        }
    }

    @Test
    void npeWithOptionalTest() {
        Channel channel = new Channel();
        Optional<MemberShip> optional = channel.defaultMemberShipWithOptional();
        optional.ifPresent(MemberShip::hello);
        }
}
