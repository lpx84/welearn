package com.welearn.service.intef;

import com.welearn.view.View;

public interface UserService {
    /**
     * 根据用户的code验证用户是否登录，返回相应的界面，若界面为空，则返回null
     * @param openid
     * @return
     */
	public abstract View checkUser(String openid);
}
