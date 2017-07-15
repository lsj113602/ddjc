package com.ddjc.task;

import com.ddjc.dao.RatioMapper;
import com.ddjc.entity.Ratio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    private int lastId = -1;

    private int fallCount = 0;

    private boolean isFall = false;

    @Transactional
    @Scheduled(cron = "0/1 * *  * * ? ")//ÿ��ִ��һ��
    @Override
    public void myTask() {
        List<Ratio> ratioList = ratioMapper.selectLastRow();
        if (ratioList == null) return;
        System.out.println("-->" + ratioList.size());
        if (ratioList.size() < 10) {
            return;
        }
        for (Ratio ratio : ratioList) {
            if (ratio.getValue() < 2) {
                // ��������5��С��2 �������ж�Ŀ�����������������
                fallCount++;
            } else {
                fallCount = 0;
            }
            if (fallCount >= 5) {
                isFall = true;
                fallCount = 0;
                break;
            }
            ratioMapper.deleteByPrimaryKey(ratio.getId());
        }
        if (isFall){
            System.out.println("���������Ϸ�ү��������������");
            isFall = false;
        }else {
            System.out.println("û����- - ");
        }
    }
}
