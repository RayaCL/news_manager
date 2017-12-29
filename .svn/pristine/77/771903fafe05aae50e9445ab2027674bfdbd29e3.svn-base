package cn.et.model;

import java.util.List;
import java.util.Map;

import cn.et.DbUtils;

public class MyNews {
	/**
	 * ≤Â»Î
	 * @param title
	 * @param content
	 * @param newsPath
	 */
	public void inserNews(String title,String content,String newsPath,String createTime){
		String sql="insert into mynews (title,content,htmlpath,createtime) values ('"+title+"','"+content+"','"+newsPath+"','"+createTime+"')";
	
		DbUtils.execute(sql);
		
	}
	/**
	 * ≤È—Ø
	 */
	public List<Map> queryNews() {
		String sql="select * from mynews";
		return DbUtils.query(sql);
	}
}
