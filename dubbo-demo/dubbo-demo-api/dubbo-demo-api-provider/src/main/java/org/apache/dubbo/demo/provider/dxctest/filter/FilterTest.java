package org.apache.dubbo.demo.provider.dxctest.filter;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcException;

import static org.apache.dubbo.common.constants.CommonConstants.CONSUMER;
import static org.apache.dubbo.common.constants.CommonConstants.PROVIDER;

/**
 * @author dingchenchen
 * @since 2021/4/30
 */
@Activate(group = {PROVIDER, CONSUMER})
public class FilterTest implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("filter:" + invoker.getInterface().getName());
        return invoker.invoke(invocation);
    }
}
