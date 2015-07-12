package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.CourseNotify;
import com.welearn.entity.CourseProblem;

public class CourseProblemDao extends SuperDao {
	
	public Integer addCourseProblem(CourseProblem courseProblem){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseProblem);
	}
	
	public boolean delCourseProblemById(int id){
		this.hql = "DELETE FROM CourseProblem AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseProblemByAnswerId(int answerid){
		this.hql = "DELETE FROM CourseProblem AS u WHERE u.answer_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, answerid);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseProblem(CourseProblem courseProblem){
		this.sessionFactory.getCurrentSession().update(courseProblem);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseProblem getCourseProblemById(int id){
		this.hql = "FROM CourseProblem AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseProblem) query.uniqueResult();
	}
	
	public List<CourseProblem> getCourseProblemByAnswerId(int answerid, int pageNo, int pageItemNum){
		this.hql = "from CourseProblem as a where a.answer_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, answerid);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseProblem> result = query.list();
		return result;
	}
	
	public List<CourseProblem> getCourseProblemByComment(String comment, int pageNo, int pageItemNum){
		this.hql = "from CourseProblem as a where a.comment like '%"+comment+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseProblem> result = query.list();
		return result;
	}
	
	public List<CourseProblem> getCourseProblemByContent(String content, int pageNo, int pageItemNum){
		this.hql = "from CourseProblem as a where a.comment like '%"+content+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseProblem> result = query.list();
		return result;
	}
	
	public List<CourseProblem> getCourseProblemByCourseId(int courseid, int pageNo, int pageItemNum){
		this.hql = "from CourseProblem as a where a.course_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseProblem> result = query.list();
		return result;
	}
	
	/**
	 * 根据问题选项id查找课程问题
	 * @param courseOptionId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course_option AS a, bjtu_course_problem AS b where a.problem_id=b.id and a.id=1;
	public List<CourseProblem> getCourseProblemByCourseOptionId(int courseOptionId, int pageNo, int pageItemNum){
		this.hql = "select b.* from bjtu_course_option AS a, bjtu_course_problem AS b "
				+ "where a.problem_id=b.id and a.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseOptionId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseProblem> result = query.list();
		return result;
	}
	
	/**
	 * 根据课程号查找课程问题列表
	 * @param courseNo
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course AS a, bjtu_course_problem AS b where a.id=b.course_id and a.course_no=1;
	public List<CourseProblem> getCourseProblemByCourseNo(String courseNo, int pageNo, int pageItemNum){
		this.hql = "select b.* from bjtu_course AS a, bjtu_course_problem AS b "
				+ "where a.id=b.course_id and a.course_no='?'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, courseNo);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseProblem> result = query.list();
		return result;
	}
	/**
	 * 根据老师的id查找课程问题
	 * @param teacherId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<CourseProblem> getCourseProblemByTeacherId(int teacherId, int pageNo, int pageItemNum){
		this.hql = "select b.* from bjtu_course AS a, bjtu_course_problem AS b "
				+ "where a.id=b.course_id and a.teacherId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, teacherId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseProblem> result = query.list();
		return result;
	}
	
	//select b.* from bjtu_course AS a, bjtu_course_problem AS b where a.id=b.course_id and a.name like '%方%';
	public List<CourseProblem> getCourseProblemByCourseName(String name, int pageNo, int pageItemNum){
		this.hql = "select b.* from bjtu_course AS a, bjtu_course_problem AS b "
				+ "where a.id=b.course_id and a.name like '%"+name+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		//query.setInteger(0, teacherId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseProblem> result = query.list();
		return result;
	}
}
