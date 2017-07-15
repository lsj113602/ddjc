package com.ddjc.service.serviceImpl;

import com.ddjc.dao.RatioMapper;
import com.ddjc.entity.Ratio;
import com.ddjc.service.VideoFallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: LongDuping
 * date  : 2017-07-15 20:44
 * email : 610215675@qq.com
 * --------------------------------------------------
 * function: ÊÓÆµµøµ¹¼ì²â·þÎñ
 */
@Service("VideoFallService")
public class VideoFallServiceImpl implements VideoFallService, Runnable {

    @Autowired
    private RatioMapper ratioMapper;

    private int lastId = -1;

    private int fallCount = 0;

    @Override
    public void beginCheck() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        List<Ratio> ratioList = ratioMapper.selectLastRow();
        if (ratioList == null) return;
        if (ratioList.size() < 10) {
            return;
        }
    }
}
