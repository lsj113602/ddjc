package com.ddjc.dao;

import com.ddjc.entity.Userfeedback;

public interface UserfeedbackMapper {
    int insert(Userfeedback record);

    int insertSelective(Userfeedback record);
}