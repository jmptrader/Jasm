package jasm;

import jasm.JasmC.Instance;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import jplug.util.Pair;
import wybs.lang.BuildProject;
import wybs.lang.BuildTask;
import wyfs.lang.Path.Entry;
import wyfs.lang.Path.Root;

/**
 * The Jasm Decompiler, responsible for decompiling JVM
 * Classfiles into ".jasm" files.
 * 
 * @author David J. Pearce
 * 
 */
public class JasmD implements BuildTask {
	
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

		/**
		 * Enable bytecode verification on the given class file. This is useful if
		 * you are debugging class files automatically generated (e.g. from a
		 * compiler).
		 */
		private boolean verify; 

		public Instance(BuildProject project) {
			this.project = project;
		}

		@Override
		public BuildProject project() {
			return project;
		}

		// =======================================================
		// Configuration Options
		// =======================================================

		public boolean getVerify() {
			return verify;
		}

		public void setVerify(boolean verify) {
			this.verify = verify;
		}

		public String describeVerify() {
			return "Enable bytecode verification on the class file(s) being decompiled.";
		}

		// =======================================================
		// Build Method
		// =======================================================

		@Override
		public Set<Entry<?>> build(Collection<Pair<Entry<?>, Root>> delta)
				throws IOException {
			System.out.println("ASKED TO DECOMPILE!");
			return null;
		}
	}
}
