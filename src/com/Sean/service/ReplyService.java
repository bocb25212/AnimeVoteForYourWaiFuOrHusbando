package com.Sean.service;

import com.Sean.pojo.Reply;
import java.util.List;

import org.springframework.stereotype.Service;
public interface ReplyService {

    List<Reply> getRepliesOfTopic(Integer topicId);

    boolean addReply(Reply reply);

    int repliesNum(Integer topicId);
}
