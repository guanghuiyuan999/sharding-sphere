/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.orchestration.internal.config.listener;

import io.shardingsphere.orchestration.reg.api.RegistryCenter;
import io.shardingsphere.orchestration.reg.listener.DataChangedEventListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public final class RuleOrchestrationListenerTest {
    
    private RuleOrchestrationListener ruleOrchestrationListener;
    
    @Mock
    private RegistryCenter regCenter;
    
    @Before
    public void setUp() {
        ruleOrchestrationListener = new RuleOrchestrationListener("test", regCenter, "sharding_db");
    }
    
    @Test
    public void assertWatch() {
        ruleOrchestrationListener.watch();
        verify(regCenter).watch(eq("/test/config/schema/sharding_db/rule"), any(DataChangedEventListener.class));
    }
}
