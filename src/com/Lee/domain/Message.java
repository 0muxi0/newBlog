package com.Lee.domain;



/**
 * 留言实体
 * @author lee
 *
 */
public class Message {
		private Integer mid;//留言id
		private String img;//头像
		private String content;//留言内容
		private String name;//留言者名字
		private String uptime;//留言时间
		private int  tomid;//回复给哪条留言的ID（null表示一级评论,!null表示二级）
		private String toname;//回复给某个人的名字
		
		
		
		public Integer getMid() {
			return mid;
		}
		public void setMid(Integer mid) {
			this.mid = mid;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUptime() {
			return uptime;
		}
		public void setUptime(String uptime) {
			this.uptime = uptime;
		}
		public int getTomid() {
			return tomid;
		}
		public void setTomid(int tomid) {
			this.tomid = tomid;
		}
		public String getToname() {
			return toname;
		}
		public void setToname(String toname) {
			this.toname = toname;
		}
		
		
		
}
