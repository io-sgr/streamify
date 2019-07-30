/*
 * Copyright 2017-2019 SgrAlpha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.sgr.streamable.uploader.config;

import io.sgr.streamable.uploader.streams.webdav.WebDavUploadChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChannelConfigurer {

    private final String baseUrl;
    private final String username;
    private final String password;

    @Autowired
    public ChannelConfigurer(
            @Value("${webdav.base-url}") final String baseUrl,
            @Value("${webdav.username}") final String username,
            @Value("${webdav.password}") final String password) {
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
    }

    @Bean
    public WebDavUploadChannel webDavUploadChannel() {
        return new WebDavUploadChannel(baseUrl, username, password);
    }

}
