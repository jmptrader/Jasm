package jasm;

import jasm.lang.ClassFile;
import jplug.lang.PluginActivator;
import jplug.lang.PluginContext;
import wybs.lang.BuildProject;
import wybs.lang.BuildTask;

/**
 * Entry point for Jasm plugin when used within the Whiley Compiler Collection.
 * 
 * @author David J. Pearce
 * 
 */
public class Activator implements PluginActivator {

	@Override
	public void start(PluginContext context) {
		// =================================================================
		// Register Content.Type for class files.
		// =================================================================	
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
		
		// =================================================================
		// Register build tasks for compiling from jasm to class files.
		// =================================================================
		context.register("wybs.BuildTask", new PluginContext.Extension() { 
			@Override
			public String id() {
				return "jasm.util.BuildTask";
			}

			@Override
			public Object data() {
				return new BuildTask() {

					@Override
					public String id() {
						return "jasmc";
					}

					@Override
					public Instance instantiate(BuildProject project) {
						return null;
					}
					
				};
			}
		});
		
		// =================================================================
		// Register build tasks for decompiling from class to jasm files.
		// =================================================================
		context.register("wybs.BuildTask", new PluginContext.Extension() { 
			@Override
			public String id() {
				return "jasm.util.BuildTask";
			}

			@Override
			public Object data() {
				return new BuildTask() {

					@Override
					public String id() {
						return "jasmd";
					}

					@Override
					public Instance instantiate(BuildProject project) {
						return null;
					}
					
				};
			}
		});
	}

	@Override
	public void stop(PluginContext context) {
		// TODO Auto-generated method stub
		
	}

}
