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
package org.eclipse.jnosql.databases.couchbase.communication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import static org.eclipse.jnosql.communication.driver.IntegrationTest.NAMED;
import static org.eclipse.jnosql.communication.driver.IntegrationTest.MATCHES;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnabledIfSystemProperty(named = NAMED, matches = MATCHES)
public class CouchbaseDocumentManagerFactoryTest {

    private CouchbaseDocumentConfiguration configuration;

    @BeforeEach
    public void setUp() {
        configuration = new CouchbaseDocumentConfiguration();

    }

    @Test
    public void shouldCreateEntityManager() {
        CouchbaseDocumentConfiguration configuration = Database.INSTANCE.getDocumentConfiguration();
        CouchbaseDocumentManagerFactory factory = configuration.apply(CouchbaseUtil.getSettings());
        assertNotNull(factory.apply(CouchbaseUtil.BUCKET_NAME));
    }
}