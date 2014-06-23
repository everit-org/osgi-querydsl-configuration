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
package org.everit.osgi.querydsl.configuration.internal;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ConfigurationPolicy;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.everit.osgi.querydsl.configuration.QuerydslConfigurationConstants;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.mysema.query.sql.Configuration;
import com.mysema.query.sql.SQLTemplates;

/**
 * Simple component that registers {@link QuerydslSupport} as an OSGi service.
 */
@Component(name = QuerydslConfigurationConstants.SERVICE_FACTORYPID_QUERYDSL_CONFIGURATION, metatype = true,
        configurationFactory = true, policy = ConfigurationPolicy.REQUIRE)
@Properties({ @Property(name = QuerydslConfigurationConstants.PROP_SQL_TEMPLATES_TARGET),
        @Property(name = QuerydslConfigurationConstants.PROP_USE_LITERALS, boolValue = false) })
public class QuerydslConfigurationComponent {

    private ServiceRegistration<Configuration> serviceRegistration;
    /**
     * SQLTemplates reference.
     */
    @Reference
    private SQLTemplates sqlTemplates;

    @Activate
    public void activate(BundleContext context, Map<String, Object> props) {
        Configuration configuration = new Configuration(sqlTemplates);

        Object useLiteralsProp = props.get(QuerydslConfigurationConstants.PROP_USE_LITERALS);
        if (useLiteralsProp != null) {
            configuration.setUseLiterals(Boolean.valueOf(useLiteralsProp.toString()));
        }
        Dictionary<String, Object> serviceProperties = new Hashtable<String, Object>(props);
        serviceRegistration = context.registerService(Configuration.class, configuration, serviceProperties);
    }

    public void bindSqlTemplates(final SQLTemplates sqlTemplates) {
        this.sqlTemplates = sqlTemplates;
    }

    @Deactivate
    public void deactivate() {
        if (serviceRegistration != null) {
            serviceRegistration.unregister();
        }
    }
}
