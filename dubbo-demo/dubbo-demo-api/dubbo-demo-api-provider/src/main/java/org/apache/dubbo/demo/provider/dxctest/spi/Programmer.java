package org.apache.dubbo.demo.provider.dxctest.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;

/**
 * @author dingchenchen
 * @since 2021/4/10
 */
public class Programmer implements Person{
    @Override
    public String haveFood() {
        return "泡面";
    }

    @Override
    public String earnMoney(URL url) {
        return "写代码挣钱";
    }
}
