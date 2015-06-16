package com.welearn.service.intef;

public interface StudentService {

    /**
     * 根据openid来判断是否已经绑定
     * @param openid
     * @return
     */
    public abstract boolean checkBindByOpenId(String openid);
    
}
