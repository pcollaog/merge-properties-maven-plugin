package cl.pcollaog.plugin;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * @author pcollaog
 * 
 */
@Mojo(name = "merge")
public class MergePropertiesMojo extends AbstractMojo {

	/**
	 * 
	 */
	private static final String DEFAULT_ENCODING = "UTF-8";

	@Parameter(property = "merges")
	private List<MergeConfig> merges;

	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("Hello, world.");

		getLog().info("Reading input properties");

		Properties propertyOut = new Properties();

		for (MergeConfig mergeConfig : merges) {
			FileFilter filter = new WildcardFileFilter(mergeConfig.getPattern());
			File[] listFiles = mergeConfig.getSourceDirectory().listFiles(
					filter);

			for (File file : listFiles) {
				try {
					Properties prop = new Properties();
					InputStreamReader is = new InputStreamReader(
							new FileInputStream(file), DEFAULT_ENCODING);
					prop.load(is);
					propertyOut.putAll(prop);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			try {
				File outputDirectory = mergeConfig.getOutputDirectory();

				if (!outputDirectory.exists()) {
					outputDirectory.mkdirs();
				}

				if (outputDirectory.exists() && outputDirectory.isDirectory()) {
					String outTmp = outputDirectory.getPath() + File.separator
							+ mergeConfig.getOutputFilename();

					File out = new File(outTmp);

					if (!out.exists()) {
						out.createNewFile();
					} else {
						out.delete();
						out.createNewFile();
					}

					OutputStreamWriter outputStream = new OutputStreamWriter(
							new FileOutputStream(out), DEFAULT_ENCODING);

					propertyOut.store(outputStream, "Merge Properties");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the merges
	 */
	public final List<MergeConfig> getMerges() {
		return merges;
	}

	/**
	 * @param merges
	 *            the merges to set
	 */
	public final void setMerges(List<MergeConfig> merges) {
		this.merges = merges;
	}

}
