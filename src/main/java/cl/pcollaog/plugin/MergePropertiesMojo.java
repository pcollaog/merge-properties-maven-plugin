package cl.pcollaog.plugin;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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

	@Parameter(property = "merges")
	private List<MergeConfig> merges;

	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("Hello, world.");

		getLog().info("Reading input properties");

		Properties propertyOut = new Properties();

		for (MergeConfig mergeConfig : merges) {
			FileFilter filter = new WildcardFileFilter(mergeConfig.getPattern());
			File[] listFiles = mergeConfig.getInputDirectory()
					.listFiles(filter);

			for (File file : listFiles) {
				try {
					Properties prop = new Properties();
					InputStream is = new FileInputStream(file);
					prop.load(is);

					propertyOut.putAll(prop);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
