package jasm;

import jasm.lang.ClassFile;
import jplug.lang.PluginActivator;
import jplug.lang.PluginContext;

/**
 * Entry point for Jasm plugin when used within the Whiley Compiler Collection.
 * 
 * @author David J. Pearce
 * 
 */
public class Activator implements PluginActivator {

	@Override
	public void start(PluginContext context) {
		context.register("wyfs.ContentType", new PluginContext.Extension() {

			@Override
			public String id() {
				return "jasm.lang.ClassFile";
			}

			@Override
			public Object data() {
				return ClassFile.ContentType;
			}
			
		});
	}

	@Override
	public void stop(PluginContext context) {
		// TODO Auto-generated method stub
		
	}

}
