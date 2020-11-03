package com.briup.estore.web.listener;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.util.GetInstance;

@WebListener
public class IndexListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
    
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext app = sce.getServletContext();
    	try {
			Map<Category, List<Category>> categoriesMap = GetInstance.CATEGORY_SERVER.selectCategoryMap();
			List<List<Book>> two = GetInstance.BOOK_SERVER.selectBookHalf();
			app.setAttribute("categoriesMap", categoriesMap);
			app.setAttribute("goodBooks", two.get(0));
			app.setAttribute("seckillBooks", two.get(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
