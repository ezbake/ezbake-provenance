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
 * Date: 9/19/14
 * Time: 10:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class IdGeneratorException extends Exception {

    public IdGeneratorException(String message) {
        super(message);
    }

    public IdGeneratorException(Exception ex) {
        super(ex);
    }
}
