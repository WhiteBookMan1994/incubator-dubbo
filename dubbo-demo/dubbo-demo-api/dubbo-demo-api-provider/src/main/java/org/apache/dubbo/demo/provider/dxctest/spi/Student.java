package org.apache.dubbo.demo.provider.dxctest.spi;

import org.apache.dubbo.common.URL;

/**
 * @author dingchenchen
 * @since 2021/4/10
 */
public class Student implements Person{

    @Override
    public String haveFood() {
        return "食堂卷饼";
    }

    @Override
    public String earnMoney(URL url) {
        return "兼职+打零工挣钱";
    }
}
