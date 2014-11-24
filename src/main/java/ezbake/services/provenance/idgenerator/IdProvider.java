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

package ezbake.services.provenance.idgenerator;

/**
 * Created with IntelliJ IDEA.
 * User: dev
 * Date: 9/18/14
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IdProvider {
    public enum ID_GENERATOR_TYPE {
        DocumentType,
        AgeOffRule,
        PurgeEvent
    }

    public abstract void shutdown();

    public abstract long getNextId(ID_GENERATOR_TYPE type) throws IdGeneratorException;

    public abstract long getNextNId(ID_GENERATOR_TYPE type, long delta) throws IdGeneratorException;

    public abstract long getCurrentValue(ID_GENERATOR_TYPE type) throws IdGeneratorException;

    public abstract void setCurrentValue(ID_GENERATOR_TYPE type, long value) throws IdGeneratorException;
}

