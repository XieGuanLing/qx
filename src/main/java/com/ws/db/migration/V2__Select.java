package com.ws.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

/**
 * Created by gl on 2019/4/1.
 */

public class V2__Select extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        context.getConnection().prepareStatement("select * from sm_user").execute();
    }
}
