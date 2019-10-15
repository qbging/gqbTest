package mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author guoqb
 * @date : 2019/10/11 16:01
 */
public class test {

    public static void main(String[] args) {
        try {
            InputStream inputStream = test.class.getResourceAsStream(".\\mybatis-config.xml");
//            InputStream inputStream = Resources.getResourceAsStream("./mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
//            ResultHandler resultHandler
            List<Object> objects = sqlSession.selectList("select * from test");
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
