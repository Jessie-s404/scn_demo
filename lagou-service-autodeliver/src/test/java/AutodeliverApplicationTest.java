import com.lagou.edu.AutodeliverApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * ClassName: AutodeliverApplicationTest
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-07-11 下午4:07   @Version 1.0        描述
 */
@SpringBootTest(classes = AutodeliverApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AutodeliverApplicationTest {

    @Autowired
    private DiscoveryClient discovery;

    @Test
    public void testInstanceMetadata() {
        List<ServiceInstance> instances = discovery.getInstances("lagou-service-resume");
        for (int i = 0; i < instances.size(); i++) {
            ServiceInstance serviceInstance = instances.get(i);
            System.out.println(serviceInstance);
        }
    }
}
