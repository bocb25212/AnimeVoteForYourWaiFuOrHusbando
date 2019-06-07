package com.Sean.service.impl;

import com.Sean.mapper.ReplyMapper;
import com.Sean.pojo.Reply;
import com.Sean.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    public ReplyMapper ReplyMapper;

    public List<Reply> getRepliesOfTopic(Integer topicId) {
        return ReplyMapper.getRepliesOfTopic(topicId);
    }

    public boolean addReply(Reply reply) {
        return ReplyMapper.insert(reply)>0;
    }

    public int repliesNum(Integer topicId) {
        return ReplyMapper.getRepliesNum(topicId);
    }
}
