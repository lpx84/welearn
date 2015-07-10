package com.welearn.service.intef;

import com.welearn.entity.Student;
import com.welearn.view.View;

public interface StudentService {

    /**
     * 根据openid来判断是否已经绑定
     * @param openid
     * @return
     */
    public boolean checkBindByOpenId(String openid);
    
    /**
     * 根据用户的openid验证用户是否登录，返回相应的界面，若界面为空，则返回null
     * @param openid
     * @return
     */
	public View checkUser(String openid);
	/**
	 * 根据openid获取学生信息，如果不存在，就返回null
	 * @param openId
	 * @return
	 */
	public Student getStudentByOpenId(String openId);
	
	/**
	 * 根据用户学号来获取学生信息
	 * @param studentId
	 * @return
	 */
	public Student getStudentByStudentId(int studentId);
	
	/**
	 * 更新学生信息
	 * @param student
	 * @return
	 */
	public boolean updateStudent(Student student);
	
}
