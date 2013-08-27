package com.sanyu.jpgrammar.entity;

public class Statuses {
	// "created_at": "Tue May 31 17:46:55 +0800 2011",
	// "id": 11488058246,
	// "text": "���ע��",
	// "source": "<a href="http://weibo.com" rel="nofollow">����΢��</a>",
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

	private String created_at;// ����ʱ��
	private long id;
	private String text;// ����
	private int comments_count;// ������
	private int reposts_count;// ת����
	private int attitudes_count;// ��̬��(��)
	private String thumbnail_pic;// ����ͼƬ��ַ��û��ʱ�����ش��ֶ�
	private String bmiddle_pic; // �еȳߴ�ͼƬ��ַ��û��ʱ�����ش��ֶ�
	private String original_pic; // ԭʼͼƬ��ַ��û��ʱ�����ش��ֶ�
	private User user;
	private String source;// ΢����Դ
	private Statuses retweeted_status;// ת��΢��

	private boolean isSina;

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(getUser().getName() + ": " + getText());
		if (retweeted_status != null) {
			buffer.append("\n" + "ת����: " + retweeted_status.getUser().getName() + ": "
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
