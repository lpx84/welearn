package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.CourseNotify;
import com.welearn.entity.CourseOption;

public class CourseOptionDao extends SuperDao {

	public Integer addCourseOption(CourseOption courseOption){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseOption);
	}
	
	public boolean delCourseOptionById(int id){
		this.hql = "DELETE FROM CourseOption AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseOptionByProblemId(int problemid){
		this.hql = "DELETE FROM CourseOption AS u WHERE u.problemId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, problemid);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseOption(CourseOption courseOption){
		this.sessionFactory.getCurrentSession().update(courseOption);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseOption getCourseOptionById(int id){
		this.hql = "FROM CourseOption AS u inner join fetch u.problemEntity WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseOption) query.uniqueResult();
	}
	
	public List<CourseOption> getCourseOptionByProblemId(int problemId, int pageNo, int pageItemNum){
		this.hql = "from CourseOption as a inner join fetch a.problemEntity where a.problemId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseOption> result = query.list();
		return result;
	}
	
	public List<CourseOption> getCourseOptionByContent(String content, int pageNo, int pageItemNum){
		this.hql = "from CourseOption as a inner join fetch a.problemEntity where a.content like '%"+content+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseOption> result = query.list();
		return result;
	}
	
	/**
	 * 根据课程编号查找options
	 * @param CourseID
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course_problem AS a, bjtu_course_option AS b where a.id=b.problem_id and a.course_id=1;
	public List<CourseOption> getCourseOptionsByCourseId(int CourseID, int pageNo, int pageItemNum){
		/*this.hql = "select b from CourseProblem AS a, CourseOption AS b "
				+ "inner join fetch b.problemEntity"
				+ "where a.id=b.problemId and a.courseId=?";*/
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, CourseID);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseOption> result = query.list();
		return null;
	}
	
}
