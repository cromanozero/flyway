/**
 * Copyright 2010-2016 Boxfuse GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flywaydb.core.internal.metadatatable;

import org.flywaydb.core.internal.dbsupport.Schema;

import java.util.concurrent.Callable;

/**
 * The metadata table used to track all applied migrations.
 */
public interface MetaDataTable extends FlywayMetaDataTable {

	/**
	 * Acquires an exclusive read-write lock on the metadata table. This lock will be released automatically upon completion.
	 * @return The result of the action.
	 */
	<T> T lock(Callable<T> callable);

	/**
	 * Indicates in the metadata table that Flyway created these schemas.
	 *
	 * @param schemas The schemas that were created by Flyway.
	 */
	void addSchemasMarker(Schema[] schemas);

}
