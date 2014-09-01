// ========================================================================
// Copyright (c) 2009-2009 Mort Bay Consulting Pty. Ltd.
// ------------------------------------------------------------------------
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// and Apache License v2.0 which accompanies this distribution.
// The Eclipse Public License is available at
// http://www.eclipse.org/legal/epl-v10.html
// The Apache License v2.0 is available at
// http://www.opensource.org/licenses/apache2.0.php
// You may elect to redistribute this code under either of these licenses.
// ========================================================================

package com.abhinav.yaml;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

/* ------------------------------------------------------------ */
/**
 */
public class YamlReaderTest {

	public <T> void yamlReader(final Class<T> clazz) throws IOException {

		Properties properties = new Properties();
		properties.setProperty("env_cassandra.cluster", "testCluster1");

		URL resource = Resources.getResource("test.yml");

		List<String> lines = Resources.readLines(resource, Charsets.UTF_8);

		StringBuilder yamBuilder = new StringBuilder();

		for (String line : lines) {
			yamBuilder.append(replaceEnvVariables(line, properties));
		}

		YamlReader reader = new YamlReader(yamBuilder.toString());

		System.out.println("Yaml Reader :" + reader);

		T config = reader.read(clazz);

		System.out.println(config.toString());

	}

	private String replaceEnvVariables(final String line, final Properties envProperties) {
		if (null == envProperties || envProperties.isEmpty()) {
			return line;
		}
		System.out.println("Got line in resource yaml file :" + line);

		String finalLine = line;
		for (Map.Entry<Object, Object> envPropertyEntry : envProperties.entrySet()) {
			String key = (String) envPropertyEntry.getKey();
			String value = (String) envPropertyEntry.getValue();

			finalLine = finalLine.replaceAll(Pattern.quote("${" + key + "}"), value);
			System.out.println("Final line : " + finalLine);
		}
		return finalLine;
	}

	public static void main(final String... args) throws IOException {

		YamlReaderTest yamlTest = new YamlReaderTest();

		yamlTest.yamlReader(SampleConfiguration.class);

	}

}
