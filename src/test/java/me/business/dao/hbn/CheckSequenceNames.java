package me.business.dao.hbn;

import static org.junit.Assert.fail;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.SequenceGenerator;
import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Aug 28, 2014
 * 
 */
public class CheckSequenceNames {

	private static final String MODEL_PACKAGE = "me.business.model";
	private static final String DB_DDL_PATH = "db/schema.sql";
	private Reflections reflections;
	// TODO fix when the ddl is too big.
	private String schemaContent;

	/**
	 * http://stackoverflow.com/a/9571146/1126380
	 * 
	 * @throws IOException
	 */
	@Before
	public void initReflections() throws IOException {

		List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
		classLoadersList.add(ClasspathHelper.contextClassLoader());
		classLoadersList.add(ClasspathHelper.staticClassLoader());

		reflections = new Reflections(
				new ConfigurationBuilder()
						.setScanners(new SubTypesScanner(false),
								new ResourcesScanner())
						.setUrls(
								ClasspathHelper.forClassLoader(classLoadersList
										.toArray(new ClassLoader[0])))
						.filterInputsBy(
								new FilterBuilder().include(FilterBuilder
										.prefix(MODEL_PACKAGE))));

		ClassPathResource cpr = new ClassPathResource(DB_DDL_PATH);
		schemaContent = new String(FileCopyUtils.copyToByteArray(cpr
				.getInputStream())).toLowerCase();
	}

	@Test
	public void testCheckNames() throws Exception {

		Set<Class<?>> entities = reflections.getSubTypesOf(Object.class);

		for (Class<?> clazz : entities) {

			System.out.println(clazz);
			String name = getSequenceName(clazz);
			if (name == null)
				continue;
			if (!schemaContent.contains(name.toLowerCase())) {
				fail("The clazz " + clazz.getSimpleName()
						+ " has a sequence called: " + name
						+ " and it doesn't exits");
			}
		}

	}

	/**
	 * TODO check when the clazz has two or more sequences.
	 * 
	 * @param clazz
	 * @return
	 */
	private String getSequenceName(Class<?> clazz) {

		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(SequenceGenerator.class)) {

				SequenceGenerator sg = f.getAnnotation(SequenceGenerator.class);
				return sg.sequenceName();
			}
		}
		return null;
	}
}
