package com.sanyu.jpgrammar.entity;

public class Comments {
	// "created_at": "Wed Jun 01 00:50:25 +0800 2011",
	// "id": 12438492184,
	// "text": "love your work.......",
	// "source": "<a href="http://weibo.com" rel="nofollow">ĞÂÀËÎ¢²©</a>",
	// "mid": "202110601896455629",
	// "user":
	// "status":

	private String created_at;
	private long id;
	private String text;
	private String source;
	private User user;
	private Statuses status;
	private Comments reply_comment;

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Statuses getStatus() {
		return status;
	}

	public void setStatus(Statuses status) {
		this.status = status;
	}

	public Comments getReply_comment() {
		return reply_comment;
	}

	public void setReply_comment(Comments reply_comment) {
		this.reply_comment = reply_comment;
	}
}
