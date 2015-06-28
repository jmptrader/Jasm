package jasm;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jasm.lang.ClassFile;
import jplug.lang.Feature;
import jplug.lang.Plugin;
import wybs.lang.BuildProject;
import wybs.lang.BuildTask;
import wyfs.lang.Content.Type;

/**
 * Entry point for Jasm plugin when used within the Whiley Compiler Collection.
 * 
 * @author David J. Pearce
 * 
 */
public class JasmPlugin implements Plugin {

	// ===============================================
	// Accessors
	// ===============================================

	@Override
	public Feature get(String... id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Feature> features() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String name() {
		return "jasm";
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// ===============================================
	// Activation
	// ===============================================
	
	public void start(Plugin.Context context) {
		// TODO: register classfile content type
//		context.register("wyfs.ContentType", new Feature() {
//			@Override
//			public Object data() {
//				return ClassFile.ContentType;
//			}
//
//		});
		
		// Register all tasks and platforms
		context.register("wybs.BuildTask", new JasmC.Task());
		context.register("wybs.BuildPlatform", new JasmC.Platform());
		context.register("wybs.BuildTask", new JasmD.Task());
		context.register("wybs.BuildPlatform", new JasmD.Platform());
	}
	
	public static class Activator implements Plugin.Activator {
		@Override
		public Plugin start(Plugin.Context context) {
			JasmPlugin thisPlugin = new JasmPlugin();
			thisPlugin.start(context);
			return thisPlugin;
		}

		@Override
		public void stop(Plugin plugin, Plugin.Context context) {
			// Should unregister all registered extensions above.
		}
	}
}
