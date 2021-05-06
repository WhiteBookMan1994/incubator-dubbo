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
 * Activate. This annotation is useful for automatically activate certain extensions with the given criteria,
 * for examples: <code>@Activate</code> can be used to load certain <code>Filter</code> extension when there are
 * multiple implementations.
 * 激活。此注解对于使用给定条件自动激活某些扩展非常有用，
 * 例如：<code>@Activate</code>可用于在有多个实现时加载某些<code>Filter</code>扩展。
 * <ol>
 * <li>{@link Activate#group()} specifies group criteria. Framework SPI defines the valid group values.
 * {@link Activate#group()}指定组条件。框架SPI定义有效的组值。
 * <li>{@link Activate#value()} specifies parameter key in {@link URL} criteria.
 * {@link Activate#value()}指定{@link URL}条件中的参数键。
 * </ol>
 * SPI provider can call {@link ExtensionLoader#getActivateExtension(URL, String, String)} to find out all activated
 * extensions with the given criteria.
 * SPI提供者可以调用{@link ExtensionLoader＃getActivateExtension（URL，String，String）}来找出具有给定条件的所有激活的扩展。
 *
 * @see SPI
 * @see URL
 * @see ExtensionLoader
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Activate {
    /**
     * Activate the current extension when one of the groups matches. The group passed into
     * {@link ExtensionLoader#getActivateExtension(URL, String, String)} will be used for matching.
     *
     * 当其中一个组匹配时激活当前扩展。传递到{@link ExtensionLoader#getActivateExtension（URL，String，String）}的组将用于匹配。
     *
     * @return group names to match
     * @see ExtensionLoader#getActivateExtension(URL, String, String)
     */
    String[] group() default {};

    /**
     * Activate the current extension when the specified keys appear in the URL's parameters.
     * 当指定的键出现在URL的参数中时，激活当前扩展名。
     * <p>
     * For example, given <code>@Activate("cache, validation")</code>, the current extension will be return only when
     * there's either <code>cache</code> or <code>validation</code> key appeared in the URL's parameters.
     * </p>
     *
     * 例如，给定<code>@Activate（“cache，validation”）</code>，
     * 仅当URL参数中出现<code>cache</code>或<code>validation</code>键时，才会返回当前扩展名。
     *
     * @return URL parameter keys
     * @see ExtensionLoader#getActivateExtension(URL, String)
     * @see ExtensionLoader#getActivateExtension(URL, String, String)
     */
    String[] value() default {};

    /**
     * Relative ordering info, optional
     * Deprecated since 2.7.0
     *
     * @return extension list which should be put before the current one
     */
    @Deprecated
    String[] before() default {};

    /**
     * Relative ordering info, optional
     * Deprecated since 2.7.0
     *
     * @return extension list which should be put after the current one
     */
    @Deprecated
    String[] after() default {};

    /**
     * Absolute ordering info, optional
     * 顺序，可选的
     *
     * @return absolute ordering info
     */
    int order() default 0;
}