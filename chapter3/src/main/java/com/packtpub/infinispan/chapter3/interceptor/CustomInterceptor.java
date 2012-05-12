package com.packtpub.infinispan.chapter3.interceptor;

import org.infinispan.commands.write.PutKeyValueCommand;
import org.infinispan.commands.write.RemoveCommand;
import org.infinispan.context.InvocationContext;

public class CustomInterceptor extends org.infinispan.interceptors.base.CommandInterceptor {

   public CustomInterceptor() {}
   @Override
      public Object visitRemoveCommand(InvocationContext ctx, RemoveCommand command) throws Throwable {
       if (command.getKey().equals(1))  {
           System.out.println("Unable to remove Ticket N. 1");
           return null;
       }
       Object retval = super.visitRemoveCommand(ctx, command);
          
         return retval;
      }
   @Override
      public Object visitPutKeyValueCommand(InvocationContext ctx, PutKeyValueCommand command) throws Throwable {
        if ((Integer)command.getKey() > 1000)  {
          System.out.println("Sorry, no more than 1000 Tickets can be sold!!");
          return null;
       }  
       Object retval = super.visitPutKeyValueCommand(ctx, command);
          
         return retval;
      }

}
