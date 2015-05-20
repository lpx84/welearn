package com.welearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
}
