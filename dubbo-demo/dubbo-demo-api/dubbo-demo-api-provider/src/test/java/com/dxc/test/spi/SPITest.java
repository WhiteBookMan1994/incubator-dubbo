package com.dxc.test.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.demo.provider.dxctest.spi.Person;
import org.junit.jupiter.api.Test;

/**
 * @author dingchenchen
 * @since 2021/4/10
 */
public class SPITest {

    @Test
    public void testSPI(){
        // 创建一个模拟调用的 URL 对象
        URL url = URL.valueOf("dubbo://127.0.0.1:20880?person=programmer");
        //通过 ExtensionLoader 获取一个 Person 对象
        Person person = ExtensionLoader.getExtensionLoader(Person.class).getAdaptiveExtension();
        System.out.println(person.earnMoney(url));
        System.out.println(person.haveFood());
    }
}
