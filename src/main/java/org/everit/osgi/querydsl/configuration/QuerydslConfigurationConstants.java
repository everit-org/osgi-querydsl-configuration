/**
 * This file is part of Everit - QueryDSL Configuration.
 *
 * Everit - QueryDSL Configuration is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - QueryDSL Configuration is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - QueryDSL Configuration.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * This file is part of Everit - QueryDSL Support.
 *
 * Everit - QueryDSL Support is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - QueryDSL Support is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - QueryDSL Support.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.querydsl.configuration;

/**
 * Constants that make it possible to configure the Configuration component programmatically.
 */
public final class QuerydslConfigurationConstants {

    /**
     * OSGi service filter for the Querydsl SQLTemplates service.
     */
    public static final String PROP_SQL_TEMPLATES_TARGET = "sqlTemplates.target";

    /**
     * Property that says whether to use literals in the queries or not.
     */
    public static final String PROP_USE_LITERALS = "useLiterals";

    /**
     * The name of the component.
     */
    public static final String SERVICE_FACTORYPID_QUERYDSL_CONFIGURATION =
            "org.everit.osgi.querydsl.configuration.QuerydslConfiguration";

    private QuerydslConfigurationConstants() {
    }
}
