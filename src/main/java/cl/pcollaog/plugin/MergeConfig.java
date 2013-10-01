package cl.pcollaog.plugin;

import java.io.File;

/**
 * @author pcollaog
 * 
 */
public final class MergeConfig {

	private String outputFilename;

	private File outputDirectory;

	private File sourceDirectory;

	private String pattern;

	/**
	 * @return the outputFilename
	 */
	public String getOutputFilename() {
		return outputFilename;
	}

	/**
	 * @param outputFilename
	 *            the outputFilename to set
	 */
	public void setOutputFilename(String outputFilename) {
		this.outputFilename = outputFilename;
	}

	/**
	 * @return the outputDirectory
	 */
	public File getOutputDirectory() {
		return outputDirectory;
	}

	/**
	 * @param outputDirectory
	 *            the outputDirectory to set
	 */
	public void setOutputDirectory(File outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

	/**
	 * @return the sourceDirectory
	 */
	public File getSourceDirectory() {
		return sourceDirectory;
	}

	/**
	 * @param sourceDirectory
	 *            the sourceDirectory to set
	 */
	public void setSourceDirectory(File sourceDirectory) {
		this.sourceDirectory = sourceDirectory;
	}

	/**
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * @param pattern
	 *            the pattern to set
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
