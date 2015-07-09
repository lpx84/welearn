package com.welearn.service.intef;

import com.welearn.view.View;

public interface StudentService {

    /**
     * 根据openid来判断是否已经绑定
     * @param openid
     * @return
     */
    public abstract boolean checkBindByOpenId(String openid);
    
    /**
     * 根据用户的openid验证用户是否登录，返回相应的界面，若界面为空，则返回null
     * @param openid
     * @return
     */
	public abstract View checkUser(String openid);
    
}