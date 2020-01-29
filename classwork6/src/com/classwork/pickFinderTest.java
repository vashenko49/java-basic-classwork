package com.classwork;

import org.junit.Assert;
import org.junit.Test;


public class pickFinderTest {
    @Test
    public void pickSum_should_getNoResult_when_noPicks() {
        //given
        int[] picks = {};
        pickFinder pickFinder = new pickFinder();
        //when
        int result = pickFinder.pickSum(picks);
        //then
        Assert.assertEquals(-1, result);
    }

    @Test
    public void findFirstPick_should_getNOResult_when_noPicks() {
        //given
        int[] picks = {};
        pickFinder pickFinder = new pickFinder();
        //when
        int result = pickFinder.findFirstPick(picks);
        //then
        Assert.assertEquals(-1, result);
    }

    @Test
    public void findPicks_should_getPick_when_hasFirstPick() {
        //given
        int[] picks = {5, 3, 5};
        pickFinder pickFinder = new pickFinder();
        //when
        int result = pickFinder.findFirstPick(picks);
        //then
        Assert.assertEquals(0, result);
    }

    @Test
    public void findPicks_should_getPick_when_hasLastPick() {
        //given
        int[] picks = {1, 3, 5};
        pickFinder pickFinder = new pickFinder();
        //when
        int result = pickFinder.findFirstPick(picks);
        //then
        Assert.assertEquals(2, result);
    }
}