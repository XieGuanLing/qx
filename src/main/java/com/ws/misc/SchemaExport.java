package com.ws.misc;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.schema.TargetType;
import org.reflections.Reflections;

import java.util.EnumSet;
import java.util.Set;

public class SchemaExport {
    public static void main(String[] args) {

        try {
            MetadataSources metadataSources = new MetadataSources(
                    new StandardServiceRegistryBuilder()
                            .applySetting(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect")
                            .applySetting(Environment.PHYSICAL_NAMING_STRATEGY, PhysicalNamingStrategyStandardImpl.INSTANCE)
                            .applySetting(Environment.IMPLICIT_NAMING_STRATEGY, ImplicitNamingStrategyStandardImpl.INSTANCE)
                            .build()
                     );

            Reflections reflections = new Reflections("com.ws");
            Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(javax.persistence.Entity.class);
            System.out.println(annotated);
            annotated.forEach(clazz ->{
                metadataSources.addAnnotatedClass(clazz);
            });

            org.hibernate.tool.hbm2ddl.SchemaExport export = new org.hibernate.tool.hbm2ddl.SchemaExport();
            export.setDelimiter(";");
            export.setFormat(true);
            export.setOutputFile("export.sql");
            export.execute(
                    EnumSet.of(TargetType.SCRIPT),
                    org.hibernate.tool.hbm2ddl.SchemaExport.Action.CREATE,
                    metadataSources.buildMetadata()
            );



        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
