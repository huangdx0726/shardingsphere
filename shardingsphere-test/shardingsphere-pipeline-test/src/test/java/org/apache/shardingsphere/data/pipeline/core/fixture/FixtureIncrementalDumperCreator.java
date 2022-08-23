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

package org.apache.shardingsphere.data.pipeline.core.fixture;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.apache.shardingsphere.data.pipeline.api.config.ingest.DumperConfiguration;
import org.apache.shardingsphere.data.pipeline.api.ingest.channel.PipelineChannel;
import org.apache.shardingsphere.data.pipeline.api.ingest.position.FinishedPosition;
import org.apache.shardingsphere.data.pipeline.api.ingest.position.IngestPosition;
import org.apache.shardingsphere.data.pipeline.core.ingest.dumper.IncrementalDumperCreator;
import org.apache.shardingsphere.data.pipeline.core.metadata.loader.PipelineTableMetaDataLoader;
import org.apache.shardingsphere.data.pipeline.spi.ingest.dumper.IncrementalDumper;

/**
 * Fixture incremental dumper creator.
 */
public class FixtureIncrementalDumperCreator implements IncrementalDumperCreator<FinishedPosition> {
    
    private static final Collection<String> TYPE_ALIASES = Collections.unmodifiableList(Arrays.asList("Fixture", "H2"));
    
    @Override
    public IncrementalDumper createIncrementalDumper(final DumperConfiguration dumperConfig, final IngestPosition<FinishedPosition> position,
                                                     final PipelineChannel channel, final PipelineTableMetaDataLoader metaDataLoader) {
        return new FixtureIncrementalDumper(dumperConfig, position, channel, metaDataLoader);
    }
    
    @Override
    public String getType() {
        return "Fixture";
    }
    
    @Override
    public Collection<String> getTypeAliases() {
        return TYPE_ALIASES;
    }
}
