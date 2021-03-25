package com.DAI.ProChild;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.DAI.ProChild.Topic.Topic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class DirectoryTest {

    Set<Topic> topicsFiltered;
    Set<Topic> rightTopics;
    Set<Topic> topicsToBeFilteredMix;
    Set<Topic> topicsToBeFilteredAllWrong;
    Set<Topic> topicsToBeFilteredAllRight;
    @BeforeEach
    public void createSets() {
        this.topicsFiltered = new HashSet<>();
        this.rightTopics = new HashSet<>();
        this.topicsToBeFilteredMix = new HashSet<>();
        this.topicsToBeFilteredAllWrong = new HashSet<>();
        this.topicsToBeFilteredAllRight = new HashSet<>();
    }

    @Test
    public void filterByThemeTest() {
        Topic topicThemeRight = new Topic("someRightTheme", "someRightTitle");
        Topic topicThemeRight1 = new Topic("someRightTheme", "someRightTitle");
        Topic topicThemeWrong = new Topic("someWrongTheme", "someWrongTitle");
        Topic topicThemeWrong1 = new Topic("someWrongTheme", "someWrongTitle");

        this.rightTopics.add(topicThemeRight);
        this.rightTopics.add(topicThemeRight1);
        this.topicsToBeFilteredMix.add(topicThemeRight);
        this.topicsToBeFilteredMix.add(topicThemeWrong1);
        this.topicsToBeFilteredMix.add(topicThemeRight1);
        assertNotEquals(rightTopics, topicsToBeFilteredMix);
        this.topicsToBeFilteredAllRight.add(topicThemeRight);
        this.topicsToBeFilteredAllRight.add(topicThemeRight1);
        assertEquals(rightTopics, topicsToBeFilteredAllRight);
        this.topicsToBeFilteredAllWrong.add(topicThemeWrong);
        this.topicsToBeFilteredAllWrong.add(topicThemeWrong1);
        assertNotEquals(rightTopics, topicsToBeFilteredAllWrong);
    }

    @Test
    public void filterByTitleTest() {
        Topic topicTitleRight = new Topic("someRightTheme", "someRightTitle");
        Topic topicTitleRight1 = new Topic("someRightTheme", "someRightTitle");
        Topic topicTitleWrong = new Topic("someWrongTheme", "someWrongTitle");
        Topic topicTitleWrong1 = new Topic("someWrongTheme", "someWrongTitle");

        this.rightTopics.add(topicTitleRight);
        this.rightTopics.add(topicTitleRight1);
        this.topicsToBeFilteredMix.add(topicTitleRight);
        this.topicsToBeFilteredMix.add(topicTitleWrong1);
        this.topicsToBeFilteredMix.add(topicTitleRight1);
        assertNotEquals(rightTopics, topicsToBeFilteredMix);
        this.topicsToBeFilteredAllRight.add(topicTitleRight);
        this.topicsToBeFilteredAllRight.add(topicTitleRight1);
        assertEquals(rightTopics, topicsToBeFilteredAllRight);
        this.topicsToBeFilteredAllWrong.add(topicTitleWrong);
        this.topicsToBeFilteredAllWrong.add(topicTitleWrong1);
        assertNotEquals(rightTopics, topicsToBeFilteredAllWrong);
    }

}
