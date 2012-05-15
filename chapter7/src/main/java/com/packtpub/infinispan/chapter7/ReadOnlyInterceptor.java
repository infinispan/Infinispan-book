package com.packtpub.infinispan.chapter7;

import org.infinispan.commands.write.ClearCommand;
import org.infinispan.commands.write.PutKeyValueCommand;
import org.infinispan.commands.write.PutMapCommand;
import org.infinispan.commands.write.RemoveCommand;
import org.infinispan.commands.write.ReplaceCommand;
import org.infinispan.context.InvocationContext;
import org.infinispan.interceptors.base.BaseCustomInterceptor;
import org.infinispan.util.logging.Log;
import org.infinispan.util.logging.LogFactory;

public class ReadOnlyInterceptor extends BaseCustomInterceptor {
   
   private static final Log LOG = LogFactory.getLog(ReadOnlyInterceptor.class);  
   
   @Override
   protected Log getLog() {
      return LOG;
   }

   @Override
   protected void start() {
      LOG.info("Read-only interceptor starting up");
   }

   @Override
   protected void stop() {
      LOG.info("Read-only interceptor stopping");
   }

   @Override
   public Object visitPutKeyValueCommand(InvocationContext ctx, PutKeyValueCommand cmd) {
      LOG.debug("Ignoring this call to enforce read-only behavior");
      return null;
   }

   @Override
   public Object visitPutMapCommand(InvocationContext ctx, PutMapCommand cmd) {
      LOG.debug("Ignoring this call to enforce read-only behavior");
      return null;
   }

   @Override
   public Object visitRemoveCommand(InvocationContext ctx, RemoveCommand cmd) {
      LOG.debug("Ignoring this call to enforce read-only behavior");
      return null;
   }

   @Override
   public Object visitReplaceCommand(InvocationContext ctx, ReplaceCommand cmd) {
      LOG.debug("Ignoring this call to enforce read-only behavior");
      return null;
   }

   @Override
   public Object visitClearCommand(InvocationContext ctx, ClearCommand cmd) throws Throwable {
      LOG.debug("Read-only, but we will allow the cache to be cleared!");
      Object o = invokeNextInterceptor(ctx, cmd);
      if (cmd.isSuccessful()) {
         LOG.debug("Cache successfully cleared!");
      } else {
         LOG.debug("Clear command failed!");
      }
      return o;
   }
}
