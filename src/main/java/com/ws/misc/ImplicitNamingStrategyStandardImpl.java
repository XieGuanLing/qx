package com.ws.misc;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitJoinColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;

/**
 * Created by gl on 2019/4/1.
 */
public class ImplicitNamingStrategyStandardImpl extends ImplicitNamingStrategyJpaCompliantImpl {


    public static final ImplicitNamingStrategy INSTANCE = new ImplicitNamingStrategyStandardImpl();


    /**
     *     @ManyToOne
     *     private User operator ;
     *
     *    默认生成的字段是operator_user_id
     *
     *    需要operator_id
     *
     *
     *
     * @param source
     * @return
     */
    @Override
    public Identifier determineJoinColumnName(ImplicitJoinColumnNameSource source) {
        final String name;

        if ( source.getNature() == ImplicitJoinColumnNameSource.Nature.ELEMENT_COLLECTION
                || source.getAttributePath() == null ) {
            name = transformEntityName( source.getEntityNaming() )
                    + '_'
                    + source.getReferencedColumnName().getText();
        }
        else {
            name = transformAttributePath(source.getAttributePath())
                    + "_id";
        }
        return toIdentifier( name, source.getBuildingContext() );
    }
}
