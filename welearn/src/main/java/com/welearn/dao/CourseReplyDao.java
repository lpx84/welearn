package com.welearn.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.Admin;
import com.welearn.entity.CourseReply;

public class CourseReplyDao extends SuperDao {
	
	public Integer AddCourseReply(CourseReply courseReply){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseReply);
	}
	
	public boolean delCourseReplyById(int id){
		this.hql = "DELETE FROM CourseReply AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseReplyByCourseId(int courseId){
		this.hql = "DELETE FROM CourseReply AS u WHERE u.courseId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseReplyByReplyor(String replyor){
		this.hql = "DELETE FROM CourseReply AS u WHERE u.replyor=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, replyor);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseReply(CourseReply courseReply){
		this.sessionFactory.getCurrentSession().update(courseReply);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseReply getCourseReplyById(int id){
		this.hql = "FROM CourseReply AS u inner join fetch u.courseEntity WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseReply) query.uniqueResult();
	}
	
	public List<CourseReply> getCourseReplyByCourseID(int courseid){
		this.hql = "from CourseReply as a inner join fetch a.courseEntity where a.courseId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		List<CourseReply> result = query.list();
		return result;
	}
	
	public List<CourseReply> getCourseReplyByReplyIDandType(int replyId, int type){
		this.hql = "from CourseReply as a inner join fetch a.courseEntity where a.replyIdId=? AND a.type=? order by a.reply_time desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, replyId);
		query.setInteger(1, type);
		List<CourseReply> result = query.list();
		
		/*for(int i=0;i<result.size();i++){
			System.out.println("---------------");
			System.out.println(result.get(i).toString());
		}*/
		
		return result;
	}
	
	/**
	 * 参数时间之后的回复
	 * @param courseId
	 * @param time
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CourseReply> getCourseReplyByTimeAfter(int courseId, Date time){
		this.hql = "from CourseReply as a inner join fetch a.courseEntity where a.courseId=:courseId and a.reply_time > :date order by a.reply_time desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger("courseId", courseId);
		query.setTimestamp("date", time);
		return query.list();
	}
	
	/**
	 * 参数时间之前的回复
	 * @param courseId
	 * @param time
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CourseReply> getCourseReplyByTimeBefore(int courseId, Date time){
		this.hql = "from CourseReply as a inner join fetch a.courseEntity where a.courseId=:courseId and a.reply_time < :date order by a.reply_time desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger("courseId", courseId);
		query.setTimestamp("date", time);
		return query.list();
	}
	
	/**
	 * 参数之前的回复，规定条数
	 * @param courseId
	 * @param time
	 * @param num
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CourseReply> getCourseReplyByTimeBefore(int courseId, Date time, int num){
		this.hql = "from CourseReply as a inner join fetch a.courseEntity where a.courseId=:courseId and a.reply_time < :date order by a.reply_time desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger("courseId", courseId);
		query.setTimestamp("date", time);
		query.setMaxResults(num);
		return query.list();
	}
	
	
}
