package mybatisProject;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/*
mybatis读取全局xml配置文件，解析XML中各个节点元素
将节点元素键值对，设置到Configuration实例的相关变量中
由Configuration实例创建SqlSessionFactory单例对象
 */
public class myBatis4 {
  public static void main(String[] args) throws Exception {
	
	  
	  String resource = "main/resources/SqlMapConfig.xml";
	  InputStream inputStream = Resources.getResourceAsStream(resource);
	  SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//建造者模式
	  
	  SqlSession session = sessionFactory.openSession();
	  
	  
	  
	  
	  
	  
}
}

 