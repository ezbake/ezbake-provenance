/*   Copyright (C) 2013-2014 Computer Sciences Corporation
 *
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
 * limitations under the License. */

package ezbake.services.provenance.graph.frames;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;

/**
 * Created with IntelliJ IDEA.
 * User: dev
 * Date: 9/9/14
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AgeOffEvent extends VertexFrame {
    public static final String TYPE = "AgeOffEvent";
    public static final String EventMaxId = "EventMaxId";

    @Property(BaseVertex.Type)
    public void setType(String user);

    @Property(BaseVertex.Type)
    public String getType();

    @Property(EventMaxId)
    public long getEventMaxId();

    @Property(EventMaxId)
    public void setEventMaxId(long id);

}