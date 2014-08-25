package jasm;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import jplug.util.Pair;
import wybs.lang.BuildProject;
import wybs.lang.BuildTask;
import wyfs.lang.Path.Entry;
import wyfs.lang.Path.Root;

/**
 * The Jasm Compiler, responsible for compiling ".jasm" files into JVM
 * Classfiles.
 * 
 * @author David J. Pearce
 * 
 */
public class JasmC implements BuildTask {

	@Override
	public String id() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuildTask.Instance instantiate(BuildProject project) {
		return new Instance(project);
	}
	
	/**
	 * An instance of the JasmC build task for a given project. Instances will
	 * differ between different projects, but there will always be exactly one
	 * instance per project.
	 * 
	 * @author David J. Pearce
	 * 
	 */
	public class Instance implements BuildTask.Instance {
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
