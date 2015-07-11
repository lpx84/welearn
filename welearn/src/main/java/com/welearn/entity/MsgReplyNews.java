package com.welearn.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.welearn.util.TimeUtil;

@Entity
@Table(name="wx_msg_reply_news")
public class MsgReplyNews {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="index_id", columnDefinition="int default 0", nullable=false)
	private Integer indexId;

	public MsgReplyNews() {
		super();
	}

	public MsgReplyNews(Integer indexId) {
		super();
		this.indexId = indexId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIndexId() {
		return indexId;
	}

	public void setIndexId(Integer indexId) {
		this.indexId = indexId;
	}
	 
	/**
	 * 得到封装的XML文本
	 * @param toUser
	 * @param fromUser
	 * @param list 查询到该新闻的NewItem
	 * @return
	 */
	public String getReplyXML(String toUser, String fromUser, List<MsgNewsItem> list) {
		String r = "<xml><ToUserName><![CDATA[";
		r += toUser + "]]></ToUserName><FromUserName><![CDATA[";
		r += fromUser + "]]></FromUserName><CreateTime>";
		r += TimeUtil.getAbsoluteTime() + "</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount><![CDATA[";
		r += list.size() + "]]></ArticleCount><Articles>";
		for(MsgNewsItem n:list) {
			r += n.getReplyXML();
		}
		r += "</Articles></xml>";
		return r;
	} 
	
}
