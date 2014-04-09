package jasm;

import jasm.lang.ClassFile;
import wycc.lang.PluginActivator;
import wycc.lang.PluginContext;

/**
 * Entry point for Jasm plugin when used within the Whiley Compiler Collection.
 * 
 * @author David J. Pearce
 * 
 */
public class Activator implements PluginActivator {

	@Override
	public void start(PluginContext context) {
		context.register("wyfs.ContentType", ClassFile.ContentType.class);
	}

	@Override
	public void stop(PluginContext context) {
		// TODO Auto-generated method stub
		
	}

}