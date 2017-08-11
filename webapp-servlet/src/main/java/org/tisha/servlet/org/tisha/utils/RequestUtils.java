package org.tisha.servlet.org.tisha.utils;

import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @author Tsikhan Kuprevich
 * @since 8/11/2017
 */
public class RequestUtils {

    public static Collection<String> getRequestMappings(HttpServletRequest request) {
        Collection<String> mappingsOut = new LinkedList<>();
        Collection<String> mappings = new LinkedList<>();
        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext().getServletRegistrations();
        Set<? extends Map.Entry<String, ? extends ServletRegistration>> entries = servletRegistrations.entrySet();
        for (Map.Entry<String, ? extends ServletRegistration> entry : entries) {
            mappings.addAll(((ServletRegistration) entry.getValue()).getMappings());
        }
        Iterator<String> iterator = mappings.iterator();
        while (iterator.hasNext()) {
            String mapping = iterator.next();
            if (mapping.endsWith("*.jspx") || mapping.endsWith("*.jsp")) {
                continue;
            }
            if (mapping.endsWith("*")) {
                mappingsOut.add(mapping.substring(0, mapping.length() - 1));
                iterator.remove();
                continue;
            }
            mappingsOut.add(mapping);
        }
        return mappingsOut;
    }
}
