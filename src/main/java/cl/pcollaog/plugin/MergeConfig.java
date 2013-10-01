package cl.pcollaog.plugin;

import java.io.File;

/**
 * @author pcollaog
 * 
 */
public final class MergeConfig {

	private String outputFilename;

	private File outputDirectory;

	private File inputDirectory;

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
	 * @return the inputDirectory
	 */
	public File getInputDirectory() {
		return inputDirectory;
	}

	/**
	 * @param inputDirectory
	 *            the inputDirectory to set
	 */
	public void setInputDirectory(File inputDirectory) {
		this.inputDirectory = inputDirectory;
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
