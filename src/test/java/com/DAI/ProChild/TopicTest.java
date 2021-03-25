package com.DAI.ProChild;

import com.DAI.ProChild.Directory.Directory;
import com.DAI.ProChild.Topic.Topic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class TopicTest {

    @Test
    public void test() {
        Topic topic = new Topic();
        Directory directory = new Directory();
        topic.setDirectory(directory);
        assertSame(directory, topic.getDirectory());
    }
}
