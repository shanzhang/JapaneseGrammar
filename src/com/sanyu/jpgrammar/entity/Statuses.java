package com.sanyu.jpgrammar.entity;

public class Statuses {
	// "created_at": "Tue May 31 17:46:55 +0800 2011",
	// "id": 11488058246,
	// "text": "求关注。",
	// "source": "<a href="http://weibo.com" rel="nofollow">新浪微博</a>",
	// "favorited": false,
	// "truncated": false,
	// "in_reply_to_status_id": "",
	// "in_reply_to_user_id": "",
	// "in_reply_to_screen_name": "",
	// "geo": null,
	// "mid": "5612814510546515491",
	// "reposts_count": 8,
	// "comments_count": 9,
	// "annotations": [],
	// "user":

	private String created_at;// 创建时间
	private long id;
	private String text;// 内容
	private int comments_count;// 评论数
	private int reposts_count;// 转发数
	private int attitudes_count;// 表态数(赞)
	private String thumbnail_pic;// 缩略图片地址，没有时不返回此字段
	private String bmiddle_pic; // 中等尺寸图片地址，没有时不返回此字段
	private String original_pic; // 原始图片地址，没有时不返回此字段
	private User user;
	private String source;// 微博来源
	private Statuses retweeted_status;// 转发微博

	private boolean isSina;

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(getUser().getName() + ": " + getText());
		if (retweeted_status != null) {
			buffer.append("\n" + "转发至: " + retweeted_status.getUser().getName() + ": "
					+ retweeted_status.getText());
		}
		return buffer.toString();
	}

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

	public int getComments_count() {
		return comments_count;
	}

	public void setComments_count(int comments_count) {
		this.comments_count = comments_count;
	}

	public int getReposts_count() {
		return reposts_count;
	}

	public void setReposts_count(int reposts_count) {
		this.reposts_count = reposts_count;
	}

	public int getAttitudes_count() {
		return attitudes_count;
	}

	public void setAttitudes_count(int attitudes_count) {
		this.attitudes_count = attitudes_count;
	}

	public String getThumbnail_pic() {
		return thumbnail_pic;
	}

	public void setThumbnail_pic(String thumbnail_pic) {
		this.thumbnail_pic = thumbnail_pic;
	}

	public String getBmiddle_pic() {
		return bmiddle_pic;
	}

	public void setBmiddle_pic(String bmiddle_pic) {
		this.bmiddle_pic = bmiddle_pic;
	}

	public String getOriginal_pic() {
		return original_pic;
	}

	public void setOriginal_pic(String original_pic) {
		this.original_pic = original_pic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Statuses getRetweeted_status() {
		return retweeted_status;
	}

	public void setRetweeted_status(Statuses retweeted_status) {
		this.retweeted_status = retweeted_status;
	}

	public boolean isSina() {
		return isSina;
	}

	public void setSina(boolean isSina) {
		this.isSina = isSina;
	}
}
