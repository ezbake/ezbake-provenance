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

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.frames.EdgeFrame;
import com.tinkerpop.frames.modules.javahandler.JavaHandler;
import com.tinkerpop.frames.modules.javahandler.JavaHandlerContext;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: dev
 * Date: 6/20/14
 * Time: 7:01 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * All Documents inserted with InheritanceInfo should have an edge running from each parent document to the child document.
 */
public interface DerivedFrom extends BaseEdge {

    public static final String LABEL = "DerivedFrom";

    @JavaHandler
    public void updateProperties(ezbake.base.thrift.EzSecurityToken securityToken);

    public abstract class Impl extends BaseEdgeImpl implements DerivedFrom {

        public void updateProperties(ezbake.base.thrift.EzSecurityToken securityToken) {
            super.updateCommonProperties(securityToken);
        }
    }

}
