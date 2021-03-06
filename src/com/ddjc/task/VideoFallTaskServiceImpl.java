package com.ddjc.task;

import com.ddjc.dao.RatioMapper;
import com.ddjc.dao.WarningmoveMapper;
import com.ddjc.entity.Ratio;
import com.ddjc.entity.Warningmove;
import com.ddjc.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * author: LongDuping
 * date  : 2017-07-15 21:11
 * email : 610215675@qq.com
 * --------------------------------------------------
 * function:
 */
@Component
public class VideoFallTaskServiceImpl implements VideoFallTaskService {
    @Autowired
    private RatioMapper ratioMapper;

    @Autowired
    private WarningmoveMapper warningmoveMapper;

    private int lastId = -1;

    private int fallCount = 0;

    private boolean isFall = false;

    private Ratio fallRatio = null;

    @Scheduled(cron = "0/1 * *  * * ? ")//每秒执行一次
    @Override
    public void myTask() {
        List<Ratio> ratioList = ratioMapper.selectLastRow();
        if (ratioList == null) return;
        //System.out.println("-->" + ratioList.size());
        if (ratioList.size() < 10) {
            return;
        }
        for (Ratio ratio : ratioList) {
            if (ratio.getValue() < 2) {
                // 假如连续5次小于2 则暴力的判断目标跌倒！！！！！！
                fallCount++;
            } else {
                fallCount = 0;
            }
            if (fallCount >= 5) {
                isFall = true;
                fallCount = 0;
                fallRatio = ratio;
                break;
            }
            ratioMapper.deleteByPrimaryKey(ratio.getId());
        }
        if (isFall) {
            System.out.println("报！！！老佛爷跌倒啦！！！！");
            Warningmove warningmove = new Warningmove();
            warningmove.setId(UuidUtil.getUuid());
            warningmove.setReceivetime(fallRatio.getCreatetime());
            warningmove.setDeviceid(fallRatio.getDeviceid() + "");
            warningmove.setIshandle((byte) 0);
            warningmove.setDeletemark((byte) 0);
            warningmove.setBehavior("跌倒");
            warningmove.setRemarks("老佛爷跌倒啦！");
            warningmove.setSource((byte) 1);
            warningmove.setUserid(null);
            warningmoveMapper.insert(warningmove);
            isFall = false;
            fallRatio = null;
        } else {
            System.out.println("没跌倒- - ");
        }
    }
}
