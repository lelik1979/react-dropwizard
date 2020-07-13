package org.lelik.react.dropwizard;

import org.lelik.react.dropwizard.resources.SomeAPIResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
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
        bootstrap.addBundle(new AssetsBundle("/web", "/", "index.html", "assets"));
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false))
        );
    }

    @Override
    public void run(final ReactApplicationConfiguration configuration,
                    final Environment environment) {

        environment.jersey().register(new SomeAPIResource());
    }

}
