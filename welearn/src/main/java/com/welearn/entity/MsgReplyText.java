package com.welearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.welearn.util.TimeUtil;

@Entity
@Table(name="wx_msg_reply_text")
public class MsgReplyText {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="content", columnDefinition="varchar(1024)", nullable=false)
	private String content;
	
	@Column(name="index_id", columnDefinition="int default 0", nullable=false)
	private Integer indexId;

	public MsgReplyText() {
		super();
	}

	public MsgReplyText(String content, Integer indexId) {
		super();
		this.content = content;
		this.indexId = indexId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIndexId() {
		return indexId;
	}

	public void setIndexId(Integer indexId) {
		this.indexId = indexId;
	}
	
	/**
	 * 封装回复的XML字符串
	 * @param toUser 用户的微信号OpenID
	 * @param fromUser 开发者账号
	 * @return
	 */
	public String getReplyXML(String toUser, String fromUser) {
		String r = "<xml><ToUserName><![CDATA[";
		r += toUser + "]]></ToUserName><FromUserName><![CDATA[";
		r += fromUser + "]]></FromUserName><CreateTime>";
		r += TimeUtil.getAbsoluteTime() + "</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[";
		r += content + "]]></Content></xml>";
		return r;
	} 
}
