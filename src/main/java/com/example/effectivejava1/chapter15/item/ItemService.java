package com.example.effectivejava1.chapter15.item;

import com.example.effectivejava1.chapter15.member.MemberService;

import java.util.List;

public class ItemService {

    public static final List<String> MY_COLLECTIONS = List.of("A", "B", "C");
    public static final String NAME = "whiteship";

    MemberService memberService;

    boolean onSale;

    protected int saleRate;

    public ItemService(MemberService memberService) {
        this.memberService = memberService;
    }

    public MemberService getMemberService() {
        return memberService;
    }
}
