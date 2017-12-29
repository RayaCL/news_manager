package cn.et.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.et.model.MyNews;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Servlet implementation class NewsController
 */
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NewsController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public static final String HTML_DIR="F:\\html";
    MyNews myNews=new MyNews();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Date date=new Date();
		String createtime=sdf.format(date);
	
		String uuid=UUID.randomUUID().toString();
		//生成html
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		cfg.setDirectoryForTemplateLoading(
		        new File("src/main/resources"));
		cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_23));  
		Map root = new HashMap();
		root.put("title", title);
		root.put("content", content);
		root.put("createtime", createtime);
		Template temp = cfg.getTemplate("newsdetail.ftl");
		String saveFile=HTML_DIR+"/"+uuid+".html";
		FileOutputStream fos=new FileOutputStream(new File(saveFile));
		Writer out = new OutputStreamWriter(fos);
		try {
			temp.process(root, out);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();  
		response.getWriter().println("添加成功");
		
		myNews.inserNews(title, content, uuid+".html",createtime);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
