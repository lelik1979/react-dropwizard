package com.oracle.ugbu.opower;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ReactApplication extends Application<ReactApplicationConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ReactApplication().run(args);
    }

    @Override
    public String getName() {
        return "ReactApplication";
    }

    @Override
    public void initialize(final Bootstrap<ReactApplicationConfiguration> bootstrap) {

    }

    @Override
    public void run(final ReactApplicationConfiguration configuration,
                    final Environment environment) {

    }

}
