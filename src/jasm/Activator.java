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
			public String id() {
				return "jasm.lang.ClassFile";
			}

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
			public String id() {
				return "jasm.JasmC";
			}

			@Override
			public Object data() {
				return new JasmC();
			}
		});
		
				
		// =================================================================
		// Register build task & platform for decompiling from class to jasm
		// files.
		// =================================================================
		context.register("wybs.BuildTask", new PluginContext.Extension() { 
			
			@Override
			public String id() {
				return "jasm.JasmD";
			}

			@Override
			public Object data() {
				return new JasmD();
			}
		});
		
		context.register("wybs.BuildPlatform", new PluginContext.Extension() {

			@Override
			public String id() {
				return "jasm.Class2JasmExtension";
			}

			@Override
			public Object data() {

				return new wybs.lang.BuildPlatform() {

					@Override
					public String id() {
						return "jasm.Class2JasmPlatform";
					}

					@Override
					public Type<?> sourceType() {
						// TODO Auto-generated method stub
						return ClassFile.ContentType;
					}

					@Override
					public Type<?> targetType() {
						return JasmFile.ContentType;
					}

					@Override
					public List<Type<?>> intermediateTypes() {
						return Collections.EMPTY_LIST;
					}

					@Override
					public Set<String> builders() {
						HashSet<String> builders = new HashSet<String>();
						builders.add("jasm.JasmD");
						return builders;
					}

					@Override
					public Set<String> dependents() {
						return Collections.EMPTY_SET;
					}
					
				};
			}
			
		});

	}

	@Override
	public void stop(PluginContext context) {
		// Not much to do really.
	}
}
