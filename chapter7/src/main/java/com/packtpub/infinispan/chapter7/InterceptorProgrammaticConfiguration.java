package com.packtpub.infinispan.chapter7;

import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.cache.InterceptorConfiguration;

/**
 * Code snippet to demonstrate programmatically configuring a custom interceptor.
 */
public class InterceptorProgrammaticConfiguration {
   public void configureInterceptor() {
      ConfigurationBuilder builder = new ConfigurationBuilder();
      builder.customInterceptors()
            .addInterceptor()
            .interceptor(new ReadOnlyInterceptor())
            .position(InterceptorConfiguration.Position.FIRST);
      Configuration c = builder.build();
   }
}
