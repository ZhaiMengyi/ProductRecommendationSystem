package com.zmy.service;

import com.zmy.entity.Merchant;
import org.apache.ibatis.annotations.Param;

/**
 * 商家业务接口
 */
public interface MerchantService {
    /**
     * 注册商家账号
     *
     * @param merchant 商家账号信息
     * @return 影响行数
     */
    Integer registerMerchant(Merchant merchant);

    /**
     * 商家登录
     *
     * @param merUsername 商家用户名
     * @param merPassword 商家密码
     * @return 影响行数
     */
    Integer loginMerchant(@Param(value = "merUsername") String merUsername, @Param(value = "merPassword") String merPassword);

    /**
     * 查看商家信息
     *
     * @param merId 商家Id号
     * @return 商家信息
     */
    Merchant inquireMerInfoById(Integer merId);

    /**
     * 修改商家信息
     *
     * @param merchant 修改后的商家信息
     * @return 影响行数
     */
    Integer modifyMerInfo(Merchant merchant);

    /**
     * 注销商家
     *
     * @param merId 需要删除的商家Id号
     * @return 影响行数
     */
    Integer deleteMerchant(Integer merId);
}
