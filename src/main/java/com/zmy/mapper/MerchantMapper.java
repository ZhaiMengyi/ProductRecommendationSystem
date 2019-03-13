package com.zmy.mapper;

import com.zmy.entity.Merchant;
import org.apache.ibatis.annotations.Param;

public interface MerchantMapper {
    Integer registerMerchant(@Param(value = "merchant") Merchant merchant);

    Integer loginMerchant(@Param(value = "merUsername") String merUsername, @Param(value = "merPassword") String merPassword);

    Merchant inquireMerInfoById(Integer merId);

    Integer modifyMerInfo(@Param(value = "merchant") Merchant merchant);

    Integer deleteMerchant(Integer merId);
}
