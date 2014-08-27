package jasm;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jasm.lang.ClassFile;
import jplug.lang.PluginActivator;
import jplug.lang.PluginContext;
import wybs.lang.BuildProject;
import wybs.lang.BuildTask;
import wyfs.lang.Content.Type;

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
			public Object data() {
				return ClassFile.ContentType;
			}

		});

		// =================================================================
		// Register build task & platform for compiling from jasm to class
		// files.
		// =================================================================
		context.register("wybs.BuildTask", new PluginContext.Extension() {			
			@Override
			public Object data() {
				return JasmC.BuildTask;
			}
		});

		context.register("wybs.BuildPlatform", new PluginContext.Extension() {			
			@Override
			public Object data() {
				return JasmC.BuildPlatform;
			}
		});

		// =================================================================
		// Register build task & platform for decompiling from class to jasm
		// files.
		// =================================================================
		context.register("wybs.BuildTask", new PluginContext.Extension() {			
			@Override
			public Object data() {
				return JasmD.BuildTask;
			}
		});

		context.register("wybs.BuildPlatform", new PluginContext.Extension() {
			@Override
			public Object data() {
				return JasmD.BuildPlatform;
			}
		});

	}

	@Override
	public void stop(PluginContext context) {
		// Should unregister all registered extensions above.
	}
}
