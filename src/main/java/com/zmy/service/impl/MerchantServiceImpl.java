package com.zmy.service.impl;

import com.zmy.entity.Merchant;
import com.zmy.mapper.MerchantMapper;
import com.zmy.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantMapper merchantMapper;
    @Override
    public Integer registerMerchant(Merchant merchant) {
        return merchantMapper.registerMerchant(merchant);
    }

    @Override
    public Integer loginMerchant(String merUsername, String merPassword) {
        return merchantMapper.loginMerchant(merUsername,merPassword);
    }

    @Override
    public Merchant inquireMerInfoById(Integer merId) {
        return merchantMapper.inquireMerInfoById(merId);
    }

    @Override
    public Integer modifyMerInfo(Merchant merchant) {
        return merchantMapper.modifyMerInfo(merchant);
    }

    @Override
    public Integer deleteMerchant(Integer merId) {
        return merchantMapper.deleteMerchant(merId);
    }
}
