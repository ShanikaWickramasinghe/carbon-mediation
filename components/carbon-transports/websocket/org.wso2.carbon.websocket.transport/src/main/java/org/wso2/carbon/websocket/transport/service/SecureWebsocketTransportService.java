/**
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.websocket.transport.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.core.transports.AbstractTransportService;
import org.wso2.carbon.core.transports.util.TransportParameter;

public class SecureWebsocketTransportService extends AbstractTransportService {

    private static final Log log = LogFactory.getLog(SecureWebsocketTransportService.class);

    public static final String TRANSPORT_NAME = "wss";
    public static final String TRANSPORT_CONF = "secure-websocket-transports.xml";

    public SecureWebsocketTransportService() {
        super(TRANSPORT_NAME);
    }

    public boolean dependenciesAvailable(TransportParameter[] params) {
        try {
            Class.forName("io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler");
            Class.forName("io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler");
            return true;
        } catch (ClassNotFoundException e) {
            log.error("Websocket protocol handlers not found");
            return false;
        }
    }
}












