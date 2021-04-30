package org.apache.dubbo.demo.provider.dxctest.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author dingchenchen
 * @since 2021/4/10
 */
@SPI
public interface Person {

    /**
     * 吃的饭
     * @return
     */
    String haveFood();

    /**
     * 挣钱方式
     * @param url
     * @return
     */
    @Adaptive
    String earnMoney(URL url);
}
