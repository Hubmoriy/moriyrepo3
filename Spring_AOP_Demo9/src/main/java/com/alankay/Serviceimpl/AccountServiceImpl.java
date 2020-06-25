package com.alankay.Serviceimpl;

import com.alankay.Service.AcconutService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/**
 * description(描述):账户业务层实现类
 * author（作者）：河流
 * time：2020/6/2412:09
 */
@Service("accountService")

public class AccountServiceImpl implements AcconutService{

    public void SaveAccount() {
        System.out.println("执行保存");
    }

    public void UpdateAccount(int i) {
        System.out.println("执行更新");
    }

    public int DeleteAccount() {
        System.out.println("执行删除");
        return 0;
    }
}
