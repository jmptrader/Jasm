package jasm;

import jasm.lang.ClassFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import jplug.lang.Feature;
import jplug.util.Pair;
import wybs.lang.BuildPlatform;
import wybs.lang.BuildProject;
import wybs.lang.BuildTask;
import wyfs.lang.Content.Type;
import wyfs.lang.Path.Entry;
import wyfs.lang.Path.Root;

/**
 * The Jasm Compiler, responsible for compiling ".jasm" files into JVM
 * Classfiles.
 * 
 * @author David J. Pearce
 * 
 */
public class JasmC {

	// =====================================================================
	// Build Task
	// =====================================================================
	
	public static class Task implements BuildTask,Feature {

		@Override
		public String name() {
			return "BuildTask";
		}

		@Override
		public String description() {
			return null;
		}

		@Override
		public String id() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BuildTask.Instance instantiate(BuildProject project) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
		
	// =====================================================================
	// Build Platform
	// =====================================================================
	
	public static final class Platform implements BuildPlatform,Feature {

		@Override
		public String name() {
			return "BuildPlatform";
		}

		@Override
		public String description() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String id() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Type<?> sourceType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Type<?> targetType() {
			return ClassFile.ContentType;
		}

		@Override
		public List<Type<?>> intermediateTypes() {
			return Collections.EMPTY_LIST;
		}

		@Override
		public Set<String> builders() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Set<String> dependents() {
			return Collections.EMPTY_SET;
		}
	}
	
	// =====================================================================
	// Build Task Instance
	// =====================================================================
	
	/**
	 * An instance of the JasmC build task for a given project. Instances will
	 * differ between different projects, but there will always be exactly one
	 * instance per project.
	 * 
	 * @author David J. Pearce
	 * 
	 */
	public static class Instance implements BuildTask.Instance {
		private final BuildProject project;

		public Instance(BuildProject project) {
			this.project = project;
		}

		@Override
		public BuildProject project() {
			return project;
		}

		@Override
		public Set<Entry<?>> build(Collection<Pair<Entry<?>, Root>> delta)
				throws IOException {
			// TODO Auto-generated method stub
			return null;
		}				
	}
	
}
