/*
 *  Copyright (c) 2022 Contributors to the Eclipse Foundation
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   and Apache License v2.0 which accompanies this distribution.
 *   The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *   and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 *   You may elect to redistribute this code under either of these licenses.
 *
 *   Contributors:
 *
 *   Otavio Santana
 */
package org.eclipse.jnosql.databases.arangodb.communication;

import org.eclipse.jnosql.communication.document.DocumentEntity;

import org.eclipse.jnosql.communication.document.DocumentManager;


import java.util.Map;
import java.util.stream.Stream;

/**
 * The ArangoDB implementation of {@link DocumentManager} it does not support to TTL methods:
 * <p>{@link DocumentManager#insert(DocumentEntity)}</p>
 */
public interface ArangoDBDocumentManager extends DocumentManager {

    /**
     * Executes ArangoDB query language, AQL.
     * <p>FOR u IN users FILTER u.status == @status RETURN u </p>
     *
     * @param query  the query
     * @param values the named queries
     * @return the query result
     * @throws NullPointerException when either query or values are null
     */
    Stream<DocumentEntity> aql(String query, Map<String, Object> values);

    /**
     * Executes ArangoDB query language, AQL.
     * <p>FOR u IN users FILTER u.status == @status RETURN u </p>
     *
     * @param query     the query
     * @param values    named query
     * @param typeClass The type of the result
     * @param <T>       the type
     * @return the query result
     * @throws NullPointerException when either query or values are null
     */
    <T> Stream<T> aql(String query, Map<String, Object> values, Class<T> typeClass);

    /**
     * Executes ArangoDB query language, AQL.
     * <p>FOR u IN users FILTER u.status == @status RETURN u </p>
     *
     * @param query     the query
     * @param typeClass The type of the result
     * @param <T>       the type
     * @return the query result
     * @throws NullPointerException when either query or values are null
     */
    <T> Stream<T> aql(String query, Class<T> typeClass);
}
