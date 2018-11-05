package mybatisProject;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/*
mybatis��ȡȫ��xml�����ļ�������XML�и����ڵ�Ԫ��
���ڵ�Ԫ�ؼ�ֵ�ԣ����õ�Configurationʵ������ر�����
��Configurationʵ������SqlSessionFactory��������
 */
public class myBatis4 {
  public static void main(String[] args) throws Exception {
	
	  
	  String resource = "main/resources/SqlMapConfig.xml";
	  InputStream inputStream = Resources.getResourceAsStream(resource);
	  SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//������ģʽ
	  
	  SqlSession session = sessionFactory.openSession();
	  
	  
	  
	  
	  
	  
}
}

 