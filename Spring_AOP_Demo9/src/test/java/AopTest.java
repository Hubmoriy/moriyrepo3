import com.alankay.Service.AcconutService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description(描述):
 * author（作者）：河流
 * time：2020/6/25/0:49
 */
public class AopTest {
    public static void main(String[] args) {
        //获取 容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        AcconutService acconutService = applicationContext.getBean("acconutService",AcconutService.class);
        //执行方法
        acconutService.SaveAccount();
    }
}
