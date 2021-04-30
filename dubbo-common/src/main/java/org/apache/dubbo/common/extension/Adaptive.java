/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.common.extension;

import org.apache.dubbo.common.URL;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Provide helpful information for {@link ExtensionLoader} to inject dependency extension instance.
 * 提供有用的信息，以供{@link ExtensionLoader}注入依赖项扩展实例。
 *
 * @see ExtensionLoader
 * @see URL
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Adaptive {
    /**
     * Decide which target extension to be injected. The name of the target extension is decided by the parameter passed
     * in the URL, and the parameter names are given by this method.
     * 确定要注入的目标扩展点。 目标扩展点名由URL中传递的参数决定，参数名称由此方法指定。
     *
     * <p>
     * If the specified parameters are not found from {@link URL}, then the default extension will be used for
     * dependency injection (specified in its interface's {@link SPI}).
     *
     * 如果从{@link URL}中找不到指定的参数，则将使用默认扩展名进行依赖项注入（在其接口的{@link SPI}中指定）。
     * <p>
     * For example, given <code>String[] {"key1", "key2"}</code>:
     * 例如，给定字符串数组 ["key1", "key2"]:
     * <ol>
     * <li>find parameter 'key1' in URL, use its value as the extension's name</li>
     * <li>在URL中找到参数“ key1”，使用其值作为扩展名</ li>
     *
     * <li>try 'key2' for extension's name if 'key1' is not found (or its value is empty) in URL</li>
     * <li>如果在URL中找不到“ key1”（或其值为空），请尝试使用“ key2”作为扩展名。</ li>
     *
     * <li>use default extension if 'key2' doesn't exist either</li>
     * <li>如果“key2”也不存在，请使用默认扩展点名称</ li>
     *
     * <li>otherwise, throw {@link IllegalStateException}</li>
     * <li>否则，抛出{@link IllegalStateException} </ li>
     * </ol>
     * If the parameter names are empty, then a default parameter name is generated from interface's
     * class name with the rule: divide classname from capital char into several parts, and separate the parts with
     * dot '.', for example, for {@code org.apache.dubbo.xxx.YyyInvokerWrapper}, the generated name is
     * <code>String[] {"yyy.invoker.wrapper"}</code>.
     *
     * 如果参数名称为空，则使用以下规则从接口的类名称生成默认参数名称：将大写字符的类名称分成几部分，并用点号'.'分隔，
     * 例如，用于{@code org.apache.dubbo.xxx.YyyInvokerWrapper}，
     * 生成的名称为<code> String [] {“ yyy.invoker.wrapper”} </ code>。
     *
     * @return parameter names in URL 注意：返回的是 URL 中参数的名称，并非参数=的值
     */
    String[] value() default {};

}