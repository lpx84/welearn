package com.welearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.welearn.util.TimeUtil;

@Entity
@Table(name="wx_msg_news_item")
public class MsgNewsItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="news_id", columnDefinition="int", nullable=false)
	private Integer newsId;
	
	@Column(name="title", columnDefinition="varchar(100)", nullable=false)
	private String title;
	
	@Column(name="description", columnDefinition="varchar(255)", nullable=false)
	private String description;
	
	@Column(name="pic_url", columnDefinition="varchar(255)", nullable=false)
	private String picUrl;
	
	@Column(name="url", columnDefinition="varchar(255)", nullable=false)
	private String url;

	public MsgNewsItem() {
		super();
	}

	public MsgNewsItem(Integer newsId, String title, String description,
			String picUrl, String url) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.description = description;
		this.picUrl = picUrl;
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	 
	public String getReplyXML() {
		String r = "<item><Title><![CDATA[";
		r += title + "]]></Title><Description><![CDATA[";
		r += description + "]]></Description><PicUrl>";
		r += picUrl + "</PicUrl><Url><![CDATA[";
		r += url + "]]></Url></item>";
		return r;
	}
	
}
